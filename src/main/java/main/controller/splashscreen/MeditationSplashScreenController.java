package main.controller.splashscreen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MeditationSplashScreenController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		imageView.setImage(new Image("file:Resources/Mediary.data.images/MeditationSplashScreenImage.png"));
	}

}
