package com.meti;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Display {
    @FXML
    private ListView<String> dependencyView;

    @FXML
    public void openList(){
    }

    @FXML
    public void saveList(){
    }

    @FXML
    public void openSettings(){
    }

    @FXML
    public void close(){
        Platform.exit();
    }

    @FXML
    public void addDependency(){
    }

    @FXML
    public void removeDependency(){
    }

    @FXML
    public void clearDependencies(){
    }

    @FXML
    public void openDependencySettings(){
    }
}