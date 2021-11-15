package main.utill;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

import java.util.List;
import java.util.Optional;

public class AlertSelector {
	
	private static boolean answer;
	
	private AlertSelector() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void errorAlert(String title, String headerText, String contentText) {
		Alert error = new Alert(Alert.AlertType.ERROR);
		error.setTitle(title);
		error.setHeaderText(headerText);
		error.setContentText(contentText);
		error.showAndWait();
	}
	
	public static void warningAlert(String title, String headerText, String contentText) {
		Alert warning = new Alert(Alert.AlertType.WARNING);
		warning.setTitle(title);
		warning.setHeaderText(headerText);
		warning.setContentText(contentText);
		
		DialogPane dialogPane = warning.getDialogPane();
		dialogPane.getStylesheets().add(AlertSelector.class.getResource("/dreamary/resources/css/DreamaryDarkStyle.css").toExternalForm());
		dialogPane.getStyleClass().add("DreamaryDarkStyle.css");
		
		warning.showAndWait();
	}

	public static void informationAlert(String title, String headerText, String contentText) {
		Alert info = new Alert(Alert.AlertType.INFORMATION);
		info.setTitle(title);
		info.setHeaderText(headerText);
		info.setContentText(contentText);
		info.showAndWait();
	}
	
	public static void extraInformationAlert(String title, String headerText, String contentText, String textArea) {
		Alert info = new Alert(Alert.AlertType.INFORMATION);
		info.setTitle(title);
		info.setHeaderText(headerText);
		info.setContentText(contentText);
		
		TextArea area = new TextArea(textArea);
		
		info.getDialogPane().setExpandableContent(area);
		info.showAndWait();
	}
	

