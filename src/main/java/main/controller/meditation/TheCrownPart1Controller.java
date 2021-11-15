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

public class TheCrownPart1Controller implements Initializable {

    @FXML
    private StackPane rootCrownPane;

    @FXML
    private AnchorPane crownAnchorPane;

    @FXML
    private ImageView crownMeditationImageView;

    @FXML
    private ImageView guidedCrownMeditationImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(3), rootCrownPane);
		
		crownMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/CrownMeditationImage.png"));
		guidedCrownMeditationImageView.setImage(new Image("file:Resources/Mediary.data.images/CrownMeditationGuidedImage.png"));

	}
    
    @FXML
    void handleCrownMeditation(MouseEvent event) {
    	((Stage)rootCrownPane.getScene().getWindow()).close();
    	WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_CROWN_PART2_STAGE),
				"Crown Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

    @FXML
    void handleGuidedCrownMeditation(MouseEvent event) {
    	((Stage)rootCrownPane.getScene().getWindow()).close();
		WindowEditor.loadModalityWindowWithoutUNDECORATED(WindowEditor.setStage(WindowEditor.StageSelector.THE_CROWN_PART2_GUIDED_STAGE),
				"Guided Crown Meditations", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
    }

}
