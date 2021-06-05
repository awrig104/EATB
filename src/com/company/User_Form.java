package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Form extends JFrame {

    private static JPanel userPanel;
    private static JFrame userFrame;
    private static JLabel creditslabel, creditsvalueLabel;
    private static JButton buyButton, sellButton, listassetButton, listorgorderButton, changepassButton, backButton;


    User_Form() {
        userPanel = new JPanel();
        userFrame = new JFrame("User Page");
        userFrame.setSize(350, 300);
        userFrame.setLocationRelativeTo(null);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.add(userPanel);

        userPanel.setLayout(null);

        creditslabel = new JLabel("Credits:");
        creditslabel.setBounds(10,20,80,25);
        userPanel.add(creditslabel);

        creditsvalueLabel = new JLabel("0");
        creditsvalueLabel.setBounds(60,20,80,25);
        userPanel.add(creditsvalueLabel);

        buyButton = new JButton("Buy Menu");
        buyButton.setBounds(75,50,200,25);
        buyButton.addActionListener(new ButtonListener());
        userPanel.add(buyButton);

        sellButton = new JButton("Sell Menu");
        sellButton.setBounds(75,80,200,25);
        sellButton.addActionListener(new ButtonListener());
        userPanel.add(sellButton);

        listassetButton = new JButton("List All Assets");
        listassetButton.setBounds(75,110,200,25);
        listassetButton.addActionListener(new ButtonListener());
        userPanel.add(listassetButton);

        listorgorderButton = new JButton("List All Org Orders");
        listorgorderButton.setBounds(75,140,200,25);
        listorgorderButton.addActionListener(new ButtonListener());
        userPanel.add(listorgorderButton);

        changepassButton = new JButton("Change Password");
        changepassButton.setBounds(75,170,200,25);
        changepassButton.addActionListener(new ButtonListener());
        userPanel.add(changepassButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,200,200,25);
        backButton.addActionListener(new ButtonListener());
        userPanel.add(backButton);

        userFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buyButton){

            }else if(e.getSource() == sellButton){

            }else if(e.getSource() == listassetButton){

            }else if(e.getSource() == listorgorderButton){

            }else if(e.getSource() == changepassButton){

            }else if(e.getSource() == backButton){
               
            }
        }
    }


}
