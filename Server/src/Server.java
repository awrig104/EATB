import java.net.*;
import java.io.*;
import java.nio.channels.SocketChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.net.*;
import java.io.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

// root password for mariadb is "root"
// tcp port 3306

public class Server
{
    private static int SERVER_PORT = 4999;
    private static int DATABASE_PORT = 3306;
    private static String SERVER_IP = "localhost";
    public static String DATABASE_NAME = "eatp";
    public static String DATABASE_USERNAME = "root";
    public static String DATABASE_PASSWORD = "root";
    private static int nThreads = 1;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(nThreads);
    private static final String ADMIN_PERMISSIONS = "1";
    private static final String USER_PERMISSIONS = "0";

    //get database connection established
    public static Connection getConnection() throws Exception
    {
        try {
            String url = "jdbc:mariadb://" + SERVER_IP + ":" + DATABASE_PORT + "/" + DATABASE_NAME;
            String user = DATABASE_USERNAME;
            String password = DATABASE_PASSWORD;
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    // input a query here for any insert queries to work
    public static void insertQuery(String query) throws Exception
    {
        try
        {
            // gets database connection
            Connection connection = getConnection();
            // prepares query input
            PreparedStatement post = connection.prepareStatement(query);
            // executes query and inserts query into database
            post.executeUpdate();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // SQL statement for adding an asset
    public static String insertAsset(String asset_names)
    {
        String query = "INSERT INTO asset_types (asset_names) VALUES ('" + asset_names + "');";
        return query;
    }

    public static String insertOrganisation()
    {
        String query = "INSERT INTO organisational_unit_information (credits) VALUES (" + 0 + ");";
        return query;
    }

    public static String insertMember(String password, String account_type, String org_ID)
    {
        String query = "INSERT INTO user_information (password, account_type, organisation_id) VALUES ('" + password + "','" + account_type + "','" + org_ID + "');";
        return query;
    }

    public static String deleteUser(String user)
    {
        String query = "DELETE FROM user_information where username = '" + user + "';";
        return query;
    }

    public static String updatePassword(String newPass, String oldPass)
    {
        String query = "UPDATE user_information SET password = '" + newPass + "' WHERE password = '" + oldPass + "';";
        return query;
    }

    public static String insertBuyRequest(String assetName, String quantity, String price, String org_id)
    {
        String query = "INSERT INTO current_trades (buy_sell, asset_id, quantity, price, organisation_id) VALUES ('buy', '" + assetName + "','" + quantity + "','" + price + "', '" + org_id + "');";
        return query;
    }

    public static String insertSellRequest(String assetName, String quantity, String price, String org_id)
    {
        String query = "INSERT INTO current_trades (buy_sell, asset_id, quantity, price, organisation_id) VALUES ('sell', '" + assetName + "','" + quantity + "','" + price + "', '" + org_id + "');";
        return query;
    }



    // compares user input for username to usernames in database
    // if username exists in database, returns username for use in following method
    // if no username exists in database, returns "false"
    public static String loginCompareUsername(String user)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT username FROM user_information ORDER BY username ASC;");
            ResultSet result = select.executeQuery();

            ArrayList<String> arr = new ArrayList<String>();

            while (result.next())
            {
                arr.add(result.getString("username"));
                if (result.getString("username").equals(user))
                {
                    return user;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "false";
    }

    // compares password input with passwords in database
    // if a password does exists with a matched username input, method returns "true"
    // if not, returns "false"
    public static String loginComparePassword(String user,String password)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT password FROM user_information WHERE " + user + " = username ORDER BY username ASC;");
            ResultSet result = select.executeQuery();

            ArrayList<String> arr = new ArrayList<String>();

            while (result.next())
            {
                arr.add(result.getString("password"));
                if (result.getString("password").equals(password))
                {
                    return "true";
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "false";
    }

    // currently does not work as intended
    // supposed to get permission for either admin or user of person logging in
    // currently does not care about password being correct/incorrect
    public static String getPermission(String user, String password)
    {
        if (loginComparePassword(loginCompareUsername(user),password).equals("true"));
        {
            try {
                Connection connection = getConnection();
                PreparedStatement select = connection.prepareStatement("SELECT username,account_type FROM user_information WHERE " + user + " = username ORDER BY username ASC;");
                ResultSet result = select.executeQuery();


                ArrayList<String> arr = new ArrayList<String>();

                while (result.next())
                {
                    arr.add(result.getString("account_type"));
                    System.out.println(result.getString("account_type"));
                    if (result.getString("account_type").equals("1"))
                    {
                        return "true admin";
                    }
                    else if (result.getString("account_type").equals("0"))
                    {
                        return "true user";
                    }
                }
                System.out.println(result.getString("account_type"));
                return result.getString("account_type");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "false";
    }


    public static void main(String[] args) throws Exception
    {


        // connection
        ServerSocket listener = new ServerSocket(SERVER_PORT);
        Socket client = null;
        String login = "login true";
        String temp = "asset add false";
        String temp2 = "user menu false";
        String adminMenu = "admin menu false";


        String user;
        String password;

        String addPassword;
        String addaccountType;
        String addOrgID;

        String removeUser;

        String newPassword;
        String oldPassword;

        String assetNameBuy;
        String quantityBuy;
        String priceBuy;
        String orgIDBuy;

        String assetNameSell;
        String quantitySell;
        String priceSell;
        String orgIDSell;


        while (true)
        {
            // connecting
            client = listener.accept();
            // skeleton and unused code for implemented threads. Discarded due to lack of time
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());


            if (temp.equals("user menu true"))
            {
                temp2 = (String) in.readObject();
            }
            if (temp2.equals("change password true"))
            {
                newPassword = (String) in.readObject();
                oldPassword = (String) in.readObject();
                insertQuery(updatePassword(newPassword,oldPassword));
            }

            if (temp2.equals("List buy request"))
            {
                assetNameBuy = (String) in.readObject();
                quantityBuy = (String) in.readObject();
                priceBuy = (String) in.readObject();
                orgIDBuy = (String) in.readObject();
                insertQuery(insertBuyRequest(assetNameBuy, quantityBuy, priceBuy, orgIDBuy));

            }

            if (temp2.equals("List sell request"))
            {
                assetNameSell = (String) in.readObject();
                quantitySell = (String) in.readObject();
                priceSell = (String) in.readObject();
                orgIDSell = (String) in.readObject();
                insertQuery(insertBuyRequest(assetNameSell, quantitySell, priceSell, orgIDSell));

            }

            if (adminMenu.equals("admin menu true"))
            {
                temp = (String) in.readObject(); // asset add true
            }

            if (temp.equals("list org true"))
            {

            }

            if (temp.equals("add org true"))
            {
                insertQuery(insertOrganisation());
            }

            if (temp.equals("add user true"))
            {
                addPassword = (String) in.readObject();
                addaccountType = (String) in.readObject();
                addOrgID = (String) in.readObject();
                insertQuery(insertMember(addPassword,addaccountType,addOrgID));
            }

            if (temp.equals("asset add true"))
            {
                String add_asset = (String) in.readObject();
                insertQuery(insertAsset(add_asset));
            }

            if (temp.equals("remove user true"))
            {
                removeUser = (String) in.readObject();
                insertQuery(deleteUser(removeUser));
            }
            System.out.println(temp);





            if (login.equals("login true")) {
                user = (String) in.readObject();
                password = (String) in.readObject();
                if (loginComparePassword(loginCompareUsername(user), password).equals("true"))
                {
                    //login = (String)in.readObject();
                    login = "login false";
                    adminMenu = "admin menu true";
                }
                //out.writeObject(getPermission(user,password));
                out.writeObject(loginComparePassword(loginCompareUsername(user), password));
                out.flush();
                //System.out.println(adminMenu);
            }

            //insertQuery(user);
            //System.out.println(user);

        }
    }
}
