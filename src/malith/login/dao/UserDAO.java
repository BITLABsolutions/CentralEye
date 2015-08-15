package malith.login.dao;

import common.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import malith.login.core.PasswordUtils;

import malith.login.core.User;

public class UserDAO {

    private Connection myConn;

    public UserDAO() throws Exception {
        myConn = new DbConnector().getMyConn();
    }

    private User convertRowToUser(ResultSet myRs) throws SQLException {

        String id = myRs.getString("id");
        String lastName = myRs.getString("last_name");
        String firstName = myRs.getString("first_name");
        String email = myRs.getString("email");
        int accessPriviledge = myRs.getInt("accessPriviledge");

        User tempUser = new User(id, lastName, firstName, email, accessPriviledge);

        return tempUser;
    }

    public List<User> getUsers(boolean admin, int userId) throws Exception {
        List<User> list = new ArrayList<User>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();

            String sql = null;

            if (admin) {
                // get all users
                sql = "select * from users order by last_name";
            } else {
                // only the current user
                sql = "select * from users where id=" + userId + " order by last_name";
            }

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                User tempUser = convertRowToUser(myRs);
                list.add(tempUser);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * return the user object according to the name AC number
     *
     */
    public User searchUser(String keyWord) throws Exception {
        //keyWord = "%" + keyWord + "%";
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String query;

        User user = null;
        query = "select * from users where id = ?";
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

            user = new User(id, lastName, firstName,  email,accessPriviledge);

        }
        return user;

    }

    public void addUser(User theUser) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("insert into users"
                    + " (first_name, last_name, email, accessPriviledge, password)"
                    + " values (?, ?, ?, ?, ?)");

            // set params
            myStmt.setString(1, theUser.getFirstName());
            myStmt.setString(2, theUser.getLastName());
            myStmt.setString(3, theUser.getEmail());
            myStmt.setInt(4, theUser.getAccessPriviledge());

            // encrypt password
            String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPassword());
            myStmt.setString(5, encryptedPassword);

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }

    }

    public void updateUser(User theUser) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("update users"
                    + " set first_name=?, last_name=?, email=?, accessPriviledge=?"
                    + " where id=?");

            // set params
            myStmt.setString(1, theUser.getFirstName());
            myStmt.setString(2, theUser.getLastName());
            myStmt.setString(3, theUser.getEmail());
            myStmt.setInt(4, theUser.getAccessPriviledge());
            myStmt.setString(5, theUser.getId());

            // execute SQL
            myStmt.executeUpdate();

        } finally {
            close(myStmt);
        }
    }

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
        String encryptedPasswordFromDatabase = getEncrpytedPassword(theUser.getId());

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
            myRs = myStmt.executeQuery("select password from users where id=" + id);

            if (myRs.next()) {
                encryptedPassword = myRs.getString("password");
            } else {
                throw new Exception("User id not found: " + id);
            }

            return encryptedPassword;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void changePassword(User user) throws Exception {

        // get plain text password
        String plainTextPassword = user.getPassword();

        // encrypt the password
        String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);

        // update the password in the database
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("update users"
                    + " set password=?"
                    + " where id=?");

            // set params
            myStmt.setString(1, encryptedPassword);
            myStmt.setString(2, user.getId());

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
