package com.meti.module;

import java.net.URL;

public class Module {
    private final URL location;
    private final String name;

    private final URL displayLocation;

    public Module(URL location, String name, URL displayLocation) {
        this.location = location;
        this.name = name;

        this.displayLocation = displayLocation;
    }

    public URL getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}