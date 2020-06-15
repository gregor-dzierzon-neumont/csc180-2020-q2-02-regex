package edu.neumont;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Integer counter = 0;

    public static void main(String[] args) {
        launch();
    }

//    @Override
//    public void start(Stage stage) throws Exception
//    {
//        StackPane pane = new StackPane();
//        Button button = new Button();
//        button.setText("Counter");
//        button.setOnAction(actionEvent -> { //click event
//            counter++;
//            button.setText(counter.toString());
//        });
//
//        pane.getChildren().add(button);
//
//        Scene scene = new Scene(pane,200, 200);
//        stage.setScene(scene);
//        stage.show();
//    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


}