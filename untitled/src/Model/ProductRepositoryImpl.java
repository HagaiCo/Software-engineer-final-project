package Model;

import java.io.IOException;

public class ProductRepositoryImpl implements IProductRepository {

    private String[] products;
    private FileManager<Products> fileManager;
    Object test = "test";
    public ProductRepositoryImpl() throws IOException, ClassNotFoundException
    {
        this.fileManager = new FileManager<Products>("Products.csv");
        this.products = this.fileManager.readCSV();
    }

    @Override
    public void add(Products user) throws Exception
    {

    }

    @Override
    public String[] getProductList() throws IOException
    {
        return products;
    }
}
