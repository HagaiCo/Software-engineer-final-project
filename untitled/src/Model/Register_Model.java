package Model;

import view.Register_View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Register_Model {

    private JButton registerButton;
    private JButton resetButton;
    private Register_View register_view;
    private JTextField LastNameField;
    private JTextField UsernameField;
    private JTextField MobileField;
    private JTextField AddressField;
    private JPasswordField passwordField;
    private JTextField FirstNameField;
    private JRadioButton charityRadioButton;
    private JRadioButton retailRadioButton;
    private JRadioButton volunteerRadioButton;
    UserRepository userRepository = new UserRepositoryImpl();


    public Register_Model() throws IOException, ClassNotFoundException {
    }

    public void addUser(String username,String password,String mobile,String firstName,String lastName,String address) {
        try {
            userRepository.add(new account(1,username,password,mobile,firstName,lastName,address));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

