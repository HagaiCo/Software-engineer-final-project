package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import static View.ViewFactory.ViewUtils.*;
public class HomePageView extends JFrame {
    private JLabel title;
    private JButton button_register;
    private JButton button_log;
    private JLabel welcome;
    private JLabel welcome1;
    private JPanel home_page;
    private String openPage;


    public HomePageView() {
        super("Donation-Program");
        setBounds(300, 300, 800, 500);
        CenterWindow(this);
        getContentPane().add(home_page);
        //setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void showHomePageView() {
        this.setVisible(true);
    }



    public void addButton_registerListener(ActionListener mal) {
        button_register.addActionListener(mal);
    }

    public void addButton_loginListener(ActionListener mal) {
        button_log.addActionListener(mal);
    }
}






