/**
 * Represents geographical location.
 * Stores the details such as city, state, and zip code.
 */
public class Location {

    private String state;
    private int zip;
    private String city;

    private WeatherAPI weatherAPI;
    private Clothes clothes;

    /**
     * Constructs a Location object.
     * * @param state      State name.
     * @param zip        Numeric zip code.
     * @param city       City name.
     * @param weatherAPI Reference to weather service.
     * @param clothes    Reference to clothing logic.
     */
    public Location(String state, int zip, String city, WeatherAPI weatherAPI, Clothes clothes){
        this.state = state;
        this.zip = zip;
        this.city = city;
        this.weatherAPI = weatherAPI;
        this.clothes = clothes;
    }

    /**
     * Sets the state.
     * @param state The state name.
     */
    //Setter Methods - Jason S
    public void setState(String state){
        this.state=state;
    }

    /**
     * Sets the zip code.
     * @param zip The zip code.
     */
    public void setZip(int zip){
        this.zip=zip;

    }
    /**
     * Sets the city.
     * @param city The city name.
     */
    //only this is used currently - Jason S
    public void setCity(String city){
        this.city=city;

    }

    /**
     * Returns the state name.
     * @param state Current state (parameter seems redundant based on usage).
     * @return The state string.
     */
    //Getter Methods - Jason S
    public String getState(String state){

        String userState = state;
        return userState;
    }

    /**
     * Returns the zip code.
     * @param zip Current zip.
     * @return The zip integer.
     */
    public int getZip(int zip){

        int userZip= zip;
        return userZip;
    }

    /**
     * Returns the city name.
     * @param city Current city.
     * @return The city string.
     */
    public String getCity(String city){

        String userCity = city;
        return userCity;
    }
}
