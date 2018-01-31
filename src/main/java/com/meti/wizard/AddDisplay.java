package com.meti.wizard;

import com.meti.Main;
import com.meti.depend.DependencyRegistry;
import com.meti.module.Module;
import com.meti.module.ModuleRegistry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;

public class AddDisplay {
    private ModuleRegistry moduleRegistry;
    private DependencyRegistry dependencyRegistry;

    @FXML
    private ListView<String> moduleView;

    @FXML
    private AnchorPane moduleOptions;
    private Object controller;

    public void setDependencyRegistry(DependencyRegistry dependencyRegistry) {
        this.dependencyRegistry = dependencyRegistry;
    }

    @FXML
    public void next() {
        if(controller instanceof Dependable){
            dependencyRegistry.add(((Dependable) controller).getDependency());
        }
        else{
            throw new IllegalStateException("Controller not instance of Dependable");
        }
    }

    public void setModuleRegistry(ModuleRegistry moduleRegistry) {
        this.moduleRegistry = moduleRegistry;

        Collection<Module> modules = moduleRegistry.getModules().values();
        for (Module module : modules) {
            moduleView.getItems().addAll(module.getName());
        }
    }

    @FXML
    public void moduleSelected() {
        String name = moduleView.getSelectionModel().getSelectedItem();
        Module module = moduleRegistry.getModule(name);

        try {
            FXMLLoader loader = new FXMLLoader(module.getOptionsLocation());
            Parent parent = loader.load();
            controller = loader.getController();
            moduleOptions.getChildren().add(parent);
        } catch (IOException e) {
            Main.log(Level.WARNING, e);
        }
    }
}