	public static boolean confirmationAlert(String title, String message) {

		Stage confirmBoxWindow = new Stage();

		confirmBoxWindow.initModality(Modality.APPLICATION_MODAL);
		confirmBoxWindow.setTitle(title);
		confirmBoxWindow.setMinWidth(350);
		confirmBoxWindow.setMinHeight(170);

		Label label = new Label(message);
		label.setFont(new Font("Euphemia", 17));
		label.setStyle("-fx-text-fill: #FFFFFF");
		
		//Creating buttons
		Button yesButton = new Button("Yes");
		yesButton.setMinWidth(70);
		yesButton.setMinHeight(20);
		
		final String BUTTON_STYLE = "-fx-background-color: #1E88E5; -fx-background-radius: 10";
		final String HOVER_YES_BUTTON_STYLE = "-fx-background-color: #4CAF50; -fx-background-radius: 10";
		yesButton.setStyle(BUTTON_STYLE);
		yesButton.setOnMouseEntered(event -> yesButton.setStyle(HOVER_YES_BUTTON_STYLE));
		yesButton.setOnMouseExited(event -> yesButton.setStyle(BUTTON_STYLE));

		Button noButton = new Button("No");
		noButton.setMinWidth(70);
		noButton.setMinHeight(20);
		
		final String HOVER_NO_BUTTON_STYLE = "-fx-background-color: #d32f2f; -fx-background-radius: 10";
		noButton.setStyle(BUTTON_STYLE);
		noButton.setOnMouseEntered(event -> noButton.setStyle(HOVER_NO_BUTTON_STYLE));
		noButton.setOnMouseExited(event -> noButton.setStyle(BUTTON_STYLE));
		
		yesButton.setOnAction(e -> {
			answer = true;
			confirmBoxWindow.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			confirmBoxWindow.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label);
		layout.setAlignment(Pos.CENTER);
			
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(yesButton, noButton);
		layout2.setSpacing(20);
		layout2.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(layout);
		borderPane.setCenter(layout2);
		borderPane.setStyle("-fx-background-color: #455A64;");

		Scene scene = new Scene(borderPane);
		confirmBoxWindow.setScene(scene);
		confirmBoxWindow.setResizable(false);
		confirmBoxWindow.showAndWait();
		
		return answer;

	}
	
	public static void loginWindow() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Look, a Custom Login Dialog");

		// Set the icon (must be included in the project).
		dialog.setGraphic(new ImageView(AlertSelector.class.getResource("login.png").toString()));

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(username.getText(), password.getText());
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
		    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		});
	}
	
	public static void jfxPopOutDialog(StackPane rootPane, Node nodeToBeBlured, List<JFXButton> controls, String heading, String body) {
		 BoxBlur blur = new BoxBlur(3, 3, 3); //width, height, iterations(intensity of blurs i think)
		 
		 JFXDialogLayout dialogLayout = new JFXDialogLayout();
		 JFXDialog dialog = new JFXDialog(rootPane, dialogLayout, JFXDialog.DialogTransition.TOP);
		 
		 controls.forEach(controlButton -> {
			 controlButton.getStyleClass().add("dialog-button");
			 controlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> dialog.close());
		 });
		 
		 Label headingLabel = new Label(heading);
		 headingLabel.getStyleClass().add("jfx-label-color-black");
		 dialogLayout.setHeading(headingLabel); 
		 Label bodyLabel = new Label(body);
		 bodyLabel.getStyleClass().add("jfx-label-color-black");
		 dialogLayout.setBody(bodyLabel);
		 dialogLayout.setActions(controls); //sets button on layout
		 dialogLayout.getStylesheets().add(AlertSelector.class.getResource("/css/Style.css").toExternalForm());
		 dialogLayout.getStyleClass().add("Style.css");
		 dialog.show();
		 dialog.setOnDialogClosed((JFXDialogEvent event2) -> nodeToBeBlured.setEffect(null));
		 
		 nodeToBeBlured.setEffect(blur);
	}
	
	public static void customCloseDialog() {

		Stage confirmBoxWindow = new Stage();

		confirmBoxWindow.initModality(Modality.APPLICATION_MODAL);
		confirmBoxWindow.setTitle("Closing...");
		confirmBoxWindow.setMinWidth(350);
		confirmBoxWindow.setMinHeight(170);

		Label label = new Label("Are you sure want to exit?");
		label.setFont(new Font("Euphemia", 16));
		label.setStyle("-fx-text-fill: #FFFFFF");
		
		//Creating buttons
		Button yesButton = new Button("Yes");
		yesButton.setMinWidth(60);
		yesButton.setMinHeight(10);
		
		final String BUTTON_STYLE = "-fx-background-color: #1E88E5; -fx-background-radius: 10";
		final String HOVER_YES_BUTTON_STYLE = "-fx-background-color: #4CAF50; -fx-background-radius: 10";
		yesButton.setStyle(BUTTON_STYLE);
		yesButton.setOnMouseEntered(event -> yesButton.setStyle(HOVER_YES_BUTTON_STYLE));
		yesButton.setOnMouseExited(event -> yesButton.setStyle(BUTTON_STYLE));

		Button noButton = new Button("No");
		noButton.setMinWidth(60);
		noButton.setMinHeight(10);
		
		final String HOVER_NO_BUTTON_STYLE = "-fx-background-color: #d32f2f; -fx-background-radius: 10";
		noButton.setStyle(BUTTON_STYLE);
		noButton.setOnMouseEntered(event -> noButton.setStyle(HOVER_NO_BUTTON_STYLE));
		noButton.setOnMouseExited(event -> noButton.setStyle(BUTTON_STYLE));
		
		yesButton.setOnAction(e -> {
			Platform.exit();
			confirmBoxWindow.close();
		});
		
		noButton.setOnAction(e -> {
			confirmBoxWindow.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label);
		layout.setAlignment(Pos.CENTER);
			
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(yesButton, noButton);
		layout2.setSpacing(20);
		layout2.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(layout);
		borderPane.setCenter(layout2);
		borderPane.setStyle("-fx-background-color: #37474F;");

		Scene scene = new Scene(borderPane);
		confirmBoxWindow.setScene(scene);
		confirmBoxWindow.setResizable(false);
		confirmBoxWindow.showAndWait();
	}
	
	public static void showInformation(String title, String message) {

		Stage confirmBoxWindow = new Stage();

		confirmBoxWindow.initModality(Modality.APPLICATION_MODAL);
		confirmBoxWindow.setTitle(title);
		confirmBoxWindow.setMinWidth(200);
		confirmBoxWindow.setMinHeight(800);
		confirmBoxWindow.setMaxWidth(600);
		confirmBoxWindow.setMaxHeight(900);

		Text text = new Text(message);
		text.setFont(new Font("Euphemia", 17));
		text.setFill(Color.WHITE);
		
		TextFlow textFlow = new TextFlow();
		textFlow.getChildren().add(text);
		
		//Creating buttons
		Button yesButton = new Button("Continue");
		yesButton.setMinWidth(70);
		yesButton.setMinHeight(30);
		
		final String BUTTON_STYLE = "-fx-background-color: #FF0000; -fx-background-radius: 10";
		final String HOVER_YES_BUTTON_STYLE = "-fx-background-color: #1976D2; -fx-background-radius: 10";
		yesButton.setStyle(BUTTON_STYLE);
		yesButton.setOnMouseEntered(event -> yesButton.setStyle(HOVER_YES_BUTTON_STYLE));
		yesButton.setOnMouseExited(event -> yesButton.setStyle(BUTTON_STYLE));

		
		yesButton.setOnAction(e -> {
			answer = true;
			confirmBoxWindow.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(textFlow);
		layout.setAlignment(Pos.CENTER);
			
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(yesButton);
		layout2.setSpacing(20);
		layout2.setAlignment(Pos.CENTER);
		

		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(layout);
		borderPane.setCenter(layout2);
		borderPane.setStyle("-fx-background-color: #212121;");

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(borderPane);
		scrollPane.fitToWidthProperty().set(true);
		scrollPane.fitToHeightProperty().set(true);
		
		Scene scene = new Scene(scrollPane);
		confirmBoxWindow.setScene(scene);
		confirmBoxWindow.setResizable(false);
		confirmBoxWindow.showAndWait();

	}
	
	public static boolean showInformationWithImageView(String labelInput, String imagePath) {

		Stage confirmBoxWindow = new Stage();

		confirmBoxWindow.initModality(Modality.APPLICATION_MODAL);
		confirmBoxWindow.setMinWidth(200);
		confirmBoxWindow.setMinHeight(405);
		confirmBoxWindow.setMaxWidth(600);
		confirmBoxWindow.setMaxHeight(900);

		ImageView imageView = new ImageView();
		imageView.setPreserveRatio(false);
		imageView.setFitWidth(600);
		imageView.setFitHeight(405);
		imageView.setImage(new Image(imagePath));
		
		Label label = new Label(labelInput);
		label.setFont(new Font("Euphemia", 17));
		label.setTextFill(Color.WHITE);
		
		//Creating buttons
		Button yesButton = new Button("Continue");
		yesButton.setMinWidth(70);
		yesButton.setMinHeight(20);
		
		final String BUTTON_STYLE = "-fx-background-color: #FF0000; -fx-background-radius: 10";
		final String HOVER_YES_BUTTON_STYLE = "-fx-background-color: #1976D2; -fx-background-radius: 10";
		yesButton.setStyle(BUTTON_STYLE);
		yesButton.setOnMouseEntered(event -> yesButton.setStyle(HOVER_YES_BUTTON_STYLE));
		yesButton.setOnMouseExited(event -> yesButton.setStyle(BUTTON_STYLE));

		
		yesButton.setOnAction(e -> {
			answer = true;
			confirmBoxWindow.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, imageView);
		layout.setAlignment(Pos.CENTER);
			
		HBox layout2 = new HBox();
		layout2.getChildren().addAll(yesButton);
		layout2.setSpacing(20);
		layout2.setAlignment(Pos.BOTTOM_CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(layout);
		borderPane.setCenter(layout2);
		borderPane.setStyle("-fx-background-color: #212121;");

		Scene scene = new Scene(borderPane);
		confirmBoxWindow.setScene(scene);
		confirmBoxWindow.setResizable(false);
		confirmBoxWindow.initStyle(StageStyle.UNDECORATED);
		confirmBoxWindow.showAndWait();
		
		return answer;

	}
	
}
