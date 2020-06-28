package view;

import javax.swing.*;

public class Test_Page extends JFrame{
    private JPanel Test_Page;
    private JList UserList;
    private JLabel infoBox;


    public Test_Page() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(Test_Page);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JList getUserList (){
        return UserList;
    }

    public JLabel getInfoBox(){
        return infoBox;
    }


}
