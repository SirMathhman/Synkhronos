package com.meti.app;

import com.meti.Library;
import com.meti.Module;
import com.meti.ModuleRegistry;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Display implements Initializable {
    private final HashMap<String, Module> moduleHashMap = new HashMap<>();

    @FXML
    private ListView<String> sourceView;

    @FXML
    private TreeView<String> locationView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Module> modules = ModuleRegistry.getModules();
        for(Module module : modules) {
            String name = module.getName();
            sourceView.getItems().add(name);
            moduleHashMap.put(name, module);
        }
    }

    @FXML
    public void addSource(){
        List<String> items = sourceView.getSelectionModel().getSelectedItems();
        for(String item : items){
            moduleHashMap.get(item).openDisplay();
        }
    }
}
