package Driver;

import Controller.HomePageController;
import Controller.LogInController;
import Controller.RegisterController;
import Model.LoginModel;
import Model.RegisterModel;
import View.HomePageView;
import View.LogInView;
import View.RegisterView;

public class MVCDriver {
    public static RegisterView register_view;
    public static RegisterModel register_model;

    public static RegisterController registerController;
    public static LogInView logIn_view;
    public static LoginModel login_model;
    public static LogInController logInController;



    public static void main(String[] args) throws Exception
    {
        HomePageView homePage_view = new HomePageView();

        HomePageController homePageController = new HomePageController(homePage_view);
        homePage_view.showHomePageView();
    }
}
