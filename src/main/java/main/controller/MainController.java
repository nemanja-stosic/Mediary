package main.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.model.SplashScreenSelector;
import main.utill.WindowEditor;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML
    private ImageView diaryImage;

    @FXML
    private ImageView medImage;

    @FXML
    private StackPane rootPane;

    private FadeTransition fadeIn;
    private FadeTransition fadeOut;

    public static boolean isSplashLoaded = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupBackground();
    }

    @FXML
    void handleMeditation(MouseEvent event) {
        loadSplashScreen(SplashScreenSelector.MEDITATION);
    }

    @FXML
    void handleDiary(MouseEvent event) {
        loadSplashScreen(SplashScreenSelector.DIARY);
    }

    private void setupBackground() {
        medImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/css/images/meditation.jpg"))));
        diaryImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/css/images/diary.jpg"))));
    }

    private void loadSplashScreen(SplashScreenSelector selectSplashScreen) {
        try {

            StackPane pane = null;

            if (selectSplashScreen == SplashScreenSelector.MEDITATION) {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Objects.requireNonNull(
                        WindowEditor.setStage(WindowEditor.StageSelector.MEDITATION_SPLASH_SCREEN_STAGE)))));

                rootPane.getChildren().setAll(pane);

                FadeTransition fadeIn = WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN,
                        Duration.seconds(5), pane);
                FadeTransition fadeOut = WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_OUT,
                        Duration.seconds(5), pane);

                fadeIn.setOnFinished(event -> fadeOut.play());

                fadeOut.setOnFinished(event -> {
                    StackPane main = null;
                    try {
                        main = FXMLLoader.load(Objects.requireNonNull(
                                getClass().getResource(Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.HOME_STAGE)))));
                    } catch (IOException e) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, "main stage load failed...",
                                e);
                    }
                    rootPane.getChildren().setAll(main);
                    WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.MEDITATION_INTRO_STAGE),
                            "Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);

                });

            } else if (selectSplashScreen == SplashScreenSelector.DIARY) {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.DIARY_SPLASH_SCREEN_STAGE)))));

                rootPane.getChildren().setAll(pane);

                FadeTransition fadeIn = WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN,
                        Duration.seconds(5), pane);
                FadeTransition fadeOut = WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_OUT,
                        Duration.seconds(5), pane);

                fadeIn.setOnFinished(event -> fadeOut.play());

                fadeOut.setOnFinished(event -> {
                    StackPane main = null;
                    try {
                        main = FXMLLoader.load(Objects.requireNonNull(
                                getClass().getResource(Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.HOME_STAGE)))));
                    } catch (IOException e) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, "main stage load failed...",
                                e);
                    }
                    rootPane.getChildren().setAll(main);
                    WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.DIARY_STAGE), "Diary",
                            WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);

                });
            }

        } catch (IOException e) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, "loadSplashScreen failed...", e);
        }
    }
}
