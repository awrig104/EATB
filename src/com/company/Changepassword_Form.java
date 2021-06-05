package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changepassword_Form extends JFrame {

    private static JPanel changePanel;
    private static JFrame changeFrame;
    private static JLabel titleLabel, currentLabel, passlabel, verifylabel, outcomeLabel;
    private static JPasswordField currentText, passText, verifyText;
    private static JButton changeButton, backButton;

    Changepassword_Form() {
        changePanel = new JPanel();
        changeFrame = new JFrame("Login Page");
        changeFrame.setSize(400, 300);
        changeFrame.setLocationRelativeTo(null);
        changeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeFrame.add(changePanel);

        changePanel.setLayout(null);

        titleLabel = new JLabel("Enter your current password followed by your new password");
        titleLabel.setBounds(10,20,380,25);
        changePanel.add(titleLabel);

        currentLabel = new JLabel("Current Password");
        currentLabel.setBounds(10,50,120,25);
        changePanel.add(currentLabel);

        currentText = new JPasswordField(20);
        currentText.setBounds(150,50,150,25);
        changePanel.add(currentText);

        passlabel = new JLabel("New Password");
        passlabel.setBounds(10,80,120,25);
        changePanel.add(passlabel);

        passText = new JPasswordField(20);
        passText.setBounds(150,80,150,25);
        changePanel.add(passText);

        verifylabel = new JLabel("Verify Password");
        verifylabel.setBounds(10,110,120,25);
        changePanel.add(verifylabel);

        verifyText = new JPasswordField(20);
        verifyText.setBounds(150,110,150,25);
        changePanel.add(verifyText);

        changeButton = new JButton("Change Password");
        changeButton.setBounds(100,140,200,25);
        changeButton.addActionListener(new ButtonListener());
        changePanel.add(changeButton);

        backButton = new JButton("Back");
        backButton.setBounds(100,170,200,25);
        backButton.addActionListener(new ButtonListener());
        changePanel.add(backButton);

        outcomeLabel = new JLabel(" ");
        outcomeLabel. setBounds(10,200,380,25);
        changePanel.add(outcomeLabel);

        changeFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == changeButton){

            }else if(e.getSource() == backButton){
                
            }
        }
    }
}
