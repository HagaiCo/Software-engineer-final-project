package controller;

import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import viewer.LogInViewer;
import viewer.ProductViewer;
import viewer.Register_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginFrameController {
    private JButton button_register;
    private JButton button_log;
    private LogInViewer logInViewer;
    Register_page Register_page;
    ProductViewer productViewer;
    UserRepository userRepository = new UserRepositoryImpl();


    public LoginFrameController() throws IOException, ClassNotFoundException {
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
            String username = logInViewer.getUsername();
            String password = logInViewer.getPassword();
            //account  = new account(username,password);
            if(userRepository.loginSuccess(username,password))
            {
                //retail/charity page is opened.
                System.out.println("logged in");
                logInViewer.SetStatusMassage("Logged in");
            }
            else {
                System.out.println("User name or password doesn't match !");
                logInViewer.SetStatusMassage("User name or password doesn't match !");
            }
            logInViewer.GetStatusMassage();
            /*try
            {
               Boolean isSuccessfullyLoggedIn = object.ValidateLoginRequest(userName,pass);
                if(isSuccessfullyLoggedIn==true) {
                    StatusMassage.setText("Welcome " + userName);
                    StatusMassage.setForeground(Color.green);
                    productViewer=new ProductViewer(userName);
                    productViewer.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                }
                else {
                    StatusMassage.setText(userName + " is not a registered account");
                    JOptionPane.showMessageDialog(logInViewer,"No user found ", "Sorry "+userName ,JOptionPane.INFORMATION_MESSAGE);
                    StatusMassage.setForeground(Color.red);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }*/

        }
    }
}