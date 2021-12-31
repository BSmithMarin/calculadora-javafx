module com.iesinfantaelena.caluladora_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;


    opens com.iesinfantaelena.caluladora_javafx to javafx.fxml;
    exports com.iesinfantaelena.caluladora_javafx;
}