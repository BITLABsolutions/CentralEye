/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prabath.ui;

import chanaka.dao.StudentDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import prabath.dao.TeacherDAO;

/**
 *
 * @author prabath s
 */
class UpdateClerkUi implements Runnable {
    JLabel timeLbl,dateLbl,teacherCountLbl,studentCountLbl;
    TeacherDAO teacherDao;
    StudentDAO studentDao;
    
    public UpdateClerkUi(JLabel timeLbl,JLabel dateLbl,TeacherDAO teacherDao,JLabel teacherCountLbl,StudentDAO studentDao,JLabel studentCountLbl) {
        this.timeLbl=timeLbl;
        this.dateLbl=dateLbl;
        this.studentCountLbl=studentCountLbl;
        this.teacherCountLbl=teacherCountLbl;
        this.teacherDao=teacherDao;
        this.studentDao=studentDao;
    }

    @Override
    public void run() {
        while(true){
            try {
                timeLbl.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
                dateLbl.setText(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
                studentCountLbl.setText(String.valueOf(studentDao.getStudentCount()));
                teacherCountLbl.setText(String.valueOf(teacherDao.getTeacherCount()));
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UpdateClerkUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UpdateClerkUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
