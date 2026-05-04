import java.util.ArrayList;

public class Authenticate {

    // simulated database -Dan
    private ArrayList<String> userList;
    private ArrayList<String> passList;

    public Authenticate(){
        userList = new ArrayList<>();
        passList = new ArrayList<>();
    }

    // handles the actual verification -Dan
    public boolean checkLogin(String u, String p){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(u) && passList.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(String u, String p) {
        userList.add(u);
        passList.add(p);
    }

    public void displayError(){
        System.out.println("Invalid login credentials.");
    }
}
