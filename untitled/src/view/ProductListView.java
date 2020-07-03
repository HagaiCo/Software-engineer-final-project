package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductListView extends JFrame{
    private JPanel Test_Page;
    private JList productList;
    private JLabel productNameText;
    private JLabel productAmountText;
    private JLabel productDateText;
    private JButton add_button;

    private ListSelectionModel listSelectionModel;


    public ProductListView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(Test_Page);
        setVisible(true);
        centerWindow(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        listSelectionModel=productList.getSelectionModel();

    }

    public JList getProductList (){
        return productList;
    }

   public void UpdateProductsOnScreen(String [] products){

       for(String product: products)
       {
        System.out.println(product);
       }
       productList.setListData(products);
   }

    public void SetProductsOnScreen(String [] products)
    {
        productList.setListData(products);
    }

    public void addProduct_listListener(ListSelectionListener lis) {
        listSelectionModel.addListSelectionListener(lis);
    }

    public String getSelectedValue(){
        String value = (String) productList.getSelectedValue();
       return value;
    }

    public void SetProductNameText(String text){
        productNameText.setText(text);
    }
    public void SetProductAmountText(String text){
        productAmountText.setText(text);
    }
    public void SetProductDateText(String text){
        productDateText.setText(text);
    }

    public void addAddButton_Listener(ActionListener mal){
        add_button.addActionListener(mal);
    }


    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


}
