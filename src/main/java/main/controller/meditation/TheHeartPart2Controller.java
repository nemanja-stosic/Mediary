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

public class TheHeartPart2Controller implements Initializable {

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
    
    private String meditationImagePath = "file:Resources/Meditation/Heart/HeartChakra.png";
    private String meditation1ImagePath = "file:Resources/Meditation/Heart/HeartChakra1.png";
    private String meditation2ImagePath = "file:Resources/Meditation/Heart/HeartChakra2.png";
    private String meditation3ImagePath = "file:Resources/Meditation/Heart/HeartChakra3.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleHeartChakraMeditation(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Balancing and activation of heart chakra", vboxOne, meditation, MeditateState.MEDITATION);
    }
    
    @FXML
    void handleHeartChakraMeditation1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(meditation1ImagePath, "Length: 25 minutes", "Name: Anahata - Yam chanting meditation", vboxTwo, meditation1, MeditateState.MEDITATION1);
    }
    
    @FXML
    void handleHeartChakraMeditation2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(meditation2ImagePath, "Length: 18 minutes", "Name: Open & Clear your heart chakra", vboxThree, meditation2, MeditateState.MEDITATION2);
    }

    @FXML
    void handleHeartChakraMeditation3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Powerful heart chakra opening vibrations", vboxFour, meditation3, MeditateState.MEDITATION3);
    }

	private void setupTextFlow() {
		text = new Text("Signs your fourth chakra may be out of balance\r\n" +
				"The heart chakra can become imbalanced as a result of life experiences that have a strong emotional charge, physical illments, or significant changes in your environment. It may manifests as a blockage in the energy flow or, on the contrary, a tendency to become overactive or have an excess of energy.\r\n" +
				"\r\n" +
				"You can see the following signs of imbalance in the heart chakra :\r\n" +
				"\r\n" +
				"-Being overly defensive\r\n" +
				"-Feeling closed down\r\n" +
				"-Jealousy; fear of intimacy\r\n" +
				"-Codependency, relying on other’s approval and attention, trying to please at all cost\r\n" +
				"-Always putting oneself in the role of the savior or the rescuer; or on the contrary, falling into victimization\r\n" +
				"-Excessive isolation, being recluse, antisocial\r\n" +
				"-Holding grudges, not being to forgive\r\n" +
				"At the physical level, it can manifest as:\r\n" +
				"\r\n" +
				"-Respiratory ailments, such as lung infection, bronchitis\r\n" +
				"-Circulatory and heart-related issues\r\n" +
				"When the energy in your fourth chakra is blocked or hindered, you may experience what is sometimes referred to as heart chakra pain.\r\n" +
				"\r\n" +
				"Simple ideas to balance the heart chakra\r\n" +
				"To get started, try out these few simple practices:\r\n" +
				"\r\n" +
				"-Work with the breath to balance your energy; observe it, play with it with breathing exercises\r\n" +
				"-Cultivate your appreciation for beauty, whether it’s in nature, people or in the arts\r\n" +
				"-Practice self-care and love your body up, from a good bath with rose essential oil to yoga poses opening the heart area\r\n" +
				"-Cultivate self-compassion and acceptance, especially with regards to your emotions and body\r\n" +
				"-Engage in activities that feed your heart\r\n" +
				"-Focus on receiving if you are naturally inclined to be a giver; and on giving if you’re more inclined to receive all the time\r\n" +
				"-Reflect on old wounds inherited from family relationships and come to terms with them compassionately; practice forgiveness deep within your heart\r\n" +
				"-Express your gratitude, even if it’s in silence; you can be grateful for the presence of other people in your life or simply for good things that make your life easier and happier");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.LAWNGREEN);

		textFlow.getChildren().add(text);
	}

	public void popOutMessage() {
		Platform.runLater(() -> {

			JFXButton button = new JFXButton("Done");
			AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple heart chakra meditation:", "Note. You can just skip this practice if you are "
					+ "familiar with heart meditation.\n"
					+ "1. Find a comfortable, relaxing place where you won’t be disturbed.\r\n" +
					"2. Sit and breathe in through your nose and out through your mouth for a few minutes. Feel your body relaxing as you do this.\r\n" +
					"3. Imagine that you’re drawing green energy up through your body towards the heart, starting at the base of the spine and moving upwards.\r\n" +
					"4. Picture that energy solidifying into a bright ball of green energy sitting at the level of the heart chakra. As you inhale and exhale, see that ball becoming bigger and brighter.\r\n" +
					"5. Focus on tuning into feelings of love for yourself and others, letting the green energy radiate through your whole body. Emerge from the meditation after 3-5 minutes.");
		});

	}
    
    public void setupMeditationsImageViews() {
    	meditation.setImage(new Image(meditationImagePath));
    	meditation1.setImage(new Image(meditation1ImagePath));
    	meditation2.setImage(new Image(meditation2ImagePath));
    	meditation3.setImage(new Image(meditation3ImagePath));
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
    	if(medState == MeditateState.MEDITATION)
    		musicPlayer.playMusic("Resources/Meditation/Heart/HeartChakraMeditation.mp3");
    	else if(medState == MeditateState.MEDITATION1)
    		musicPlayer.playMusic("Resources/Meditation/Heart/HeartChakraMeditation1.mp3");
    	else if(medState == MeditateState.MEDITATION2)
    		musicPlayer.playMusic("Resources/Meditation/Heart/HeartChakraMeditation2.mp3");
    	else if(medState == MeditateState.MEDITATION3)
    		musicPlayer.playMusic("Resources/Meditation/Heart/HeartChakraMeditation3.mp3");
    	
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
    	case MEDITATION:
    		vboxOne.setTranslateX(-450);
        	
        	meditation.setOnMouseClicked(event -> {
        		vboxOne.setTranslateX(-450);
        	  	WindowEditor.setTransition(vboxOne, "x", 450, 0);
             	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Balancing and activation of heart chakra", vboxOne, meditation, MeditateState.MEDITATION);
        	});
         	WindowEditor.setTransition(vboxOne, "x", 0, 0);
        	vboxOne.getChildren().setAll(meditation);
        	break;
    	case MEDITATION1:
    		vboxTwo.setTranslateX(-450);
    		vboxTwo.setTranslateY(-200);
        	
        	meditation1.setOnMouseClicked(event -> {
        		vboxTwo.setTranslateX(-450);
        		vboxTwo.setTranslateY(-200);
            	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
             	loadNextScene(meditation1ImagePath, "Length: 25 minutes", "Name: Anahata - Yam chanting meditation", vboxTwo, meditation1, MeditateState.MEDITATION1);
        	});
         	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
        	vboxTwo.getChildren().setAll(meditation1);
        	break;
    	case MEDITATION2:
    		vboxThree.setTranslateX(-450);
    		vboxThree.setTranslateY(-400);
        	
        	meditation2.setOnMouseClicked(event -> {
        		vboxThree.setTranslateX(-450);
        		vboxThree.setTranslateY(-400);
            	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
             	loadNextScene(meditation2ImagePath, "Length: 18 minutes", "Name: Open & Clear your heart chakra", vboxThree, meditation2, MeditateState.MEDITATION2);
        	});
         	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
         	vboxThree.getChildren().setAll(meditation2);
        	break;
    	case MEDITATION3:
    		vboxFour.setTranslateX(-450);
    		vboxFour.setTranslateY(-600);
        	
        	meditation3.setOnMouseClicked(event -> {
        		vboxFour.setTranslateX(-450);
        		vboxFour.setTranslateY(-600);
            	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
             	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Powerful heart chakra opening vibrations", vboxFour, meditation3, MeditateState.MEDITATION3);
        	});
         	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
         	vboxFour.getChildren().setAll(meditation3);
        	break;
    	}
    	
    	
    }
    
    public enum MeditateState {
    	MEDITATION,
    	MEDITATION1,
    	MEDITATION2,
    	MEDITATION3,
    }
    
}
