import java.util.HashMap;

public class Data {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    Data(){

        loginInfo.put("Test", "Test1234");
        loginInfo.put("Max", "Min");
        loginInfo.put("Admin", "Admin");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
