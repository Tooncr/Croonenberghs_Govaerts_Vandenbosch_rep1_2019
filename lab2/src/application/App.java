package application;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.CodeerUi;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new application.ComboBoxUI(stage);
    }
}
