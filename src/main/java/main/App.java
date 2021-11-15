package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.utill.WindowEditor;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    /*
        and continue with diary, last change was splash screen FXML
     */

    public static double monitorWidth = 0;
    public static double monitorHeight = 0;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Mediary");
        stage.setScene(loadScene(loadPane(), stage));
        stage.setResizable(false);
        stage.show();
        WindowEditor.setIcon(stage, "file:Resources/Mediary.data.images/MediaryIcon.png");
        setMonitorResolution();
    }

    private Pane loadPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.HOME_STAGE))));

    }

    private Scene loadScene(Pane pane, Stage stage) {
        Scene scene = new Scene(pane);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass().getResource(
                Objects.requireNonNull(WindowEditor.setStage(WindowEditor.StageSelector.STYLE)))).toExternalForm());
        return scene;
    }

    private static void setMonitorResolution() {
        Rectangle2D mainScreenSize = Screen.getPrimary().getBounds();
        monitorHeight = mainScreenSize.getHeight();
        monitorWidth = mainScreenSize.getWidth();
    }

    public static void main(String[] args) {
        launch();
    }

}