package com.company;

import javax.swing.*;

public class Buyhistory_Form {

    private static JPanel buyhistoryPanel;
    private static JFrame buyhistoryFrame;
    private static JLabel titlelabel, listLabel;

    Buyhistory_Form() {
        buyhistoryPanel = new JPanel();
        buyhistoryFrame = new JFrame("Buy History Page");
        buyhistoryFrame.setSize(350, 450);
        buyhistoryFrame.setLocationRelativeTo(null);
        buyhistoryFrame.add(buyhistoryPanel);

        buyhistoryPanel.setLayout(null);

        titlelabel = new JLabel("The buy history of the chosen asset");
        titlelabel.setBounds(10,20,290,25);
        buyhistoryPanel.add(titlelabel);

        listLabel = new JLabel(" ");
        listLabel.setBounds(10,50,290,25);
        buyhistoryPanel.add(listLabel);

        buyhistoryFrame.setVisible(true);
    }
}