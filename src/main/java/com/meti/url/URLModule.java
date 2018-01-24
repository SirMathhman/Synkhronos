package com.meti.url;

import com.meti.Library;
import com.meti.Module;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class URLModule extends Module {
    private final URL step1FXML = getClass().getResource("URLModuleStep1.fxml");
    private String protocol;

    public URLModule() {
        super("URL");
    }

    @Override
    public void openDisplay() {
        try {
            load(step1FXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        Parent parent = loader.load();
        URLModuleStep step1 = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        step1.setModule(this);
    }

    @Override
    public Library getLibrary() {
        return null;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
