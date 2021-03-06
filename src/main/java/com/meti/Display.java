package com.meti;

import com.meti.depend.DependencyRegistry;
import com.meti.module.ModuleRegistry;
import com.meti.wizard.AddDisplay;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

import static com.meti.Main.log;

public class Display implements Initializable {
    private final URL addLocation = getClass().getResource("wizard\\AddDisplay.fxml");

    private final ModuleRegistry moduleRegistry = new ModuleRegistry();
    private DependencyRegistry dependencyRegistry;

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
            FXMLLoader loader = new FXMLLoader(addLocation);
            Parent root = loader.load();

            AddDisplay display = loader.getController();
            display.setModuleRegistry(moduleRegistry);
            display.setDependencyRegistry(dependencyRegistry);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Add a Dependency");
            stage.setScene(scene);
            stage.show();

            display.setStage(stage);
        } catch (Exception e) {
            log(Level.SEVERE, "Failed to load add wizard", e);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dependencyRegistry = new DependencyRegistry(dependencyView);

        File moduleDirectory = new File("modules");
        try {
            if (moduleDirectory.exists()) {
                this.moduleRegistry.load(moduleDirectory);
            } else {
                if (moduleDirectory.mkdirs()) {
                    log(Level.FINE, "Created module directory");
                }
            }

            Default.loadModules(moduleRegistry);
        } catch (Exception e) {
            log(Level.WARNING, "Failed to load modules", e);
        }
    }
}