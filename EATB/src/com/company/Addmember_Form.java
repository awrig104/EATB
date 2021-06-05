package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addmember_Form extends JFrame {
    private static JPanel addmemberPanel;
    private static JFrame addmemberFrame;
    private static JLabel messagelabel, passwordLabel, verifyLabel, accdescriptionLabel, accLabel, orgLabel, outcomeLabel;
    private static JTextField passwordText, verifyText, accText, orgText;
    private static JButton addmemberButton, backButton;

    Addmember_Form() {
        addmemberPanel = new JPanel();
        addmemberFrame = new JFrame("Add New Member Page");
        addmemberFrame.setSize(400, 350);
        addmemberFrame.setLocationRelativeTo(null);
        addmemberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addmemberFrame.add(addmemberPanel);

        addmemberPanel.setLayout(null);

        messagelabel = new JLabel("Fill out the data points to add a new member");
        messagelabel.setBounds(10,20,290,25);
        addmemberPanel.add(messagelabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,290,25);
        addmemberPanel.add(passwordLabel);

        passwordText = new JTextField(20);
        passwordText.setBounds(120,50,150,25);
        addmemberPanel.add(passwordText);

        verifyLabel = new JLabel("Verify Password");
        verifyLabel.setBounds(10,80,290,25);
        addmemberPanel.add(verifyLabel);

        verifyText = new JTextField(20);
        verifyText.setBounds(120,80,150,25);
        addmemberPanel.add(verifyText);

        accdescriptionLabel = new JLabel("If the user is an admin type 1 else type 0 for account type");
        accdescriptionLabel.setBounds(10,110,390,25);
        addmemberPanel.add(accdescriptionLabel);

        accLabel = new JLabel("Account type");
        accLabel.setBounds(10,140,290,25);
        addmemberPanel.add(accLabel);

        accText = new JTextField(20);
        accText.setBounds(120,140,150,25);
        addmemberPanel.add(accText);

        orgLabel = new JLabel("Organisation");
        orgLabel.setBounds(10,170,290,25);
        addmemberPanel.add(orgLabel);

        orgText = new JTextField(20);
        orgText.setBounds(120,170,150,25);
        addmemberPanel.add(orgText);

        addmemberButton = new JButton("Add New Member");
        addmemberButton.setBounds(75,200,200,25);
        addmemberButton.addActionListener(new ButtonListener());
        addmemberPanel.add(addmemberButton);

        backButton = new JButton("Back");
        backButton.setBounds(75,230,200,25);
        backButton.addActionListener(new ButtonListener());
        addmemberPanel.add(backButton);

        outcomeLabel = new JLabel("");
        outcomeLabel. setBounds(10,260,300,25);
        addmemberPanel.add(outcomeLabel);

        addmemberFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == addmemberButton){
                String password = String.valueOf(passwordText.getText()).trim();
                String verify = String.valueOf(verifyText.getText()).trim();
                String type = String.valueOf(accText.getText()).trim();
                String name  = orgText.getText().trim();
                if(password.equals("")){
                    outcomeLabel.setText("Enter The Password First");
                } else if(verify.equals("")){
                    outcomeLabel.setText("Enter your password again to verify");
                } else if(type.equals("")){
                    outcomeLabel.setText("Enter the account type");
                } else if(name.equals("")){
                    outcomeLabel.setText("Enter the name of the organisation"); //check if org exists
                } else if(verify.equals(password)){
                    outcomeLabel.setText("You added a new member");
                } else{
                    outcomeLabel.setText("Passwords do not match");
                }
            }else if(e.getSource() == backButton){
                addmemberFrame.dispose();
                new Admin_Form();
            }
        }
    }
}
