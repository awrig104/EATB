package com.company;

import javax.swing.*;

public class Showorgasset_Form {

    private static JPanel orgassetPanel;
    private static JFrame orgassetFrame;
    private static JLabel titlelabel, listLabel;

    Showorgasset_Form() {
        orgassetPanel = new JPanel();
        orgassetFrame = new JFrame("Organisation Assets Page");
        orgassetFrame.setSize(350, 450);
        orgassetFrame.setLocationRelativeTo(null);
        orgassetFrame.add(orgassetPanel);

        orgassetPanel.setLayout(null);

        titlelabel = new JLabel("List of all of the assets your org has");
        titlelabel.setBounds(10,20,290,25);
        orgassetPanel.add(titlelabel);

        listLabel = new JLabel(" ");
        listLabel.setBounds(10,50,290,25);
        orgassetPanel.add(listLabel);

        orgassetFrame.setVisible(true);
    }
}
