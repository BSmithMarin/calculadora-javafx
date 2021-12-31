package com.iesinfantaelena.caluladora_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Lanza la calculadora cargando la vista desde un fichero XML, y modificando el titulo de la ventana
 * asi como establece un tamaño minimo para esta.
 */

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.setMinHeight(600.0);      //Tamaño minomo de la ventana
        stage.setMinWidth(450.0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}