package ui;

import domain.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private CodeerContext codeerContext;
    @Override
    public void start(Stage stage) throws Exception {
        codeerContext = new CodeerContext();
        stage.setTitle("encoder/decoder");
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        TextField sentence = new TextField();


        Button encode = new Button();
        encode.setText("encode");
        Button decode = new Button();
        decode.setText("decode");




        ToggleGroup group = new ToggleGroup();
        RadioButton caesar = new RadioButton("caesar algoritme");
        RadioButton spiegel = new RadioButton("spiegel algoritme");
        RadioButton base = new RadioButton("base 64 algoritme");
        RadioButton random = new RadioButton("random algoritme");
        caesar.setToggleGroup(group);
        spiegel.setToggleGroup(group);
        base.setToggleGroup(group);
        random.setToggleGroup(group);
        caesar.setSelected(true);


        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        sentence.setPadding(new Insets(20,100,20,100));
        root.getChildren().add(sentence);
        caesar.setPadding(new Insets(20,30,10,30));
        spiegel.setPadding(new Insets(20,30,10,30));
        random.setPadding(new Insets(20,30,10,30));
        base.setPadding(new Insets(20,30,10,30));
        root.getChildren().add(caesar);
        root.getChildren().add(spiegel);
        root.getChildren().add(random);
        root.getChildren().add(base);
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
                boolean ba = base.isSelected();
                boolean ra = random.isSelected();
                if(cs){
                    strat = new CaesarStrat();
                } else if(sp){
                    strat = new GespiegeldStrat();
                } else if(ba){
                    strat = new Base64Strat();
                } else if(ra){
                    strat = new RandomStrat();
                }
                sentence.setText(strat.codeer(sentence.getText()));
            }
        });

        decode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CodeerStrategy strat = null;
                boolean cs = caesar.isSelected();
                boolean sp = spiegel.isSelected();
                boolean ra = random.isSelected();
                boolean ba = base.isSelected();
                if(cs){
                    strat = new CaesarStrat();
                } else if(sp){
                    strat = new GespiegeldStrat();
                } else if(ba){
                    strat = new Base64Strat();
                } else if(ra){
                    strat = new RandomStrat();
                }
                sentence.setText(strat.decodeer(sentence.getText()));
            }
        });
    }

}