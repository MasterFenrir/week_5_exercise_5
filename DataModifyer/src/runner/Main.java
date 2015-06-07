package runner;

import connector.DatabaseConnection;
import modifyer.DatabaseModifyer;

/**
 * Created by Sander on 2-6-2015.
 */
public class Main {

    public static void main(String args[]) {
        try{
            DatabaseModifyer mod = new DatabaseModifyer(DatabaseConnection.getSession());
            //mod.setRandomMkantoormdwEntity();
            //mod.moveLoginData();
            mod.linkLoginData();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
