package com.meti.module;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class ModuleRegistry {
    private final Map<String, Module> modules = new HashMap<>();

    public void load(File file) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length != 0) {
                for (File f : files) {
                    load(f);
                }
            }
        } else {
            if (file.getPath().contains("jar")) {
                //load from jar
                URL fileURL = new URL("file:" + file.toString());
                ClassLoader classLoader = new URLClassLoader(new URL[]{fileURL});
                Class<?> c = classLoader.loadClass("com.meti.Index");
                Module module = new Module(c);
                addModule(module.getName(), module);
            }
        }
    }

    public Module addModule(String name, Module module) {
        return modules.put(name, module);
    }

    public Module removeModule(String name) {
        return modules.remove(name);
    }

    public void clear() {
        modules.clear();
    }

    public Map<String, Module> getModules() {
        return modules;
    }

    public Module getModule(String name) {
        return modules.get(name);
    }

    public void addModule(Module module) {
        addModule(module.getName(), module);
    }
}