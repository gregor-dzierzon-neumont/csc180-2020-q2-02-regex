module edu.neumont {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.neumont to javafx.fxml;
    exports edu.neumont;
}