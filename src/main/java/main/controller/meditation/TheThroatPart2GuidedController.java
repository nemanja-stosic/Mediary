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

public class TheThroatPart2GuidedController implements Initializable {

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
    private VBox vboxFive;
    
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
    
    private String guidedImagePath = "file:Resources/Meditation/Throat.guided/ThroatChakraGuided.png";
    private String guided1ImagePath = "file:Resources/Meditation/Throat.guided/ThroatChakraGuided1.png";
    private String guided2ImagePath = "file:Resources/Meditation/Throat.guided/ThroatChakraGuided2.png";
    private String guided3ImagePath = "file:Resources/Meditation/Throat.guided/ThroatChakraGuided3.png";
    private String guided4ImagePath = "file:Resources/Meditation/Throat.guided/ThroatChakraGuided4.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleThroatChakraGuided(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(guidedImagePath, "Length: 30 minutes", "Name: Healing Throat chakra meditation", vboxOne, meditation, MeditateState.GUIDED);
    }
    
    @FXML
    void handleThroatChakraGuided1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(guided1ImagePath, "Length: 17 minutes", "Name: Balancing energy of throat chakra", vboxTwo, meditation1, MeditateState.GUIDED1);
    }
    
    @FXML
    void handleThroatChakraGuided2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(guided2ImagePath, "Length: 10 minutes", "Name: Throat chakra meditation for Communicating and sharing ", vboxThree, meditation2, MeditateState.GUIDED2);
    }

    @FXML
    void handleThroatChakraGuided3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(guided3ImagePath, "Length: 6 minutes", "Name: Clearing throat chakra meditation", vboxFour, meditation3, MeditateState.GUIDED3);
    }
    
    @FXML
    void handleThroatChakraGuided4(MouseEvent event) {
    	vboxFive.setTranslateX(-450);
    	vboxFive.setTranslateY(-800);
    	WindowEditor.setTransition(vboxFive, "xy", 0, 0);
    	loadNextScene(guided4ImagePath, "Length: 14 minutes", "Name: Balancing throat chakra meditation", vboxFive, meditation4, MeditateState.GUIDED4);
    }

	private void setupTextFlow() {
		text = new Text("Opening the Throat Chakra\r\n" +
				"Burn Vishuddha incense and essential oils. \r\n" +
				"Aromatherapy has powerful healing properties that tap into the sense of self. To open the throat chakra, burn ether incense, essential oils, and candles like frankincense, geranium, jasmine, sage, cypress, peppermint, eucalyptus, clove, tree tea, and lavender. \r\n" +
				"\r\n" +
				"Repeat positive affirmations about authenticity.\r\n" +
				"The repetition of affirmations sets the intention to break old patterns and create new ones. To open the throat chakra, repeat affirmations that relate to authenticity and open communication. Here are some examples:\r\n" +
				"\r\n" +
				"“I communicate confidently and with ease.”\r\n" +
				"“I feel comfortable speaking my mind.”\r\n" +
				"“I am balanced in speaking and listening.”\r\n" +
				"“I am an active listener.” \r\n" +
				"“I speak my true thoughts with ease.”\r\n" +
				"“I set clear boundaries.”\r\n" +
				"\r\n" +
				"By repeating these statements, we create new thought patterns, behaviors, and actions that align with feelings of authenticity and open self-expression.\r\n" +
				"\r\n" +
				"Practice postures that activate the throat chakra\r\n" +
				"Yoga helps connect the spiritual and physical of the body through postures, called asanas. Connecting to the breath while holding asanas helps to release tension and bring energy to the area of the throat and thyroid. Throat chakra poses include camel, plow, cat-cow with lion’s breath, shoulder stand, and fish pose.\r\n" +
				"\r\n" +
				"Mindfulness Meditation\r\n" +
				"Connecting with our inner truth begins with quieting the mind. Mindful breathing presents a way to calm thoughts by focusing attention on the breath. With each inhale, think to yourself: breathing in. Then, with each exhale, think to yourself: breathing out. When thoughts or distractions arise, observe them and let them calmly pass.\r\n" +
				"\r\n" +
				"As simple as it sounds, our minds are constantly flooded with thoughts, and even a short 5 minutes of mindful breathing is more difficult than it sounds. Mindfulness meditation gets easier over time and brings stillness and space to our minds. Through that quiet, we learn to connect more closely with our inner selves and open the throat chakra.");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.AQUA);

		textFlow.getChildren().add(text);
	}

	public void popOutMessage() {
		Platform.runLater(() -> {

			JFXButton button = new JFXButton("Done");
			AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple 10 minutes throat chakra meditation:", "Note. You can just skip this practice if you are "
					+ "familiar with throat meditation.\n" +
					"1. Sit down in a comfortable chair in a quiet room.\r\n" +
					"2. Inhale and exhale 10 times, as deeply as you can. Breathe in through your nose, and then exhale through your mouth.\r\n" +
					"3. Starting at the top of your head, scan down the body and imagine your muscles relaxing as you go.\r\n" +
					"4. When you’ve done this for your whole body, picture a spinning ball in a shade of blue (the throat chakra color). See it sitting at the level of your throat, and imagine it glowing.\r\n" +
					"5. See the blue sphere getting bigger and bigger, focusing on a feeling of openness and relaxation in the throat.\r\n" +
					"6. Allow the energy to disperse through your body, and then open your eyes when you’re ready.");
		});

	}
    
    public void setupMeditationsImageViews() {
    	meditation.setImage(new Image(guidedImagePath));
    	meditation1.setImage(new Image(guided1ImagePath));
    	meditation2.setImage(new Image(guided2ImagePath));
    	meditation3.setImage(new Image(guided3ImagePath));
    	meditation4.setImage(new Image(guided4ImagePath));
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
    	nameLabel.setTextFill(Color.WHITE);
    	
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
    	if(medState == MeditateState.GUIDED)
    		musicPlayer.playMusic("Resources/Meditation/Throat.guided/ThroatChakraGuided.mp3");
    	else if(medState == MeditateState.GUIDED1)
    		musicPlayer.playMusic("Resources/Meditation/Throat.guided/ThroatChakraGuided1.mp3");
    	else if(medState == MeditateState.GUIDED2)
    		musicPlayer.playMusic("Resources/Meditation/Throat.guided/ThroatChakraGuided2.mp3");
    	else if(medState == MeditateState.GUIDED3)
    		musicPlayer.playMusic("Resources/Meditation/Throat.guided/ThroatChakraGuided3.mp3");
    	else if(medState == MeditateState.GUIDED4)
    		musicPlayer.playMusic("Resources/Meditation/Throat.guided/ThroatChakraGuided4.mp3");
    	
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
		meditateStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->  {
			meditateStage.close();
			musicPlayer.stopMusic();
		});
		meditateStage.setScene(scene);
		meditateStage.setTitle("Meditating...");
		meditateStage.show();
		
    }
    
    private void handleBack(MeditateState meditateState) {
    	switch(meditateState) {
    	case GUIDED:
    		vboxOne.setTranslateX(-450);
        	
        	meditation.setOnMouseClicked(event -> {
        		vboxOne.setTranslateX(-450);
        	  	WindowEditor.setTransition(vboxOne, "x", 450, 0);
             	loadNextScene(guidedImagePath, "Length: 30 minutes", "Name: Healing Throat chakra meditation", vboxOne, meditation, MeditateState.GUIDED);
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
             	loadNextScene(guided1ImagePath, "Length: 17 minutes", "Name: Balancing energy of throat chakra", vboxTwo, meditation1, MeditateState.GUIDED1);
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
             	loadNextScene(guided2ImagePath, "Length: 10 minutes", "Name: Throat chakra meditation for Communicating and sharing ", vboxThree, meditation2, MeditateState.GUIDED2);
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
             	loadNextScene(guided3ImagePath, "Length: 6 minutes", "Name: Clearing throat chakra meditation", vboxFour, meditation3, MeditateState.GUIDED3);
        	});
         	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
         	vboxFour.getChildren().setAll(meditation3);
        	break;
    	case GUIDED4:
    		vboxFive.setTranslateX(-450);
    		vboxFive.setTranslateY(-800);
        	
        	meditation4.setOnMouseClicked(event -> {
        		vboxFive.setTranslateX(-450);
        		vboxFive.setTranslateY(-800);
            	WindowEditor.setTransition(vboxFive, "xy", 0, 0);
             	loadNextScene(guided4ImagePath, "Length: 14 minutes", "Name: Balancing throat chakra meditation", vboxFive, meditation4, MeditateState.GUIDED4);
        	});
         	WindowEditor.setTransition(vboxFive, "xy", 0, 0);
         	vboxFive.getChildren().setAll(meditation4);
        	break;
    	}
    	
    	
    }
    
    public enum MeditateState {
    	GUIDED,
    	GUIDED1,
    	GUIDED2,
    	GUIDED3,
    	GUIDED4,
    }
    
}
