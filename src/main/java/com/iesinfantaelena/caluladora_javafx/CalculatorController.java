package com.iesinfantaelena.caluladora_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class CalculatorController {
    //Controlador display
    DisplayController dpController;
    //textField
    @FXML protected Label display,history;
    //Numeros
    @FXML protected Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,dot;
    //Simbolos
    @FXML protected Button sum, subtraction, multiplication, division, result;
    @FXML protected Button clean, leftParenthesis, rightParenthesis;
    //Scroll pane
    @FXML protected ScrollPane scrollPane;

    /**
     * Establece callback al cambiar el contenido de la expresion generada por el usuario.
     * Para ello se utiliza la clase DisplayController, que se encarga de controlar el estado del
     * texto mostrado en pantalla.
     */
    public CalculatorController() {
        dpController = new DisplayController();
        dpController.expressionProperty().addListener((observableValue, oldValue, newValue) -> {
            if(oldValue.equals("SYNTAX ERROR")){
                dpController.setExpression(newValue.replace("SYNTAX ERROR",""));
            }else {
                display.setText(dpController.getExpression());
            }

        });

        dpController.historyProperty().addListener((observableValue, oldValue, newValue)->{
            history.setText(dpController.getHistory());
        });
    }

    /**
     *  Añade el texto de cada boton a la cadena que representa la expresion mostrada por pantalla.
     *  O realiza la acción asociada a ese boton.
     *
     * @param e Boton pulsado por el usuario
     */
    @FXML protected void pintarPantalla(ActionEvent e){

        Button clickedButton = (Button)e.getTarget();

        switch (clickedButton.getId()){
            case "n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "n0","dot", "sum", "subtraction",
                    "multiplication", "division","leftParenthesis","rightParenthesis" ->
                    dpController.append(clickedButton.getText());

            case "result" -> {
                dpController.calculate();
                scrollPane.layout();
                scrollPane.setVvalue(Double.MAX_VALUE);
            }
            case "clean" -> dpController.clear();
        }
    }
}