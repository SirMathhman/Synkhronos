package com.meti.module;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.Attributes;

public class ModuleRegistry {
    private final Set<Module> modules = new HashSet<>();

    public void load(File location) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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
                URL url = location.toURI().toURL();
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                Attributes attributes = connection.getMainAttributes();
                String mainClassName = attributes.getValue(Attributes.Name.MAIN_CLASS);

                ClassLoader classLoader = new URLClassLoader(new URL[]{url});

                Class<?> mainClass = classLoader.loadClass(mainClassName);
                Method mainMethod = mainClass.getMethod("main", String[].class);
                int modifiers = mainMethod.getModifiers();
                if (mainMethod.getReturnType() != void.class || !Modifier.isStatic(modifiers) || Modifier.isPublic(modifiers)) {
                    throw new NoSuchMethodException("Cannot find main method");
                }

                mainMethod.invoke(null);
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
