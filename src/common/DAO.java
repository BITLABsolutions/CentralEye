/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import chanaka.data.Student;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import malith.login.core.Clerk;
import malith.login.core.PasswordUtils;
import prabath.data.Teacher;

/**
 *
 * @author Malith
 */
public class DAO {

    /**
     * Return true if user's password is authenticated.
     *
     * @param theUser
     * @return
     */
    public boolean authenticate(User theUser) throws Exception {
        boolean result = false;

        String plainTextPassword = theUser.getPassword();
   

      // get the encrypted password from database for this user
        String encryptedPasswordFromDatabase = getEncrpytedPassword(theUser);

        // compare the passwords
        result = PasswordUtils.checkPassword(plainTextPassword, encryptedPasswordFromDatabase);

        return result;
    }

    private String getEncrpytedPassword(User theUser) throws Exception {
        Connection myConn = new DbConnector().getMyConn();
        String encryptedPassword = null;

        Statement myStmt = null;
        ResultSet myRs = null;
        String id = theUser.getId();
        
            myStmt = myConn.createStatement();
            if (theUser.getClass() == Clerk.class) {
                myRs = myStmt.executeQuery("select password from clerk where id=" + id);
            } else if (theUser.getClass() == Teacher.class) {
                myRs = myStmt.executeQuery("select password from teacher where NIC=" + id);
            } else if (theUser.getClass() == Student.class) {
                myRs = myStmt.executeQuery("select password from student where AdmissionNumber=" + id);
            }

            if (myRs.next()) {
                encryptedPassword = myRs.getString("password");
            
            }
            return encryptedPassword;
            
    }

    public void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    public void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    public void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

    public static void main(String[] args) {
        User theUser = new Clerk();
        Clerk clerk = new Clerk();
        User user = new User();

        if (theUser.getClass() == User.class) {
            System.out.println("equal");
        }
    }
}
