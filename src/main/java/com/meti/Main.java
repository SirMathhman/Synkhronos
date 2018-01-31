package com.meti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private static final Logger logger = Logger.getLogger("Synkhronos");
    private static Main instance;

    static {
        logger.setLevel(Level.ALL);
    }

    private final URL displayLocation = getClass().getResource("Display.fxml");

    public static Main getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void log(Level level, String message) {
        log(level, message, null);
    }

    public static void log(Level level, String message, Exception e) {
        StringBuilder builder = new StringBuilder();
        if (message != null) {
            builder.append(message);
        }

        if (message != null && e != null) {
            builder.append("\n");
        }

        if (e != null) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            builder.append(writer.toString());
        }

        logger.log(level, builder.toString());

        if (level.equals(Level.SEVERE)) {
            System.exit(-1);
        }
    }

    public static void log(Level level, Exception e) {
        log(level, null, e);
    }

    @Override
    public void start(Stage primaryStage) {
        instance = this;

        try {
            Scene scene = new Scene(FXMLLoader.load(displayLocation));
            primaryStage.setTitle("Synkhronos");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            log(Level.SEVERE, "Failed to load display", e);
        }
    }

    @Override
    public void stop() {
        System.exit(0);
    }
}
