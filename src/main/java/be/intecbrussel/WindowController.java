package be.intecbrussel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class WindowController {
    @FXML
    private TextField amount;

    @FXML
    private TextField tipAmount;

    @FXML 
    private TextField totalAmount;

    @FXML
    private Slider tipSlider;

    @FXML
    private Label percentage;

    @FXML
    private void calculateTip(){
        double enteredAmount = Double.parseDouble(amount.getText());
        double enteredTipPercentage = tipSlider.getValue();

        double calculatedTipAmount = (enteredAmount / 100) * enteredTipPercentage;
        double calculatedTotalAmount = enteredAmount + calculatedTipAmount;

        tipAmount.setText(String.format("%.2f", calculatedTipAmount));
        totalAmount.setText(String.format("%.2f", calculatedTotalAmount));

    }

    @FXML
    public void initialize(){
        tipSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            percentage.setText(String.format("%.2f%s", newValue, "%"));
        });
    }
}
