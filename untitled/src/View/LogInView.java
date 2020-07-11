package View;

import javax.swing.*;
import java.awt.event.ActionListener;

import static View.ViewFactory.ViewUtils.CenterWindow;

public class LogInView extends JFrame
{
    private JPanel LoginFrame;
    private JPasswordField passwordField;
    private JLabel Label;
    private JLabel pass;
    private JTextField UsernameField;
    private JButton register_button;
    private JButton logIn_button;
    private JLabel logIn_text;

    public LogInView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        CenterWindow(this);
        getContentPane().add(LoginFrame);
        //setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void SetLogInText(boolean logged)
    {
        if(!logged)
        logIn_text.setText("wrong username or password");
        else
            logIn_text.setText("");
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
