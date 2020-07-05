package Model;

import controller.RegisterController;
import view.LogInView;

import javax.swing.*;

public class LoginModel {

    private JButton button_register;
    private JButton button_log;
    private JLabel StatusMassage;
    private LogInView logInView;
    private RegisterController registerController;
    IUserRepository userRepository = UserRepositoryImpl.getInstance();

    public LoginModel() throws Exception { }

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

