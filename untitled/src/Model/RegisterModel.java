package Model;

import Model.Objects.Account;
import Model.UserRepository.IUserRepository;
import Model.UserRepository.UserRepository;
import View.RegisterView;

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
    public void AddUser(Account newAccount)
    {
        Account account = new Account(newAccount.getId(), newAccount.getUsername(), newAccount.getPassword(), newAccount.getPhone(), newAccount.getFirstName(), newAccount.getLastName(), newAccount.getType());
        try
        {
            userRepository.add(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

