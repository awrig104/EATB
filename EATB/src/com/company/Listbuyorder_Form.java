package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listbuyorder_Form extends JFrame {
    private static JPanel buyPanel;
    private static JFrame buyFrame;
    private static JLabel titleLabel, listlabel, instructionLabel, searchlabel, outcomeLabel;
    private static JTextField searchText;
    private static JButton searchButton, backButton;

    Listbuyorder_Form() {
        buyPanel = new JPanel();
        buyFrame = new JFrame("list all Buy Orders Page");
        buyFrame.setSize(400, 500);
        buyFrame.setLocationRelativeTo(null);
        buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buyFrame.add(buyPanel);

        buyPanel.setLayout(null);

        instructionLabel = new JLabel("Type in the name of the asset you wish to see the buy history off");
        instructionLabel.setBounds(10,20,380,25);
        buyPanel.add(instructionLabel);

        searchlabel = new JLabel("Asset Name");
        searchlabel.setBounds(10,50,280,25);
        buyPanel.add(searchlabel);

        searchText = new JTextField(20);
        searchText.setBounds(120,50,150,25);
        buyPanel.add(searchText);

        searchButton = new JButton("Search");
        searchButton.setBounds(75,80,200,25);
        searchButton.addActionListener(new ButtonListener());
        buyPanel.add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,110,200,25);
        backButton.addActionListener(new ButtonListener());
        buyPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,140,300,25);
        buyPanel.add(outcomeLabel);

        titleLabel = new JLabel("All Current Buy Orders");
        titleLabel.setBounds(10,170,280,25);
        buyPanel.add(titleLabel);

        listlabel = new JLabel(" ");
        listlabel.setBounds(10,200,280,25);
        buyPanel.add(listlabel);

        buyFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == searchButton){
                new Buyhistory_Form();
            }else if(e.getSource() == backButton){
                buyFrame.dispose();
                new Sellmenu_Form();
            }
        }
    }
}
