package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * Controller [基础操作类]
 *
 * @author RunBrick <zhouwei9280@gmail.com>
 * @version 1.0.0
 * @description ""
 */
public class Controller {

    @FXML
    private Label effectLabel;


    private String firstNum, resultNum, signs, operator;
    private boolean status;

    /**
     * buttonNum [数字]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonNum(ActionEvent actionEvent) {
        Button enter = (Button) actionEvent.getSource();
        if (!getEffect().equals("0")) {
            if (status) {
                status = false;
                setEffect(enter.getText());
            } else {
                setEffect(getEffect() + enter.getText());
            }
        } else {
            setEffect(enter.getText());
        }
    }

    /**
     * buttonAdd [加法]
     *
     * @param
     * @return void
     * @description ""
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonAdd(ActionEvent actionEvent) {
        status = true;
        if (firstNum != null) {
            calculate();
            firstNum = null;
        } else {
            firstNum = getEffect();
        }
        operator = "+";
    }

    /**
     * buttonSubtract [减法]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonSubtract(ActionEvent actionEvent) {
        status = true;
        if (firstNum != null) {
            calculate();
            firstNum = null;
        } else {
            firstNum = getEffect();
        }
        operator = "-";
    }


    /**
     * buttonMultiply [乘法]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonMultiply(ActionEvent actionEvent) {
        status = true;
        if (firstNum != null) {
            calculate();
            firstNum = null;
        } else {
            firstNum = getEffect();
        }
        operator = "*";
    }

    /**
     * buttonDivision [除法]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonDivision(ActionEvent actionEvent) {
        status = true;
        if (firstNum != null) {
            calculate();
            firstNum = null;
        } else {
            firstNum = getEffect();
        }
        operator = "/";
    }


    /**
     * buttonDot [点]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonDot(ActionEvent actionEvent) {
        setEffect(getEffect() + ".");
    }

    /***
     * buttonEquals [等于]
     *
     * @description ""
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonEquals() {
        calculate();
    }

    public void calculate() {
        switch (operator) {

            case "-":
                resultNum = "" + (Double.parseDouble(firstNum) - Double.parseDouble(getEffect()));
                break;
            case "*":
                resultNum = "" + (Double.parseDouble(firstNum) * Double.parseDouble(getEffect()));
                break;
            case "/":
                resultNum = "" + (Double.parseDouble(firstNum) / Double.parseDouble(getEffect()));
                break;
            case "+":
            default:
                resultNum = "" + (Double.parseDouble(firstNum) + Double.parseDouble(getEffect()));
                break;
        }
        firstNum = getEffect();
        setEffect(resultNum);
    }

    /**
     * buttonAC [清空所有]
     *
     * @author RunBrick <zhouwei9280@gmail.com>
     * @version 1.0.0
     */
    @FXML
    public void buttonAC(ActionEvent actionEvent) {
        firstNum = resultNum = signs = operator = null;
        setEffect("0");
    }

    @FXML
    public void buttonSymbol() {
        System.out.println("正负");
    }

    @FXML
    public void buttonResidue() {
        if (!getEffect().equals("0")) {
            double v = Double.parseDouble(getEffect()) / 100;
            setEffect(Double.toString(v));
        }
    }

    /**
     * @return 返回结果框内的数字
     */
    private String getEffect() {
        return effectLabel.getText();
    }

    /**
     * 设置结果框内的数字
     *
     * @param effectText 要放入结果框内的数字
     */
    private void setEffect(String effectText) {
        effectLabel.setText(effectText);
    }

}
