package Model;

import java.io.IOException;

public interface IProductRepository {

    void add(Products product) throws Exception;

    String[] getProductList() throws IOException;
}
