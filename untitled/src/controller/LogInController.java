package controller;

import Model.Login_Model;
import view.LogIn_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {
    private Login_Model login_model;
    private LogIn_View logIn_view;
    private boolean Logged_In=false;

    public LogInController(Login_Model login_model, LogIn_View logIn_view) {
        this.login_model = login_model;
        this.logIn_view = logIn_view;

        logIn_view.addButton_loginSubmitListener(new button_logSubmitListener());
        //  logIn_view.addButton_registerListener(new register_buttonListener());
    }

    public boolean isLogged_In() {
        return Logged_In;
    }

    public LogIn_View getLogIn_view() {
        return logIn_view;
    }


    class button_logSubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("login submit from controller");
            Logged_In=login_model.validateUser(logIn_view.getUsername(),logIn_view.getPassword());

        }
    }
}


