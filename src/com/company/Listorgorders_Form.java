package com.company;

import javax.swing.*;

public class Listorgorders_Form extends JFrame {
    private static JPanel ordersPanel;
    private static JFrame ordersFrame;
    private static JLabel titleLabel, listlabel;

    Listorgorders_Form() {
        ordersPanel = new JPanel();
        ordersFrame = new JFrame("list all Current Organisation Orders Page");
        ordersFrame.setSize(350, 300);
        ordersFrame.setLocationRelativeTo(null);
        ordersFrame.add(ordersPanel);

        ordersPanel.setLayout(null);

        titleLabel = new JLabel("All Current Orders");
        titleLabel.setBounds(10,20,280,25);
        ordersPanel.add(titleLabel);

        listlabel = new JLabel(" ");
        listlabel.setBounds(10,50,280,25);
        ordersPanel.add(listlabel);

        ordersFrame.setVisible(true);
    }
}