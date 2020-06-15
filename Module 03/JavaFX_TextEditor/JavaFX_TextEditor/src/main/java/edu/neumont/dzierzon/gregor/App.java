package edu.neumont.dzierzon.gregor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("primary", stage), 640, 480);

        stage.setScene(scene);
        stage.show();


    }


    private static Parent loadFXML(String fxml, Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = null;

        //reads the xml into memory and creates a parent object
        root = fxmlLoader.load();

        PrimaryController controller = fxmlLoader.getController();

        controller.setStage(stage);
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}