package edu.neumont;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import dzierzon.gregor.*;

public class PrimaryController {

    public TextArea textArea;
    Stage stage;

    public Stage getStage()
    {
        return stage;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    @FXML
    public Menu fileMenu;

    @FXML
    public void newFileClick(ActionEvent event) throws IOException
    {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open File");
//        File file = fileChooser.showOpenDialog(stage);
//        System.out.println(file.getName());
//        textArea.setText(file.getName());
        Program program = new Program();
        textArea.setText(program.getMessage("Gregor"));


    }
}
