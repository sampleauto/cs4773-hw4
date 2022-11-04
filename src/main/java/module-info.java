module com.cs4773.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cs4773.Main to javafx.fxml;
    exports com.cs4773.Main;
    exports com.cs4773.ViewModel;
    opens com.cs4773.ViewModel to javafx.fxml;
}