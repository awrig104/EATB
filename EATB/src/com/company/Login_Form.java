package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Form extends JFrame implements ActionListener {

    private static JPanel loginPanel;
    private static JFrame loginFrame;
    private static JLabel userlabel, passlabel, outcomeLabel;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JButton loginButton;

    Login_Form() {
        loginPanel = new JPanel();
        loginFrame = new JFrame("Login Page");
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);

        loginPanel.setLayout(null);

        userlabel = new JLabel("Username");
        userlabel.setBounds(10,20,80,25);
        loginPanel.add(userlabel);

        userText = new JTextField(20);
        userText.setBounds(100,20,150,25);
        loginPanel.add(userText);

        passlabel = new JLabel("Password");
        passlabel.setBounds(10,50,80,25);
        loginPanel.add(passlabel);

        passText = new JPasswordField(20);
        passText.setBounds(100,50,150,25);
        loginPanel.add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(100,80,80,25);
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        outcomeLabel = new JLabel("Click login to continue");
        outcomeLabel. setBounds(10,110,300,25);
        loginPanel.add(outcomeLabel);

        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username  = userText.getText().trim();
        String password = String.valueOf(passText.getPassword()).trim();
        if(username.equals("")){
            outcomeLabel.setText("Enter Your Username First");
        } else if(password.equals("")){
            outcomeLabel.setText("You Need To Enter Your Password");
        } else if(username.equals("admin") && password.equals("pass123")){
            loginFrame.dispose();
            new Admin_Form();
        } else{
            outcomeLabel.setText("Incorrect Username or Password");
        }
    }
}
