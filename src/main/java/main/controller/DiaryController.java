package main.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.App;
import main.utill.AlertSelector;
import main.utill.DatabaseUtil;
import main.utill.WindowEditor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiaryController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox vboxOnScroll;

    @FXML
    private ImageView imageView;

    @FXML
    private Label titleLabel;

    @FXML
    private TextArea textArea;

    private File file;

    private Label openedFileNameLabel;

    private int index = 0;

    private Stage stage;
    private boolean isFullscreenOn;
    private boolean isNewEntryMenuItemClicked = false;

    private DatabaseUtil dbUtil = DatabaseUtil.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(5), rootPane);
    }

    @FXML
    void handleNewEntryMenuItem(ActionEvent event) {
        System.out.println("new entry working...");
        addNewEntry();
    }

    @FXML
    void handleSaveMenuItem(ActionEvent event) {
        saveEntry();
    }

    @FXML
    void handleExitMenuItem(ActionEvent event) {
        JFXButton yesButton = new JFXButton("Yes");
        JFXButton noButton = new JFXButton("No");
        yesButton.setPrefSize(80, 30);
        yesButton.setTranslateX(-100);
        yesButton.setTranslateY(-20);
        noButton.setPrefSize(80, 30);
        noButton.setTranslateX(-150);
        noButton.setTranslateY(-20);
        yesButton.setOnAction(event2 -> {
            DatabaseUtil.closeConnection();
            ((Stage) rootPane.getScene().getWindow()).close();
        });
        AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(noButton, yesButton), "Are you sure want to close diary ?", "");
    }

    @FXML
    void handleOpenEntryMenuItem(ActionEvent event) {
        WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.SHOW_DIARY_ENTRIES_STAGE), "View Entries",
                WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleChangeTextColorMenuIem(ActionEvent event) {
        if (isNewEntryMenuItemClicked)
            changeTextColor();
        else {
            JFXButton button = new JFXButton("Got it");
            AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Please first create a entry before trying to change text color...", "");
        }

    }

    @FXML
    void handleFocusModeMenuItem(ActionEvent event) {
        stage = ((Stage) rootPane.getScene().getWindow());

        isFullscreenOn = stage.isFullScreen();

        if (!isFullscreenOn && isNewEntryMenuItemClicked) {
            isFullscreenOn = true;
            stage.setFullScreenExitHint(""); //removes press escape to exit the full screen mode message.
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); //disables default esc key from exiting full screen mode.
            stage.setFullScreen(isFullscreenOn);

            textArea.setStyle("-fx-background-color: linear-gradient(#212121, #212121);");
            imageView.setFitWidth(App.monitorWidth);
            imageView.setFitHeight(App.monitorHeight);
            rootPane.setMinWidth(App.monitorWidth);
            rootPane.setMinHeight(App.monitorHeight);
            textArea.setMinWidth(textArea.getWidth() + (App.monitorWidth - textArea.getWidth()));
            textArea.setMinHeight(textArea.getHeight() + (App.monitorHeight - textArea.getHeight() - (titleLabel.getHeight() * 2))); //adjusting height for label and text area
        } else if (isNewEntryMenuItemClicked) {
            stage.setFullScreen(false);

            textArea.setStyle("-fx-background-color: transparent;");
            imageView.setFitWidth(1366);
            imageView.setFitHeight(787);
            rootPane.setMinWidth(1366);
            rootPane.setMinHeight(787);
            textArea.setMinWidth(1366);
            textArea.setMinHeight(723); //adjusting height for label and text area
        } else {
            JFXButton button = new JFXButton("Got it");
            AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Please first create a entry before entering in focus mode...", "");
        }

    }

    private void addNewEntry() {
        // letting user pick up a title for entry and a background image
        Stage stage = new Stage();
        stage.setTitle("Setup entry");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        AnchorPane pane = new AnchorPane();
        StackPane parent = new StackPane();

        String font = "Arial";

        TextField title = new TextField();
        title.setPromptText("Enter a title");
        title.setFont(new Font(font, 15));
        title.setMinSize(283, 31);
        title.setLayoutX(9);
        title.setLayoutY(26);

        openedFileNameLabel = new Label("");
        openedFileNameLabel.setFont(new Font(font, 15));
        openedFileNameLabel.setLayoutX(14);
        openedFileNameLabel.setLayoutY(128);

        Button choseImageButton = new Button("Chose image (png)");
        choseImageButton.setFont(new Font(font, 15));
        choseImageButton.setLayoutX(9);
        choseImageButton.setLayoutY(91);
        choseImageButton.setOnAction(eventt -> {
            if (title.getText().equals("")) {
                JFXButton button = new JFXButton("Sure");
                AlertSelector.jfxPopOutDialog(parent, pane, Arrays.asList(button), "Please chose a title first...", "");
            } else {

                FileChooser fileChooser = new FileChooser();
                // configuring file chooser
                configureFileChooser(fileChooser);

                this.file = fileChooser.showOpenDialog(stage);

                //handling null pointer if user clicks cancel while choosing picture
                if (this.file != null) {
                    openedFileNameLabel.setText(this.file.getName());
                }
            }
        });

        Button setDefaultImageButton = new Button("Set default image");
        setDefaultImageButton.setFont(new Font(font, 15));
        setDefaultImageButton.setLayoutX(179);
        setDefaultImageButton.setLayoutY(91);
        setDefaultImageButton.setOnAction(eventt -> {
            if (title.getText().equals("")) {
                JFXButton button = new JFXButton("Sure");
                AlertSelector.jfxPopOutDialog(parent, pane, Arrays.asList(button), "Please chose a title first...", "");
            } else {
                openedFileNameLabel.setText("DefaultDiaryBackgroundImage.png");
            }

        });

        Button finishButton = new Button("Finish");
        finishButton.setFont(new Font(font, 15));
        finishButton.setLayoutX(339);
        finishButton.setLayoutY(63);
        finishButton.setOnAction(eventt -> {
            if (openedFileNameLabel.getText().equals("") || title.getText().equals("")) {
                JFXButton button = new JFXButton("Sure");
                AlertSelector.jfxPopOutDialog(parent, pane, Arrays.asList(button), "Please enter a title and chose a background image", "");
            } else {
                if (openedFileNameLabel.getText().equals("DefaultDiaryBackgroundImage.png")) {
                    isNewEntryMenuItemClicked = true;
                    imageView.setImage(new Image("file:Resources/Saved.images/DefaultDiaryBackgroundImage.png"));

                    //setting things for writing a diary
                    titleLabel.setText(title.getText());
                    textArea.setEditable(true);

                    //delete if you must
                    JFXButton button = new JFXButton("Cool");
                    button.setOnMouseClicked(eventtt -> stage.close());
                    AlertSelector.jfxPopOutDialog(parent, pane, Arrays.asList(button), "All set!", "");
                } else {
                    isNewEntryMenuItemClicked = true;
                    //convert file to image to byte and write it on file system
                    try {
                        //converting image to byte
                        BufferedImage bImage = ImageIO.read(file);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ImageIO.write(bImage, "png", bos);
                        byte data[] = bos.toByteArray();

                        File savedFile = new File("Resources/Saved.images/User/" + title.getText().replaceAll("\\s", "") + "ByteImage.png");
                        FileOutputStream fos = new FileOutputStream(savedFile);
                        fos.write(data);
                        fos.close();

                        imageView.setImage(new Image("file:Resources/Saved.images/User/" + title.getText().replaceAll("\\s", "") + "ByteImage.png"));

                        //setting things for writing a diary
                        titleLabel.setText(title.getText());
                        textArea.setEditable(true);

                        JFXButton button = new JFXButton("Cool");
                        button.setOnMouseClicked(eventtt -> stage.close());
                        AlertSelector.jfxPopOutDialog(parent, pane, Arrays.asList(button), "All set!", "");

                    } catch (IOException e) {
                        Logger.getLogger(DiaryController.class.getName()).log(Level.SEVERE, "File not saved in diary controller...", e);
                    }

                }

            }
        });

        pane.getChildren().addAll(title, openedFileNameLabel, choseImageButton, setDefaultImageButton, finishButton);

        parent.getChildren().addAll(pane);

        Scene scene = new Scene(parent, 456, 157);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass().getResource(
                Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.STYLE)))).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    private void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("Select Picture");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
    }

    private void saveEntry() {
        //first we will get current time and date, text also and then: saving all data that user wrote...
        //checking first this in case user clicks save before creating new entry...
        if (!isNewEntryMenuItemClicked) {
            JFXButton button = new JFXButton("Got it");
            AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Please first create a entry before saving...", "");
        } else if (openedFileNameLabel.getText().equals("DefaultDiaryBackgroundImage.png")) {
            isNewEntryMenuItemClicked = false;

            JFXButton yesButton = new JFXButton("Yes");
            JFXButton noButton = new JFXButton("No");
            yesButton.setPrefSize(80, 30);
            yesButton.setTranslateX(-150);
            yesButton.setTranslateY(-20);
            noButton.setPrefSize(80, 30);
            noButton.setTranslateX(-370);
            noButton.setTranslateY(-20);
            yesButton.setOnAction(event2 -> {
                String text = textArea.getText();

                File defaultFileImage = new File("Resources/Saved.images/DefaultDiaryBackgroundImage.png");
                try (FileInputStream fis = new FileInputStream(defaultFileImage)) {
                    dbUtil.add(titleLabel.getText(), text, fis, defaultFileImage);
                    textArea.setText("");
                    textArea.setEditable(false);
                    titleLabel.setText("");

                    //exiting focus mode...
                    closeFocusModeAfterSave();

                    JFXButton button = new JFXButton("Great");
                    AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Your entry has been saved!", "");
                } catch (IOException e) {
                    Logger.getLogger(DiaryController.class.getName()).log(Level.SEVERE, "save entry failed in diary controller...", e);
                }

            });
            AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(noButton, yesButton), "Are you sure want to save this entry, once you save it you cannot edit it anymore?", "");
        } else {
            isNewEntryMenuItemClicked = false;

            JFXButton yesButton = new JFXButton("Yes");
            JFXButton noButton = new JFXButton("No");
            yesButton.setPrefSize(80, 30);
            yesButton.setTranslateX(-150);
            yesButton.setTranslateY(-20);
            noButton.setPrefSize(80, 30);
            noButton.setTranslateX(-370);
            noButton.setTranslateY(-20);
            yesButton.setOnAction(event2 -> {
                String text = textArea.getText();

                try (FileInputStream fis = new FileInputStream(file)) {
                    dbUtil.add(titleLabel.getText(), text, fis, file);
                    textArea.setText("");
                    titleLabel.setText("");
                    textArea.setEditable(false);

                    //exiting focus mode...
                    closeFocusModeAfterSave();

                    JFXButton button = new JFXButton("Great");
                    AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(button), "Your entry has been saved!", "");
                } catch (IOException e) {
                    Logger.getLogger(DiaryController.class.getName()).log(Level.SEVERE, "save entry failed in diary controller...", e);
                }

            });
            AlertSelector.jfxPopOutDialog(rootPane, anchorPane, Arrays.asList(noButton, yesButton), "Are you sure want to save this entry, once you save it you cannot edit it anymore?", "");
        }

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

    private void closeFocusModeAfterSave() {
        stage = ((Stage) rootPane.getScene().getWindow());

        isFullscreenOn = stage.isFullScreen();

        if (isFullscreenOn && !isNewEntryMenuItemClicked) {
            stage.setFullScreen(false);

            textArea.setStyle("-fx-background-color: transparent;");
            imageView.setFitWidth(1366);
            imageView.setFitHeight(787);
            rootPane.setMinWidth(1366);
            rootPane.setMinHeight(787);
            textArea.setMinWidth(1366);
            textArea.setMinHeight(723); //adjusting height for label and text area
        }
    }

}
