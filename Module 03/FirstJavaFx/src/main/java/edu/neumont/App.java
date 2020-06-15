package edu.neumont;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    Button counterButton;
    Integer counter = 0;

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Label lbl = new Label("test");
        counterButton = new Button("0");
        counterButton.setOnAction((event) -> counterButton.setText((++counter).toString()));
//        counterButton.setText(counter.toString());
//        counterButton.setOnAction(this::actionPerformed);
//        grid.add(counterButton,1,1);

        Scene scene = new Scene(grid,300,200);
        stage.setScene(scene);
        stage.show();
    }

    public void actionPerformed(javafx.event.ActionEvent actionEvent)
    {
        counter ++;
        counterButton.setText(counter.toString());
    }


    public static void main(String[] args) {
        launch();
    }

}