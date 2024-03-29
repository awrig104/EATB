package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sellmenu_Form extends JFrame {
    private static JPanel sellPanel;
    private static JFrame sellFrame;
    private static JLabel titleLabel, namelabel, quantityLabel, priceLabel, outcomeLabel;
    private static JButton buyorderButton, uploadorderButton, backButton;
    private static JTextField nameText, quantityText, priceText;

    Sellmenu_Form() {
        sellPanel = new JPanel();
        sellFrame = new JFrame("Sell Menu Page");
        sellFrame.setSize(350, 300);
        sellFrame.setLocationRelativeTo(null);
        sellFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sellFrame.add(sellPanel);

        sellPanel.setLayout(null);

        titleLabel = new JLabel("Enter the details for what you are selling");
        titleLabel.setBounds(10,50,280,25);
        sellPanel.add(titleLabel);

        namelabel = new JLabel("Asset Name");
        namelabel.setBounds(10,80,80,25);
        sellPanel.add(namelabel);

        nameText = new JTextField(20);
        nameText.setBounds(100,80,150,25);
        sellPanel.add(nameText);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(10,110,80,25);
        sellPanel.add(quantityLabel);

        quantityText = new JTextField(20);
        quantityText.setBounds(100,110,150,25);
        sellPanel.add(quantityText);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(10,140,80,25);
        sellPanel.add(priceLabel);

        priceText = new JTextField(20);
        priceText.setBounds(100,140,150,25);
        sellPanel.add(priceText);

        buyorderButton = new JButton("List All Buy Orders");
        buyorderButton.setBounds(75,20,200,25);
        buyorderButton.addActionListener(new ButtonListener());
        sellPanel.add(buyorderButton);

        uploadorderButton = new JButton("Upload Order");
        uploadorderButton.setBounds(75,170,200,25);
        uploadorderButton.addActionListener(new ButtonListener());
        sellPanel.add(uploadorderButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,200,200,25);
        backButton.addActionListener(new ButtonListener());
        sellPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,230,300,25);
        sellPanel.add(outcomeLabel);

        sellFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buyorderButton){
                new Listbuyorder_Form();
            }else if(e.getSource() == uploadorderButton){
                String name  = nameText.getText().trim();
                String quantity = String.valueOf(quantityText.getText()).trim();
                String price = String.valueOf(priceText.getText()).trim();
                if(name.equals("")) {
                    outcomeLabel.setText("Enter an asset name first");
                }
                else if(quantity.equals("")) {
                    outcomeLabel.setText("Enter the Quantity");
                }
                else if(price.equals("")) {
                    outcomeLabel.setText("Enter the price");
                }
                else {
                    try {
                        Main.listSellRequest(name, quantity, price, Main.organisation_id);
                    } catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    outcomeLabel.setText("Thank you for putting up your asset"); //check if asset is owned
                }
            }else if(e.getSource() == backButton){
                sellFrame.dispose();
                new User_Form();
            }
        }
    }
}
