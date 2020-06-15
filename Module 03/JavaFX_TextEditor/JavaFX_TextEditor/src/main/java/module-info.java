module edu.neumont.dzierzon.gregor {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.neumont.dzierzon.gregor to javafx.fxml;
    exports edu.neumont.dzierzon.gregor;
}