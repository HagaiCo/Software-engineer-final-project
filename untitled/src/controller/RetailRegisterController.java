package controller;

import viewer.RetailRegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetailRegisterController {
    private String Rname;
    private String Rmobile;
    private String Raddress;
    private JTextField name;
    private JTextField address;
    private JTextField mobile;
    private JButton submit;
    private RetailRegisterView view;

    public RetailRegisterController(){
        view=new RetailRegisterView();
        name=view.getRetailNameField();
        address=view.getRetailAddressField();
        mobile=view.getRetailMobileField();
        submit=view.getSubmitButton();
    }
    private void InitListeners() {
        submit.addActionListener(new button_subListener());

    }

    private class button_subListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
       Rname=name.toString();
       Raddress=address.toString();
       Rmobile=mobile.toString();

        }

    }
}
