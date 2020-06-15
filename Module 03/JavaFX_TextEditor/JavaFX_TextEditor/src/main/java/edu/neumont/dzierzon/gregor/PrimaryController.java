package edu.neumont.dzierzon.gregor;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {

    public Menu fileMenu;
    Stage stage;

    public void setStage(Stage stage)
    {
        this.stage = stage;

        this.stage.setOnCloseRequest(event -> {
            System.out.println("closing");
        });
    }

    public TextArea textBox;

    @FXML
    public void openFile(ActionEvent actionEvent)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file...");
        File file = fileChooser.showOpenDialog(this.stage);
        // open the file - read the contents
        stage.setTitle(file.getAbsolutePath());


        //read the context of the text box

        try ( BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath())))
        {
            //read the text and put it in the text area
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while(line != null)
            {
                builder.append(line);
                builder.append("\n");
                line = reader.readLine();
            }

            textBox.setText(builder.toString());
        }
        catch(IOException ex)
        {

        }
    }
}
