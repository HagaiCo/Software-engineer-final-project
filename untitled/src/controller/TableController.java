package controller;

import Model.product;
import viewer.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class TableController {
    JTable table;
    private Table view;
    private DefaultTableModel TableModel;
    private List<Model.product> list;
    private String[] columns = {"Product Name", "Quantity", "Expiration day"};  //headers for the table
    private product product;
    private   String windownsUserName = System.getProperty("user.name");

    public TableController(){

        view=new Table();
        table=view.getTable();
        TableModel = new DefaultTableModel(columns,0);
        try
        {
            TableModel.fireTableDataChanged();
            table.setModel(TableModel);
            System.out.println("Connecting to a selected database...");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\"+windownsUserName+"\\IdeaProjects\\Software-engineer-final-project\\untitled\\src\\DButills\\account.db");
            System.out.println("Connected database successfully...");
            String sqlQuary = "SELECT product_name, product_amount, product_expration_date FROM products";
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(sqlQuary);
            while (rs.next()) {
                product product = new product(rs.getString("product_name"),rs.getInt("product_amount"),rs.getString("product_expration_date"));
                String N=rs.getString("product_name");
                Integer A=rs.getInt("product_amount");
                String E= rs.getString("product_expration_date");
              TableModel.addRow(new Object[]{N,A,E});
                TableModel.fireTableDataChanged();
            }
            table.setModel(TableModel);
        }

        catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }


    }

}
