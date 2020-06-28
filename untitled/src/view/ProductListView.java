package view;

import javax.swing.*;
import java.awt.*;

public class ProductListView extends JFrame{
    private JPanel Test_Page;
    private JList productList;
    private JTextField ProductAmountField;
    private JTextField ProductNameField;
    private JButton ApplyButton;
    private JLabel infoBox;


    public ProductListView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(Test_Page);
        setVisible(true);
        centerWindow(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JList test = getProductList();
    }

    public JList getProductList (){
        return productList;
    }
    public JLabel getInfoBox(){
        return infoBox;
    }


    public void SetProductsOnScreen(String [] products)
    {
        productList.setListData(products);
    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
