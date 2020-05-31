package controller;

import viewer.LogInViewer;
import viewer.Register_page;

import Model.account;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrameController {
    private JButton button_register;
    private JButton button_log;
    private JLabel StatusMassage;
    private LogInViewer logInViewer;
    Register_page Register_page;

    public LoginFrameController() {
        InitComponent();
        InitListeners();
    }

    private void InitComponent() {
        logInViewer = new LogInViewer();
        button_log= logInViewer.getLogIn();
        button_register= logInViewer.getRegister();

    }



    private void InitListeners() {
        button_log.addActionListener(new button_logListener());
        button_register.addActionListener(new button_regListener());
    }
    private class button_regListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register_page=new Register_page();
            Register_page.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }

    private class button_logListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            StatusMassage =logInViewer.getConnect();
            String userName = logInViewer.getUsername();
            String pass = logInViewer.getPassword();
            account object = new account(userName,pass);
            try
            {
               Boolean isSuccessfullyLoggedIn = object.ValidateLoginRequest(userName,pass);
                if(isSuccessfullyLoggedIn==true) {
                    StatusMassage.setText("Welcome " + userName);
                    StatusMassage.setForeground(Color.green);
                }
                else {
                    StatusMassage.setText(userName + "is not a registered account");
                    StatusMassage.setForeground(Color.red);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}