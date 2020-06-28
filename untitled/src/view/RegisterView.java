package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends  JFrame {
    private JLabel FirstName_lable;
    private JLabel LastName_lable;
    private JTextField LastNameField;
    private JTextField UsernameField;
    private JTextField MobileField;
    private JTextField AddressField;
    private JPasswordField passwordField;
    private JTextField FirstNameField;
    private JLabel UserName_lable;
    private JLabel Password_lable;
    private JLabel Mobile_lable;
    private JLabel Address_lable;
    private JRadioButton charityRadioButton;
    private JRadioButton retailRadioButton;
    private JRadioButton volunteerRadioButton;
    private JComboBox dayCombo;
    private JComboBox monthCombo;
    private JComboBox yearCombo;
    private JCheckBox acceptTermsAndConditionsCheckBox;
    private JButton registerButton;
    private JButton resetButton;
    private JPanel RegisterViewer;



    public RegisterView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(RegisterViewer);
        //setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }


    public String getFirstname() { return FirstNameField.getText(); }
    public String getLastname() { return LastNameField.getText(); }
    public String getUsername() { return UsernameField.getText(); }
    public String getPassword() { return passwordField.getText(); }
    public String getAddress() { return AddressField.getText(); }
    public String getMobile() { return MobileField.getText(); }

    public void showRegisterView()
    {
        this.setVisible(true);
    }



    public void addRegisterSubmitListener(ActionListener mal){registerButton.addActionListener(mal);}


}
