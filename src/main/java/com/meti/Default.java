package com.meti;

import com.meti.module.Module;
import com.meti.module.ModuleRegistry;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Default {
    private static URL urlDisplayPath = URLDisplay.class.getResource("URLDisplay.fxml");

    private Default(){
    }

    public static void loadModules(ModuleRegistry moduleRegistry) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Module urlModule = new Module(Index.class);
        moduleRegistry.addModule(urlModule);
    }
}
