package Controller;


import Model.*;
import Model.Objects.Account;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(RegisterModel registerModel, RegisterView registerView)
    {
        this.registerModel = registerModel;
        this.registerView = registerView;

        registerView.addRegisterSubmitListener(new button_logListener());
    }

    public void showRegisterView() { registerView.showRegisterView(); }

    class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(registerView.TermsAccepted())
            {
                Account newAccount = new Account(1, registerView.getUsername(), registerView.getPassword(), registerView.getMobile(), registerView.getFirstName(), registerView.getLastName(), registerView.GetType());
                NewUserRegistration(newAccount);
            }
            else
                registerView.AlertTerms();
        }
    }
    public void NewUserRegistration(Account newAccount)
    {
        Account account = new Account(newAccount);
        try
        {
            registerModel.AddUser(account);
            registerView.setVisible(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


