package com.qf.Utils;

import java.io.IOException;
import java.io.InputStream;

import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static{
        Properties properties = new Properties();
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public static void close(Connection conn, PreparedStatement ps){
        try {
            if(ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection conn, PreparedStatement ps,ResultSet res){
        try {
            if (res!=null){
                res.close();
            }
            if(ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
