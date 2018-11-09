package main.java.com.Notepad.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class GUI extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        mainWindow();
    }
    public void mainWindow(){
        try {
            File f = new File("resources/CSS/modern.css");
            FXMLLoader loader = new FXMLLoader(GUI.class.getResource("MainScene.fxml"));
            AnchorPane pane = loader.load();

            primaryStage.setMinHeight(100);
            primaryStage.setMinWidth(100);
            primaryStage.setTitle("Menü");

            MainSceneController guiCon = loader.getController();
            guiCon.setGui(this);
            Scene scene = new Scene(pane);
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\","/"));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}