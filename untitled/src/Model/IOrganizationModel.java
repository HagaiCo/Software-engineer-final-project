package Model;

import Model.Objects.Products;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOrganizationModel
{
    void AddProductToMyList(Products product) throws IOException;

    String[] getAddedList() throws IOException, ClassNotFoundException;

    String[] getProductList() throws IOException;

    String GetInfoByIndex(int index) throws FileNotFoundException;

    void RemoveFromFile(int value) throws IOException;

    int GetProductNumberInDB(String fileName) throws IOException;
}
