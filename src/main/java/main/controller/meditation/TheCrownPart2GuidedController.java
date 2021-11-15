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

public class TheCrownPart2GuidedController implements Initializable {

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
    
    private String guidedImagePath = "file:Resources/Meditation/Crown.guided/CrownChakraGuided.png";
    private String guided1ImagePath = "file:Resources/Meditation/Crown.guided/CrownChakraGuided1.png";
    private String guided2ImagePath = "file:Resources/Meditation/Crown.guided/CrownChakraGuided2.png";
    private String guided3ImagePath = "file:Resources/Meditation/Crown.guided/CrownChakraGuided3.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleCrownChakraGuided(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(guidedImagePath, "Length: 35 minutes", "Name: OPEN CROWN CHAKRA - A Powerful Guided Meditation", vboxOne, meditation, MeditateState.GUIDED);
    }
    
    @FXML
    void handleCrownChakraGuided1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(guided1ImagePath, "Length: 15 minutes", "Name: Crown Chakra Balancing Guided Meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
    }
    
    @FXML
    void handleCrownChakraGuided2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(guided2ImagePath, "Length: 4 minutes", "Name: Guided Meditation: Balancing and Healing Crown Chakra", vboxThree, meditation2, MeditateState.GUIDED2);
    }

    @FXML
    void handleCrownChakraGuided3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(guided3ImagePath, "Length: 10 minutes", "Name: Crown Chakra Guided Meditation", vboxFour, meditation3, MeditateState.GUIDED3);
    }

	private void setupTextFlow() {
		text = new Text("Crown Chakra Healing\nThe seven chakras are the points that energy flows through in the body. When open and balanced, energy moves freely through them and spiritual and physical healing can occur. However, when the chakras become blocked, it can cause mental and physical disease. A blockage in the crown chakra can lead to spiritual malaise and other problems.\n"
				+ "\nUnderstanding the Crown Chakra\n\n"
				+ "The crown chakra, known as Sahasrara in Sanskrit, is the seventh major chakra. It is located on the crown of the head and is associated with spirituality. The Sahasrara chakra is violet or white, and is represented by a lotus flower with a thousand petals. This chakra is what allows people to move beyond individual materialistic needs to connect with the universal whole. Opening the crown chakra brings spiritual insight, mindfulness and the ability to live with quiet self-confidence in all aspects of life.\n"
				+ "Symptoms of Sahasrara Imbalance\n"
				+ "A deficiency in the crown chakra tends to cause subtle, systemic problems. These include:\r\n" +
				"\r\n" +
				"-Depression and mental fog\n" +
				"-Chronic fatigue\n" +
				"-Migraines and other chronic headaches\n" +
				"-Greed and materialism\n" +
				"An excess of energy in the crown chakra can also cause problems including:\n" +
				"\r\n" +
				"-Sensitivity to light and sound\n" +
				"-Neurological or endocrine disorders\n" +
				"-Boredom and frustration\n" +
				"-A sense of elitism or unearned accomplishment\n" +
				"An unbalanced crown chakra can also play a role in learning disabilities, comas, sleep disorders and mental illness.\n"
				+ "Healing the Crown Chakra\n"
				+ "The most powerful way to heal the crown chakra is through meditation. This is because of the ties between the crown chakra and spirituality. Regular meditation practice of all sorts is beneficial. For a meditation focused on Sahasrara, envision white light pouring into the top of your head, filling your body and connecting you with the world around you. If you only have a few moments to meditate, try imagining a violet lotus flower over your crown for a simple chakra meditation.\r\n" +
				"Unlike other chakras, the crown chakra does not have any healing food specific to it. This is because of its role in spiritual nourishment. Nurturing the body with wholesome, healthy foods while focusing on spiritual things can help heal this chakra."
				+ "Silence is best for crown chakra activation, because it does not distract from spiritual practice. The sound of Om and deep, tonal sounds can also be healing music for Sahasrara because of their universal nature.\r\n" +
				"\r\n" +
				"Most yoga asanas are useful for crown chakra balancing because of the meditative aspect. Slow practice that allows time for plenty of focus on the breath is ideal. This is not the time to push boundaries and strive to achieve difficult poses, but rather to work on mindfulness and meditation.\r\n" +
				"\r\n" +
				"Using chakra stones such as Selenite, Clear Quartz, Amethyst and Diamond can also be an effective way to heal the crown chakra.\r\n" +
				"\r\n" +
				"Aromatherapy for the crown chakra encompasses a wide range of scents. Flowery essential oils like jasmine, rose and lavender can soothe an overactive crown chakra, while more pungent essential oils like sandalwood, frankincense and myrrh can help stimulate an underactive or blocked Sahasrara.\r\n" +
				"\r\n" +
				"The crown chakra’s elements are thought and light, so spending time in the sunlight is good for opening the crown chakra. Reading or doing puzzles outside on a sunny day is an easy way to help heal the crown chakra.");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.WHITE);

		textFlow.getChildren().add(text);
	}

	public void popOutMessage() {
		Platform.runLater(() -> {

			JFXButton button = new JFXButton("Done");
			AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple crown chakra meditation:", "Note. You can just skip this practice if you are "
					+ "familiar with crown meditation.\n" +
					"1. Get comfortable, sitting with your back straight and your feet on the floor.\r\n" +
					"2. Put your hands in your lap and turn your palms to the sky. This position is called the “mudra” and helps you receive energy.\r\n" +
					"3. Shut your eyes and inhale through your nose, exhaling through your mouth.\r\n" +
					"4. Imagine a lotus at the top of your head. As you continue to breathe slowly and evenly, see the lotus petals unfurling to show you a bright violet light—the crown chakra color.\r\n" +
					"5. Picture the light getting brighter and brighter, warming the crown of your head.\r\n" +
					"6. Let that warmth spread downwards throughout your whole body.\r\n" +
					"7. After 5-10 minutes, open your eyes and sit quietly for a few minutes.");
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
    		musicPlayer.playMusic("Resources/Meditation/Crown.guided/Crown chakra guided meditation 35min.mp3");
    	else if(medState == MeditateState.GUIDED1)
    		musicPlayer.playMusic("Resources/Meditation/Crown.guided/Crown chakra guided meditation1 15 min.mp3");
    	else if(medState == MeditateState.GUIDED2)
    		musicPlayer.playMusic("Resources/Meditation/Crown.guided/Crown chakra guided meditation2 4 min.mp3");
    	else if(medState == MeditateState.GUIDED3)
    		musicPlayer.playMusic("Resources/Meditation/Crown.guided/Crown chakra guided meditation3 10 min.mp3");
    	
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
             	loadNextScene(guidedImagePath, "Length: 35 minutes", "Name: OPEN CROWN CHAKRA - A Powerful Guided Meditation", vboxOne, meditation, MeditateState.GUIDED);
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
             	loadNextScene(guided1ImagePath, "Length: 15 minutes", "Name: Crown Chakra Balancing Guided Meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
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
             	loadNextScene(guided2ImagePath, "Length: 4 minutes", "Name: Guided Meditation: Balancing and Healing Crown Chakra", vboxThree, meditation2, MeditateState.GUIDED2);
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
             	loadNextScene(guided3ImagePath, "Length: 10 minutes", "Name: Crown Chakra Guided Meditation", vboxFour, meditation3, MeditateState.GUIDED3);
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
