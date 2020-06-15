package edu.neumont;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

public class SecondaryController {

    @FXML
    public Menu fileMenu;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void newFileClick(ActionEvent actionEvent)
    {
        System.out.println("new file");
    }
}