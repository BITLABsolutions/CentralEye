/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prabath.dao;

import prabath.data.Teacher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prabath s
 */
public class TeacherDAO {

    Connection myCon;

    public TeacherDAO(Connection myCon) {
        this.myCon = myCon;
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        PreparedStatement myStmnt = null;
        try {
            myStmnt = myCon.prepareStatement("INSERT INTO Teacher (NIC,RNo,NameWithIn,FullName,Gender,Dob,CivilStatus,Address,TelNoMobile,TelNoRecident,DateOfAssignmentAsTeacher,DateOfAssignmentToSchool,EducationQual,ProffessionalQual,SubjectsAndClasses,SubjectsWishToTeach,GradesWishToTeach,"
                    + "NatureOfPresentPost,GradeOfService,DateOfPromotion,SectionTaught,ServiceRecord,PositionInSchool,AccessPriviledge,ClubIncharge)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            myStmnt.setString(1, teacher.getNIC());
            myStmnt.setString(2, teacher.getRNo());
            myStmnt.setString(3, teacher.getNameWithin());
            myStmnt.setString(4, teacher.getFullName());
            myStmnt.setString(5, teacher.getGender());
            myStmnt.setDate(6, teacher.getDob());
            myStmnt.setString(7, teacher.getCivilStatus());
            myStmnt.setString(8, teacher.getAddress());
            myStmnt.setString(9, teacher.getTelNoMobile());
            myStmnt.setString(10, teacher.getTelNoRecident());
            myStmnt.setDate(11, teacher.getDateOfAssignAsTeacher());
            myStmnt.setDate(12, teacher.getDateOfAssignToSchool());
            myStmnt.setString(13, teacher.getEducationQual());
            myStmnt.setString(14, teacher.getProfessionalQual());
            myStmnt.setString(15, teacher.getSubjectsAndClasses());
            myStmnt.setString(16, teacher.getSubjectsWishToTeach());
            myStmnt.setString(17, teacher.getGradesWishToTeach());
            myStmnt.setString(18, teacher.getNatureOfPresentPost());
            myStmnt.setString(19, teacher.getGradeOfService());
            myStmnt.setDate(20, teacher.getDateOfPromotion());
            myStmnt.setString(21, teacher.getSectionTaught());
            myStmnt.setString(22, teacher.getServiceRecord());
            myStmnt.setString(23, teacher.getPositionInSchool());
            myStmnt.setInt(24,3 );
            myStmnt.setString(25, null);

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

    public List<Teacher> getAllTeacher() throws Exception {

        List<Teacher> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myCon.createStatement();
            myRs = myStmt.executeQuery("select * from Teacher");

            // load each teacher object to the Teacher List
            while (myRs.next()) {
                Teacher tempTeacher = convertRowToTeacher(myRs);
                list.add(tempTeacher);

            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * search teachers for given input parameters = last name, tel number, id, AC
     * number
     *
     */
    public List<Teacher> searchTeacher(String keyWord, String searchPara) throws Exception {

        List<Teacher> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String query;
        try {

            keyWord = "%" + keyWord + "%";
            switch (searchPara) {
                case "Name":
                    query = "select * from teacher where FullName = ? or NameWithIn =?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);
                    myStmt.setString(2, keyWord);

                    break;
                case "NIC":
                    query = "select * from teacher where NIC = ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);

                    break;
                case "RNo":
                    query = "select * from teacher where RNo = ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);

                    break;
                //if "keyWord" in any field in the record, return them
                case "All":
                    query = "select * from teacher where NIC = ? or RNo = ? or NameWithIN = ? or FullName = ? or Gender = ? or Dob = ? or CivilStatus = ? or Address = ? or TelNoMobile = ? or TelNoRecident = ? or DateOfAssignmentAsTeacher = ? or DateOfAssignmentToSchool = ? or EducationQual = ? or ProffessionalQual = ? or SubjectsAndClasses = ? or SubjectsWishToTeach = ? or GradesWishToTeach = ? or NatureOfPresentPost = ? or GradeOfService = ? or DateOfPromotion = ?  or SectionTaught = ? or ServiceRecord = ? or PositionInSchool = ? ";
                    myStmt = myCon.prepareStatement(query);
                    //set parameters
                    for (int i = 1; i < 24; i++) {
                        myStmt.setString(i, keyWord);
                    }
                    break;
                default:
                    query = "select * from teacher where " + searchPara + " = ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);

            }

            // execute statement
            myRs = myStmt.executeQuery();

            //load teachers to a Teacher List
            while (myRs.next()) {
                Teacher tempTeacher = convertRowToTeacher(myRs);
                list.add(tempTeacher);

                System.out.println(tempTeacher.getNIC());
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void updateTeacher(Teacher teacher, String previousNIC) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            //prepare the statement
            myStmt = myCon.prepareStatement("update teacher set NIC=? ,  RNo= ? , NameWithIN= ? , FullName= ? , Gender= ? , Dob= ? , CivilStatus= ? , Address= ? , TelNoMobile= ? , TelNoRecident= ? , DateOfAssignmentAsTeacher= ? , DateOfAssignmentToSchool= ? , EducationQual= ? , ProffessionalQual= ? , SubjectsAndClasses= ? , SubjectsWishToTeach= ? , GradesWishToTeach= ? , NatureOfPresentPost= ? , GradeOfService= ? , DateOfPromotion= ?  , SectionTaught= ? , ServiceRecord= ? , PositionInSchool= ? where NIC=? ");

            // set params
            //myStmt.setString(1, teacher.getNIC());
            myStmt.setString(2, teacher.getRNo());
            myStmt.setString(1, teacher.getNIC());
            myStmt.setString(3, teacher.getNameWithin());
            myStmt.setString(4, teacher.getFullName());
            myStmt.setString(5, teacher.getGender());
            myStmt.setDate(6, teacher.getDob());
            myStmt.setString(7, teacher.getCivilStatus());
            myStmt.setString(8, teacher.getAddress());
            myStmt.setString(9, teacher.getTelNoMobile());
            myStmt.setString(10, teacher.getTelNoRecident());
            myStmt.setDate(11, teacher.getDateOfAssignAsTeacher());
            myStmt.setDate(12, teacher.getDateOfAssignToSchool());
            myStmt.setString(13, teacher.getEducationQual());
            myStmt.setString(14, teacher.getProfessionalQual());
            myStmt.setString(15, teacher.getSubjectsAndClasses());
            myStmt.setString(16, teacher.getSubjectsWishToTeach());
            myStmt.setString(17, teacher.getGradesWishToTeach());
            myStmt.setString(18, teacher.getNatureOfPresentPost());
            myStmt.setString(19, teacher.getGradeOfService());
            myStmt.setDate(20, teacher.getDateOfPromotion());
            myStmt.setString(21, teacher.getSectionTaught());
            myStmt.setString(22, teacher.getServiceRecord());
            myStmt.setString(23, teacher.getPositionInSchool());
            myStmt.setString(24, previousNIC);

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    public void deleteTeacher(String nic) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            // prepare statement
            myStmt = myCon.prepareStatement("delete from teacher where NIC=?");

            //set param
            myStmt.setString(1, nic);

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    private Teacher convertRowToTeacher(ResultSet myRs) throws SQLException {

        String NIC = myRs.getString(1);
        String RNo = myRs.getString(2);
        String NameWithIn = myRs.getString(3);
        String FullName = myRs.getString(4);
        String Gender = myRs.getString(5);
        Date Dob = myRs.getDate(6);
        String CivilStatus = myRs.getString(7);
        String Address = myRs.getString(8);
        String TelNoMobile = myRs.getString(9);
        String TelNoRecident = myRs.getString(10);
        Date DateOfAssignmentAsTeacher = myRs.getDate(11);
        Date DateOfAssignmentToSchool = myRs.getDate(12);
        String EducationQual = myRs.getString(13);
        String ProffessionalQual = myRs.getString(14);
        String SubjectsAndClasses = myRs.getString(15);
        String SubjectsWishToTeach = myRs.getString(16);
        //teacher_image // later
        String GradesWishToTeach = myRs.getString(17);
        String NatureOfPresentPost = myRs.getString(18);
        String GradeOfPromotion = myRs.getString(19);
        Date DateOfPromotion = myRs.getDate(20);
        //String acType = myRs.getString(21);
        String SectionTaught = myRs.getString(21);
        String ServiceRecord = myRs.getString(22);
        String PositionInSchool = myRs.getString(23);

        Teacher tempTeacher = new Teacher(NIC, RNo, NameWithIn, FullName, Gender, Dob, CivilStatus, Address, TelNoMobile, TelNoRecident, DateOfAssignmentAsTeacher, DateOfAssignmentToSchool, EducationQual, ProffessionalQual, SubjectsAndClasses, SubjectsWishToTeach, GradesWishToTeach, NatureOfPresentPost,  GradeOfPromotion,DateOfPromotion, SectionTaught, ServiceRecord, PositionInSchool);
        return tempTeacher;
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }
    
    private void updateAccess(Teacher teacher,String NIC,String clubName) throws SQLException{
        PreparedStatement myStmt = null;
        try {
            //prepare the statement
            myStmt = myCon.prepareStatement("update teacher set AccessPriviledge=? ,  ClubIncharge= ?  where NIC=? ");

            // set params
            //myStmt.setString(1, teacher.getNIC());
            
            myStmt.setInt(1, 2);
            myStmt.setString(2, clubName);
            myStmt.setString(3, NIC);
            
            

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

}
