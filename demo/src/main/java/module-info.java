module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.desktop;
    requires com.google.gson;
    
    opens com.example to javafx.fxml;
    exports com.example;
    opens com.example.interfaces to javafx.fxml;
    exports com.example.interfaces;
}