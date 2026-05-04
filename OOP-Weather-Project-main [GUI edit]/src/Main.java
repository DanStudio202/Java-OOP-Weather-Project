public class Main {
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