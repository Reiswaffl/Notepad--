package main.java.com.Notepad.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        File f = new File("resources/modern.css");
        primaryStage.setTitle("Notepad--");

        AnchorPane pane = new AnchorPane();
        Label userName = new Label();
        userName.setText("username");

        Button changeUser = new Button();
        changeUser.setText("Change User");

        HBox top = new HBox();
        top.getChildren().add(userName);
        top.getChildren().add(changeUser);

        pane.getChildren().add(top);
        Scene scene = new Scene(pane,300,600);
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\","/"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
