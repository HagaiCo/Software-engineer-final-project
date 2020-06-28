package controller;

import view.Test_Page;

import java.io.IOException;

import javax.swing.*;
import Model.UserRepository;
import Model.UserRepositoryImpl;


public class Test_PageController {
    private Test_Page Test_Page;
    private JList UserJList;
    UserRepository userRepository = new UserRepositoryImpl();
    private String[] UserList;
    private JLabel infoBox;



    public Test_PageController() throws IOException, ClassNotFoundException {
        InitComponent();

    }

    private void InitComponent() {
        Test_Page = new Test_Page();
        UserJList= Test_Page.getUserList();
        UserList=userRepository.getUserList();
        //account[] array=new account[UserList.size()];
       // array=UserList.toArray(array);
        UserJList.setListData(UserList);
        infoBox= Test_Page.getInfoBox();

    }

}
