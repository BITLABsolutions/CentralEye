/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malith.login.ui;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import common.DAO;
import common.DbConnector;
import common.User;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import malith.login.core.Clerk;
import malith.login.dao.ClerkDAO;
import prabath.dao.TeacherDAO;
import prabath.data.Teacher;
import prabath.ui.ClerkHomeMenu;

/**
 *
 * @author Malith
 */
public class Login extends javax.swing.JFrame {

    Connection myConn;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        try {
            myConn = new DbConnector().getMyConn();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbUserType = new javax.swing.JComboBox();
        pfield = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Central Eye Login");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblID.setText("ID");

        jLabel2.setText("Password");

        jLabel3.setText("User Type");

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Principle", "Clerk", "Teacher In Charge", "Teacher", "Student" }));
        cmbUserType.setSelectedItem(null);
        cmbUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserTypeActionPerformed(evt);
            }
        });
        cmbUserType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbUserTypePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserID, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(pfield)))
                    .addComponent(cmbUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        performUserLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbUserTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbUserTypePropertyChange

    }//GEN-LAST:event_cmbUserTypePropertyChange

    private void cmbUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserTypeActionPerformed
        int index = cmbUserType.getSelectedIndex() + 1;
        setLbl(index);
    }//GEN-LAST:event_cmbUserTypeActionPerformed
    private void performUserLogin() {

        try {

            // check whether a user type is selected
            if (cmbUserType.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "You must select a user type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // get the user type
            String userType = cmbUserType.getSelectedItem().toString();

            //get the user ID
            String userId = txtUserID.getText();

            // get the password
            String plainTextPassword = new String(pfield.getPassword());

            /* switch between these users
             Principle
             Clerk
             Teacher In Charge
             Teacher
             Student
             */
            switch (userType) {
                case "Principle":

                    break;
                case "Clerk":
                    ClerkDAO clerkDAO = new ClerkDAO(myConn);

                    // get the relevent user from the db according to the user ID
                    Clerk logingClerk = clerkDAO.searchClerk(userId);
                    // set password in the tempory object
                    logingClerk.setPassword(plainTextPassword);
                    // check the password and login
                    loginAuthenticate(clerkDAO, logingClerk);
                    break;
                case "Teacher In Charge":
                    break;
                case "Teacher":
                    break;
                case "Student":

            }

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error during login", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loginAuthenticate(DAO dao, User logingUser) {
        try {
            // check the user's password against the encrypted version in the database
            boolean isValidPassword = dao.authenticate(logingUser);

            if (isValidPassword) {
                // get the accessPriviledge 
                int accessPriviledge = logingUser.getAccessPriviledge();
                System.out.println("user ID " + logingUser.getId() + " accessPriviledge " + accessPriviledge + " name " + logingUser.getPassword());

                // hide the login window
                setVisible(false);
                switch (accessPriviledge) {
                    case 1:
                        //  new PrincipalHome(DbConnector)
                        break;
                    case 2:
                        new ClerkHomeMenu(this, true).setVisible(true);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:

                }

            } else {
                // show error message
                JOptionPane.showMessageDialog(this, "Invalid login", "Invalid Login",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setLbl(int index) {

        if (index == 1 || index == 2 || index == 3 || index == 4) {
            lblID.setText("NIC Number");
        } else {
            lblID.setText("Admission Number");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox cmbUserType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblID;
    private javax.swing.JPasswordField pfield;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
