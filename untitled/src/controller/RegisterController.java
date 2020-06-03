package controller;



import viewer.RegisterViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

    private void InitListeners() {
       registerButton.addActionListener(new resetButtonListener());
       resetButton.addActionListener(new resetButtonListener());

    }

    private class registerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(charityRadioButton.isSelected()){
                JOptionPane.showMessageDialog(RegisterViewer,"you are a cherity");

            }
            else if (retailRadioButton.isSelected()){
                JOptionPane.showMessageDialog(RegisterViewer,"you are a retail");

            }
            else {JOptionPane.showMessageDialog(RegisterViewer,"you are a voulunteer"); }


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

        }
    }

}
