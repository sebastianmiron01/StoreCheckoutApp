module com.example.effectsproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.effectsproject to javafx.fxml;
    exports com.example.effectsproject;
}