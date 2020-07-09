package Model;

import DBUtils.FileManager;
import Model.Objects.Products;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationModel implements IOrganizationModel {

    private String[] products;
    private FileManager<Products> fileManager;
    Object test = "test";
    private FileManager<Products> addedProductsManager;
    private List<Products> addedProducts=new ArrayList<Products>();

    public OrganizationModel() throws IOException, ClassNotFoundException
    {
        this.fileManager = new FileManager<Products>();
        this.products = this.fileManager.ReadFromCSV(",", "Products.csv");
        //this.addedProducts=this.fileManager.read("AddedProducts");
    }

    @Override
    public void AddProductToMyList(Products product) throws IOException {
        this.addedProducts.add(product);
        this.fileManager.write(this.addedProducts, "AddedProducts");
    }

    @Override
    public String[] getAddedList() throws IOException, ClassNotFoundException {
        int i=0;
        this.addedProducts=this.fileManager.read("AddedProducts");
        String [] addedList=new String[addedProducts.size()];
        for(Products product : addedProducts)
            addedList[i++]=product.getProduct_name();
        return addedList ;
    }

    @Override
    public String[] getProductList() throws IOException
    {
        this.products = this.fileManager.ReadFromCSV(",", "Products.csv");
        return products;
    }

    @Override
    public String GetInfoByIndex(int index) throws FileNotFoundException {
        return this.fileManager.GetInfoByIndex(index, "Products.csv");
    }

    @Override
    public void RemoveFromFile(int index) throws IOException {
        this.fileManager.RemoveFromFile(index, "Products.csv");
    }

    @Override
    public int GetProductNumberInDB(String fileName) throws IOException
    {
        int result = fileManager.GetCSVSize(fileName);
        return result;
    }
}
