package main.java.com.Notepad.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        File f = new File("resources/CSS/modern.css");
        primaryStage.setTitle("Notepad--");

        BorderPane pane = new BorderPane();

        Label userName = new Label();
        userName.setText("username");



        Button changeUser = new Button();
        changeUser.setText("Change User");

        HBox top = new HBox();
        top.getChildren().add(userName);
        top.getChildren().add(changeUser);


        pane.setTop(top);

        Scene scene = new Scene(pane,600,800);
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\","/"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
