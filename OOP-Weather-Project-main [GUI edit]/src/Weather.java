
public class Weather {

    private String city;
    private double temp;
    private double humidity;
    private String condition;
    private double windSpeed; //added from API
    //private Clothes clothes;

    public Weather(String city, double temp, double humidity, String condition, double windSpeed){
        this.city = city;
        this.temp = temp;
        this.humidity = humidity;
        this.condition = condition;
        this.windSpeed = windSpeed;
        //this.clothes = clothes;
    }

    public double getTemp() {
       return temp; 
    }

    //Print weather objects data - Jason S
    //Split into different gettersfor clearner report - Jason S
    public String getReport() {
        return "Location: " + city + " Temperature: " + temp + " Humdity: " + humidity +
            " Conditions: " + condition + " WindSpeed: " + windSpeed;

    }
}
