import com.meti.URLDisplay;

import java.net.URL;

public class Index {
    private static final String NAME = "URL";

    public static String getName(){
        return NAME;
    }

    public static URL getLocation() {
        return URLDisplay.class.getResource("URLDisplay.fxml");
    }
}
