package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orgedit_Form extends JFrame{
    private static JPanel orgeditPanel;
    private static JFrame orgeditFrame;
    private static JLabel creditmessagelabel, creditamountLabel, assetmessageLabel, assetnameLabel, assetamountLabel,  outcomeLabel;
    private static JTextField creditText, assetnameText, assetText;
    private static JButton assetsButton, memberButton, creditaddButton, credittakeButton, assetaddButton, assettakeButton, backButton;

    Orgedit_Form() {
        orgeditPanel = new JPanel();
        orgeditFrame = new JFrame("Organisation Edit Page");
        orgeditFrame.setSize(350, 450);
        orgeditFrame.setLocationRelativeTo(null);
        orgeditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orgeditFrame.add(orgeditPanel);

        orgeditPanel.setLayout(null);

        assetsButton = new JButton("Show all assets");
        assetsButton.setBounds(75,20,200,25);
        assetsButton.addActionListener(new ButtonListener());
        orgeditPanel.add(assetsButton);

        memberButton = new JButton("Show all members");
        memberButton.setBounds(75,50,200,25);
        memberButton.addActionListener(new ButtonListener());
        orgeditPanel.add(memberButton);

        creditmessagelabel = new JLabel("Add or Take organisation credits");
        creditmessagelabel.setBounds(10,80,290,25);
        orgeditPanel.add(creditmessagelabel);

        creditamountLabel = new JLabel("Amount");
        creditamountLabel.setBounds(10,110,290,25);
        orgeditPanel.add(creditamountLabel);

        creditText = new JTextField(20);
        creditText.setBounds(120,110,150,25);
        orgeditPanel.add(creditText);

        creditaddButton = new JButton("Add Credits");
        creditaddButton.setBounds(75,140,200,25);
        creditaddButton.addActionListener(new ButtonListener());
        orgeditPanel.add(creditaddButton);

        credittakeButton = new JButton("Take Credits");
        credittakeButton.setBounds(75,170,200,25);
        credittakeButton.addActionListener(new ButtonListener());
        orgeditPanel.add(credittakeButton);

        assetmessageLabel = new JLabel("Add or Take organisation asset quantity");
        assetmessageLabel.setBounds(10,200,290,25);
        orgeditPanel.add(assetmessageLabel);

        assetnameLabel = new JLabel("Asset Name");
        assetnameLabel.setBounds(10,230,290,25);
        orgeditPanel.add(assetnameLabel);

        assetnameText = new JTextField(20);
        assetnameText.setBounds(120,230,150,25);
        orgeditPanel.add(assetnameText);

        assetamountLabel = new JLabel("Amount");
        assetamountLabel.setBounds(10,260,290,25);
        orgeditPanel.add(assetamountLabel);

        assetText = new JTextField(20);
        assetText.setBounds(120,260,150,25);
        orgeditPanel.add(assetText);

        assetaddButton = new JButton("Add Asset");
        assetaddButton.setBounds(75,290,200,25);
        assetaddButton.addActionListener(new ButtonListener());
        orgeditPanel.add(assetaddButton);

        assettakeButton = new JButton("Take Asset");
        assettakeButton.setBounds(75,320,200,25);
        assettakeButton.addActionListener(new ButtonListener());
        orgeditPanel.add(assettakeButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,350,200,25);
        backButton.addActionListener(new ButtonListener());
        orgeditPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,380,300,25);
        orgeditPanel.add(outcomeLabel);

        orgeditFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == assetsButton){
                new Showorgasset_Form();
            }else if(e.getSource() == memberButton){
                new Showorgmember_Form();
            }else if(e.getSource() == creditaddButton){

            }else if(e.getSource() == credittakeButton){

            }else if(e.getSource() == assetaddButton){

            }else if(e.getSource() == assettakeButton){

            }else if(e.getSource() == backButton){
                orgeditFrame.dispose();
                new Admin_Form();
            }
        }
    }
}