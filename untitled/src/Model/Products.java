package Model;

import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Products implements Serializable
{

    private String product_name;
    private String product_quantity;
    private String experation_day;

    public Products()
    {
        this.product_name = "";
        this.product_quantity = "";
        this.experation_day = "";
    }

    public Products(String product_name, String product_quantity, String experation_day) {
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.experation_day = experation_day;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public String getExperation_day() {
        return experation_day;
    }

    public String getProduct_name()
    {
        return product_name;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public void setExperation_day(String experation_day) {
        this.experation_day = experation_day;
    }

    public void setProduct_name(String product_name)
    {
        this.product_name = product_name;
    }



}
