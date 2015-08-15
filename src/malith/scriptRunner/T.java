/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malith.scriptRunner;

import common.DbConnector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malith
 */
public class T {

    public void runScript() {
        DbConnector dbConnector;
        try {
            dbConnector = new DbConnector();
            Connection con = dbConnector.getMyConn();
            ScriptRunner runner = new ScriptRunner(con, false, true);

            //runner.runScript(new BufferedReader(new FileReader("C:\\Users\\Malith\\Dropbox\\OOSD\\CentralEye\\src\\malith\\scriptRunner\\demo.sql")));
            runner.runScript(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("club.sql"))));
            runner.runScript(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("teacher.sql"))));
          //  runner.runScript(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("student.sql"))));
           runner.runScript(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("login.sql"))));
        } catch (IOException | SQLException ex) {
            Logger.getLogger(T.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] arg) {
        new T().runScript();

    }
}
