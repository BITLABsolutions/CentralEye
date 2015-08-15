/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prabath.dao;

import common.DAO;
import prabath.data.Teacher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import malith.login.core.PasswordUtils;

/**
 *
 * @author prabath s
 */
public class TeacherDAO extends DAO{

    Connection myCon;
    boolean passwordChangeSuccessfully;

    public TeacherDAO(Connection myCon) {
        this.myCon = myCon;
        this.passwordChangeSuccessfully=false;
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        PreparedStatement myStmnt = null;
        try {
            myStmnt = myCon.prepareStatement("INSERT INTO Teacher (NIC,RNo,NameWithIn,FullName,Gender,Dob,CivilStatus,Address,TelNoMobile,TelNoRecident,DateOfAssignmentAsTeacher,DateOfAssignmentToSchool,EducationQual,ProffessionalQual,SubjectsAndClasses,SubjectsWishToTeach,GradesWishToTeach,"
                    + "NatureOfPresentPost,GradeOfService,DateOfPromotion,SectionTaught,ServiceRecord,PositionInSchool,AccessPriviledge,ClubIncharge,Password)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            myStmnt.setInt(24, 3);
            myStmnt.setString(25, null);
            myStmnt.setString(26, PasswordUtils.encryptPassword("1234"));

            myStmnt.executeUpdate();

        } finally {
            close(myStmnt);
        }

    }
    
    public void changePassword(String NIC,String oldPassword,String newPassword,String confirmPassword) throws SQLException{
        
        PreparedStatement myStmt=null;
        String oldPass="";
        try {
            String query = "select Password from teacher where NIC like ? ";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, NIC);
                    ResultSet rs=myStmt.executeQuery();
                    rs.next();
                    oldPass=rs.getString(1);
                    
                    
            //rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{close(myStmt);}
        System.out.println(oldPass);
        System.out.println(oldPassword);
        if(PasswordUtils.checkPassword(oldPassword, oldPass)){
            if(newPassword.equals(confirmPassword)){
                PreparedStatement myStmt1 = null;
        try {
            //prepare the statement
            myStmt = myCon.prepareStatement("update teacher set Password=?  where NIC=? ");

            // set params
            //myStmt.setString(1, teacher.getNIC());
            myStmt.setString(1, PasswordUtils.encryptPassword(newPassword));
            myStmt.setString(2,NIC);
            
            //execute statement
            myStmt.executeUpdate();
            this.passwordChangeSuccessfully=true;
        } finally {
            close(myStmt);
        }
            }
            else{
                JOptionPane.showMessageDialog(null, "New password and Confirm password does not match");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Old password is wrong");
        }
        
    }

    public boolean isPasswordChangeSuccessfully() {
        return passwordChangeSuccessfully;
    }

    public void setPasswordChangeSuccessfully(boolean passwordChangeSuccessfully) {
        this.passwordChangeSuccessfully = passwordChangeSuccessfully;
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
     * search teachers for given input parameters = last name, tel number, id,
     * AC number
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
                    query = "select * from teacher where FullName like ? or NameWithIn like ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);
                    myStmt.setString(2, keyWord);

                    break;
                case "NIC":
                    query = "select * from teacher where NIC like ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);

                    break;
                case "RNo":
                    query = "select * from teacher where RNo like ?";
                    myStmt = myCon.prepareStatement(query);
                    myStmt.setString(1, keyWord);

                    break;
                //if "keyWord" in any field in the record, return them
                case "All":
                    query = "select * from teacher where NIC like ? or RNo like ? or NameWithIN like ? or FullName like ? or Gender like ? or Dob like ? or CivilStatus like ? or Address like ? or TelNoMobile like ? or TelNoRecident like ? or DateOfAssignmentAsTeacher like ? or DateOfAssignmentToSchool like ? or EducationQual = ? or ProffessionalQual like ? or SubjectsAndClasses like ? or SubjectsWishToTeach like ? or GradesWishToTeach like ? or NatureOfPresentPost like ? or GradeOfService like ? or DateOfPromotion like ?  or SectionTaught like ? or ServiceRecord like ? or PositionInSchool like ? ";
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
    
    public int getTeacherCount() throws SQLException {
        int count=0;
        Statement myStatment=null;
        try {
            myStatment = myCon.createStatement();
            ResultSet rs=myStatment.executeQuery("SELECT COUNT(*) FROM Teacher");
            rs.next();
            count=rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{close(myStatment);}
        return count;
    }

    public Teacher getTeacherById(String RNo) throws SQLException {

        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String query;
        
        try {

            query = "select * from teacher where RNo = ?";
            myStmt = myCon.prepareStatement(query);
            myStmt.setString(1, RNo);

            // execute statement
            myRs = myStmt.executeQuery();
            
            //load teachers to a Teacher List
            myRs.next();
            Teacher teacherIn =convertRowToTeacher(myRs);
            //System.out.println(NameWithIn);
            return  teacherIn;
             
        } finally {
            close(myStmt, myRs);
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

        Teacher tempTeacher = new Teacher(NIC, RNo, NameWithIn, FullName, Gender, Dob, CivilStatus, Address, TelNoMobile, TelNoRecident, DateOfAssignmentAsTeacher, DateOfAssignmentToSchool, EducationQual, ProffessionalQual, SubjectsAndClasses, SubjectsWishToTeach, GradesWishToTeach, NatureOfPresentPost, GradeOfPromotion, DateOfPromotion, SectionTaught, ServiceRecord, PositionInSchool);
        return tempTeacher;
    }


    public void updateAccess(Teacher teacher) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            //prepare the statement
            myStmt = myCon.prepareStatement("update teacher set AccessPriviledge=? ,  ClubIncharge= ?  where NIC=? ");

            // set params
            //myStmt.setString(1, teacher.getNIC());
            myStmt.setInt(1, teacher.getAccessPriviledge());
            myStmt.setString(2, teacher.getClubIncharge());
            myStmt.setString(3, teacher.getNIC());

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

}
