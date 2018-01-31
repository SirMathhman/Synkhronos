package com.meti.module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class Module {
    private final String name;
    private final URL optionsLocation;
    private final URL displayLocation;

    public Module(Class<?> c) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method nameMethod = c.getMethod("getName");
        Method optionsMethod = c.getMethod("getOptions");
        Method locationMethod = c.getMethod("getLocation");

        Object nameToken = nameMethod.invoke(null);
        Object optionsToken = optionsMethod.invoke(null);
        Object locationToken = locationMethod.invoke(null);
        if (nameToken instanceof String && optionsMethod != null && locationToken instanceof URL) {
            name = (String) nameToken;
            optionsLocation = (URL) optionsToken;
            displayLocation = (URL) locationToken;
        } else {
            name = "";
            optionsLocation = null;
            displayLocation = null;
        }
    }

    public URL getOptionsLocation() {
        return optionsLocation;
    }

    public String getName() {
        return name;
    }

    public URL getDisplayLocation() {
        return displayLocation;
    }
}