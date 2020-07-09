package Controller;

import Model.LoginModel;
import Model.RegisterModel;
import View.HomePageView;
import View.LogInView;
import View.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class HomePageController
{
    private static HomePageView homePageView;

    private static RegisterController registerController;
    private static RegisterView registerView;
    private static RegisterModel registerModel;

    private static LogInController logInController;
    private static LogInView logInView;
    private static LoginModel loginModel;

    public HomePageController(HomePageView homePageView) throws Exception
    {
        this.homePageView = homePageView;

        getHomePage_view().addButton_registerListener(new button_registerListener());
        getHomePage_view().addButton_loginListener(new button_logListener());
    }

    public HomePageView getHomePage_view() {
        return homePageView;
    }

    static class button_registerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("register from driver");
            registerView = new RegisterView();
            try
            {
                registerModel = new RegisterModel();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            registerController = new RegisterController(registerModel, registerView);
            registerController.showRegisterView();
        }
    }

    static class button_logListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("login from driver");
            logInView = new LogInView();
            try {
                loginModel = new LoginModel();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (Exception classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            logInController = new LogInController(loginModel, logInView);
            logInController.showLogInView();
        }
    }
}




