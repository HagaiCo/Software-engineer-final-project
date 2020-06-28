package controller;

import Model.IProductRepository;
import Model.ProductRepositoryImpl;
import view.ProductListView;

import javax.swing.*;
import java.io.IOException;


public class ProductsListController
{
    private ProductListView ProductList_View;
    private JList productJList;

    IProductRepository productRepository = new ProductRepositoryImpl();

    private String[] userList;
    private String[] productsList;
    private JLabel infoBox;

    public ProductsListController() throws IOException, ClassNotFoundException
    {
        InitComponent();
    }

    private void InitComponent() throws IOException
    {
        ProductList_View = new ProductListView();
        productsList = productRepository.getProductList();
        ProductList_View.SetProductsOnScreen(productsList);
        infoBox = ProductList_View.getInfoBox();
    }
}
