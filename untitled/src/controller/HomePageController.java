package controller;

import Model.HomePageModel;
import view.HomePageView;


public class HomePageController {
    private HomePageModel homePage_model;
    private HomePageView homePage_view;



    public HomePageController(HomePageModel homePage_model, HomePageView homePage_view) {
        this.homePage_model = homePage_model;
        this.homePage_view = homePage_view;

    }

    public HomePageModel getHomePage_model() {
        return homePage_model;
    }

    public HomePageView getHomePage_view() {
        return homePage_view;
    }



}




