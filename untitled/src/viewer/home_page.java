package viewer;

import javax.swing.*;


public class home_page extends JFrame {
    private JLabel title;
    private JButton button_register;
    private JButton button_log;
    private JLabel welcome;
    private JLabel welcome1;
    private JPanel home_page;


    public home_page() {
        super("Donation-Program");
        setBounds(300,300,800,500);
        getContentPane().add(home_page);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public JButton getButton_register() {
        return button_register;
    }

        public JButton getButton_log() {
        return button_log;
    }



}
