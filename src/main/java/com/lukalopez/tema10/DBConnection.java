package com.lukalopez.tema10;

public class DBConnection {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private static DBConnection instance;

    private DBConnection(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public static DBConnection getInstance(String host, int port, String username, String password){
        if (instance==null){
            instance = new DBConnection(host,port,username,password);
        }
        return instance;
    }
}
