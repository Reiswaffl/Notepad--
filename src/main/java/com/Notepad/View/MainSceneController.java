package main.java.com.Notepad.View;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable{
    public GUI gui;

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
}