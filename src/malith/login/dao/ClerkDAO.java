package malith.login.dao;

import common.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import malith.login.core.PasswordUtils;

import malith.login.core.Clerk;

public class ClerkDAO extends DAO {

    private Connection myConn;

    public ClerkDAO(Connection myConn) throws Exception {
        this.myConn = myConn;
    }

    private Clerk convertRowToClerk(ResultSet myRs) throws SQLException {

        String id = myRs.getString("id");
        String lastName = myRs.getString("last_name");
        String firstName = myRs.getString("first_name");
        String email = myRs.getString("email");
        int accessPriviledge = myRs.getInt("accessPriviledge");

        Clerk tempClerk = new Clerk(id, lastName, firstName, email, accessPriviledge);

        return tempClerk;
    }

    // modify to access priviledge!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public List<Clerk> getClerks(boolean admin, int clerkId) throws Exception {
        List<Clerk> list = new ArrayList<Clerk>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();

            String sql = null;

            if (admin) {
                // get all clerks
                sql = "select * from clerks order by last_name";
            } else {
                // only the current clerk
                sql = "select * from clerk where id=" + clerkId + " order by last_name";
            }

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                Clerk tempClerk = convertRowToClerk(myRs);
                list.add(tempClerk);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * return the clerk object according to the name AC number
     *
     */
    public Clerk searchClerk(String keyWord) throws Exception {
        //keyWord = "%" + keyWord + "%";
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String query;

        Clerk clerk = null;
        query = "select * from clerk where id = ?";
        myStmt = myConn.prepareStatement(query);
        myStmt.setString(1, keyWord);

        // execute statement
        myRs = myStmt.executeQuery();

        while (myRs.next()) {

            String id = myRs.getString("id");
            String lastName = myRs.getString("last_name");
            String firstName = myRs.getString("first_name");
            String email = myRs.getString("email");
            int accessPriviledge = myRs.getInt("accessPriviledge");

            clerk = new Clerk(id, lastName, firstName,  email,accessPriviledge);

        }
        return clerk;

    }

    public void addClerk(Clerk theClerk) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("insert into clerk"
                    + " (first_name, last_name, email, accessPriviledge, password)"
                    + " values (?, ?, ?, ?, ?)");

            // set params
            myStmt.setString(1, theClerk.getFirstName());
            myStmt.setString(2, theClerk.getLastName());
            myStmt.setString(3, theClerk.getEmail());
            myStmt.setInt(4, theClerk.getAccessPriviledge());

            // encrypt password
            String encryptedPassword = PasswordUtils.encryptPassword(theClerk.getPassword());
            myStmt.setString(5, encryptedPassword);

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }

    }

    public void updateClerk(Clerk theClerk) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("update clerk"
                    + " set first_name=?, last_name=?, email=?, accessPriviledge=?"
                    + " where id=?");

            // set params
            myStmt.setString(1, theClerk.getFirstName());
            myStmt.setString(2, theClerk.getLastName());
            myStmt.setString(3, theClerk.getEmail());
            myStmt.setInt(4, theClerk.getAccessPriviledge());
            myStmt.setString(5, theClerk.getId());

            // execute SQL
            myStmt.executeUpdate();

        } finally {
            close(myStmt);
        }
    }

    /**
     * Return true if clerk's password is authenticated.
     *
     * @param theClerk
     * @return
     */
    public boolean authenticate(Clerk theClerk) throws Exception {
        boolean result = false;

        String plainTextPassword = theClerk.getPassword();

        // get the encrypted password from database for this clerk
        String encryptedPasswordFromDatabase = getEncrpytedPassword(theClerk.getId());

        // compare the passwords
        result = PasswordUtils.checkPassword(plainTextPassword, encryptedPasswordFromDatabase);

        return result;
    }

    private String getEncrpytedPassword(String id) throws Exception {
        String encryptedPassword = null;

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select password from clerk where id=" + id);

            if (myRs.next()) {
                encryptedPassword = myRs.getString("password");
            } else {
                throw new Exception("Clerk id not found: " + id);
            }

            return encryptedPassword;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void changePassword(Clerk clerk) throws Exception {

        // get plain text password
        String plainTextPassword = clerk.getPassword();

        // encrypt the password
        String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);

        // update the password in the database
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("update clerk"
                    + " set password=?"
                    + " where id=?");

            // set params
            myStmt.setString(1, encryptedPassword);
            myStmt.setString(2, clerk.getId());

            // execute SQL
            myStmt.executeUpdate();

        } finally {
            close(myStmt);
        }

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
}
