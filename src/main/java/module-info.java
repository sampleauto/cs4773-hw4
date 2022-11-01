module com.cs4773.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cs4773.app to javafx.fxml;
    exports com.cs4773.app;
    exports com.cs4773.controllers;
    opens com.cs4773.controllers to javafx.fxml;
}