package View;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import static View.ViewFactory.ViewUtils.*;

public class OrganizationView extends JFrame{
    private JPanel panel;
    private JList productList;
    private JLabel productNameText;
    private JLabel productAmountText;
    private JLabel productDateText;
    private JButton addProduct_button;
    private JButton refreshList_Button;
    private JList addedJList;
    private ListSelectionModel listSelectionModel;

    public OrganizationView() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(panel);
        setVisible(true);
        CenterWindow(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        listSelectionModel=productList.getSelectionModel();
    }

    public JList getProductList (){
        return productList;
    }

   public void UpdateProductsOnScreen(String [] products){

       productList.setListData(products);
   }

    public void SetProductsOnScreen(String [] products)
    {
        productList.setListData(products);
    }

    public void SetAddedList(String [] addedList){
        addedJList.setListData(addedList);
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
    public void AddButton_Listener(ActionListener mal){
        addProduct_button.addActionListener(mal);
    }
    public void AddRefresh_Listener(ActionListener mal){
        refreshList_Button.addActionListener(mal);
    }
}
