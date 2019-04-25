package application;
	
import domain.Spel;
import domain.Speler;
import domain.View;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Spel spel = new Spel();
		Speler s1 = new Speler(1);
		Speler s2 = new Speler(2);
		Speler s3 = new Speler(3);
		View sv1 = 	new ScoreView(spel);
		View pv3 = new PlayerView(spel, s3);
		View pv2 = new PlayerView(spel, s2);
		View pv1 = new PlayerView(spel, s1);
		((PlayerView) pv1).isAanBeurt(true);
		spel.addSpeler(s1);
		spel.addSpeler(s2);
		spel.addSpeler(s3);
		spel.addView(pv1);
		spel.addView(pv2);
		spel.addView(pv3);
		spel.addView(sv1);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
