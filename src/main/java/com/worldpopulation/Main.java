package com.worldpopulation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    protected ArrayList<Country> read_DB(Connection conn){
        ArrayList<Country> countrylist = new ArrayList<>();
        try {
            PreparedStatement stat = conn.prepareStatement("SELECT country_name, capital_name, " +
                    "region_name, sub_region_name FROM population");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                countrylist.add(new Country(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));

            }
            rs.close();
            stat.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countrylist;
    }


    public static void main(String[] args) {
        Main m = new Main();
        Connection conn = m.getConnection("localhost", 3306,
                "world_population","root","");
        ArrayList<Country> countrylist = m.read_DB(conn);
        System.out.println(countrylist.getLast());

        try {
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}