package com.cs4773.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML Label myLabel;
    @FXML Button myButton;
    public void actionOnClickButton(ActionEvent event) {
        myLabel.setText("Hello; thank you for clicking");
    }
}