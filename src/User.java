
public class User {
    //Aggregation: User has an Account and Location - Jason S
    private Account account;
    private Location location;

    //Public attributes since user may need to see them - Jason S
    public String username;
    public String password;
    public String email;

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