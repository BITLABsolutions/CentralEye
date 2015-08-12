package chanaka.dao;

//This is the controller class for add a student

import chanaka.data.Student;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {

    private final Connection myConn;

    public StudentDAO(Connection myConn) throws IOException, SQLException {
        this.myConn = myConn;
    }

    public Connection getMyConn() {
        return myConn;
    }

      /**
     * get all student to a List
     *
     */
    public List<Student> getAllStudent() throws Exception {

        List<Student> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from student");

            // load each student object to the Student List
            while (myRs.next()) {
                Student tempStudent = convertRowToStudent(myRs);
                list.add(tempStudent);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }
    
    public void addStudent(Student student) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            myStmt = myConn.prepareStatement("INSERT INTO student (AdmissionNumber,FullNameEnglish, FullNameSinhala, BirthDate, House, Religion, Address, TelephoneNumber, DateOfAdmission, ClassOfAdmission, Gender) values (?,?,?,?,?,?,?,?,?,?,?)");
            myStmt.setString(1, student.getAdmissionNumber());
            myStmt.setString(2, student.getFullNameEnglish());
            myStmt.setString(3, student.getFullNameSinhala());
            myStmt.setDate(4, student.getBirthDate());
            myStmt.setString(5, student.getHouse());
            myStmt.setString(6, student.getReligion());
            myStmt.setString(7, student.getAddress());
            myStmt.setString(8, student.getTelephoneNumber());
            myStmt.setDate(9, student.getDateOfAdmission());
            myStmt.setString(10, student.getClassOfAdmission());
            myStmt.setString(11, student.getGender());

            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }

    }

    public void updateStudent(Student selectedStudent, String previousAdmissionNumber) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            myStmt = myConn.prepareStatement("update student set AdmissionNumber=?, FullNameEnglish=?, FullNameSinhala=?, BirthDate=?, House=?, Religion=?, Address=?, TelephoneNumber=?, DateOfAdmission=?, ClassOfAdmission=?, Gender=? where AdmissionNumber=?");
            myStmt.setString(1, selectedStudent.getAdmissionNumber());
            myStmt.setString(2, selectedStudent.getFullNameEnglish());
            myStmt.setString(3, selectedStudent.getFullNameSinhala());
            myStmt.setDate(4, selectedStudent.getBirthDate());
            myStmt.setString(5, selectedStudent.getHouse());
            myStmt.setString(6, selectedStudent.getReligion());
            myStmt.setString(7, selectedStudent.getAddress());
            myStmt.setString(8, selectedStudent.getTelephoneNumber());
            myStmt.setDate(9, selectedStudent.getDateOfAdmission());
            myStmt.setString(10, selectedStudent.getClassOfAdmission());
            myStmt.setString(11, selectedStudent.getGender());
            myStmt.setString(12, previousAdmissionNumber);

            myStmt.executeUpdate();
        } catch (Exception e) {
        } finally {
            close(myStmt);
        }
    }

    public List<Student> searchStudent(String keyWord, String searchPara) throws SQLException {

        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        List<Student> list = new ArrayList<>();
        String query;
        try {
            keyWord += "%";

            if (!"".equals(searchPara)) {
                query = "select * from student where " + searchPara + " like ?";

                myStmt = myConn.prepareStatement(query);
                myStmt.setString(1, keyWord);
            } else {
                query = "select * from student where AdmissionNumber like ? or FullNameEnglish like ? or FullNameSinhala like ? or BirthDate like ? or House like ? or Religion like ? or Address like ? or TelephoneNumber like ? or DateOfAdmission like ? or ClassOfAdmission like ? or Gender like ?";
                myStmt = myConn.prepareStatement(query);
                for (int i = 1; i < 12; i++) {
                    myStmt.setString(i, keyWord);
                }
            }

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Student tempStudent = convertRowToStudent(myRs);
                list.add(tempStudent);
            }

            return list;

        } finally {
            close(myStmt, myRs);
        }
    }

    
    /**
     * delete student
     *
     * @param admissionNo
     * @throws SQLException
     */
    public void deleteStudent(String admissionNumber) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            // prepare statement
            myStmt = myConn.prepareStatement("delete from student where AdmissionNumber =?");

            //set param
            myStmt.setString(1, admissionNumber);

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }
    
    private Student convertRowToStudent(ResultSet myRs) throws SQLException {
        String AdmissionNumber = myRs.getString(1);
        String FullNameEnglish = myRs.getString(2);
        String FullNameSinhala = myRs.getString(3);
        Date BirthDate = myRs.getDate(4);
        String House = myRs.getString(5);
        String Religion = myRs.getString(6);
        String Address = myRs.getString(7);
        String TelephoneNumber = myRs.getString(8);
        Date DateOfAdmission = myRs.getDate(9);
        String ClassOfAdmission = myRs.getString(10);
        String Gender = myRs.getString(11);
        Student tempStudent = new Student(AdmissionNumber, FullNameEnglish, FullNameSinhala, BirthDate, House, Religion, Address, TelephoneNumber, DateOfAdmission, ClassOfAdmission, Gender);
        return tempStudent;

    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
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
}
