package Model;

import controller.RegisterController;
import view.LogInView;

import javax.swing.*;
import java.io.IOException;

public class Login_Model {

    private JButton button_register;
    private JButton button_log;
    private JLabel StatusMassage;
    private LogInView logInView;
    private RegisterController registerController;
    IUserRepository userRepository = new UserRepositoryImpl();

    public Login_Model() throws IOException, ClassNotFoundException { }

    public boolean validateUser(String username,String password){
        if (userRepository.loginSuccess(username, password)) {
            System.out.println("logged in");
            return true;
        }
        else System.out.println("Invalid username or password");
        return false;
    }
    public String GetUserType(String username)
    {
        return userRepository.GetType(username);
    }
}

