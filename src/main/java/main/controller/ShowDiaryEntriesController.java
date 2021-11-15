package main.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.App;
import main.model.DiaryEntryData;
import main.utill.AlertSelector;
import main.utill.DatabaseUtil;
import main.utill.WindowEditor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowDiaryEntriesController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<DiaryEntryData> tableView;

    @FXML
    private TableColumn<DiaryEntryData, String> titleColumn;

    @FXML
    private TableColumn<DiaryEntryData, Date> createdOnColumn;

    private ObservableList<DiaryEntryData> list = FXCollections.observableArrayList();
    private DatabaseUtil dbUtil = DatabaseUtil.getInstance();

    private int index = 0;

    private Label titleLabel;
    private TextArea textArea;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initColumns();
        loadData();
    }

    @FXML
    void handleDeleteEntry(ActionEvent event) {
        DiaryEntryData selectedEntry = tableView.getSelectionModel().getSelectedItem();

        if (selectedEntry == null) {
            AlertSelector.errorAlert("No Entry Selected", null, "Please select a entry you want to delete first!");
            return;
        }

        JFXButton yesButton = new JFXButton("Yes");
        JFXButton noButton = new JFXButton("No");
        yesButton.setPrefSize(80, 30);
        yesButton.setTranslateX(-100);
        yesButton.setTranslateY(-20);
        noButton.setPrefSize(80, 30);
        noButton.setTranslateX(-150);
        noButton.setTranslateY(-20);
        yesButton.setOnAction(event2 -> {
            try {
                dbUtil.delete(selectedEntry.getTitle());
                Files.deleteIfExists(Paths.get("Resources/Saved.images/User/" + selectedEntry.getTitle().replaceAll("\\s", "") + "ByteImage.png"));

                JFXButton button = new JFXButton("Thanks");
                AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Entry deleted!", "");

                list.remove(selectedEntry);

                //refreshing...
                loadData();

            } catch (IOException e) {
                AlertSelector.errorAlert("ERROR", null, "Error when deleting entry: " + e.getMessage());
            }

        });
        AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(noButton, yesButton), "Are you sure want to delete this entry: " + selectedEntry.getTitle() + " ?", "");

    }

    @FXML
    void handleViewEntry(ActionEvent event) {
        DiaryEntryData selectedEntry = tableView.getSelectionModel().getSelectedItem();

        if (selectedEntry == null) {
            AlertSelector.errorAlert("No Entry Selected", null, "Please select a entry you want see first!");
            return;
        }

        //entering full screen mode by creating temporary stage
        Stage stage = new Stage();
        stage.setFullScreen(true);

        String title = "";
        String textEntries = "";

        String q = "SELECT * FROM DIARY_ENTRIES WHERE title = '" + selectedEntry.getTitle() + "'";
        try (Statement statement = DatabaseUtil.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(q);) {

            while (rs.next()) {
                title = rs.getString("title");
                textEntries = rs.getString("entriesText");
                //getting image from database
                File savingImageFile = new File("Resources/Saved.images/User/" + selectedEntry.getTitle().replaceAll("\\s", "") + "ByteImage.png");
                FileOutputStream fos = new FileOutputStream(savingImageFile);
                byte b[];
                Blob blob;

                blob = rs.getBlob("backgroundImage");
                b = blob.getBytes(1, (int) blob.length());
                fos.write(b);

                fos.close();
            }

        } catch (SQLException | IOException e) {
            Logger.getLogger(ShowDiaryEntriesController.class.getName()).log(Level.SEVERE, "data load failed diary entries...", e);
        }

        titleLabel = new Label("");
        titleLabel.setText(title);
        titleLabel.setStyle("-fx-text-fill: #d50000; -fx-font-size: 23px; -fx-font-weight: bold; -fx-font-style: italic;");

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setText(textEntries);

        //setting right click option
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item = new MenuItem("Change text color");
        contextMenu.getItems().addAll(item);
        textArea.setContextMenu(contextMenu);

        item.setOnAction(eventt -> changeTextColor());

        BorderPane bPane = new BorderPane();
        bPane.setTop(titleLabel);
        bPane.setCenter(textArea);
        bPane.setPrefSize(App.monitorWidth, App.monitorHeight);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        VBox root = new VBox();
        root.setStyle("-fx-background-image: url(\"file:Resources/Saved.images/User/" + titleLabel.getText().replaceAll("\\s", "") + "ByteImage.png" + "\");"
                + "-fx-background-size: 100% 100%;");
        root.getChildren().addAll(bPane);

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass().getResource(Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.STYLE)))).toExternalForm());
        scene.setOnKeyPressed(eventt -> {
            if (eventt.getCode() == KeyCode.ESCAPE) {
                stage.close();
            }
        });

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("Entry reading...");
        stage.setScene(scene);

        stage.show();

    }

    private void initColumns() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //configuring date column

        createdOnColumn.setCellFactory(column -> {
            TableCell<DiaryEntryData, Date> cell = new TableCell<>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        this.setText(format.format(item));

                    }
                }
            };

            return cell;
        });

        createdOnColumn.setCellValueFactory(new PropertyValueFactory<>("entryIssueTime"));
    }

    private void loadData() {
        list.clear();

        String q = "SELECT * FROM DIARY_ENTRIES";
        try (Statement statement = DatabaseUtil.getConnection().createStatement();
             ResultSet rs = statement.executeQuery(q)) {

            while (rs.next()) {
                String title = rs.getString("title");
                Timestamp entryIssueTime = rs.getTimestamp("entryIssueTime");
                Date issueDate = new Date(entryIssueTime.getTime());

                list.add(new DiaryEntryData(title, issueDate));
            }

        } catch (SQLException e) {
            Logger.getLogger(ShowDiaryEntriesController.class.getName()).log(Level.SEVERE, "data load failed diary entries...", e);
        }

        tableView.setItems(list);

    }

    private void changeTextColor() {

        String allTexts[] = {"Change to Blue", "Change to Red", "Change to Yellow", "Change to Green", "Change to Aqua", "Change to White", "Change to Pink", "Change to Black", "Change to BlueViolet",
                "Change to Indigo", "Change to linen", "Change to Magenta", "Change to Tan", "Change to LightGrey"};
        Color allColors[] = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.AQUA, Color.WHITE, Color.PINK, Color.BLACK, Color.BLUEVIOLET, Color.INDIGO, Color.LINEN, Color.MAGENTA, Color.TAN,
                Color.LIGHTGRAY};
        String cssColors[] = {"blue", "red", "yellow", "green", "aqua", "white", "pink", "black", "blueviolet", "indigo", "linen", "magenta", "tan", "lightgrey"};


        index++;
        if (index >= allTexts.length)
            index = 0;

        titleLabel.setTextFill(allColors[index]);
        textArea.setStyle("-fx-text-fill: " + cssColors[index]);

    }

}
