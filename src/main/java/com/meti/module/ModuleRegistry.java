package com.meti.module;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class ModuleRegistry {
    private final Set<Module> modules = new HashSet<>();

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
                Class<?> c = classLoader.loadClass("Index");
                Method locationMethod = c.getMethod("getLocation");
                Method nameMethod = c.getMethod("getName");

                Object nameToken = nameMethod.invoke(null);
                Object locationToken = locationMethod.invoke(null);
                if (nameToken instanceof String && locationToken instanceof URL) {
                    String name = (String) nameToken;
                    URL location = (URL) locationToken;

                    addModule(new Module(fileURL, name, location));
                }
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