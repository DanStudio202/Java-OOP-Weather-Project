/**
 * Representing the user account in the system.
 * Handles the identity management and also  authentication linking.
 */
public class Account {

    /** The unique identifier for the account. */
    protected int id;
    private Authenticate authenticate;


    /**
     * Constructs an Account.
     * * @param id           The unique account ID.
     * @param authenticate The authentication handler associated with this account.
     */
    public Account(int id, Authenticate authenticate) {
        this.id = id;
        this.authenticate = authenticate;
    }

    /**
     * Static factory method to create a new account with a fresh Authenticate instance.
     * * @param id The desired ID.
     * @return A new Account instance.
     */
    public static Account createAccount(int id) {
        int testId = id;
        Authenticate testAuth = new Authenticate();
        return new Account(testId, testAuth);
    }

    /**
     * Method to generate a new unique ID.
     */
    public void createId(){

    }

    /**
     * Prints the ID of the provided account to the console.
     * * @param a The account to print.
     */
    public void printAccount(Account a){
        System.out.println("account ID: " + a.id);
    }

}
