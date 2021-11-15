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

public class TheSacralPart2Controller implements Initializable {

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
    
    private String meditationImagePath = "file:Resources/Meditation/Sacral/SacralChakra.png";
    private String meditation1ImagePath = "file:Resources/Meditation/Sacral/SacralChakra1.png";
    private String meditation2ImagePath = "file:Resources/Meditation/Sacral/SacralChakra2.png";
    private String meditation3ImagePath = "file:Resources/Meditation/Sacral/SacralChakra3.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleSacralChakraMeditation(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Sacral Chakra Activation and Balancing", vboxOne, meditation, MeditateState.MEDITATION);
    }
    
    @FXML
    void handleSacralChakraMeditation1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(meditation1ImagePath, "Length: 4 minutes", "Name: Sacral Chakra Meditation Muladhara Sound Juliette", vboxTwo, meditation1, MeditateState.MEDITATION1);
    }
    
    @FXML
    void handleSacralChakraMeditation2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(meditation2ImagePath, "Length: 15 minutes", "Name: Sacral Chakra Alpha Waves Binaural Beats ", vboxThree, meditation2, MeditateState.MEDITATION2);
    }

    @FXML
    void handleSacralChakraMeditation3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Music BOOST SELF ESTEEM & CREATIVITY", vboxFour, meditation3, MeditateState.MEDITATION3);
    }

	private void setupTextFlow() {
		text = new Text("Sacral chakra meaning\r\n" +
				"The second chakra is referred to as:\r\n" +
				"\r\n" +
				"-Sacral chakra\r\n" +
				"-Svadhisthana\r\n" +
				"-Adhishthan\r\n" +
				"-Shaddala\r\n" +
				"The most common Sanskrit name for the sacral chakra is “Svadhisthana”, which means “your own place”.\r\n" +
				"\r\n" +
				"Sacral chakra color\r\n" +
				"The sacral chakra is most commonly represented with the color orange. However, since it’s associated with the element of water, it could also take the color of very light blue or white in more rare occasions.\r\n" +
				"\r\n" +
				"The orange of the second chakra is translucent and has a transparent quality.\r\n" +
				"\r\n" +
				"Sacral chakra symbol\r\n" +
				"The symbol of the sacral chakra is composed of:\r\n" +
				"\r\n" +
				"-A circle with six petals\r\n" +
				"-A moon crescent\r\n" +
				"The circle represents the elements of water. Typically, the moon crescent is colored in silver and represents the connection of the energy of the moon with water. These symbols point to the close relationship between the phases of the moon and the fluctuations in the water and the emotions.\r\n" +
				"\r\n" +
				"Furthermore, the symbolism of the moon relates to the feminine menstrual cycle that takes the same number of days to complete and the connection of the sacral chakra with sexual organs and reproduction.");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.ORANGE);

		textFlow.getChildren().add(text);
	}

	public void popOutMessage() {
		Platform.runLater(() -> {

			JFXButton button = new JFXButton("Done");
			AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple sacral chakra meditation:", "Note. You can just skip this practice if you are "
					+ "familiar with navel meditation.\n" +
					"1. Sit in a comfortable, quiet place where you won’t be disturbed. Keep your spine straight, and your limbs relaxed.\r\n" +
					"2. Take ten slow, deep breaths.\r\n" +
					"3. Picture a spinning orange circle in the location of your sacral chakra.\r\n" +
					"4. Since the sacral chakra’s element is water, imagine the orange light of the chakra spreading out in rippling waves, slowly enveloping your whole body. Feel yourself warming up in response.\r\n" +
					"5. Do this for as long as you like (preferably for at least five minutes), then open your eyes when you’re ready.");
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
    		musicPlayer.playMusic("Resources/Meditation/Sacral/SacralChakraMeditation.mp3");
    	else if(medState == MeditateState.MEDITATION1)
    		musicPlayer.playMusic("Resources/Meditation/Sacral/SacralChakraMeditation1.mp3");
    	else if(medState == MeditateState.MEDITATION2)
    		musicPlayer.playMusic("Resources/Meditation/Sacral/SacralChakraMeditation2.mp3");
    	else if(medState == MeditateState.MEDITATION3)
    		musicPlayer.playMusic("Resources/Meditation/Sacral/SacralChakraMeditation3.mp3");
    	
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
             	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Sacral Chakra Activation and Balancing", vboxOne, meditation, MeditateState.MEDITATION);
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
             	loadNextScene(meditation1ImagePath, "Length: 4 minutes", "Name: Sacral Chakra Meditation Muladhara Sound Juliette", vboxTwo, meditation1, MeditateState.MEDITATION1);
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
             	loadNextScene(meditation2ImagePath, "Length: 15 minutes", "Name: Sacral Chakra Alpha Waves Binaural Beats ", vboxThree, meditation2, MeditateState.MEDITATION2);
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
             	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Music BOOST SELF ESTEEM & CREATIVITY", vboxFour, meditation3, MeditateState.MEDITATION3);
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
