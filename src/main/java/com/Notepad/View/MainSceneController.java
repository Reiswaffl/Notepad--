package main.java.com.Notepad.View;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import main.java.com.Notepad.InputManagement.InputManagement;
import main.java.com.Notepad.Logic.Logic;

public class MainSceneController implements Initializable{
    public GUI gui;
    @FXML private MenuButton monthButton;
    @FXML private TextField dayField;
    @FXML private TextField yearField;
    @FXML private TextField startField;
    @FXML private TextField endField;
    private InputManagement inputManagement = new InputManagement();
    private String start;
    private String end;
    private String day;
    private String month;
    private String year;
    Logic Logic = new Logic();
    /**
     * @brief setup for GUI
     * @param gui
     */
    public void setGui(GUI gui){
        this.gui = gui;
    }

    /**
     * @brief setup for GUI
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    /**
     * changes user to Input
     * @param event
     */
    public void changeUser(ActionEvent event) {
    }

    public void handleIJanuary(ActionEvent event) {
        month = "01";
        monthButton.setText("January");
    }

    public void handleIFebruary(ActionEvent event) {
        month = "02";
        monthButton.setText("February");
    }

    public void handleIMarch(ActionEvent event) {
        month = "03";
        monthButton.setText("March");
    }

    public void handleIApril(ActionEvent event) {
        month = "04";
        monthButton.setText("April");
    }

    public void handleIMai(ActionEvent event) {
        month = "05";
        monthButton.setText("Mai");
    }

    public void handleIJune(ActionEvent event) {
        month = "06";
        monthButton.setText("June");
    }

    public void handleIJuly(ActionEvent event) {
        month = "07";
        monthButton.setText("July");
    }

    public void handleIAugust(ActionEvent event) {
        month = "08";
        monthButton.setText("August");
    }

    public void handleISeptember(ActionEvent event) {
        month = "09";
        monthButton.setText("September");
    }

    public void handleIOctober(ActionEvent event) {
        month = "10";
        monthButton.setText("October");
    }

    public void handleINovember(ActionEvent event) {
        month = "11";
        monthButton.setText("November");
    }

    public void handleIDecember(ActionEvent event) {
        month = "12";
        monthButton.setText("December");
    }

    public void handleAdd(ActionEvent event) {
        day = inputManagement.filterDay(dayField.getText());
        dayField.clear();

        year = inputManagement.filterYear(yearField.getText());
        yearField.clear();

        start = inputManagement.filterStartEnd(startField.getText());
        startField.clear();

        end = inputManagement.filterStartEnd(endField.getText());
        endField.clear();

        if(day == null || start == null || end == null || year == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler beim Eintragen");
            alert.setContentText("Eingabe fehlerhaft");
            alert.showAndWait();
        }
        Logic.addNote(day+"."+month+"."+year,start,end,"Termin");
    }
}