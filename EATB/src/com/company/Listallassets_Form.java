package com.company;

import javax.swing.*;

public class Listallassets_Form extends JFrame {
    private static JPanel assetPanel;
    private static JFrame assetFrame;
    private static JLabel titleLabel, listlabel;

    Listallassets_Form() {
        assetPanel = new JPanel();
        assetFrame = new JFrame("list all Organisation Assets Page");
        assetFrame.setSize(350, 300);
        assetFrame.setLocationRelativeTo(null);
        assetFrame.add(assetPanel);

        assetPanel.setLayout(null);

        titleLabel = new JLabel("All Current Assets");
        titleLabel.setBounds(10,20,280,25);
        assetPanel.add(titleLabel);

        listlabel = new JLabel(" ");
        listlabel.setBounds(10,50,280,25);
        assetPanel.add(listlabel);

        assetFrame.setVisible(true);
    }
}