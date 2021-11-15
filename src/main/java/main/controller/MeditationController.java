
package main.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

public class MeditationController implements Initializable{

    @FXML
    private StackPane rootMeditationPane;

    @FXML
    private AnchorPane anchorPaneMeditation;

    @FXML
    private CheckMenuItem fullscreenMenuItem;

    @FXML
    private JFXButton crownButton;
    
    private MusicPlayer musicPlayer = new MusicPlayer();
    
    /*
	 * UPDATE AVAILABLE
	 */
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MainController.isSplashLoaded = true; 
		
		rootMeditationPane.setOpacity(0);
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootMeditationPane);
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
    	yesButton.setOnAction(event2 -> ((Stage)rootMeditationPane.getScene().getWindow()).close());
    	AlertSelector.jfxPopOutDialog(rootMeditationPane, anchorPaneMeditation, Arrays.asList(noButton, yesButton),
				"Are you sure want to stop meditating ?", "");
    	
    }
    

    @FXML
    void handleMorningMeditationAnaMenuItem(ActionEvent event) {
    	loadMeditateState("file:Resources/Meditation/More.meditations/MorningMeditationAna.png");
    	musicPlayer.playMusic("Resources/Meditation/More.meditations/MorningMeditationAna.mp3");
    }
    
    @FXML
    void handleBeforeSleepMeditationAnaMenuItem(ActionEvent event) {
     	loadMeditateState("file:Resources/Meditation/More.meditations/BeforeSleepMeditationAna.png");
    	musicPlayer.playMusic("Resources/Meditation/More.meditations/BeforeSleepMeditationAna.mp3");
    }
    
    @FXML
    void handleMorningMeditationAbrahamMenuItem(ActionEvent event) {
     	loadMeditateState("file:Resources/Meditation/More.meditations/MorningMeditationAbraham.png");
    	musicPlayer.playMusic("Resources/Meditation/More.meditations/MorningMeditationAbraham.mp3");
    }
    
    @FXML
    void handleAffirmationsAbrahamMenuItem(ActionEvent event) {
     	loadMeditateState("file:Resources/Meditation/More.meditations/AffirmationsAbraham.png");
    	musicPlayer.playMusic("Resources/Meditation/More.meditations/AffirmationsAbraham.mp3");
    }

    @FXML
    void handleBrowButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_BROW_PART1_STAGE), "Brow Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleCrownButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_CROWN_PART1_STAGE), "Crown Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleHeartButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_HEART_PART1_STAGE), "Heart Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleNavelButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_NAVEL_PART1_STAGE), "Navel Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleRootButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_ROOT_PART1_STAGE), "Root Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleSacralButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_SACRAL_PART1_STAGE), "Sacral Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleThroatButton(ActionEvent event) {
    	WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.THE_THROAT_PART1_STAGE), "Throat Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
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
}
