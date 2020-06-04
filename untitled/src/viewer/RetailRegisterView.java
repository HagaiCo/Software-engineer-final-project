package viewer;

import javax.swing.*;

public class RetailRegisterView extends JFrame{
    private JPanel RetailRegister;
    private JTextField RetailAddressField;
    private JTextField RetailNameField;
    private JTextField RetailMobileField;
    private JButton submitButton;



    public RetailRegisterView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(RetailRegister);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JTextField getRetailAddressField() {
        return RetailAddressField;
    }
    public void setRetailAddressField(JTextField retailAddressField) {
        this.RetailAddressField = retailAddressField;
    }
    public JTextField getRetailNameField() {
        return RetailNameField;
    }
    public void setRetailNameField(JTextField retailNameField) {
        this.RetailNameField = retailNameField;
    }
    public JTextField getRetailMobileField() {
        return RetailMobileField;
    }
    public void setRetailMobileField(JTextField retailMobileField) {
        this.RetailMobileField = retailMobileField;
    }
    public JButton getSubmitButton() {
        return submitButton;
    }
    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }
}
