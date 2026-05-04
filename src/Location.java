
public class Location {

    private String state;
    private int zip;
    private String city;

    private WeatherAPI weatherAPI;
    private Clothes clothes;

    public Location(String state, int zip, String city, WeatherAPI weatherAPI, Clothes clothes){
        this.state = state;
        this.zip = zip;
        this.city = city;
        this.weatherAPI = weatherAPI;
        this.clothes = clothes;
    }

    //Setter Methods - Jason S
    public void setState(String state){
        this.state=state;
    }

    public void setZip(int zip){
        this.zip=zip;

    }
    //only this is used currently - Jason S
    public void setCity(String city){
        this.city=city;

    }

    //Getter Methods - Jason S
    public String getState(String state){

        String userState = state;
        return userState;
    }

    public int getZip(int zip){

        int userZip= zip;
        return userZip;
    }

    public String getCity(String city){

        String userCity = city;
        return userCity;
    }
}
