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
    private static int nThreads = 1;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(nThreads);

    public static Connection getConnection() throws Exception
    {
        try {
            String url = "jdbc:mariadb://" + SERVER_IP + ":" + DATABASE_PORT + "/" + DATABASE_NAME;
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void createTable() throws Exception
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS test(id int primary key not null auto_increment, first_name varchar(255), last_name varchar(255));");
            create.executeUpdate();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("created table if it did not exist");
        }
    }

    public static void insertQuery(String query) throws Exception
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement post = connection.prepareStatement(query);
            post.executeUpdate();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("inserted information into table");
        }
    }

    public static ArrayList<String> get() throws Exception
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT * FROM test;");
            ResultSet result = select.executeQuery();

            ArrayList<String> arr = new ArrayList<String>();
            while (result.next())
            {
                System.out.print(result.getString("first_name"));
                System.out.print(" ");
                System.out.println(result.getString("last_name"));

                arr.add(result.getString("first_name"));
                arr.add(result.getString("last_name"));
            }
            System.out.println("All records have been selected");
            return arr;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String insertAsset(String asset_names)
    {
        String query = "INSERT INTO asset_types(asset_names) VALUES ('" + asset_names + "');";
        return query;
    }

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
        //loginComparePassword(loginCompareUsername("1"),"admin");
        //getPermission("2","hazza");
        // connection
        ServerSocket listener = new ServerSocket(SERVER_PORT);
        Socket client = null;
        String login = "login true";
        boolean adminMenu = true;


        String user;
        String password;


        while (true)
        {
            System.out.println(login + "1");
            // connecting
            client = listener.accept();
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);



            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            System.out.println(login + "2");


            if (login.equals("login true")) {
                user = (String) in.readObject();
                password = (String) in.readObject();
                if (loginComparePassword(loginCompareUsername(user), password).equals("true"))
                {
                    login = (String)in.readObject();
                }
                System.out.println(login + "3");
                //out.writeObject(getPermission(user,password));
                out.writeObject(loginComparePassword(loginCompareUsername(user), password));


            }
            out.flush();
            System.out.println(login + "4");

            //client.close();





            //insertQuery(user);
            //System.out.println(user);


        }
        /*
        while (true)
        {
            System.out.println("2nds loop");
            // connecting
            client = listener.accept();
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);
        }

         */
    }
}
