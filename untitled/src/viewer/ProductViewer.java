package viewer;

import Model.product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductViewer extends JFrame{
    private JTable productForCharityTable;
    private JPanel ProductFrame;
    private JButton addNewProductButton;
    private JButton deleteProductButton;
    private JButton productListButton;
    private JLabel label;
    private product product;
    private Table table;
    private List <product> L;
    String[] columnNames = {"Product Name",
            "Quantity",
            "Expiration day",
            "Need fridge"};


    public ProductViewer(String name) {
        setTitle("Registration Form");
        label.setText("Logged In As "+name);
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(ProductFrame);
        setVisible(true);

        productListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table=new Table();
                table.getTable();

            }
        });
    }

    public JTable getProductForCharityTable() {
        return productForCharityTable;
    }

    public JButton getAddNewProductButton() {
        return addNewProductButton;
    }

    public JButton getDeleteProductButton() {
        return deleteProductButton;
    }

    public JButton getProductListButton() {
        return productListButton;
    }

    public JLabel getLabel() {
        return label;
    }

    }