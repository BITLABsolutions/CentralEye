/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamin.gui;

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
class UpdateOtherUi implements Runnable {
    JLabel timeLbl,dateLbl,teacherCountLbl,studentCountLbl;
    TeacherDAO teacherDao;
    StudentDAO studentDao;
    
    public UpdateOtherUi(JLabel timeLbl,JLabel dateLbl) {
        this.timeLbl=timeLbl;
        this.dateLbl=dateLbl;
        
    }

    @Override
    public void run() {
        while(true){
            timeLbl.setText(new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
            dateLbl.setText(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdateOtherUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
