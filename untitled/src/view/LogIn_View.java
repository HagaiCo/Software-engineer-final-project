package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LogIn_View extends JFrame {
    private JPanel LoginFrame;
    private JPasswordField passwordField;
    private JLabel Label;
    private JLabel pass;
    private JTextField UsernameField;
    private JButton register_button;
    private JButton logIn_button;



    public LogIn_View() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(LoginFrame);
        //setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void showLogInView()
    {
        this.setVisible(true);
    }

    public String getPassword() {
        return passwordField.getText();
    }
    public String getUsername() { return UsernameField.getText(); }

    public void addButton_loginSubmitListener(ActionListener mal) {
        logIn_button.addActionListener(mal);
    }

    public void addButton_registerListener(ActionListener mal) {
        register_button.addActionListener(mal);
    }
}
