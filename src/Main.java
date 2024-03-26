public class Main {
    public static void main(String[] args) throws Exception {
        Data idAndPasswords = new Data();

        LoginPage loginPage = new LoginPage(idAndPasswords.getLoginInfo());
    }
}
