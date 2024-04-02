module corner_gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens corner_gui to javafx.fxml;
    exports corner_gui;
}
