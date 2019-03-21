package ui;

import domain.CaesarStrat;
import domain.CodeerStrategy;
import domain.GespiegeldStrat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("encoder/decoder");
        Button encode = new Button();
        encode.setText("encode");
        Button decode = new Button();
        decode.setText("decode");
        ToggleGroup group = new ToggleGroup();
        RadioButton caesar = new RadioButton("caesar algoritme");
        RadioButton spiegel = new RadioButton("spiegel algoritme");
        caesar.setToggleGroup(group);
        spiegel.setToggleGroup(group);
        caesar.setSelected(true);
        /*
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        */
        TextField sentence = new TextField();
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        sentence.setPadding(new Insets(20,100,20,100));
        root.getChildren().add(sentence);
        caesar.setPadding(new Insets(20,30,10,30));
        root.getChildren().add(caesar);
        spiegel.setPadding(new Insets(10,30,20,30));
        root.getChildren().add(spiegel);
        root.getChildren().add(encode);
        root.getChildren().add(decode);
        Scene mainScene = new Scene(root, 700, 500);
        stage.setScene(mainScene);
        stage.show();


        encode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CodeerStrategy strat = null;
                boolean cs = caesar.isSelected();
                boolean sp = spiegel.isSelected();
                if(cs){
                    strat = new CaesarStrat();
                } else if(sp){
                    strat = new GespiegeldStrat();
                }
                root.getChildren().add(new Label(strat.codeer(sentence.getText())));
            }
        });
        decode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CodeerStrategy strat = null;
                boolean cs = caesar.isSelected();
                boolean sp = spiegel.isSelected();
                if(cs){
                    strat = new CaesarStrat();
                } else if(sp){
                    strat = new GespiegeldStrat();
                }
                root.getChildren().add(new Label(strat.decodeer(sentence.getText())));
            }
        });
    }
}


