package com.iesinfantaelena.caluladora_javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Esta clase utiliza dos objetos de la clase StringProperty para controlar tanto el historial de operaciones
 * como la expresion mostrada por pantalla. En el constructor de CalculatorController se establece el callback
 * cuando estas propiedades cambian de estado.
 */

public class DisplayController {

    private StringProperty expression;
    private StringProperty history;


    public DisplayController(){
        expression = new SimpleStringProperty();
        history = new SimpleStringProperty();
        setExpression("");
        setHistory("");
    }

    /**
     * Calcula el resultado de la expresion generada por el usuario, o pinta SYNTAX ERROR en caso de que no sea valida.
     * La tarea de realizar el calculo se delega en la libreria exp4j que evalua expresiones y devuelve su resultado.
     */
    public void calculate(){
        //Antes de realizar el calculo se normaliza la expresion para que sea evaluable por la libreria exp4j.
        try{
            String normalizedExpression = getExpression()
                    .replace("÷","/")
                    .replace("×","*")
                    .replace("−","-");
            Expression e = new ExpressionBuilder(normalizedExpression).build();
            String result = Double.toString(e.evaluate());
            setHistory(getHistory()+"\n"+getExpression()+" = "+result);
            setExpression(result);
        }catch ( RuntimeException ex){
            setExpression("SYNTAX ERROR");
        }
    }

    /**
     * Añade al final de la cadena el caracter deseado
     * @param character
     */
    public void append(String character){
        setExpression(getExpression() + character);
    }

    /**
     * Limpia la expresion
     */
    public void clear(){
        setExpression("");
    }

    //Getters y setters

    public String getExpression() {
        return expression.get();
    }

    public StringProperty expressionProperty() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression.set(expression);
    }

    public String getHistory() {
        return history.get();
    }

    public StringProperty historyProperty() {
        return history;
    }

    public void setHistory(String history) {
        this.history.set(history);
    }
}
