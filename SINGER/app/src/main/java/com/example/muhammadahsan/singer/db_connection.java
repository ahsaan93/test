package com.example.muhammadahsan.singer;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.muhammadahsan.MainActivity.stmt;

public class DB_CONNECTION{

    String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    String DEFAULT_IP;// = "172.17.1.20"; //---1
    String DEFAULT_SERVICE_NAME;// = "PROD"; //---2
    String DEFAULT_PORT;// = "1521"; //---3
    //String DEFAULT_URL = "jdbc:oracle:thin:@172.17.1.20:1521:PROD";
    String DEFAULT_URL;// = "jdbc:oracle:thin:@"+DEFAULT_IP+":"+DEFAULT_PORT+":"+DEFAULT_SERVICE_NAME;
    String DEFAULT_USERNAME;// = "ERPMAIN"; //---4
    String DEFAULT_PASSWORD;// = "CITI_BANK2016"; //---5
    String status = "";
    public static Connection connection, conn;


    public DB_CONNECTION(String DEFAULT_IP, String DEFAULT_SERVICE_NAME, String DEFAULT_PORT, String DEFAULT_USERNAME, String DEFAULT_PASSWORD) {
        this.DEFAULT_IP = DEFAULT_IP;
        this.DEFAULT_SERVICE_NAME = DEFAULT_SERVICE_NAME;
        this.DEFAULT_PORT = DEFAULT_PORT;
        this.DEFAULT_USERNAME = DEFAULT_USERNAME;
        this.DEFAULT_PASSWORD = DEFAULT_PASSWORD;

        this.DEFAULT_URL = "jdbc:oracle:thin:"+this.DEFAULT_USERNAME+"/"+this.DEFAULT_PASSWORD+"@"+DEFAULT_IP+":"+DEFAULT_PORT+":"+DEFAULT_SERVICE_NAME;
    }


    public String connect_database() {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {

            Class.forName(DEFAULT_DRIVER);
        } catch (ClassNotFoundException e) {
            status ="Database connection failed!---2";
            e.printStackTrace();
            return status;
        }

        try {
            connection = DriverManager.getConnection(DEFAULT_URL);
            //status ="Database Connected";

            stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT SYSDATE FROM DUAL");
            while(rs.next()) {
                //System.out.println("hello : " + rs.getString(1));
                status ="Connection established on "+rs.getString(1);
            }
            //status ="Connected as ";//+rs.getString(1).toString();
        }
        catch (Exception e) {
            status ="Database connection failed!---1";
            e.printStackTrace();
        }
        return status;

    }
}
