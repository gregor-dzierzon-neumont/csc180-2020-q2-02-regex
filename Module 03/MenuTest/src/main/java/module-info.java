module edu.neumont {
    requires javafx.controls;
    requires javafx.fxml;
    requires JavaLibraryDemo;

    opens edu.neumont to javafx.fxml;
    exports edu.neumont;
}