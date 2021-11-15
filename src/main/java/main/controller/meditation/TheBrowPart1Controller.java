package main.controller.meditation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.utill.AlertSelector;
import main.utill.WindowEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class TheBrowPart1Controller implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView browMeditationImageView;

    @FXML
    private ImageView guidedBrowMeditationImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		browMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/BrowMeditationImage.png"));
		guidedBrowMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/BrowMeditationGuidedImage.png"));

	}

    @FXML
    void handleBrowMeditation(MouseEvent event) {
    	((Stage)rootPane.getScene().getWindow()).close();
    	WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_BROW_PART2_STAGE),
				"Brow Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleGuidedBrowMeditation(MouseEvent event) {
    	((Stage)rootPane.getScene().getWindow()).close();
		WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_BROW_PART2_GUIDED_STAGE),
				"Guided Brow Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

}
