module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.example to javafx.fxml;
    exports com.example;
}
