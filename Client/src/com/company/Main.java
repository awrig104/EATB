package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static String username;
    public static int organisation_id;
    public static String password;
    public static int credits;

    private static final int SERVER_PORT = 4999;
    private static final String SERVER_IP = "localhost";



    public static Socket getSocket() throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        return s;
    }

    public static String loginDetails(String user, String pass) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        String str;

        out.writeObject(user);
        out.writeObject(pass);
        out.writeObject("login false");
        out.flush();
        str  = (String)in.readObject();
        s.close();
        username = user;
        password = pass;
        return str;
    }

    /*
    public static String addAsset(String asset_name) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        String str;
    }

     */


    public static LocalDateTime CurrentDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return now;
    }

    public static void main(String args[])
    {
            new Login_Form();
    }
}
