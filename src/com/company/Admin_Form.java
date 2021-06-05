package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Form extends JFrame {
    private static JPanel adminPanel;
    private static JFrame adminFrame;
    private static JLabel messagelabel;
    private static JButton usermenuButton, addmemberButton, addassetButton, listorgButton, removeuserButton;

    Admin_Form() {
        adminPanel = new JPanel();
        adminFrame = new JFrame("Admin Page");
        adminFrame.setSize(350, 250);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.add(adminPanel);

        adminPanel.setLayout(null);

        messagelabel = new JLabel("Click on User Menu if you are not an admin");
        messagelabel.setBounds(10,20,290,25);
        adminPanel.add(messagelabel);

        usermenuButton = new JButton("User Menu");
        usermenuButton.setBounds(75,50,200,25);
        usermenuButton.addActionListener(new ButtonListener());
        adminPanel.add(usermenuButton);

        addmemberButton = new JButton("Add Member");
        addmemberButton.setBounds(75,80,200,25);
        addmemberButton.addActionListener(new ButtonListener());
        adminPanel.add(addmemberButton);

        addassetButton = new JButton("Add Asset");
        addassetButton.setBounds(75,110,200,25);
        addassetButton.addActionListener(new ButtonListener());
        adminPanel.add(addassetButton);

        listorgButton = new JButton("Search Organisations Data");
        listorgButton.setBounds(75,140,200,25);
        listorgButton.addActionListener(new ButtonListener());
        adminPanel.add(listorgButton);

        removeuserButton = new JButton("Remove User");
        removeuserButton.setBounds(75,170,200,25);
        removeuserButton.addActionListener(new ButtonListener());
        adminPanel.add(removeuserButton);

        adminFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == usermenuButton){

            }else if(e.getSource() == addmemberButton){

            }else if(e.getSource() == addassetButton){

            }else if(e.getSource() == listorgButton){

            }else if(e.getSource() == removeuserButton){
                
            }
        }
    }
}
