package Controller;

import Model.LoginModel;
import View.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LogInController {
    private LoginModel login_model;
    private LogInView logIn_view;
    private boolean Logged_In=false;

    public LogInController(LoginModel login_model, LogInView logIn_view) {
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

            if(Logged_In)
            {
                logIn_view.SetLogInText(true);
                String userName = logIn_view.getUsername();
                String userType = login_model.GetUserType(userName);
                if((userType.equals("Charity"))) {
                    try
                    {
                        OrganizationController organizationController = new OrganizationController();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                else if(userType.equals("Retail"))
                {
                    // TODO: 7/4/2020 retail Page
                    System.out.println("retail");

                }
                else
                    {
                        System.out.println("volunteer");
                }
            }
            else
            {
                logIn_view.SetLogInText(false);
            }
            // TODO: 7/4/2020 //avia open page

        }
    }
}


