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
import java.util.ResourceBundle;

public class TheBrowPart2Controller implements Initializable {

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
    
    private String meditationImagePath = "file:Resources/Meditation/Brow/BrowChakra.png";
    private String meditation1ImagePath = "file:Resources/Meditation/Brow/BrowChakra1.png";
    private String meditation2ImagePath = "file:Resources/Meditation/Brow/BrowChakra2.png";
    private String meditation3ImagePath = "file:Resources/Meditation/Brow/BrowChakra3.png";
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		popOutMessage();
		setupTextFlow();
		setupMeditationsImageViews();
	}
	
    @FXML
    void handleBrowChakraMeditation(MouseEvent event) {
     	vboxOne.setTranslateX(-450);
    	WindowEditor.setTransition(vboxOne, "x", 450, 0);
     	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Powerful Balancing and activation brow - third eye chakra \nmeditation", vboxOne, meditation, MeditateState.MEDITATION);
    }
    
    @FXML
    void handleBrowChakraMeditation1(MouseEvent event) {
    	vboxTwo.setTranslateX(-450);
     	vboxTwo.setTranslateY(-200);
    	WindowEditor.setTransition(vboxTwo, "xy", 0, 0);
    	loadNextScene(meditation1ImagePath, "Length: 15 minutes", "Name: Heaven is in Your Mind - Third Eye meditation", vboxTwo, meditation1, MeditateState.MEDITATION1);
    }
    
    @FXML
    void handleBrowChakraMeditation2(MouseEvent event) {
    	vboxThree.setTranslateX(-450);
    	vboxThree.setTranslateY(-400);
    	WindowEditor.setTransition(vboxThree, "xy", 0, 0);
    	loadNextScene(meditation2ImagePath, "Length: 6 minutes", "Name: Ajna or BrowThird Eye Chakra - Meditation, Balancing and \nTuning", vboxThree, meditation2, MeditateState.MEDITATION2);
    }

    @FXML
    void handleBrowChakraMeditation3(MouseEvent event) {
    	vboxFour.setTranslateX(-450);
    	vboxFour.setTranslateY(-600);
    	WindowEditor.setTransition(vboxFour, "xy", 0, 0);
    	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Beautiful Awaken Open Your Third Eye ", vboxFour, meditation3, MeditateState.MEDITATION3);
    }

	private void setupTextFlow() {
		text = new Text("Brow - The Third Eye chakra\nThe most common Sanskrit name for the Third eye chakra is “Ajna”, which means “command” and “perceiving”.\r\n" +
				"\r\n" +
				"This chakra is related to the “supreme element”, which is the combination of all the elements in their pure form."
				+ "Third eye chakra color\r\n" +
				"The third eye chakra is most commonly represented with the color purple or bluish purple. The auric color of third eye chakra energy can also be seen as translucent purple or bluish white. "
				+ "Rather than by its color, it is characterized by the quality of its luminescence or soft radiance that reminds us of the moon light.\r\n" +
				"\r\n" +
				"Third eye chakra symbol\r\n" +
				"The image of the Third Eye chakra symbol contains two elements frequently associated with wisdom: the upside down triangle and the lotus flower.\r\n" +
				"\r\n" +
				"Third eye chakra location\r\n" +
				"The most commonly accepted location for the sixth chakra is between the eyebrows, slightly above at the bridge of your nose. Contrary to a common misconception, it is not located in the middle of the forehead, but between the eyes where the eyebrows would meet. It can also be described as being located behind the eyes in the middle of the head. Note that secondary chakras run along the midline of the forehead, but the third eye chakra is typically located lower.\r\n" +
				"\r\n" +
				"The Third eye chakra is associated to the pineal gland in charge of regulating biorhythms, including sleep and wake time. It’s a gland located in the brain that is a center of attention because of its relationship with the perception and effect of light and altered or “mystical” states of consciousness. It’s positioned close to the optical nerves, and as such, sensitive to visual stimulations and changes in lighting.\n The third eye awakening is known as the sixth chakra where you really listen to your inner voice and intuition. This helps you with making clear decisions for you to reach your true purpose and mission in life.\n"
				+ "SIGNS YOUR THIRD EYE IS STARTING TO SEE:\n"
				+ "1. An Increasing Pressure in Your Head\r\n" +
				"This is the most common symptom of an open third eye; you will begin to feel a growing pressure between your eyebrows. This can be just a pulse or an intense sense of something expanding in the middle of your forehead. Spiritual experts advise you against worrying about this, as it is completely benign and will fade away in due time. They also say that it may seemingly come out of nowhere, and that a feeling of warmth on your forehead as if someone were touching, it is fairly normal. So don’t freak out when it happens.\n"
				+ "2. Foresight\r\n" +
				"You might experience instances of increased foresight of future events. It might just be a small tug in your stomach that alarms you that something is going to happen before it does. Do not overlook this feeling or intuition, and let it guide you forward. It might be scary at first, but the moment you realize that this power is completely controlled by you, you will have an easier time letting it show you the way.\r\n" +
				"\r\n" +
				"3. Sensitivity to Light\r\n" +
				"As your third eye expands, you will find that you are more prone to light sensitivity. This is due to the fact that you are, literally, perceiving the world in a new light. You will also be able to perceive the different hues of colors in a more vivid fashion. Overall, everything related to vision and light will be heightened. You might find that polarized sunglasses help with this.\r\n" +
				"\r\n" +
				"4. Gradual Changes\r\n" +
				"Because you are more in sync with your spiritual self, you will reap the benefits of your new view of the world. You will find that you are calmer, more forgiving, and loving. These changes can also impact your diet as you will steer away from processed foods to keep your third eye clear. You may not find a reason for these good changes, but rest assured that it is your intuition and spiritual powers that are guiding you to healthier life choices. Monitor these changes as they are a sure-fire way of verifying that your third eye is indeed expanding.\r\n" +
				"\r\n" +
				"5. Manifestation of Powers\r\n" +
				"Contrary to popular belief, psychic powers manifesting in people who have an active third eye are not uncommon. Telepathy and clairvoyance are two of the most prominent examples of this. No matter how unfamiliar this can be to you, you must not fret. Embrace your powers and nurture them.\r\n" +
				"\r\n" +
				"6. Seeing Beyond the Obvious\r\n" +
				"Although it can be a burden to know and see more than everyone does, your third eye will enable you to spot half-lies and shiny slogans. A restaurant that offers an all-you-can-eat assortment of food can be enticing to the normal individual, but for you, it will be akin to an invitation to consuming more than you need. This clarity of thought will let you make the right decisions.\r\n" +
				"\r\n" +
				"7. Heightened Sense of the Self\r\n" +
				"This final sign is one that many do not even take notice of. An open third eye will increase your sense of inner self. So, instead of defining yourself as a mere person with interests, likes, and dislikes, you will instead think of yourself as a part of the fabric of the universe. This increased sense of self will enable you to rely more on yourself rather than anyone else and let you achieve the successful life you have always dreamed of having.\r\n" +
				"\r\n" +
				"Experiencing the signs of an active third eye can be confusing and even downright scary if you do not know how to deal with them. Meditation and calming activities that let you have a deeper connection with your spiritual self will be your greatest asset. Regardless of the path, you will choose, always know that all of these manifestations are a blessing you should embrace, not hide.");
		text.setFont(new Font("Arial", 28));
		text.setFill(Color.VIOLET);

		textFlow.getChildren().add(text);
	}
    
    public void popOutMessage() {
    	Platform.runLater(() -> AlertSelector.showInformationWithImageView("Note. You can just skip this practice if you are familiar with brow - third eye\n meditation.", "file:Resources/Mediary.data.images/BrowChakraMessage.png"));
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
    		musicPlayer.playMusic("Resources/Meditation/Brow/BrowChakraMeditation.mp3");
    	else if(medState == MeditateState.MEDITATION1)
    		musicPlayer.playMusic("Resources/Meditation/Brow/BrowChakraMeditation1.mp3");
    	else if(medState == MeditateState.MEDITATION2)
    		musicPlayer.playMusic("Resources/Meditation/Brow/BrowChakraMeditation2.mp3");
    	else if(medState == MeditateState.MEDITATION3)
    		musicPlayer.playMusic("Resources/Meditation/Brow/BrowChakraMeditation3.mp3");
    	
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
             	loadNextScene(meditationImagePath, "Length: 15 minutes", "Name: Powerful Balancing and activation brow - third eye chakra \nmeditation", vboxOne, meditation, MeditateState.MEDITATION);
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
             	loadNextScene(meditation1ImagePath, "Length: 15 minutes", "Name: Heaven is in Your Mind - Third Eye meditation", vboxTwo, meditation1, MeditateState.MEDITATION1);
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
             	loadNextScene(meditation2ImagePath, "Length: 6 minutes", "Name: Ajna or BrowThird Eye Chakra - Meditation, Balancing and \nTuning", vboxThree, meditation2, MeditateState.MEDITATION2);
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
             	loadNextScene(meditation3ImagePath, "Length: 60 minutes", "Name: Beautiful Awaken Open Your Third Eye", vboxFour, meditation3, MeditateState.MEDITATION3);
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
