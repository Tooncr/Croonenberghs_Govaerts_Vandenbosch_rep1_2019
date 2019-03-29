package view;

import domain.Spel;
import domain.Speler;
import domain.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView implements View {
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel; 
	private Button playButton; 
	private Label messageLabel; 
	
	private int spelerNummer;


	public PlayerView(int spelerNummer){
		this.spelerNummer = spelerNummer;
		diceLabel = new Label("beurt 1: ");
		playButton = new Button("Werp dobbelstenen");
		messageLabel = new Label("Spel nog niet gestart");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Speler "+spelerNummer);
		stage.setResizable(false);		
		stage.setX(100+(spelerNummer-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
	
	public void isAanBeurt(boolean aanBeurt){
		playButton.setDisable(!aanBeurt);		
	}

	@Override
	public void update() {
		messageLabel.setText("dinge");
	}

	class ThrowDicesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	update();
        	//int[] gooien = spel.throwDice();
			//messageLabel.setText("beurt " + ": " + gooien[0] + " en " + gooien[1] + " - score: " +Integer.toString(speler.getPrevScore()));

        }
    }
}
