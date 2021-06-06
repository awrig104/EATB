package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SQLList
{
    private static int SERVER_PORT = 4999;
    private static int DATABASE_PORT = 3306;
    private static String SERVER_IP = "localhost";
    public static String DATABASE_NAME = "eatp";

    public static String addAsset(String asset_names)
    {
        String query = "INSERT INTO asset_types(asset_names) VALUES ('" + asset_names + "');";
        return query;
    }

}
