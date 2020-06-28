package controller;

import Model.HomePage_Model;
import view.HomePage_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePageController {
    private HomePage_Model homePage_model;
    private HomePage_View homePage_view;



    public HomePageController(HomePage_Model homePage_model, HomePage_View homePage_view) {
        this.homePage_model = homePage_model;
        this.homePage_view = homePage_view;

    }

    public HomePage_Model getHomePage_model() {
        return homePage_model;
    }

    public HomePage_View getHomePage_view() {
        return homePage_view;
    }



}




