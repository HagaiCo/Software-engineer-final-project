package controller;

import viewer.Log_in;
import viewer.Register_page;
import viewer.home_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameController {
    private JButton button_register;
    private JButton button_log;
    private Log_in Login;
    Register_page Register_page;

    public LoginFrameController() {
        InitComponent();
        InitListeners();

    }

    private void InitComponent() {
        Login = new Log_in();
        button_log= Login.getLogIn();
        button_register=Login.getRegister();

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

    private class button_logListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null,
                    "we need to have a DataBase first",
                    "No Resources",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
