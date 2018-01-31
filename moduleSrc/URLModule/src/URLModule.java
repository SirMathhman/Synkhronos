import java.net.URL;

public class URLModule {
    public static URL getLocation(){
        return URLModule.class.getResource("URLDisplay.fxml");
    }
}