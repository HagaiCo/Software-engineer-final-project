package Model;

import controller.RegisterController;
import view.LogIn_View;
import view.Register_View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login_Model {

    private JButton button_register;
    private JButton button_log;
    private JLabel StatusMassage;
    private LogIn_View logInView;
    private RegisterController registerController;
    UserRepository userRepository = new UserRepositoryImpl();

    public Login_Model() throws IOException, ClassNotFoundException {
    }


    public boolean validateUser(String username,String password){
        if (userRepository.loginSuccess(username, password)) {
            System.out.println("logged in");
            return true;
        }
        else System.out.println("error");
        return false;
    }


}

