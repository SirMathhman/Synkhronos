package com.meti.module;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ModuleRegistry {
    private final Set<Module> modules = new HashSet<>();

    public void load(File location) {
        if (location.isDirectory()) {
            File[] files = location.listFiles();
            if (files != null && files.length != 0) {
                for (File file : files) {
                    load(file);
                }
            }
        } else {
            if (location.getPath().contains("jar")) {
                //load from jar
            }
        }
    }

    public boolean addModule(Module module) {
        return modules.add(module);
    }

    public boolean removeModule(Module module) {
        return modules.remove(module);
    }

    public void clear() {
        modules.clear();
    }
}
