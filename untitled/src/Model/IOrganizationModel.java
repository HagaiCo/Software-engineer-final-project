package Model;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOrganizationModel {

    void add(Products product) throws Exception;

    String[] getProductList() throws IOException;

    String GetInfoByIndex(int index) throws FileNotFoundException;





    void RemoveFromFile(int value) throws IOException;
}
