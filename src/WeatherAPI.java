import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

//API STRUCTURE
/*{.
  "name": "Austin",
  "weather": [
    {
      "description": "clear sky"
    }
  ],
  "main": {
    "temp": 300.15,
    "feels_like": 303.15,
    "humidity": 40
  },
  "wind": {
    "speed": 2.1
  }
}*/

public class WeatherAPI {

    private String key;
    private String url;
    //private Weather weather; //Create weather object with etch instead - Jason S

    public WeatherAPI(String key, String url){
        this.key = key; //api key - Jason S
        this.url = url; // api endpoint - Jason S
    }

    //Public or private? Find out api structure - Jason S
    //change from void, need to create Weather Object
    private Weather parse(String jsonResponse){
        JSONObject json = new JSONObject(jsonResponse);

        // Added this just in case of no name java error -Dan
        if (!json.has("name") || json.has("cod") && !json.get("cod").toString().equals("200")) {
            System.out.println("Error: " + jsonResponse);
            return null;
        }

        //Gather api info based on structure - Jason S
        String city = json.getString("name");

        JSONObject main = json.getJSONObject("main");
        double temp = main.getDouble("temp");
        double humidity = main.getDouble("humidity");
        double feels_like = main.getDouble("feels_like");

        JSONObject wind = json.getJSONObject("wind");
        double windSpeed = wind.getDouble("speed");

        String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");

        return new Weather(city, temp, humidity, condition, windSpeed);
    }

    //Is this right? - Jason S
    public Weather fetch(String city) {

        try{
            // FIX: Trim accidental spaces and encode the city name to handle cities like "San Diego"
            String encodedCity = URLEncoder.encode(city.trim(), StandardCharsets.UTF_8);

            String urlString = url + "?q=" + encodedCity + "&appid=" + key + "&units=imperial";
            //debug - Jason S
            System.out.println(urlString);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return parse(response.body());
        } catch(Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
}