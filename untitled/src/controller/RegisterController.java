package controller;



import DButills.DBcollection;
import viewer.RegisterViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterController {

    private JButton registerButton;
    private JButton resetButton;
    private RegisterViewer RegisterViewer;
    private Container C;
    private JTextField LastNameField;
    private JTextField UsernameField;
    private JTextField MobileField;
    private JTextField AddressField;
    private JPasswordField passwordField;
    private JTextField FirstNameField;
    private JRadioButton charityRadioButton;
    private JRadioButton retailRadioButton;
    private JRadioButton volunteerRadioButton;
    private JLabel status;
    private JCheckBox terms;
    private String fname;
    private String lname;
    private String mobile;
    private String username;
    private String pass;
    private String address;
    private DBcollection DB;
    private CharityRegisterController charity;
    private RetailRegisterController retail;

    public RegisterController() {
        InitComponent();
        InitListeners();
    }

    private void InitComponent() {
        RegisterViewer = new RegisterViewer();
        registerButton=RegisterViewer.getRegisterButton();
        resetButton=RegisterViewer.getResetButton();
        FirstNameField=RegisterViewer.getFirstNameField();
        LastNameField=RegisterViewer.getLastNameField();
        UsernameField=RegisterViewer.getUsernameField();
        MobileField=RegisterViewer.getMobileField();
        AddressField=RegisterViewer.getAddressField();
        passwordField=RegisterViewer.getPasswordField();
        charityRadioButton=RegisterViewer.getCharityRadioButton();
        retailRadioButton=RegisterViewer.getRetailRadioButton();
        volunteerRadioButton=RegisterViewer.getVolunteerRadioButton();
        terms = RegisterViewer.getAcceptTermsAndConditionsCheckBox();
        status = RegisterViewer.getStatus();

    }

    private void InitListeners() {
       registerButton.addActionListener(new registerButtonListener());
       resetButton.addActionListener(new resetButtonListener());

    }

    private class registerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (terms.isSelected() == true) {
                DB=new DBcollection();
                if (charityRadioButton.isSelected() == true) {
                    JOptionPane.showMessageDialog(RegisterViewer, "You are Charity ", "Welcome " + FirstNameField, JOptionPane.INFORMATION_MESSAGE);
                    fname=FirstNameField.getText();
                    lname=LastNameField.getName();
                    username=UsernameField.getName();
                    mobile=MobileField.getText();
                    address=AddressField.getText();
                    pass=passwordField.getText();
                    try {
                        DB.DbAccountRegister(fname, lname, username, pass, mobile, address);
                        DB.DbCharityRegister(fname, lname, username, pass, mobile, address);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    status.setText("connecting you to our Charity Register Form");
                     charity=new CharityRegisterController();
                } else if (retailRadioButton.isSelected() == true) {
                    JOptionPane.showMessageDialog(RegisterViewer, "You are a Retail", "Welcome " + FirstNameField, JOptionPane.INFORMATION_MESSAGE);
                    fname=FirstNameField.getText();
                    lname=LastNameField.getName();
                    username=UsernameField.getName();
                    mobile=MobileField.getText();
                    address=AddressField.getText();
                    pass=passwordField.getText();
                    try {
                        DB.DbAccountRegister(fname, lname, username, pass, mobile, address);
                        DB.DbRetailRegister(fname, lname, username, pass, mobile, address);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    status.setText("connecting you to our Retail Register Form");
                    retail=new RetailRegisterController();


                } else if (volunteerRadioButton.isSelected() == true) {
                    JOptionPane.showMessageDialog(RegisterViewer, "You are a Voulunteer", "Welcome " + FirstNameField, JOptionPane.INFORMATION_MESSAGE);
                    fname=FirstNameField.getText();
                    lname=LastNameField.getName();
                    username=UsernameField.getName();
                    mobile=MobileField.getText();
                    address=AddressField.getText();
                    pass=passwordField.getText();
                    try {
                        DB.DbAccountRegister(fname, lname, username, pass, mobile, address);
                        DB.DbVolunteerRegister(fname, lname, username, pass, mobile, address);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    status.setText("connecting you to our Volunteer Register Form");

                }
                else{
                    status.setText("Make sure you choose your account type");
                }




            }
            else {
                status.setText("Please accept the"
                        + " terms & conditions..");
            }
            }
        }


    private class resetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FirstNameField.setText("");
            LastNameField.setText("");
            UsernameField.setText("");
            MobileField.setText("");
            AddressField.setText("");
            passwordField.setText("");
            charityRadioButton.setSelected(false);
            retailRadioButton.setSelected(false);
            volunteerRadioButton.setSelected(false);

        }
    }

}
