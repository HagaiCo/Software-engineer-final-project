package controller;

import Model.HomePage_Model;
import view.HomePageView;


public class HomePageController {
    private HomePage_Model homePage_model;
    private HomePageView homePage_view;



    public HomePageController(HomePage_Model homePage_model, HomePageView homePage_view) {
        this.homePage_model = homePage_model;
        this.homePage_view = homePage_view;

    }

    public HomePage_Model getHomePage_model() {
        return homePage_model;
    }

    public HomePageView getHomePage_view() {
        return homePage_view;
    }



}




