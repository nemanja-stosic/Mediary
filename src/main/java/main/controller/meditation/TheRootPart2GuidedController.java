package main.controller.meditation;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.App;
import main.model.MusicPlayer;
import main.utill.AlertSelector;
import main.utill.WindowEditor;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TheRootPart2GuidedController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox vboxOne;

    @FXML
    private VBox vboxTwo;

    @FXML
    private VBox vboxThree;

    @FXML
    private VBox vboxFour;

    @FXML
    private ImageView meditation;

    @FXML
    private ImageView meditation1;

    @FXML
    private ImageView meditation2;

    @FXML
    private ImageView meditation3;

    @FXML
    private ImageView meditation4;

    @FXML
    private ImageView meditation5;

    @FXML
    private ImageView meditation6;

    @FXML
    private ImageView meditation7;

    @FXML
    private TextFlow textFlow;

    private Text text;

    private MusicPlayer musicPlayer = new MusicPlayer();

    private String guidedImagePath = "file:Resources/Meditation/Root.guided/RootChakraGuided.png";
    private String guided1ImagePath = "file:Resources/Meditation/Root.guided/RootChakraGuided1.png";
    private String guided2ImagePath = "file:Resources/Meditation/Root.guided/RootChakraGuided2.png";
    private String guided3ImagePath = "file:Resources/Meditation/Root.guided/RootChakraGuided3.png";

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);

        popOutMessage();
        setupTextFlow();
        setupMeditationsImageViews();
    }

    @FXML
    void handleRootChakraGuided(MouseEvent event) {
        vboxOne.setTranslateX(-450);
        WindowEditor.setTransition(vboxOne, "x", 450, 0);
        loadNextScene(guidedImagePath, "Length: 7 minutes", "Name: Grounding with Root Chakra Affirmations", vboxOne, meditation, MeditateState.GUIDED);
    }

    @FXML
    void handleRootChakraGuided1(MouseEvent event) {
        vboxTwo.setTranslateX(-450);
        vboxTwo.setTranslateY(-200);
        WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
        loadNextScene(guided1ImagePath, "Length: 14 minutes", "Name: Root Chakra Balancing meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
    }

    @FXML
    void handleRootChakraGuided2(MouseEvent event) {
        vboxThree.setTranslateX(-450);
        vboxThree.setTranslateY(-400);
        WindowEditor.setTransition(vboxThree, "xy", 0, 0);
        loadNextScene(guided2ImagePath, "Length: 10 minutes", "Name: Root Chakra Meditation with Affirmations", vboxThree, meditation2, MeditateState.GUIDED2);
    }

    @FXML
    void handleRootChakraGuided3(MouseEvent event) {
        vboxFour.setTranslateX(-450);
        vboxFour.setTranslateY(-600);
        WindowEditor.setTransition(vboxFour, "xy", 0, 0);
        loadNextScene(guided3ImagePath, "Length: 13 minutes", "Name: Root Chakra Meditation Activating Flow", vboxFour, meditation3, MeditateState.GUIDED3);
    }

    private void setupTextFlow() {
        text = new Text("Opening the root chakra\r\n" +
                "There are many ways to open your root chakra. For example, you can engage more in grounding and earth-related activities (for example, connection with nature, gardening, cooking healthy, hiking).\r\n" +
                "\r\n" +
                "The main idea is to work at growing your ”roots” in a safe and comfortable environment (i.e., surround yourself with earth colors, objects reminding you of nature, stability; or on the contrary, if you wish to feel less stuck, do the opposite).\r\n" +
                "\r\n" +
                "Yoga for the root chakra can be a more physical way to bridge the body and mind and restore a more balanced energy flow.\r\n" +
                "\r\n" +
                "What’s in the Muladhara or root chakra name?\r\n" +
                "The first chakra is referred to as:\r\n" +
                "\r\n" +
                "-Root chakra\r\n" +
                "-Muladhara\r\n" +
                "-Adhara\r\n" +
                "Its sanscrit name is ”muladhara” can signify “base”, ‘foundation”, “root support”.\r\n" +
                "\r\n" +
                "The first chakra is associated with the Earth element.\r\n" +
                "\r\n" +
                "Chakra colors: The red chakra\r\n" +
                "The typical color used to represent the root chakra is a rich vermilion red. This is the color used on its symbol to fill its petals. Traditionally, it is also associated with the color yellow or gold (this is the color of its element as opposed to its petals). In the spectrum of chakra colors, red symbolizes strength, vitality, and stimulates our instinctual tendencies.\r\n" +
                "\r\n" +
                "Root chakra symbol\r\n" +
                "The symbol of the root chakra is composed of a four-petaled lotus flower, often stylized as a circle with four petals with a downward-pointing triangle.\r\n" +
                "\r\n" +
                "The downward-pointing triangle is a symbol of spirit connecting with matter, grounding on the earth and our earthly existence, in our bodies. It’s seen as the center of our vital life force and is the seat where kundalini stays coiled, dormant, until is wakes up to distribute its energy through all the other chakras.");
        text.setFont(new Font("Arial", 28));
        text.setFill(Color.RED);

        textFlow.getChildren().add(text);
    }

    public void popOutMessage() {
        Platform.runLater(() -> {

            JFXButton button = new JFXButton("Done");
            AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple root chakra meditation:", "Note. You can just skip this practice if you are "
                    + "familiar with root meditation.\n"
                    + "1. Sit with your shoulders back and your spine straight. Try to relax all your muscles as you close your eyes and breathe deeply. Inhale through the nose, pulling the breath as far down into your body as you can, and exhale through the mouth.\r\n" +
                    "2. Turn your attention to the location of the root chakra, right below your tailbone. Notice any tightness in the area.\r\n" +
                    "3. Since the root chakra’s element is red, try picturing a red glow at the base of your spine. This glow will slowly expand, making the whole area warm and relaxed. Rest in this sensation for 3-5 minutes.\r\n" +
                    "4. When you’re ready, slowly open your eyes. Sit for a few minutes before continuing with your day.");
        });

    }

    public void setupMeditationsImageViews() {
        meditation.setImage(new Image(guidedImagePath));
        meditation1.setImage(new Image(guided1ImagePath));
        meditation2.setImage(new Image(guided2ImagePath));
        meditation3.setImage(new Image(guided3ImagePath));
    }

    private void loadNextScene(String imagePath, String lenghtLabelText, String nameLabelText, VBox vbox, ImageView medImageView, MeditateState meditateState) {

        String buttonStyle = "-fx-border-color: #FFFFFF; -fx-background-color: #1976D2; -fx-text-fill: #FFFFFF;";
        String buttonHoverStyle = "-fx-border-color: #00E5FF; -fx-background-color: #00E5FF; -fx-text-fill: #FFFFFF;";
        String font = "Arial";
        vbox.getChildren().removeAll(medImageView);
        //now adding again buttons and labels as before
        AnchorPane anchorPaneGuided = new AnchorPane();

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(imagePath));
        imageView.setEffect(new GaussianBlur(15));
        imageView.setFitWidth(450);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(false);

        Label lengthLabel = new Label(lenghtLabelText);
        lengthLabel.setPadding(new Insets(10, 10, 10, 10));
        lengthLabel.setPrefSize(150, 36);
        lengthLabel.setLayoutX(0);
        lengthLabel.setLayoutY(69);
        lengthLabel.setFont(Font.font(font, FontWeight.BOLD, 14));
        lengthLabel.setTextFill(Color.WHITE);

        Label nameLabel = new Label(nameLabelText);
        nameLabel.setPadding(new Insets(10, 10, 10, 10));
        nameLabel.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        nameLabel.setLayoutX(0);
        nameLabel.setLayoutY(28);
        nameLabel.setFont(Font.font(font, FontWeight.BOLD, 14));
        nameLabel.setTextFill(Color.RED);

        JFXButton meditateButton = new JFXButton("Meditate");
        meditateButton.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        meditateButton.setLayoutX(342);
        meditateButton.setLayoutY(155);
        meditateButton.setOnAction(event -> handleMeditate(imagePath, meditateState));
        meditateButton.setStyle("-fx-border-color: #FFFFFF; -fx-background-color: #1976D2; -fx-text-fill: #FFFFFF;");
        meditateButton.setOnMouseEntered(event -> meditateButton.setStyle(buttonHoverStyle));
        meditateButton.setOnMouseExited(event -> meditateButton.setStyle(buttonStyle));

        JFXButton backButton = new JFXButton("Back");
        backButton.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        backButton.setLayoutX(24);
        backButton.setLayoutY(155);
        backButton.setOnAction(event -> {
            vbox.getChildren().removeAll(anchorPaneGuided);
            handleBack(meditateState);
        });
        backButton.setStyle("-fx-border-color: #FFFFFF; -fx-background-color: #1976D2; -fx-text-fill: #FFFFFF;");
        backButton.setOnMouseEntered(eventt -> backButton.setStyle(buttonHoverStyle));
        backButton.setOnMouseExited(eventt -> backButton.setStyle(buttonStyle));

        WindowEditor.setTransition(vboxOne, "x", 0, 0);

        anchorPaneGuided.getChildren().addAll(imageView, lengthLabel, nameLabel, meditateButton, backButton);
        vbox.getChildren().setAll(anchorPaneGuided);

    }

    private void handleMeditate(String imagePath, MeditateState medState) {
        loadMeditateState(imagePath);
        if (medState == MeditateState.GUIDED)
            musicPlayer.playMusic("Resources/Meditation/Root.guided/RootChakraGuided.mp3");
        else if (medState == MeditateState.GUIDED1)
            musicPlayer.playMusic("Resources/Meditation/Root.guided/RootChakraGuided1.mp3");
        else if (medState == MeditateState.GUIDED2)
            musicPlayer.playMusic("Resources/Meditation/Root.guided/RootChakraGuided2.mp3");
        else if (medState == MeditateState.GUIDED3)
            musicPlayer.playMusic("Resources/Meditation/Root.guided/RootChakraGuided3.mp3");
    }

    private void loadMeditateState(String imagePath) {
        Stage meditateStage = new Stage();
        ImageView imageViewer = new ImageView();
        imageViewer.setImage(new Image(imagePath));
        imageViewer.setPreserveRatio(false);

        imageViewer.setFitWidth(App.monitorWidth);
        imageViewer.setFitHeight(App.monitorHeight);

        VBox vbox = new VBox(10);
        vbox.getChildren().add(imageViewer);

        Scene scene = new Scene(vbox, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        meditateStage.initModality(Modality.APPLICATION_MODAL);
        meditateStage.initStyle(StageStyle.UNDECORATED);
        meditateStage.setFullScreenExitHint("Press any key to exit..."); //removes press escape to exit the full screen mode message.
        meditateStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); //disables default esc key from exiting full screen mode.
        meditateStage.setFullScreen(true);
        meditateStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            meditateStage.close();
            musicPlayer.stopMusic();
        });
        meditateStage.setScene(scene);
        meditateStage.setTitle("Meditating...");
        meditateStage.show();

    }

    private void handleBack(MeditateState meditateState) {
        switch (meditateState) {
            case GUIDED:
                vboxOne.setTranslateX(-450);

                meditation.setOnMouseClicked(event -> {
                    vboxOne.setTranslateX(-450);
                    WindowEditor.setTransition(vboxOne, "x", 450, 0);
                    loadNextScene(guidedImagePath, "Length: 7 minutes", "Name: Grounding with Root Chakra Affirmations", vboxOne, meditation, MeditateState.GUIDED);
                });
                WindowEditor.setTransition(vboxOne, "x", 0, 0);
                vboxOne.getChildren().setAll(meditation);
                break;
            case GUIDED1:
                vboxTwo.setTranslateX(-450);
                vboxTwo.setTranslateY(-200);

                meditation1.setOnMouseClicked(event -> {
                    vboxTwo.setTranslateX(-450);
                    vboxTwo.setTranslateY(-200);
                    WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
                    loadNextScene(guided1ImagePath, "Length: 14 minutes", "Name: Root Chakra Balancing meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
                });
                WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
                vboxTwo.getChildren().setAll(meditation1);
                break;
            case GUIDED2:
                vboxThree.setTranslateX(-450);
                vboxThree.setTranslateY(-400);

                meditation2.setOnMouseClicked(event -> {
                    vboxThree.setTranslateX(-450);
                    vboxThree.setTranslateY(-400);
                    WindowEditor.setTransition(vboxThree, "xy", 0, 0);
                    loadNextScene(guided2ImagePath, "Length: 10 minutes", "Name: Root Chakra Meditation with Affirmations", vboxThree, meditation2, MeditateState.GUIDED2);
                });
                WindowEditor.setTransition(vboxThree, "xy", 0, 0);
                vboxThree.getChildren().setAll(meditation2);
                break;
            case GUIDED3:
                vboxFour.setTranslateX(-450);
                vboxFour.setTranslateY(-600);

                meditation3.setOnMouseClicked(event -> {
                    vboxFour.setTranslateX(-450);
                    vboxFour.setTranslateY(-600);
                    WindowEditor.setTransition(vboxFour, "xy", 0, 0);
                    loadNextScene(guided3ImagePath, "Length: 13 minutes", "Name: Root Chakra Meditation Activating Flow", vboxFour, meditation3, MeditateState.GUIDED3);
                });
                WindowEditor.setTransition(vboxFour, "xy", 0, 0);
                vboxFour.getChildren().setAll(meditation3);
                break;
        }


    }

    public enum MeditateState {
        GUIDED,
        GUIDED1,
        GUIDED2,
        GUIDED3,
    }

}
