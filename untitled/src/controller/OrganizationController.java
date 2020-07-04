package controller;

import Model.IOrganizationModel;
import Model.OrganizationModel;
import view.OrganizationView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class OrganizationController
{
    private OrganizationView ProductList_View;
    private JList productJList;
    IOrganizationModel productRepository = new OrganizationModel();

    private String[] productsList;

    private int index;
    private String productName=null;
    private ListSelectionModel lsm;

    public OrganizationController() throws IOException, ClassNotFoundException
    {
        InitComponent();

    }

    private void InitComponent() throws IOException
    {
        ProductList_View = new OrganizationView();
        UpdateList();
        ProductList_View.addProduct_listListener(new product_listListener());
        ProductList_View.AddButton_Listener(new AddProduct_Listener());
        ProductList_View.AddRefresh_Listener(new AddRefresh_Listener());
    }

    public void UpdateList() throws IOException {
        productsList = productRepository.getProductList();
        ProductList_View.SetProductsOnScreen(productsList);
    }

    class product_listListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lis) {

            lsm = (ListSelectionModel)lis.getSource();
            index=lsm.getMaxSelectionIndex();
            String productInfo= null;
            String productInfoArr[]= new String[3];
            String value = ProductList_View.getSelectedValue();

            if(index!=-1) {
                try {
                    productInfo = productRepository.GetInfoByIndex(index);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println(index + ". " + value);
                productInfoArr=productInfo.split(",");
                ProductList_View.SetProductNameText(productInfoArr[0]);
                ProductList_View.SetProductAmountText(productInfoArr[1]);
                ProductList_View.SetProductDateText(productInfoArr[2]);
                productName=productInfoArr[0];

            }
        }
    }

    class AddRefresh_Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                productsList = productRepository.getProductList();
                ProductList_View.UpdateProductsOnScreen(productsList);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }
    }


    class AddProduct_Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //DefaultListModel model = ProductList_View.getProductList().getModel();
           // model.remove(index);
            //ProductList_View.UpdateProductsOnScreen(productsList);
           try {
               productRepository.RemoveFromFile(index);
               productsList = productRepository.getProductList();
               ProductList_View.UpdateProductsOnScreen(productsList);
              // productsList = productRepository.getProductList();
              // ProductList_View.UpdateProductsOnScreen(productsList);
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


        }
    }
}
