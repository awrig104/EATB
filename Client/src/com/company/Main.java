package com.company;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static String username;
    public static String organisation_id;
    public static String password;

    private static final int SERVER_PORT = 4999;
    private static final String SERVER_IP = "localhost";

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
        username = user;
        password = pass;
        out.flush();
        return str;
    }

    public static void addAsset(String asset_name) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("asset add true");
        out.writeObject(asset_name);
        out.flush();
    }

    public static void addUser(String password, String account_type, String org_id) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("add user true");
        out.writeObject(password);
        out.writeObject(account_type);
        out.writeObject(org_id);
        out.flush();
    }

    public static void listOrganisation() throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("list org true");
        out.flush();
    }

    public static void addOrganisation() throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("add org true");
        out.flush();
    }

    public static void removeUser(String username) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("remove user true");
        out.writeObject(username);
        out.flush();
    }

    public static void userMenu() throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("user menu true");
        out.flush();
    }

    public static void backButton() throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("back");
        out.flush();
    }

    public static void listBuyRequest(String assetName, String Quantity, String Price, String orgID) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("List buy request");
        out.writeObject(assetName);
        out.writeObject(Quantity);
        out.writeObject(Price);
        out.writeObject(orgID);
        out.flush();
    }

    public static void listSellRequest(String assetName, String Quantity, String Price, String orgID) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("List sell request");
        out.writeObject(assetName);
        out.writeObject(Quantity);
        out.writeObject(Price);
        out.writeObject(orgID);
        out.flush();
    }

    public static void changePassword (String newPass, String oldPass) throws Exception
    {
        Socket s = new Socket(SERVER_IP, SERVER_PORT);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("change password true");
        out.writeObject(newPass);
        out.writeObject(oldPass);
        out.flush();
    }

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
