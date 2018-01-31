package com.meti;

import com.meti.module.Module;
import com.meti.module.ModuleRegistry;

import java.net.URL;

public class Default {
    private static URL urlDisplayPath = URLDisplay.class.getResource("URLDisplay.fxml");

    private Default(){
    }

    public static void loadModules(ModuleRegistry moduleRegistry){
        Module urlModule = new Module(urlDisplayPath, Index.getName(), Index.getLocation());
        moduleRegistry.addModule(urlModule);
    }
}
