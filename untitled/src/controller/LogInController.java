package controller;

import Model.Login_Model;
import view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LogInController {
    private Login_Model login_model;
    private LogInView logIn_view;
    private boolean Logged_In=false;

    public LogInController(Login_Model login_model, LogInView logIn_view) {
        this.login_model = login_model;
        this.logIn_view = logIn_view;

        logIn_view.addButton_loginSubmitListener(new button_logSubmitListener());

    }

    public boolean isLogged_In() {
        return Logged_In;
    }

    public LogInView getLogIn_view() {
        return logIn_view;
    }


    class button_logSubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("login submit from controller");
            Logged_In = login_model.validateUser(logIn_view.getUsername(),logIn_view.getPassword());
            try
            {
                ProductsListController test = new ProductsListController();
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            //ProductListView test1 = new ProductListView();
        }
    }
}


