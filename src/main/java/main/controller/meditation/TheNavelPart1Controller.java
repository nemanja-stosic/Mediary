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

public class TheNavelPart1Controller implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView navelMeditationImageView;

    @FXML
    private ImageView guidedNavelMeditationImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootPane);
		
		navelMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/NavelMeditationImage.png"));
		guidedNavelMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/NavelMeditationGuidedImage.png"));

	}

    @FXML
    void handleNavelMeditation(MouseEvent event) {
    	((Stage)rootPane.getScene().getWindow()).close();
    	WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_NAVEL_PART2_STAGE),
				"Navel Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleGuidedNavelMeditation(MouseEvent event) {
    	((Stage)rootPane.getScene().getWindow()).close();
		WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_NAVEL_PART2_GUIDED_STAGE),
				"Guided Navel Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

}
