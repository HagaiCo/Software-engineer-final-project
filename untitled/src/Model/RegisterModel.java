package Model;

import Model.Objects.Account;
import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import view.RegisterView;

import javax.swing.*;

public class RegisterModel implements IRegisterModel {

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
    IUserRepository userRepository = UserRepository.getInstance();

    public RegisterModel() throws Exception { }

    @Override
    public void AddUser(String username, String password, String mobile, String firstName, String lastName, String address, String type)
    {
        try
        {
            userRepository.add(new Account(1,username,password,mobile,firstName,lastName,address,type));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

