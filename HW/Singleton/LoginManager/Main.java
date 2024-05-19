package Singleton.LoginManager;

public class Main {
    public static void main(String[] args) {
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.login("john", "password");
        System.out.println("Đã đăng nhập: " + loginManager.isLoggedIn());
        System.out.println("Tên người dùng: " + loginManager.getUsername());

        loginManager.logout();
        System.out.println("Đã đăng nhập: " + loginManager.isLoggedIn());
        System.out.println("Tên người dùng: " + loginManager.getUsername());
    }
}
