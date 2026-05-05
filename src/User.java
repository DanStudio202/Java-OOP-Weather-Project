
public class User {
    //Aggregation: User has an Account and Location - Jason S
    private Account account;
    private Location location;

    //Public attributes since user may need to see them - Jason S
    public String username;
    public String password;
    public String email;


    /**
     * Constructs a new User with full details.
     * * @param username The user's name.
     * @param password The user's secret password.
     * @param email    The user's email address.
     * @param account  The associated Account object.
     * @param location The user's default Location.
     */
    public User(String username, String password, String email, Account account, Location location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.account = account;
        this.location = location;
    }

    public void login(){

    }    
}
