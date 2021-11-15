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

public class TheNavelPart2GuidedController implements Initializable {

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
    
    private String guidedImagePath = "file:Resources/Meditation/Navel.guided/NavelChakraGuided.png";
    private String guided1ImagePath = "file:Resources/Meditation/Navel.guided/NavelChakraGuided1.png";
    private String guided2ImagePath = "file:Resources/Meditation/Navel.guided/NavelChakraGuided2.png";
    private String guided3ImagePath = "file:Resources/Meditation/Navel.guided/NavelChakraGuided3.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleNavelChakraGuided(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(guidedImagePath, "Length: 22 minutes", "Name: Balance your solar plexus chakra", vboxOne, meditation, MeditateState.GUIDED);
    }
    
    @FXML
    void handleNavelChakraGuided1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(guided1ImagePath, "Length: 25 minutes", "Name: Solar Plexus Chakra Healing Guided Meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
    }
    
    @FXML
    void handleNavelChakraGuided2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(guided2ImagePath, "Length: 25 minutes", "Name: Manipura Chakra Meditation RAM chanting", vboxThree, meditation2, MeditateState.GUIDED2);
    }

    @FXML
    void handleNavelChakraGuided3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(guided3ImagePath, "Length: 14 minutes", "Name:Activating Flow of Solar Plexus Chakra Meditation", vboxFour, meditation3, MeditateState.GUIDED3);
    }

	private void setupTextFlow() {
		text = new Text("How To Heal Your Solar Plexus Chakra\r\n" +
				"Healing the solar plexus chakra is a simple process, but it may take some practice. Most people have built up a blockage over many years, so chakra balancing will take time. There are some solar plexus chakra healing exercises that are easy to practice every day.\r\n" +
				"\r\n" +
				"The chakra color associated with Manipura is yellow, which means that bananas, sunflower seeds, yellow peppers and cheeses are good solar plexus chakra healing food. Spices for the solar plexus chakra are ginger, chamomile, mint, and cumin.\r\n" +
				"\r\n" +
				"Meditation can help with opening Manipura. A simple exercise is to simply envision a brilliant yellow sunflower over your solar plexus chakra. This can be even more effective with the use of chakra stones. Solar plexus chakra healing stones include yellow stones like citrine, amber, yellow tourmaline and tiger’s eye.\n"
				+ "Since the solar plexus chakra is associated with the sun and fire, simply getting outside can help. Meditating or doing yoga outdoors on sunny days will maximize your healing practice, but simply going outside for a walk or doing a little sunbathing will help open your solar plexus chakra.");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.YELLOW);

		textFlow.getChildren().add(text);
	}

	public void popOutMessage() {
		Platform.runLater(() -> {

			JFXButton button = new JFXButton("Done");
			AlertSelector.jfxPopOutDialog(rootPane, scrollPane, Arrays.asList(button), "Simple navel chakra meditation:", "Note. You can just skip this practice if you are "
					+ "familiar with navel meditation.\n" +
					"1. Turn your attention to your upper abdomen, where the solar plexus chakra resides.\r\n" +
					"2. Picture a round sphere of glowing yellow light in the center of the upper abdomen, and slowly concentrate on making the energy wider and brighter.\r\n" +
					"3. Imagine the sphere rotating (clockwise) as it grows, and feel the area becoming warmer and more relaxed as you do this.\r\n" +
					"4. After 3-5 minutes, let the energy dissipate throughout your body, take a few deep breaths again and open your eyes.");
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
    		musicPlayer.playMusic("Resources/Meditation/Navel.guided/NavelChakraGuided.mp3");
    	else if(medState == MeditateState.GUIDED1)
    		musicPlayer.playMusic("Resources/Meditation/Navel.guided/NavelChakraGuided1.mp3");
    	else if(medState == MeditateState.GUIDED2)
    		musicPlayer.playMusic("Resources/Meditation/Navel.guided/NavelChakraGuided2.mp3");
    	else if(medState == MeditateState.GUIDED3)
    		musicPlayer.playMusic("Resources/Meditation/Navel.guided/NavelChakraGuided3.mp3");
    	
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
             	loadNextScene(guidedImagePath, "Length: 22 minutes", "Name: Balance your solar plexus chakra", vboxOne, meditation, MeditateState.GUIDED);
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
             	loadNextScene(guided1ImagePath, "Length: 25 minutes", "Name: Solar Plexus Chakra Healing Guided Meditation", vboxTwo, meditation1, MeditateState.GUIDED1);
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
             	loadNextScene(guided2ImagePath, "Length: 25 minutes", "Name: Manipura Chakra Meditation RAM chanting", vboxThree, meditation2, MeditateState.GUIDED2);
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
             	loadNextScene(guided3ImagePath, "Length: 14 minutes", "Name:Activating Flow of Solar Plexus Chakra Meditation", vboxFour, meditation3, MeditateState.GUIDED3);
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
