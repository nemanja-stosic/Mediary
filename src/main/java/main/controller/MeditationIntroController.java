package main.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.utill.WindowEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class MeditationIntroController implements Initializable{

    @FXML
    private StackPane rootPaneIntro;
	
    @FXML
    private AnchorPane anchorPaneMeditation;

    @FXML
    private TextFlow textFlow;
    
    @FXML
    private JFXButton nextButtonIntro;
    
    @FXML
    private JFXButton meditateNowButton;
    
    private Text page1;
    private Text page2;
    private Text page3;
    
    private String font = "Arial";
    
    private boolean firstNextClicked = false;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rootPaneIntro.setOpacity(0);
		WindowEditor.setFadingTransitionEffect(WindowEditor.TransitionType.FADE_IN, Duration.seconds(5), rootPaneIntro);

		page1 = new Text("Meditation is a dance between you and life—a rhythm of body, breath, nature, emotion, infinite space, and everything in between. It’s an unfolding of what you are, what you came from, and what you’re becoming. The point is not to achieve a particular experience—the point is to recognize more of what you already are: unique, infinite, whole, interconnected, and always changing. A river is constantly in a state of meditation, moving and responding to gravity. Meditation can run through your everyday life, and allow you to find a dynamic relationship with your inner and outer worlds.\r\n" +
				"\r\n" +
				"The human mind is an amazing and complex system that filters raw, undivided information from the senses into digestible experiences, which usually have a particular context: friend, enemy, food, sunshine, music, money, pleasure, pain, good, bad, etc. Mind is “who” we are: the persona, story, beliefs, judgments, the gathering of knowledge and memory. The mind is brilliant and necessary but, like anything else, should not hold the reins 100 percent of the time.\r\n" +
				"\r\n" +
				"Awareness holds the mind, with all its waves, within the ocean of universality, cooperation, creativity, and transformation. Meditation is living in awareness, which includes the waves of the mind: sensations, thoughts, emotions, fears, desires. If awareness were the sky, mind would be the weather. There are clouds, rain, thunder, and sunshine, but the sky is always there.\r\n" +
				"\r\n" +
				"Under the umbrella of meditation, there are countless techniques to relax, focus, and awaken awareness. Before experimenting with a particular technique, clarify why you want to meditate, and what you’re seeking. There are techniques to cultivate calm, relaxation, focus, endurance, clarity, energetic experiences, sensation, gratitude, compassion, etc.");
		page1.setFill(Color.BISQUE);
		page1.setFont(new Font(font, 28));

		page2 = new Text("Do you want to experience insight and illumination? Do you want to sleep better, think more clearly, ease anxiety, accomplish goals, feel more alive, or experience contentment? Do you simply need some quiet time alone? If the reason why is not obvious yet, allow that inquiry to be part of your practice.\r\n" +
				"\r\n" +
				"It can be helpful to begin by experimenting with different techniques to see what feels natural. Mantra, breath-based meditation, sound meditation, walking meditation, sensory meditation, open-eyed meditation, yantra, gratitude meditation, and loving-kindness meditation are just a few styles that can lend themselves to different experiences. Once you find a technique that feels right for you, commit to it for a specified number of days, weeks, or months, and observe how your practice changes and evolves over time. With any technique, there will be a range of experiences and challenges that arise, and it’s often those challenges that lead to insight, inspiration, and self-confidence.\r\n" +
				"\r\n" +
				"If you create a schedule for practice, emphasize frequency over perfection. Give yourself plenty of space to be focused on some days, and distracted on others. Start with shorter periods (10 to 15 minutes) so that it’s easier to practice regularly. Create a time and space when you won’t be interrupted and where you’ll feel safe to explore the sensations, thoughts, and emotions that surface. Set a timer so that you won’t need to keep looking at the clock. The mind will eventually begin to relax, and become more awake and aware—but remember that the mind is naturally in a state of oscillation between the external environment and your internal world, so don’t expect that to ever go away. If it quiets, it quiets.");

		page2.setFill(Color.BISQUE);
		page2.setFont(new Font(font, 28));

		page3 = new Text("Meditation is not limited to sitting still on a cushion. As your practice continues to evolve, and the mind is given space and time to settle, you may find you can begin to let go of the technique, and allow awareness to flow—both on the cushion and throughout your day—without a separation between “regular life” and “practice.” You can be in a state of meditation anywhere you are, whatever you’re doing. Moving from an anxious state into a meditative state has more to do with how you engage with an activity, rather than what it is you’re doing. Feel your body becoming still, or moving in cooperation with your surroundings. Feel the rhythm of your heart beating and breath flowing. Feel your environment. Watch all that is happening. Watch what your intuition says and how it wants to respond to the moment. Most importantly, trust that you’re exactly where you’re supposed to be and know exactly what you need to know. There’s nothing more you need to achieve or become in order to meditate. All you need to do is be yourself and live in present moment.\r\n"
				+ "\r\nTo start your meditation first chose what kind of meditation you want. There are seven chakras, from left side you can read explanation of each and to start meditation click on desired chakra (click on their shape).\n~Master your morning, elevate your life.");
		page3.setFill(Color.BISQUE);
		page3.setFont(new Font(font, 28));

		textFlow.getChildren().add(page1);
	}
	
	@FXML
	void handleMeditateNow(ActionEvent event) {
		((Stage)rootPaneIntro.getScene().getWindow()).close();
		WindowEditor.loadModalityWindow(WindowEditor.setStage(WindowEditor.StageSelector.MEDITATION_STAGE),
				"Meditation", WindowEditor.setStage(WindowEditor.StageSelector.STYLE), false);
	}

	@FXML
	void handleNextButton(ActionEvent event) {
		if(!firstNextClicked) {
			textFlow.getChildren().remove(page1);
			textFlow.getChildren().add(page2);
			firstNextClicked = true;
		} else {
			textFlow.getChildren().remove(page2);
			textFlow.getChildren().add(page3);
			nextButtonIntro.setDisable(true);
		}
	
	}

}
