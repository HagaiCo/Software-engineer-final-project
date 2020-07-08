package Driver;

import Model.LoginModel;
import Model.RegisterModel;
import Controller.HomePageController;
import Controller.LogInController;
import Controller.RegisterController;
import View.HomePageView;
import View.LogInView;
import View.RegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MVCDriver {
    public static RegisterView register_view;
    public static RegisterModel register_model;

    public static RegisterController registerController;
    public static LogInView logIn_view;
    public static LoginModel login_model;
    public static LogInController logInController;



    public static void main(String[] args) throws Exception {

        HomePageView homePage_view = new HomePageView();
        HomePageController homePageController = new HomePageController(homePage_view);
        homePage_view.showHomePageView();

        LogInView logIn_view = new LogInView();
        LoginModel login_model = new LoginModel();
        LogInController logInController = new LogInController(login_model,logIn_view);

        homePageController.getHomePage_view().addButton_registerListener(new button_registerListener());
        homePageController.getHomePage_view().addButton_loginListener(new button_logListener());



    }

    static class button_registerListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.out.println("register from driver");
            register_view=new RegisterView();
            try {
                register_model=new RegisterModel();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (Exception classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            registerController=new RegisterController(register_model,register_view);
            register_view.showRegisterView();

        }
    }

    static class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("login from driver");
            logIn_view=new LogInView();
            try {
                login_model=new LoginModel();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (Exception classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            logInController=new LogInController(login_model,logIn_view);
            logInController.getLogIn_view().addButton_loginSubmitListener(new button_logSubmitListener());
            logInController.getLogIn_view().addButton_registerListener(new button_registerListener());
            logIn_view.showLogInView();
        }
    }

    static class button_logSubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(logInController.isLogged_In())
            System.out.println("logged in");
            //todo: get type
            else
                System.out.println("error");
            //todo: add logged in page here

        }
    }
}
