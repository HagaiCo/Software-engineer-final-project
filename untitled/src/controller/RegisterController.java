package controller;


import Model.Register_Model;
import view.Register_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private Register_Model register_model;
    private Register_View register_view;

    public RegisterController(Register_Model register_model, Register_View register_view) {
        this.register_model = register_model;
        this.register_view = register_view;

        register_view.addRegisterSubmitListener(new button_logListener());
    }

    class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                register_model.addUser(register_view.getUsername(),register_view.getPassword(),register_view.getMobile(),register_view.getFirstname(),register_view.getLastname(),register_view.getAddress());
                register_view.setVisible(false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}


