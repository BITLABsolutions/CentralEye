package dao;

//This is the controller class for add a student
import data.Student;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
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

    public void addStudent(Student student) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            myStmt = myConn.prepareStatement("INSERT INTO student (AdmissionNumber,FullNameEnglish, FullNameSinhala, BirthDate, House, Religion, Address, TelephoneNumber, DateOfAdmission, ClassOfAdmission, Gender) values (?,?,?,?,?,?,?,?,?,?,?)");
            myStmt.setString(1, student.getAdmissionNumber());
            myStmt.setString(2, student.getFullNameEnglish());
            myStmt.setString(3, student.getFullNameSinhala());
            myStmt.setString(4, student.getBirthDate());
            myStmt.setString(5, student.getHouse());
            myStmt.setString(6, student.getReligion());
            myStmt.setString(7, student.getAddress());
            myStmt.setString(8, student.getTelephoneNumber());
            myStmt.setString(9, student.getDateOfAdmission());
            myStmt.setString(10, student.getClassOfAdmission());
            myStmt.setString(11, student.getGender());

            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }

    }

    public List<Student> searchStudent(String keyWord) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        List<Student> list = new ArrayList<>();
        try {

            
            keyWord += "%";
            String query = "select * from student where AdmissionNumber like ? or FullNameEnglish like ? or FullNameSinhala like ? or BirthDate like ? or House like ? or Religion like ? or Address like ? or TelephoneNumber like ? or DateOfAdmission like ? or ClassOfAdmission like ? or Gender like ?";
            myStmt = myConn.prepareStatement(query);
            for (int i = 1; i < 12; i++) {
                myStmt.setString(i, keyWord);
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

    private Student convertRowToStudent(ResultSet myRs) throws SQLException {
        String AdmissionNumber = myRs.getString(1);
        String FullNameEnglish = myRs.getString(2);
        String FullNameSinhala = myRs.getString(3);
        String BirthDate = myRs.getString(4);
        String House = myRs.getString(5);
        String Religion = myRs.getString(6);
        String Address = myRs.getString(7);
        String TelephoneNumber = myRs.getString(8);
        String DateOfAdmission = myRs.getString(9);
        String ClassOfAdmission = myRs.getString(10);
        String Gender = myRs.getString(11);
        Student tempStudent = new Student(AdmissionNumber, FullNameEnglish, FullNameSinhala, BirthDate, House, Religion, Address, TelephoneNumber, DateOfAdmission, ClassOfAdmission, Gender);
        return tempStudent;

    }

    private void close(PreparedStatement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(PreparedStatement myStmt) throws SQLException {
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
