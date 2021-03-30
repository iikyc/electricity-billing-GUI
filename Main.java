public class Main {

    public static void main(String[] args) {

        BackEnd backEnd = new BackEnd();

        LoginPage loginPage = new LoginPage(backEnd.getLoginInfo(), backEnd.getRegisteredUsers(), backEnd.getBillsHashMap(), backEnd.getBillsList());

    }
}