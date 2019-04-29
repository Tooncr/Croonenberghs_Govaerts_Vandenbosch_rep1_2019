package application;

import domain.CodeerContext;
import domain.CodeerEnum;
import domain.CodeerFactory;
import domain.CodeerStrategy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.event.ActionListener;

public class ComboBoxUI  {
    private CodeerContext codeerContext;
    private Label aanspreekLabel = new Label("");
    private TextField sentence;

    public ComboBoxUI(Stage stage) {
        codeerContext = new CodeerContext();
        stage.setTitle("Encoder and decoder");
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        sentence = new TextField();

        grid.add(sentence, 0, 0);

        ComboBox<String> codeerComboBox = new ComboBox<>();
        ObservableList <String> strategies = FXCollections.observableList(codeerContext.getCodeerStrategies());
        codeerComboBox.setItems(strategies);
        codeerComboBox.setEditable(true);
        codeerComboBox.valueProperty().addListener(new ClickComboBoxLineHandler());
        grid.add(codeerComboBox, 0, 2);
        grid.add(aanspreekLabel,0,3);

        Button encodeButton = new Button();
        Button decodeButton = new Button();
        encodeButton.setText("encode");
        decodeButton.setText("decode");
        encodeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aanspreekLabel.setText(codeerContext.getGecodeerdeString(sentence.getText()));
            }
        });
        decodeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aanspreekLabel.setText(codeerContext.getGedecodeerdeString(sentence.getText()));
            }
        });
        grid.add(encodeButton, 0, 5);
        grid.add(decodeButton, 1, 5);

        Scene scene = new Scene(grid, 450, 250);
        stage.setScene(scene);
        stage.show();
    }

    class ClickComboBoxLineHandler implements ChangeListener<String>{
        @Override
        public void changed(ObservableValue ov, String t, String t1) {
            CodeerStrategy codeerInterface = CodeerFactory.createStrat(t1);
            codeerContext.setCodeerInterface(codeerInterface);
            //aanspreekLabel.setText(codeerContext.getGecodeerdeString(t));
        }
    }
}