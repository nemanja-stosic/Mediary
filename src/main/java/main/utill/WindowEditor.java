package main.utill;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowEditor {

    private WindowEditor() {
        throw new IllegalStateException("Utility class");
    }

    public enum StageSelector {
        HOME_STAGE,

        MEDITATION_SPLASH_SCREEN_STAGE,
        DIARY_SPLASH_SCREEN_STAGE,

        MEDITATION_INTRO_STAGE,
        MEDITATION_STAGE,
        THE_CROWN_PART1_STAGE,
        THE_CROWN_PART2_GUIDED_STAGE,
        THE_CROWN_PART2_STAGE,
        THE_BROW_PART1_STAGE,
        THE_BROW_PART2_GUIDED_STAGE,
        THE_BROW_PART2_STAGE,
        THE_THROAT_PART1_STAGE,
        THE_THROAT_PART2_GUIDED_STAGE,
        THE_THROAT_PART2_STAGE,
        THE_HEART_PART1_STAGE,
        THE_HEART_PART2_GUIDED_STAGE,
        THE_HEART_PART2_STAGE,
        THE_NAVEL_PART1_STAGE,
        THE_NAVEL_PART2_GUIDED_STAGE,
        THE_NAVEL_PART2_STAGE,
        THE_SACRAL_PART1_STAGE,
        THE_SACRAL_PART2_GUIDED_STAGE,
        THE_SACRAL_PART2_STAGE,
        THE_ROOT_PART1_STAGE,
        THE_ROOT_PART2_GUIDED_STAGE,
        THE_ROOT_PART2_STAGE,
        DIARY_STAGE,
        SHOW_DIARY_ENTRIES_STAGE,


        STYLE,
    }

    public static String setStage(StageSelector selectStage) {

        switch (selectStage) {
            case HOME_STAGE:
                return "/view/HomeStage.fxml";
            case MEDITATION_INTRO_STAGE:
                return "/view/MeditationIntroStage.fxml";
            case MEDITATION_STAGE:
                return "/view/MeditationStage.fxml";
            case MEDITATION_SPLASH_SCREEN_STAGE:
                return "/view/splashscreen/MeditationSplashScreenStage.fxml";
            case THE_CROWN_PART1_STAGE:
                return "/view/meditation/TheCrownPart1Stage.fxml";
            case THE_CROWN_PART2_GUIDED_STAGE:
                return "/view/meditation/TheCrownPart2GuidedStage.fxml";
            case THE_CROWN_PART2_STAGE:
                return "/view/meditation/TheCrownPart2Stage.fxml";
            case THE_BROW_PART1_STAGE:
                return "/view/meditation/TheBrowPart1Stage.fxml";
            case THE_BROW_PART2_GUIDED_STAGE:
                return "/view/meditation/TheBrowPart2GuidedStage.fxml";
            case THE_BROW_PART2_STAGE:
                return "/view/meditation/TheBrowPart2Stage.fxml";
            case THE_THROAT_PART1_STAGE:
                return "/view/meditation/TheThroatPart1Stage.fxml";
            case THE_THROAT_PART2_GUIDED_STAGE:
                return "/view/meditation/TheThroatPart2GuidedStage.fxml";
            case THE_THROAT_PART2_STAGE:
                return "/view/meditation/TheThroatPart2Stage.fxml";
            case THE_HEART_PART1_STAGE:
                return "/view/meditation/TheHeartPart1Stage.fxml";
            case THE_HEART_PART2_GUIDED_STAGE:
                return "/view/meditation/TheHeartPart2GuidedStage.fxml";
            case THE_HEART_PART2_STAGE:
                return "/view/meditation/TheHeartPart2Stage.fxml";
            case THE_NAVEL_PART1_STAGE:
                return "/view/meditation/TheNavelPart1Stage.fxml";
            case THE_NAVEL_PART2_GUIDED_STAGE:
                return "/view/meditation/TheNavelPart2GuidedStage.fxml";
            case THE_NAVEL_PART2_STAGE:
                return "/view/meditation/TheNavelPart2Stage.fxml";
            case THE_SACRAL_PART1_STAGE:
                return "/view/meditation/TheSacralPart1Stage.fxml";
            case THE_SACRAL_PART2_GUIDED_STAGE:
                return "/view/meditation/TheSacralPart2GuidedStage.fxml";
            case THE_SACRAL_PART2_STAGE:
                return "/view/meditation/TheSacralPart2Stage.fxml";
            case THE_ROOT_PART1_STAGE:
                return "/view/meditation/TheRootPart1Stage.fxml";
            case THE_ROOT_PART2_GUIDED_STAGE:
                return "/view/meditation/TheRootPart2GuidedStage.fxml";
            case THE_ROOT_PART2_STAGE:
                return "/view/meditation/TheRootPart2Stage.fxml";
            case SHOW_DIARY_ENTRIES_STAGE:
                return "/view/ShowDiaryEntriesStage.fxml";
            case DIARY_SPLASH_SCREEN_STAGE:
                return "/view/splashscreen/DiarySplashScreenStage.fxml";
            case DIARY_STAGE:
                return "/view/DiaryStage.fxml";
            case STYLE:
                return "/css/style.css";
            default:
                return null;
        }

    }

    public static void loadModalityWindowWithoutUNDECORATED(String fxml, String title, String css, Boolean setResizableWindow) {
        try {
            Stage subWindow = new Stage();
            subWindow.setResizable(setResizableWindow);
            subWindow.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(WindowEditor.class.getResource(fxml).openStream());

            Scene scene = new Scene(parent);
            scene.getStylesheets().setAll(WindowEditor.class.getResource(css).toExternalForm());
            subWindow.setScene(scene);
            subWindow.setTitle(title);
            subWindow.show();
        } catch (IOException e) {
            Logger.getLogger(WindowEditor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void loadModalityWindow(String fxml, String title, String css, Boolean setResizableWindow) {
        try {
            Stage subWindow = new Stage();
            subWindow.setResizable(setResizableWindow);
            subWindow.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            Parent parent = loader.load(WindowEditor.class.getResource(fxml).openStream());


            Scene scene = new Scene(parent);
            scene.getStylesheets().setAll(WindowEditor.class.getResource(css).toExternalForm());
            subWindow.setScene(scene);
            subWindow.setTitle(title);
            subWindow.setFullScreen(setResizableWindow);
            subWindow.initStyle(StageStyle.UNDECORATED);
            subWindow.show();
        } catch (IOException e) {
            Logger.getLogger(WindowEditor.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public enum TransitionType {
        FADE_IN,
        FADE_OUT
    }

    public static FadeTransition setFadingTransitionEffect(TransitionType type, Duration transitionTime, Node node) {
        if (type == TransitionType.FADE_IN) {
            FadeTransition fadeIn = new FadeTransition(transitionTime, node);
            //setting opacity from 0 to 1
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            fadeIn.play();
            return fadeIn;
        } else {
            FadeTransition fadeOut = new FadeTransition(transitionTime, node);
            //setting opacity from 0 to 1
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(0);
            return fadeOut;
        }
    }

    public static void setTransition(Pane pane, String xOrY, int valueX, int valueY) {
        //depending on X or Y transition you need to set the layoutX or layoutY on rootPane
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setNode(pane);
        if (xOrY.equalsIgnoreCase("x")) transition.setToX(valueX);
        else if (xOrY.equalsIgnoreCase("y")) transition.setToY(valueX);
        else if (xOrY.equalsIgnoreCase("xy")) {
            transition.setToX(valueX);
            transition.setToY(valueY);
        }

        transition.play();
    }

    public static void setIcon(Stage stage, String image) {
        stage.getIcons().add(new Image(image));
    }

    public static void makeFolder(String path, String folderName) {
        File file = new File(path + folderName);
        if (!file.exists()) file.mkdir();
    }

}
