package controller;




import viewer.RegisterViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Model.account;


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
    UserRepository userRepository = new UserRepositoryImpl();

    public RegisterController() throws IOException, ClassNotFoundException {
        InitComponent();
        InitListeners();
    }

    private void InitComponent() {
        RegisterViewer = new RegisterViewer();
        registerButton= RegisterViewer.getRegisterButton();
        resetButton= RegisterViewer.getResetButton();
        FirstNameField= RegisterViewer.getFirstNameField();
        LastNameField= RegisterViewer.getLastNameField();
        UsernameField= RegisterViewer.getUsernameField();
        MobileField= RegisterViewer.getMobileField();
        AddressField= RegisterViewer.getAddressField();
        passwordField= RegisterViewer.getPasswordField();
        charityRadioButton= RegisterViewer.getCharityRadioButton();
        retailRadioButton= RegisterViewer.getRetailRadioButton();
        volunteerRadioButton= RegisterViewer.getVolunteerRadioButton();

    }

    private void InitListeners() {
       registerButton.addActionListener(new registerButtonListener());
       resetButton.addActionListener(new resetButtonListener());

    }

    private class registerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                userRepository.add(new account(1,UsernameField.getText(),passwordField.getText(),MobileField.getText(),FirstNameField.getText(),LastNameField.getText(),AddressField.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }






            /*if(charityRadioButton.isSelected()){
                System.out.println("charity");

            }
            else if (retailRadioButton.isSelected()){
                System.out.println("retail");

            }
            else {
                System.out.println("volunteer");
            }*/
        }
    }

    private class resetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("reset pressed");
            FirstNameField.setText("");
            LastNameField.setText("");
            UsernameField.setText("");
            MobileField.setText("");
            AddressField.setText("");
            passwordField.setText("");

        }
    }

}
