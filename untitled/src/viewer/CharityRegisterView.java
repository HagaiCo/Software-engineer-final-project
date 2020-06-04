package viewer;

import javax.swing.*;

public class CharityRegisterView extends JFrame {
    private JPanel CharityRegister;
    private JTextField CharityAddressField;
    private JTextField ChatityNameField;
    private JTextField CharityMobileField;
    private JButton submitButton;


    public CharityRegisterView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(CharityRegister);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JTextField getCharityAddressField() {
        return CharityAddressField;
    }

    public void setCharityAddressField(JTextField charityAddressField) {
        CharityAddressField = charityAddressField;
    }

    public JTextField getChatityNameField() {
        return ChatityNameField;
    }

    public void setChatityNameField(JTextField chatityNameField) {
        ChatityNameField = chatityNameField;
    }

    public JTextField getCharityMobileField() {
        return CharityMobileField;
    }

    public void setCharityMobileField(JTextField charityMobileField) {
        CharityMobileField = charityMobileField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }
}
