/**
 * This represents our weather status for very specific location.
 * Stores temperature, humidity, wind speed, and general conditions.
 */
public class Weather {

    private String city;
    private double temp;
    private double humidity;
    private String condition;
    private double windSpeed; //added from API
    //private Clothes clothes;

    /**
     * Constructs a Weather data object.
     * * @param city      The name of the city.
     * @param temp      The temperature in Fahrenheit.
     * @param humidity  The humidity percentage.
     * @param condition A brief description of weather conditions (e.g., "clear sky").
     * @param windSpeed The wind speed in mph.
     */
    public Weather(String city, double temp, double humidity, String condition, double windSpeed){
        this.city = city;
        this.temp = temp;
        this.humidity = humidity;
        this.condition = condition;
        this.windSpeed = windSpeed;
        //this.clothes = clothes;
    }

    /**
     * Gets the current temperature.
     * * @return The temperature as a double.
     */
    public double getTemp() {
       return temp; 
    }
    /**
     * Generates a string report of the weather data.
     * * @return A formatted string containing all weather attributes.
     */
    
    //Print weather objects data - Jason S
    //Split into different gettersfor clearner report - Jason S
    public String getReport() {
        return "Location: " + city + " Temperature: " + temp + " Humdity: " + humidity +
            " Conditions: " + condition + " WindSpeed: " + windSpeed;

    }
}
