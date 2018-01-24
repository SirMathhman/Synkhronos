package com.meti;

import com.meti.url.URLModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModuleRegistry {
    private static final HashMap<Class<? extends Module>, Module> moduleClassMap = new HashMap<>();

    static {
        new URLModule();
    }

    private ModuleRegistry() {
    }

    public static void put(Class<? extends Module> aClass, Module module) {
        moduleClassMap.put(aClass, module);
    }

    public static List<Module> getModules() {
        List<Module> modules = new ArrayList<>();
        modules.addAll(moduleClassMap.values());
        return modules;
    }
}
