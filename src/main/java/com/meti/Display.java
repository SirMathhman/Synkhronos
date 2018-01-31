package com.meti;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.logging.Level;

public class Display {
    private final URL addLocation = getClass().getResource("wizard\\AddDisplay.fxml");

    @FXML
    private ListView<String> dependencyView;

    @FXML
    public void openList() {
    }

    @FXML
    public void saveList() {
    }

    @FXML
    public void openSettings() {
    }

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public void addDependency() {
        try {
            Scene scene = new Scene(FXMLLoader.load(addLocation));
            Stage stage = new Stage();
            stage.setTitle("Add a Dependency");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Main.log(Level.SEVERE, "Failed to load add wizard", e);
        }
    }

    @FXML
    public void removeDependency() {
    }

    @FXML
    public void clearDependencies() {
    }

    @FXML
    public void openDependencySettings() {
    }
}