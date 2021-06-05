package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orgdata_Form extends JFrame{
    private static JPanel orgdataPanel;
    private static JFrame orgdataFrame;
    private static JLabel messagelabel, orgLabel, outcomeLabel;
    private static JTextField orgText;
    private static JButton searchButton, backButton;

    Orgdata_Form() {
        orgdataPanel = new JPanel();
        orgdataFrame = new JFrame("Organisation Data Page");
        orgdataFrame.setSize(350, 250);
        orgdataFrame.setLocationRelativeTo(null);
        orgdataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orgdataFrame.add(orgdataPanel);

        orgdataPanel.setLayout(null);

        messagelabel = new JLabel("Enter the name of the org you wish to inspect");
        messagelabel.setBounds(10,20,290,25);
        orgdataPanel.add(messagelabel);

        orgLabel = new JLabel("Organisation");
        orgLabel.setBounds(10,50,290,25);
        orgdataPanel.add(orgLabel);

        orgText = new JTextField(20);
        orgText.setBounds(120,50,150,25);
        orgdataPanel.add(orgText);

        searchButton = new JButton("Search");
        searchButton.setBounds(75,80,200,25);
        searchButton.addActionListener(new ButtonListener());
        orgdataPanel.add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,110,200,25);
        backButton.addActionListener(new ButtonListener());
        orgdataPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,140,300,25);
        orgdataPanel.add(outcomeLabel);

        orgdataFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == searchButton){

            }else if(e.getSource() == backButton){

            }
        }
    }
}