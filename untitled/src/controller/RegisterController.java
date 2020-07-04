package controller;


import Model.Register_Model;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private Register_Model register_model;
    private RegisterView register_view;
    private String userType;

    public RegisterController(Register_Model register_model, RegisterView register_view) {
        this.register_model = register_model;
        this.register_view = register_view;

        register_view.addRegisterSubmitListener(new button_logListener());
    }

    class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(register_view.TermsAccepted()) {
                userType = register_view.GetType();
                try {
                    register_model.addUser(register_view.getUsername(), register_view.getPassword(), register_view.getMobile(), register_view.getFirstname(), register_view.getLastname(), register_view.getAddress(), userType);
                    register_view.setVisible(false);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }else register_view.AlertTerms();


        }
    }
}


