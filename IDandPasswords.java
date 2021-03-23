import java.util.HashMap;
import java.util.ArrayList;

public class IDandPasswords {

    // Needed for login and registration
    public static HashMap<String, String> logininfo = new HashMap<>();
    // Needed for bills
    public static ArrayList<String> registeredUsers = new ArrayList<>();
    public static HashMap<String, ArrayList> billsHashMap = new HashMap<>();
    public static ArrayList<Double> billsList = new ArrayList<>();

    public static String userID;

    IDandPasswords() {

        logininfo.put("kyc", "KYC");

    }

    protected HashMap<String, String> getLoginInfo() {

        return logininfo;

    }

    protected ArrayList<String> getRegisteredUsers() {

        return registeredUsers;

    }

    protected HashMap<String, ArrayList> getBillsHashMap() {

        return billsHashMap;

    }

    protected ArrayList<Double> getBillsList() {

        return billsList;

    }

}
