package com.meti;

import java.net.URL;

public class Index {
    private static final String NAME = "URL";

    public static String getName() {
        return NAME;
    }

    public static URL getOptions() {
        return URLOptions.class.getResource("URLOptions.fxml");
    }

    public static URL getLocation() {
        return URLDisplay.class.getResource("URLDisplay.fxml");
    }
}
