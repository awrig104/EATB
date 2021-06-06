package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Removemember_Form extends JFrame {

    private static JPanel removePanel;
    private static JFrame removeFrame;
    private static JLabel messagelabel, nameLabel, confirmLabel, outcomeLabel;
    private static JTextField nameText, confirmText;
    private static JButton removeButton, backButton;

    Removemember_Form() {
        removePanel = new JPanel();
        removeFrame = new JFrame("Add New Asset Page");
        removeFrame.setSize(400, 250);
        removeFrame.setLocationRelativeTo(null);
        removeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeFrame.add(removePanel);

        removePanel.setLayout(null);

        messagelabel = new JLabel("Enter the username of member to remove");
        messagelabel.setBounds(10,20,290,25);
        removePanel.add(messagelabel);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(10,50,120,25);
        removePanel.add(nameLabel);

        nameText = new JTextField(20);
        nameText.setBounds(120,50,150,25);
        removePanel.add(nameText);

        confirmLabel = new JLabel("Confirm Name");
        confirmLabel.setBounds(10,80,120,25);
        removePanel.add(confirmLabel);

        confirmText = new JTextField(20);
        confirmText.setBounds(120,80,150,25);
        removePanel.add(confirmText);

        removeButton = new JButton("Remove");
        removeButton.setBounds(75,110,200,25);
        removeButton.addActionListener(new ButtonListener());
        removePanel.add(removeButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,140,200,25);
        backButton.addActionListener(new ButtonListener());
        removePanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,170,300,25);
        removePanel.add(outcomeLabel);

        removeFrame.setVisible(true);
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == removeButton){
                String user = String.valueOf(nameText.getText()).trim();
                String verify = String.valueOf(confirmText.getText()).trim();
                if(user.equals("")){
                    outcomeLabel.setText("Enter the Username First");
                } else if(verify.equals("")){
                    outcomeLabel.setText("You Need To Enter the username again");
                } else if(user.equals(verify)){
                    try
                    {
                        Main.removeUser(user);
                    } catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    outcomeLabel.setText("You removed the user");
                } else{
                    outcomeLabel.setText("The username fields do not match");
                }
            }else if(e.getSource() == backButton){
                removeFrame.dispose();
                new Admin_Form();
            }
        }
    }
}
