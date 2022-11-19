import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();
        userService.parseUsers();
        UserLoginApplication userLoginApplication = new UserLoginApplication();
        userLoginApplication.userLoginHandler(userService);

    }

    int loginAttempts;
    String inputEmail;
    String inputPassword;
    Scanner scanner;

    public UserLoginApplication() {
        loginAttempts = 5;
        scanner = new Scanner(System.in);
    }

    private void userLoginHandler(UserService userService) {

        while(loginAttempts > 0){
            System.out.println("Enter your email: ");
            inputEmail = scanner.nextLine();
            System.out.println("Enter your password: ");
            inputPassword = scanner.nextLine();

            User user = userService.validateLogin(inputEmail,inputPassword);

            if(user != null){
                System.out.println("Welcome: " + user.getName());
                break;
            }else{
                loginAttempts--;
                if(loginAttempts <= 0){
                    System.out.println("Too many failed login attempts, you are now locked out.");
                }else{
                    System.out.println("Invalid login, please try again");
                }
            }
        }

    }


}
