package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addasset_Form extends JFrame {

    private static JPanel addassetPanel;
    private static JFrame addmemberFrame;
    private static JLabel messagelabel, nameLabel, outcomeLabel;
    private static JTextField assetText;
    private static JButton addassetButton, backButton;

    Addasset_Form() {
        addassetPanel = new JPanel();
        addmemberFrame = new JFrame("Add New Asset Page");
        addmemberFrame.setSize(400, 200);
        addmemberFrame.setLocationRelativeTo(null);
        addmemberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addmemberFrame.add(addassetPanel);

        addassetPanel.setLayout(null);

        messagelabel = new JLabel("Enter the name of the new asset you wish to add");
        messagelabel.setBounds(10,20,290,25);
        addassetPanel.add(messagelabel);

        nameLabel = new JLabel("Asset Name");
        nameLabel.setBounds(10,50,120,25);
        addassetPanel.add(nameLabel);

        assetText = new JTextField(20);
        assetText.setBounds(120,50,150,25);
        addassetPanel.add(assetText);

        addassetButton = new JButton("Add New Asset");
        addassetButton.setBounds(75,80,200,25);
        addassetButton.addActionListener(new ButtonListener());
        addassetPanel.add(addassetButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,110,200,25);
        backButton.addActionListener(new ButtonListener());
        addassetPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,140,300,25);
        addassetPanel.add(outcomeLabel);

        addmemberFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String addAsset = assetText.getText().trim();

            if(e.getSource() == addassetButton){
                try
                {
                    Main.addAsset(addAsset);
                    outcomeLabel.setText("You added a new asset: " + addAsset);
                } catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }else if(e.getSource() == backButton){
                addmemberFrame.dispose();
                new Admin_Form();
            }
        }
    }
}
