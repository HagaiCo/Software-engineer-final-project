package viewer;

import javax.swing.*;

public class Table extends JFrame{
    private JPanel Table;
    JTable table;


    public void Table() {
        setTitle("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(Table);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JTable getTable() {
        return table;
    }
}
