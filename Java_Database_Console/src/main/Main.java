package main;

import connector.DatabaseConnection;

/**
 * Created by Sander on 2-6-2015.
 */
public class Main {

    public static void main(String args[]) {
        try{
            DatabaseConnection conn = new DatabaseConnection();
            conn.setUp();
            conn.setRandomBroker();
            conn.closeConnection();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
