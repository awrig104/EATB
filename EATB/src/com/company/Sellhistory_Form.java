package com.company;

import javax.swing.*;

public class Sellhistory_Form {

    private static JPanel sellhistoryPanel;
    private static JFrame sellhistoryFrame;
    private static JLabel titlelabel, listLabel;

    Sellhistory_Form() {
        sellhistoryPanel = new JPanel();
        sellhistoryFrame = new JFrame("Sell History Page");
        sellhistoryFrame.setSize(350, 450);
        sellhistoryFrame.setLocationRelativeTo(null);
        sellhistoryFrame.add(sellhistoryPanel);

        sellhistoryPanel.setLayout(null);

        titlelabel = new JLabel("The sell history of the chosen asset");
        titlelabel.setBounds(10,20,290,25);
        sellhistoryPanel.add(titlelabel);

        listLabel = new JLabel(" ");
        listLabel.setBounds(10,50,290,25);
        sellhistoryPanel.add(listLabel);

        sellhistoryFrame.setVisible(true);
    }
}