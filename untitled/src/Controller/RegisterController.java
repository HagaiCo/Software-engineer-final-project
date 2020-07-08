package Controller;


import Model.*;
import Model.Objects.Account;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private RegisterModel register_model;
    private RegisterView register_view;
    private String userType;

    public RegisterController(RegisterModel register_model, RegisterView register_view)
    {
        this.register_model = register_model;
        this.register_view = register_view;

        register_view.addRegisterSubmitListener(new button_logListener());
    }

    class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(register_view.TermsAccepted())
            {
                Account newAccount = new Account(1, register_view.getUsername(), register_view.getPassword(), register_view.getMobile(), register_view.getFirstName(), register_view.getLastName(), register_view.GetType());
                NewUserRegistration(newAccount);
            }
            else
                register_view.AlertTerms();
        }
    }
    public void NewUserRegistration(Account newAccount)
    {
        Account account = new Account(newAccount);
        userType = register_view.GetType();
        try
        {
            register_model.AddUser(account);
            register_view.setVisible(false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


