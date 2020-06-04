package controller;

import viewer.CharityRegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharityRegisterController {
    private String Cname;
    private String Cmobile;
    private String Caddress;
    private JTextField name;
    private JTextField address;
    private JTextField mobile;
    private JButton submit;
    private CharityRegisterView view;

    public CharityRegisterController(){
        view=new CharityRegisterView();
        name=view.getChatityNameField();
        address=view.getCharityAddressField();
        mobile=view.getCharityMobileField();
        submit=view.getSubmitButton();

    }
    private void InitListeners() {
        submit.addActionListener(new button_subListener());

    }

    private class button_subListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }
}
