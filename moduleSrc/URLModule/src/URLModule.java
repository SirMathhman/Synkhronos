import java.net.URL;

public class URLModule {
    public static void main(String[] args) {
    }

    public static URL getLocation(){
        return URLModule.class.getResource("URLDisplay.fxml");
    }
}