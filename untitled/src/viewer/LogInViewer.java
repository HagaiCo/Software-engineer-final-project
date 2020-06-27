package viewer;

import javax.swing.*;

public class LogInViewer extends JFrame {
    private JPanel LoginFrame;
    private JPasswordField password;
    private JLabel Label;
    private JTextField Username;
    private JButton register;
    private JButton LogIn;
    private JLabel pass;
    private JLabel StatusMassage;




    public LogInViewer()
    {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(LoginFrame);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public void SetStatusMassage(String massage) {  StatusMassage.setText(massage); }
    public JLabel GetStatusMassage() {  return StatusMassage; }

    public String getPassword() {
        return password.getText();
    }
    public String getUsername() { return Username.getText(); }

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
