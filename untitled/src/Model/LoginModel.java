package Model;

import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import Controller.RegisterController;
import View.LogInView;

import javax.swing.*;

public class LoginModel implements ILoginModel {

    private JButton button_register;
    private JButton button_log;
    private JLabel StatusMassage;
    private LogInView logInView;
    private RegisterController registerController;
    IUserRepository userRepository = UserRepository.getInstance();

    public LoginModel() throws Exception { }

    @Override
    public boolean validateUser(String username, String password){
        if (userRepository.loginSuccess(username, password)) {
            return true;
        }
        return false;
    }
    @Override
    public String GetUserType(String username)
    {
        return userRepository.GetType(username);
    }
}

