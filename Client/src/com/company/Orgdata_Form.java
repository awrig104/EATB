package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orgdata_Form extends JFrame{
    private static JPanel orgdataPanel;
    private static JFrame orgdataFrame;
    private static JLabel messagelabel, orgLabel, addmessageLabel, orgaddLabel, outcomeLabel;
    private static JTextField orgText, orgaddText;
    private static JButton searchButton, orgaddButton, backButton;

    Orgdata_Form() {
        orgdataPanel = new JPanel();
        orgdataFrame = new JFrame("Organisation Data Page");
        orgdataFrame.setSize(350, 300);
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

        addmessageLabel = new JLabel("Enter the name of the org you wish to add");
        addmessageLabel.setBounds(10,110,290,25);
        orgdataPanel.add(addmessageLabel);

        orgaddLabel = new JLabel("Organisation");
        orgaddLabel.setBounds(10,140,290,25);
        orgdataPanel.add(orgaddLabel);

        orgaddText = new JTextField(20);
        orgaddText.setBounds(120,140,150,25);
        orgdataPanel.add(orgaddText);

        orgaddButton = new JButton("Add Org");
        orgaddButton.setBounds(75,170,200,25);
        orgaddButton.addActionListener(new ButtonListener());
        orgdataPanel.add(orgaddButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,200,200,25);
        backButton.addActionListener(new ButtonListener());
        orgdataPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,230,300,25);
        orgdataPanel.add(outcomeLabel);

        orgdataFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == searchButton){
                String name  = orgText.getText().trim();
                if(name.equals("")) {
                    outcomeLabel.setText("Enter an organisation name first");
                }else{
                    try
                    {
                        Main.listOrganisation();
                    } catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    orgdataFrame.dispose();
                    new Orgedit_Form();
                }
            }else if(e.getSource() == orgaddButton){
                String name  = orgaddText.getText().trim();
                try {

                    Main.addOrganisation();
                } catch (Exception exception) {

                    exception.printStackTrace();
                }
                outcomeLabel.setText("You have added an organisation");

            }else if(e.getSource() == backButton){
                orgdataFrame.dispose();
                new Admin_Form();
            }
        }
    }
}
