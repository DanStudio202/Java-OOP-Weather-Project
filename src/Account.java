
public class Account {

    protected int id;
     private Authenticate authenticate;

    public Account(int id, Authenticate authenticate) {
        this.id = id;
        this.authenticate = authenticate;
    }

    public static Account createAccount(int id) {
        int testId=id;
        Authenticate testAuth = new Authenticate();
        return new Account(testId, testAuth);
    }

    public void createId(){

    }

    public void printAccount(Account a){
        System.out.println("account ID: " + a.id);

    }

}


