module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports com.example.javafx.sphere;
    opens com.example.javafx.sphere to javafx.fxml;

    exports com.example.javafx.camera;
}