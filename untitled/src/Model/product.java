package Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class product
{

    private String product_name;
    private Integer product_quantity;
    private String experation_day;
    private boolean fridge = false;
    private boolean matched= false;
    private Connection connection;
    List<product> products = new ArrayList<>();


    public product()
    {
        this.product_name = "";
        this.product_quantity = 0;
        this.experation_day = "";
    }

    public product(String product_name, Integer product_quantity, String experation_day) {
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.experation_day = experation_day;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public String getExperation_day() {
        return experation_day;
    }

    public String getProduct_name()
    {
        return product_name;
    }

    public void setProduct_quantity(Integer product_quantity) {
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
