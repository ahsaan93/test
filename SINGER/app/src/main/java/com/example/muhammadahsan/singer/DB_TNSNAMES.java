package com.example.muhammadahsan.singer;

public class DB_TNSNAMES  {

    static DB_CONNECTION db;
    String DEFAULT_IP;
    String DEFAULT_SERVICE_NAME;
    String DEFAULT_PORT;
    String DEFAULT_USERNAME;
    String DEFAULT_PASSWORD;

    public String connect_SingerDEV(){
        this.DEFAULT_IP = "192.168.0.20";
        this.DEFAULT_SERVICE_NAME = "orcl";
        this.DEFAULT_PORT = "1521";
        this.DEFAULT_USERNAME = "erpmain";
        this.DEFAULT_PASSWORD = "citi_bank2016";

        db = new DB_CONNECTION(DEFAULT_IP,DEFAULT_SERVICE_NAME,DEFAULT_PORT,DEFAULT_USERNAME,DEFAULT_PASSWORD);
        //current_active_db = "SINGER DEV";
        //Toast.makeText(getApplicationContext(), ""+db.connect_database(), Toast.LENGTH_SHORT).show();
        return db.connect_database().toString();
    }
    public String connect_SingerLive(){
        this.DEFAULT_IP = "172.17.1.42";
        this.DEFAULT_SERVICE_NAME = "ERPMAIN";
        this.DEFAULT_PORT = "1521";
        this.DEFAULT_USERNAME = "ERPMAIN";
        this.DEFAULT_PASSWORD = "SINGERPK";

        db = new DB_CONNECTION(DEFAULT_IP,DEFAULT_SERVICE_NAME,DEFAULT_PORT,DEFAULT_USERNAME,DEFAULT_PASSWORD);
        //current_active_db = "SINGER LIVE";
        //Toast.makeText(getApplicationContext(), ""+db.connect_database(), Toast.LENGTH_SHORT).show();
        return db.connect_database().toString();
    }
    public String connect_EMCPL(){
        this.DEFAULT_IP = "172.17.1.41";
        this.DEFAULT_SERVICE_NAME = "EMCPL";
        this.DEFAULT_PORT = "1521";
        this.DEFAULT_USERNAME = "ERPMAIN";
        this.DEFAULT_PASSWORD = "EMCPLERP";

        db = new DB_CONNECTION(DEFAULT_IP,DEFAULT_SERVICE_NAME,DEFAULT_PORT,DEFAULT_USERNAME,DEFAULT_PASSWORD);
        //current_active_db = "EMCPL";
        //Toast.makeText(getApplicationContext(), ""+db.connect_database(), Toast.LENGTH_SHORT).show();
        return db.connect_database().toString();
    }
}
