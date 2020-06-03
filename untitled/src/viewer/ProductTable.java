package viewer;

import Model.product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductTable extends JFrame
{
    private product product;
    private Container c;
    private JTable table;
    private List<product> list;
    String[] columns = {"Product Name", "Quantity", "Expiration day"};  //headers for the table
    int i=0;
    int columnCounter = 0;
    public ProductTable() {
       table.setModel(product.ProductTableModel());
      //add the table to the frame
        setTitle("ProductList");
        setBounds(300, 90, 900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setFillsViewportHeight(true);
        setVisible(true);
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }
    }

