package Controller;

import Model.IOrganizationModel;
import Model.OrganizationModel;
import Model.Objects.Products;
import View.OrganizationView;

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
    IOrganizationModel organizationModel = new OrganizationModel();
    private String[] productsList;
    private String[] addedList;
    private int index = -1;
    private String productName=null;
    private ListSelectionModel lsm;
    String productInfoArr[]= new String[3];

    public OrganizationController() throws IOException, ClassNotFoundException
    {
        InitComponent();
    }

    private void InitComponent() throws IOException, ClassNotFoundException {
        ProductList_View = new OrganizationView();
        ProductList_View.addProduct_listListener(new SelectProductListener());
        ProductList_View.AddButton_Listener(new AddProduct_Listener());
        ProductList_View.AddRefresh_Listener(new AddRefresh_Listener());
        UpdateList();
    }

    public void UpdateList() throws IOException, ClassNotFoundException
    {
        productsList = organizationModel.getProductList();
        ProductList_View.SetProductsOnScreen(productsList);
        addedList=organizationModel.getAddedList();
        ProductList_View.SetAddedList(addedList);
    }

    class SelectProductListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent lis)
        {
            SelectProduct(lis);
        }
    }

    class AddRefresh_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            RefreshList();
        }
    }

    class AddProduct_Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AddProductToMyList(new Products(productInfoArr[0], productInfoArr[1], productInfoArr[2]), index);
        }
    }

    public String[] RefreshList()
    {
        try
        {
            productsList = organizationModel.getProductList();
            ProductList_View.UpdateProductsOnScreen(productsList);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return productsList;
    }

    public void AddProductToMyList(Products product, int index)
    {
        try
        {
            if (index != -1)
            {
                organizationModel.AddProductToMyList(product);
                organizationModel.RemoveFromFile(index);
                UpdateList();
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
            catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        }
    }
    public int GetProductNumberFromDB(String fileName) throws IOException
    {
        int result = organizationModel.GetProductNumberInDB(fileName);
        return result;
    }

    public void SelectProduct(ListSelectionEvent lis)
    {
        lsm = (ListSelectionModel) lis.getSource();
        index = lsm.getMaxSelectionIndex();
        String productInfo = null;
        if (index != -1) {
            try {
                productInfo = organizationModel.GetInfoByIndex(index);
                productInfoArr = productInfo.split(",");
                ProductList_View.SetProductNameText(productInfoArr[0]);
                ProductList_View.SetProductAmountText(productInfoArr[1]);
                ProductList_View.SetProductDateText(productInfoArr[2]);
                productName = productInfoArr[0];
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
