/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamin.dao;

import chamin.data.Club;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class ClubDAO {

    private final Connection myConn;

    public ClubDAO(Connection myConn) {
        this.myConn = myConn;
    }

    public Connection getMyConn() {
        return myConn;
    }

    //   get all club to a List
    public List<Club> getAllClub() throws SQLException {

        List<Club> list = new ArrayList<>();
        Statement myStmnt = null;
        ResultSet myRslt = null;

        try {
            myStmnt = myConn.createStatement();
            myRslt = myStmnt.executeQuery("select * from club");

            // load each club object to the club List
            while (myRslt.next()) {
                Club tempClub = convertRawToClub(myRslt);
                list.add(tempClub);
            }
            return list;
        } finally {
            close(myStmnt, myRslt);
        }
    }

    // add a new club
    public void addClub(Club club) throws SQLException {
        PreparedStatement myStmnt = null;

        try {
            String query = "INSERT INTO club (ClubId, ClubName, TeacherInchargeId, Advisor, PresidentId, VisePresidentId, SecretaryId, AssSecretaryId, TreasurerId, Task, Suggestions, DateOfEstablish, MemberIdList) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            myStmnt = myConn.prepareStatement(query);
            System.out.println("create my stmnt");
            //set parameters

            myStmnt.setString(1, club.getClubId());
            myStmnt.setString(2, club.getClubName());
            myStmnt.setString(3, club.getTeacherInchargeId());
            myStmnt.setString(4, club.getAdvisor());
            myStmnt.setString(5, club.getPresidentId());
            myStmnt.setString(6, club.getVisePresidentId());
            myStmnt.setString(7, club.getSecretaryId());
            myStmnt.setString(8, club.getAssSecretaryId());
            myStmnt.setString(9, club.getTreasurerId());
            myStmnt.setString(10, club.getTask());
            myStmnt.setString(11, club.getSuggestions());
            myStmnt.setDate(12, club.getDateOfEstablish());
            myStmnt.setString(13, club.getMemberIdList()[0]);

            myStmnt.executeUpdate();
            System.out.println("Successfully added");

        } finally {
            close(myStmnt);

        }

    }

    /**
     * update person
     *
     */
    public void updateClub(Club club, String selectedClub) throws SQLException {
        PreparedStatement myStmnt = null;
        try {
            //prepare the statement
            String query = "UPDATE club set ClubId=?, ClubName=?, TeacherInchargeId=?, Advisor=?, PresidentId=?, VisePresidentId=?, SecretaryId=?, AssSecretaryId=?, TreasurerId=?, Task=?, Suggestions=?, DateOfEstablish=?, MemberIdList=? WHERE values ClubName =?";
            // set params
            myStmnt.setString(1, club.getClubId());
            myStmnt.setString(2, club.getClubName());
            myStmnt.setString(3, club.getTeacherInchargeId());
            myStmnt.setString(4, club.getAdvisor());
            myStmnt.setString(5, club.getPresidentId());
            myStmnt.setString(6, club.getVisePresidentId());
            myStmnt.setString(7, club.getSecretaryId());
            myStmnt.setString(8, club.getAssSecretaryId());
            myStmnt.setString(9, club.getTreasurerId());
            myStmnt.setString(10, club.getTask());
            myStmnt.setString(11, club.getSuggestions());
            myStmnt.setDate(12, club.getDateOfEstablish());
            myStmnt.setString(13, club.getMemberIdList()[0]);
            myStmnt.setString(14, selectedClub);

            //execute statement
            myStmnt.executeUpdate();
        } finally {
            close(myStmnt);
        }
    }

    // search clubs by keyword
    public List<Club> searchClub(String keyWord, String searchPara) throws SQLException {

        List<Club> list = new ArrayList<>();

        
        PreparedStatement myStmnt = null;
        ResultSet myRslt = null;
        String query = null;
        try {

            switch (searchPara) {
                case "Club Name":
                  
                    query = "SELECT * from club where ClubName like ? ";
                    myStmnt = myConn.prepareStatement(query);
                    myStmnt.setString(1, keyWord);
                    break;
                case "Club Id":
                    
                    query = "SELECT * from club where ClubId like ? ";
                    myStmnt = myConn.prepareStatement(query);
                    myStmnt.setString(1, keyWord);
                    break;
                default:
                    //myStmnt=null;
                    System.out.println("default");

            }
            myRslt = myStmnt.executeQuery();

            while (myRslt.next()) {
                
                Club tempClub = convertRawToClub(myRslt);
                list.add(tempClub);
            }
            return list;
        } finally {
            close(myStmnt, myRslt);
        }

    }

    // delete person
    public void deleteClub(String ClubName) throws SQLException {
        PreparedStatement myStmnt = null;
        try {
            // prepare statement
            myStmnt = myConn.prepareStatement("delete from club where ClubName=?");

            //set param
            myStmnt.setString(1, ClubName);

            //execute statement
            myStmnt.executeUpdate();
        } finally {
            close(myStmnt);
        }
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

        if (myRs != null) {
            myRs.close();
        }
        if (myStmt != null) {
            myStmt.close();
        }
        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

    private Club convertRawToClub(ResultSet myRslt) throws SQLException {

        String ClubId = myRslt.getString(1);
        System.out.println(ClubId + "   club id");
        String ClubName = myRslt.getString(2);
        System.out.println(ClubName + "    club name");
        String TeacherInchargeId = myRslt.getString(3);
        String Advisor = myRslt.getString(4);
        String PresidentId = myRslt.getString(5);
        String VisePresidentId = myRslt.getString(6);
        String SecretaryId = myRslt.getString(7);
        String AssSecretaryId = myRslt.getString(8);
        String TreasurerId = myRslt.getString(9);
        String Task = myRslt.getString(10);
        String Suggestions = myRslt.getString(11);
        Date DateOfEstablish = myRslt.getDate(12);
        String MemberIdList[] = {myRslt.getString(13)};

        Club tempClub = new Club(ClubId, ClubName, TeacherInchargeId, Advisor, PresidentId, VisePresidentId, SecretaryId, AssSecretaryId, TreasurerId, Task, Suggestions, DateOfEstablish, MemberIdList);

        return tempClub;

    }

}
