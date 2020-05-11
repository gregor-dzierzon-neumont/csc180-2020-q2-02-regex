package edu.neumont;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Integer counter = 0;
    private Button button;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("My awesome clicker form");

        StackPane box = new StackPane();
        button = new Button();
        button.setText("Counter");

        box.getChildren().add(button);

        button.setOnAction(this::countAction);

        Scene scene = new Scene(box, 400, 300);

        stage.setScene(scene);
        stage.show();
    }

    public void countAction(javafx.event.ActionEvent actionEvent)
    {
        counter ++;
        button.setText(counter.toString());
    }

    public static void main(String[] args) {
        launch();
    }

}