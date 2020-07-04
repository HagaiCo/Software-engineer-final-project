package Model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrganizationModel implements IOrganizationModel {

    private String[] products;
    private FileManager<Products> fileManager;
    Object test = "test";
    public OrganizationModel() throws IOException, ClassNotFoundException
    {
        this.fileManager = new FileManager<Products>("Products.csv");
        this.products = this.fileManager.readCSV(",");
    }

    @Override
    public void add(Products user) throws Exception
    {

    }


    @Override
    public String[] getProductList() throws IOException
    {
        this.products = this.fileManager.readCSV(",");
        return products;
    }

    @Override
    public String GetInfoByIndex(int index) throws FileNotFoundException {
        return this.fileManager.GetInfoByIndex(index);
    }



    @Override
    public void RemoveFromFile(int index) throws IOException {
        this.fileManager.RemoveFromFile(index);
    }
}
