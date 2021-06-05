package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listsellorder_Form extends JFrame {
    private static JPanel sellPanel;
    private static JFrame sellFrame;
    private static JLabel titleLabel, listlabel, instructionLabel, searchlabel, outcomeLabel;
    private static JTextField searchText;
    private static JButton searchButton, backButton;

    Listsellorder_Form() {
        sellPanel = new JPanel();
        sellFrame = new JFrame("list all Sell Orders Page");
        sellFrame.setSize(400, 500);
        sellFrame.setLocationRelativeTo(null);
        sellFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sellFrame.add(sellPanel);

        sellPanel.setLayout(null);

        instructionLabel = new JLabel("Type in the name of the asset you wish to see the sell history off");
        instructionLabel.setBounds(10,20,380,25);
        sellPanel.add(instructionLabel);

        searchlabel = new JLabel("Asset Name");
        searchlabel.setBounds(10,50,280,25);
        sellPanel.add(searchlabel);

        searchText = new JTextField(20);
        searchText.setBounds(120,50,150,25);
        sellPanel.add(searchText);

        searchButton = new JButton("Search");
        searchButton.setBounds(75,80,200,25);
        searchButton.addActionListener(new ButtonListener());
        sellPanel.add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,110,200,25);
        backButton.addActionListener(new ButtonListener());
        sellPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,140,300,25);
        sellPanel.add(outcomeLabel);

        titleLabel = new JLabel("All Current Sell Orders");
        titleLabel.setBounds(10,170,280,25);
        sellPanel.add(titleLabel);

        listlabel = new JLabel(" ");
        listlabel.setBounds(10,200,280,25);
        sellPanel.add(listlabel);

        sellFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == searchButton){
                
            }else if(e.getSource() == backButton){
                sellFrame.dispose();
                new Buymenu_Form();
            }
        }
    }
}
