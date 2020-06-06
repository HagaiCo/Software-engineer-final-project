package viewer;

import Model.product;

import javax.swing.*;
import java.util.List;

public class Table extends JFrame{
    private JPanel Table;
    JTable table;
    private List<product> list;
    String[] columns = {"Product Name", "Quantity", "Expiration day"};  //headers for the table
    int i=0;
    int columnCounter = 0;
    private product product;

    public void getTable() {
        setBounds(300,300,800,500);
        getContentPane().add(Table);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
