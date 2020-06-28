package Model;

import view.RegisterView;
import javax.swing.*;
import java.io.IOException;

public class Register_Model {

    private JButton registerButton;
    private JButton resetButton;
    private RegisterView register_view;
    private JTextField LastNameField;
    private JTextField UsernameField;
    private JTextField MobileField;
    private JTextField AddressField;
    private JPasswordField passwordField;
    private JTextField FirstNameField;
    private JRadioButton charityRadioButton;
    private JRadioButton retailRadioButton;
    private JRadioButton volunteerRadioButton;
    IUserRepository userRepository = new UserRepositoryImpl();


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

