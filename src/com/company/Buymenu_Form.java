package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buymenu_Form extends JFrame {

    private static JPanel buyPanel;
    private static JFrame buyFrame;
    private static JLabel titleLabel, namelabel, quantityLabel, priceLabel, outcomeLabel;
    private static JButton sellorderButton, placeorderButton, backButton;
    private static JTextField nameText, quantityText, priceText;

    Buymenu_Form() {
        buyPanel = new JPanel();
        buyFrame = new JFrame("Buy Menu Page");
        buyFrame.setSize(350, 300);
        buyFrame.setLocationRelativeTo(null);
        buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buyFrame.add(buyPanel);

        buyPanel.setLayout(null);

        titleLabel = new JLabel("Enter the details for your Buy Request");
        titleLabel.setBounds(10,50,280,25);
        buyPanel.add(titleLabel);

        namelabel = new JLabel("Asset Name");
        namelabel.setBounds(10,80,80,25);
        buyPanel.add(namelabel);

        nameText = new JTextField(20);
        nameText.setBounds(100,80,150,25);
        buyPanel.add(nameText);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(10,110,80,25);
        buyPanel.add(quantityLabel);

        quantityText = new JTextField(20);
        quantityText.setBounds(100,110,150,25);
        buyPanel.add(quantityText);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(10,140,80,25);
        buyPanel.add(priceLabel);

        priceText = new JTextField(20);
        priceText.setBounds(100,140,150,25);
        buyPanel.add(priceText);

        sellorderButton = new JButton("List All Sell Orders");
        sellorderButton.setBounds(75,20,200,25);
        sellorderButton.addActionListener(new ButtonListener());
        buyPanel.add(sellorderButton);

        placeorderButton = new JButton("Place Order");
        placeorderButton.setBounds(75,170,200,25);
        placeorderButton.addActionListener(new ButtonListener());
        buyPanel.add(placeorderButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,200,200,25);
        backButton.addActionListener(new ButtonListener());
        buyPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,230,300,25);
        buyPanel.add(outcomeLabel);

        buyFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == sellorderButton){

            }else if(e.getSource() == placeorderButton){

            }else if(e.getSource() == backButton){
                buyFrame.dispose();
                new User_Form();
            }
        }
    }
}