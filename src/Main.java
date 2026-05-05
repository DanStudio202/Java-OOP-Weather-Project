/**
 * The starting point for the Weather Application.
 * This class initializes our Weather API and launches the Graphical User Interface.
 */
public class Main {
    /**
     * Main method to start the application.
     * * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // API Setup - Jason S
        String key = "be22faad5317fe55300a1ccd39259e49";
        String url = "https://api.openweathermap.org/data/2.5/weather";
        WeatherAPI api = new WeatherAPI(key, url);

        // Pass the API object to the GUI - Dan
        GUI gui = new GUI(api);
        gui.setVisible(true);
    }
}
