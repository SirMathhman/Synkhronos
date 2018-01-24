package com.meti.url;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class URLModuleStep1 extends URLModuleStep implements Initializable {
    private final URL step2 = getClass().getResource("URLModuleStep2.fxml");

    @FXML
    private ComboBox<String> protocolBox;

    @FXML
    public void next() {
        String protocol = protocolBox.getValue();
        try {
            URLModule module = getModule();
            module.setProtocol(protocol);
            module.load(step2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        protocolBox.getItems().addAll("file",
                "http");
    }
}
