package application;
	
import domain.Spel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new ScoreView();
		PlayerView pv3 = new PlayerView(3);
		PlayerView pv2 = new PlayerView(2);
		PlayerView pv1 = new PlayerView(1);		
		pv1.isAanBeurt(true);
		Spel spel = new Spel();
		spel.addView(pv1);
		spel.addView(pv2);
		spel.addView(pv3);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
