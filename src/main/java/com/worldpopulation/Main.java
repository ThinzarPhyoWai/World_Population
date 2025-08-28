package com.worldpopulation;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class Name: Main
 * Author: aaa
 * Date: sdf
 * Description: Collection Test
 */
public class Main {

    // Connection
    // Statement/PreparedStatement(more secure than Statement)
    // ResultSet (start with index 1)

    private Connection getConnection(String ipaddress, int portno, String dbname,
                                     String username, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+ ipaddress+ ":"+
                    portno + "/" + dbname, username, password);
            System.out.println("Successful Connection");

        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Connection conn = m.getConnection("localhost", 3306,
                "world_population","root","");


    }
}