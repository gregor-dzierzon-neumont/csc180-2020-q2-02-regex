package edu.neumont;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    private Integer counter = 0;

    @FXML
    public Button counterButton;

    @FXML
    private void switchToSecondary() throws IOException {
       App.setRoot("secondary");
    }

    @FXML
    public void increment(ActionEvent actionEvent)
    {
        counter++;
        counterButton.setText(counter.toString());
    }
}
