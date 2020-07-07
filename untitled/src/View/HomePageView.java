package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


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
        centreWindow(this);
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

    public static void centreWindow(Window frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}






