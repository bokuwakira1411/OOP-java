package Singleton.LoginManager;

public class LoginManager {
    private static LoginManager instance;
    private boolean login;
    private String username, password;
    public static LoginManager getInstance(){
        if(instance == null) instance = new LoginManager();
        return instance;
    }
    private LoginManager(){
        login = false;
        username = null;
    }
    public void login(String username, String password){
        if(this.username == null && this.password == null){
            login = true;
            this.username = username;
            System.out.println("Login Successful: " + username);
        }
    }
    public void logout(){
        login = false;
        username = null;
        System.out.println("Logout Successful");
    }
    public boolean isLoggedIn(){
        return login;
    }
    public String getUsername(){
        return username;
    }
}
