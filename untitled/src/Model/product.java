package Model;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
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

    public DefaultTableModel ProductTableModel() {

        String windownsUserName = System.getProperty("user.name");
        try
        {
            System.out.println("Connecting to a selected database...");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\"+windownsUserName+"\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
            System.out.println("Connected database successfully...");
            String sqlQuary = "SELECT product_name, product_amount, product_expration_date FROM products";
            DefaultTableModel model = new DefaultTableModel(new String[] {"Product Name", "Quantity", "Expiration day"}, 0);
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(sqlQuary);

            List<product> products = new ArrayList<>();
            while (rs.next()) {
                product product = new product(rs.getString("product_name"),rs.getInt("product_amount"),rs.getString("product_expration_date"));
                String N=rs.getString("product_name");
                 Integer A=rs.getInt("product_amount");
                 String E= rs.getString("product_expration_date");
                model.addRow(new Object[]{N,A,E});
            }
            return model;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
