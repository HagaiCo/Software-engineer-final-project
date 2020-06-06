package Model;

import java.util.ArrayList;

public class retail_org
{

    private String retail_name;// שם החברה
    private String retail_address;
    private Integer retail_phone;
    private ArrayList<product> product_list=new ArrayList<product>();

    public retail_org(String retail_name, String retail_address, Integer retail_phone) {
        this.retail_name = retail_name;
        this.retail_address = retail_address;
        this.retail_phone = retail_phone;

    }

    public String getRetail_name() {
        return retail_name;
    }

    public void setRetail_name(String retail_name) {
        this.retail_name = retail_name;
    }

    public String getRetail_address() {
        return retail_address;
    }

    public void setRetail_address(String retail_address) {
        this.retail_address = retail_address;
    }

    public Integer getRetail_phone() {
        return retail_phone;
    }

    public void setRetail_phone(Integer retail_phone) {
        this.retail_phone = retail_phone;
    }
}

