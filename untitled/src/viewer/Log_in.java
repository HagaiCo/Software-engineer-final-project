package viewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class Log_in extends JFrame {
    private JPanel LoginFrame;
    private JPasswordField password;
    private JLabel Label;
    private JTextField Username;
    private JButton register;
    private JButton LogIn;
    private JLabel pass;


    public Log_in() {
        super("Donation-Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,300,800,500);
        getContentPane().add(LoginFrame);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public JPasswordField getPassword() {
        return password;
    }

    public JTextField getUsername() {
        return Username;
    }


    public JButton getRegister() {
        return register;
    }

    public JButton getLogIn() {
        return LogIn;
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}