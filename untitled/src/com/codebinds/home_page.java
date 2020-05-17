package com.codebinds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_page {
    private JLabel title;

    public home_page() {
        button_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JButton getButton_register() {
        return button_register;
    }

    public JButton getButton_log() {
        return button_log;
    }

    private JButton button_register;
    private JButton button_log;
    private JLabel welcome;
    private JLabel welcome1;

    private void createUIComponents() {

    }
}
