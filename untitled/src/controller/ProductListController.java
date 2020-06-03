package controller;

import Model.product;
import viewer.ProductViewer;
import viewer.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductListController extends JFrame {

    private Table table;
    private JLabel label;
    private JTable productForCharityTable;
    private JButton addNewProductButton;
    private JButton deleteProductButton;
    private JButton productListButton;
    private product product;
    private String name;
    private ProductViewer product_viewer;

    public ProductListController(String name)  {

            ProductViewer viewer=new ProductViewer(name);
            productForCharityTable=viewer.getProductForCharityTable();
            productListButton=viewer.getProductListButton();
            productListButton.addActionListener(new productListButton());

    }
    private class productListButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            table= new Table();
        }

    }
    /*private class addNewProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register_page=new Register_page();
            Register_page.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }
    private class deleteProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register_page=new Register_page();
            Register_page.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }*/
}
