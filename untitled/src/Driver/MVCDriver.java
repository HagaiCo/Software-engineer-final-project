package Driver;

import Model.HomePage_Model;
import Model.Login_Model;
import Model.Register_Model;
import controller.HomePageController;
import controller.LogInController;
import controller.RegisterController;
import view.HomePage_View;
import view.LogIn_View;
import view.Register_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MVCDriver {
    public static Register_View register_view;
    public static Register_Model register_model;
    public static RegisterController registerController;
    public static LogIn_View logIn_view;
    public static Login_Model login_model;
    public static LogInController logInController;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        HomePage_View homePage_view=new HomePage_View();
        HomePage_Model homePage_model=new HomePage_Model();
        HomePageController homePageController =new HomePageController(homePage_model,homePage_view);
        homePage_view.showHomePageView();

        LogIn_View logIn_view=new LogIn_View();
        Login_Model login_model=new Login_Model();
        LogInController logInController=new LogInController(login_model,logIn_view);

        homePageController.getHomePage_view().addButton_registerListener(new button_registerListener());
        homePageController.getHomePage_view().addButton_loginListener(new button_logListener());



    }

    static class button_registerListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.out.println("register from driver");
            register_view=new Register_View();
            try {
                register_model=new Register_Model();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            registerController=new RegisterController(register_model,register_view);
            register_view.showRegisterView();

        }
    }

    static class button_logListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("login from driver");
            logIn_view=new LogIn_View();
            try {
                login_model=new Login_Model();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
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
            else
                System.out.println("error");
            //todo: add logged in page here

        }
    }


}
