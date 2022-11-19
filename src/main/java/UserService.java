import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

    User[] users = new User[4];

    public void parseUsers() throws IOException {
        BufferedReader fileReader = null;

        try{
            fileReader = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            for(int i = 0; i < users.length && (line = fileReader.readLine()) != null;i++) {
                String[] accountInfo = line.split(",");
                users[i] = new User(accountInfo[0],accountInfo[1],accountInfo[2]);
            }
        } finally {
            fileReader.close();
        }
    }

    public User validateLogin(String inputEmail, String inputPassword){
        for(User user : users){
            if(user.getEmail().equals(inputEmail) && user.getPassword().equals(inputPassword)){
                return user;
            }
        }
        return null;
    }


}
