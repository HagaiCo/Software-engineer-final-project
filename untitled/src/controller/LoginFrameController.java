package controller;

import viewer.LogInViewer;
import viewer.Register_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginFrameController {
    private JButton button_register;
    private JButton button_log;
    private LogInViewer logInViewer;
    Register_page Register_page;

    public LoginFrameController() {
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
            //String userName = logInViewer.getUsername();
            try
            {
                ValidateLoginRequest("","");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        public void ValidateLoginRequest (String name, String pass) throws SQLException
        {
            try {
                System.out.println("Connecting to a selected database...");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hagai\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
                System.out.println("Connected database successfully...");
                Statement stm = connection.createStatement();
                //stm.execute("INSERT INTO accounts" + "(name, pass, email, phone, birth, address)" +
                  //      "VALUES( '" + name + "', '" + pass + "', '" + email + "', '" + phone + "', '" + birth + "', '" + address + "')");
                stm.close();

                connection.close();
            } catch (SQLException e) {
                System.out.println("Can't Connect To DB" + e.getMessage());
            }
        }
    }
}
