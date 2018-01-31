package com.meti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    private URL displayLocation = getClass().getResource("Display.fxml");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(displayLocation));
        primaryStage.setTitle("Synkhronos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        System.exit(0);
    }
}
