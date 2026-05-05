import java.util.ArrayList;

/**
 * This manages the user credentials + verification.
 * Simulates a database using internal lists for usernames / passwords.
 */
public class Authenticate {

    // simulated database -Dan
    private ArrayList<String> userList;
    private ArrayList<String> passList;

    /**
     * Initializes a new authentication database.
     */
    public Authenticate(){
        userList = new ArrayList<>();
        passList = new ArrayList<>();
    }

    /**
     * Verifies if the provided username and password match any registered users.
     * * @param u The username provided.
     * @param p The password provided.
     * @return true if credentials are valid, false otherwise.
     */
    
    // handles the actual verification -Dan
    public boolean checkLogin(String u, String p){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(u) && passList.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Registers a new user into the simulated database.
     * * @param u The new username.
     * @param p The new password.
     */
    public void registerUser(String u, String p) {
        userList.add(u);
        passList.add(p);
    }

    /**
     * Displays an error message for invalid login attempts.
     */
    public void displayError(){
        System.out.println("Invalid login credentials.");
    }
}
