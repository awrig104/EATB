package com.company;

import javax.swing.*;

public class Showorgmember_Form {

    private static JPanel orgmemberPanel;
    private static JFrame orgmemberFrame;
    private static JLabel titlelabel, listLabel;

    Showorgmember_Form() {
        orgmemberPanel = new JPanel();
        orgmemberFrame = new JFrame("Organisation Assets Page");
        orgmemberFrame.setSize(350, 450);
        orgmemberFrame.setLocationRelativeTo(null);
        orgmemberFrame.add(orgmemberPanel);

        orgmemberPanel.setLayout(null);

        titlelabel = new JLabel("List of all of the assets your org has");
        titlelabel.setBounds(10,20,290,25);
        orgmemberPanel.add(titlelabel);

        listLabel = new JLabel(" ");
        listLabel.setBounds(10,50,290,25);
        orgmemberPanel.add(listLabel);

        orgmemberFrame.setVisible(true);
    }
}