package Model.Objects;

import java.io.Serializable;

public class Products implements Serializable
{
    public String product_name;
    private String product_quantity;
    private String expiration_day;

    public Products()
    {
        this.product_name = "";
        this.product_quantity = "";
        this.expiration_day = "";
    }

    public Products(String product_name, String product_quantity, String expiration_day) {
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.expiration_day = expiration_day;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public String getExpiration_day() {
        return expiration_day;
    }

    public String getProduct_name()
    {
        return product_name;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public void setExpiration_day(String expiration_day) {
        this.expiration_day = expiration_day;
    }

    public void setProduct_name(String product_name)
    {
        this.product_name = product_name;
    }
}
