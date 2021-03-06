package malith.ui;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import common.DbConnector;
import static java.awt.image.ImageObserver.WIDTH;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import prabath.dao.TeacherDAO;
import prabath.data.Teacher;
import prabath.ui.AddTeacher;

/**
 *
 * @author Malith - malith.13@cse.mrt.ac.lk
 */
public class TeacherViewer extends javax.swing.JFrame {

    DbConnector dbConnector;
    TeacherDAO teacherDAO;

    /**
     * Creates new form ContactsBook
     */
    public TeacherViewer(int accessPriviledge) {

        initComponents();

        try {
            // create the central DAO
            dbConnector = new DbConnector();
            // make a DAO for Teacher class by sending in the DB Connection from dbConnector
            teacherDAO = new TeacherDAO(dbConnector.getMyConn());

        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(TeacherViewer.this, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        switch (accessPriviledge) {
            case (1): // if the principal has logged in
            case (2): // if a clerk has logged in        

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNewContact = new javax.swing.JButton();
        btnUpdateContact = new javax.swing.JButton();
        btnDeleteContact = new javax.swing.JButton();
        comboPara = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQuickPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Central Eye");

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Last Name", "Malith", "NIC", "Account No"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Search by");

        btnNewContact.setText("Add New Teacher");
        btnNewContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewContactActionPerformed(evt);
            }
        });

        btnUpdateContact.setText("Update Teacher");
        btnUpdateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateContactActionPerformed(evt);
            }
        });

        btnDeleteContact.setText("Delete Teacher");
        btnDeleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewContact, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateContact, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteContact)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewContact)
                    .addComponent(btnUpdateContact)
                    .addComponent(btnDeleteContact))
                .addContainerGap())
        );

        comboPara.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "NIC", "RNo", "All" }));

        txtQuickPane.setEditable(false);
        txtQuickPane.setContentType("text/html"); // NOI18N
        txtQuickPane.setToolTipText("");
        jScrollPane2.setViewportView(txtQuickPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(comboPara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(comboPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        try {
            // Get keyWord to search from the text field
            String keyWord = txtSearch.getText();
            // get what to search from combo box
            String searchPara = comboPara.getSelectedItem().toString();

            List<Teacher> teacher = null;

            // Call DAO and get teachers relevent to the "searchpara"
            if (keyWord != null && keyWord.trim().length() > 0) {
                teacher = teacherDAO.searchTeacher(keyWord, searchPara);
            } else {
                // If last name is empty, then get all employees
                teacher = teacherDAO.getAllTeacher();
            }
            // when there is no search results to show, clear the table
            if (teacher.isEmpty()) {
                String[] columnNames = {"Last Name", "First Name", "NIC", "Account No"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                table.setModel(model);
                return;
            }

            // create the model and update the "table"
            TeacherTableModel model = new TeacherTableModel(teacher);
            table.setModel(model);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(TeacherViewer.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewContactActionPerformed
        new AddTeacher(this, rootPaneCheckingEnabled, teacherDAO, false, null, this).setVisible(true);

    }//GEN-LAST:event_btnNewContactActionPerformed

    private void btnUpdateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateContactActionPerformed
        // get the selected row
        int row = table.getSelectedRow();

        //make sure a row is selected
        if (row < 0) {
            JOptionPane.showMessageDialog(TeacherViewer.this, "You must select a teacher first!", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // get the selected current Teacher
        Teacher tempTeacher = (Teacher) table.getValueAt(row, TeacherTableModel.OBJECT_COL);

        new AddTeacher(this, rootPaneCheckingEnabled, teacherDAO, true, tempTeacher, this).setVisible(true);

    }//GEN-LAST:event_btnUpdateContactActionPerformed

    private void btnDeleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteContactActionPerformed
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "You must select a teacher", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int response = JOptionPane.showConfirmDialog(rootPane, "This will delete this Contact!!!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response != JOptionPane.YES_OPTION) {
            return;
        }
        Teacher tempTeacher = (Teacher) table.getValueAt(row, TeacherTableModel.OBJECT_COL);
        try {
            teacherDAO.deleteTeacher(tempTeacher.getNIC());
        } catch (SQLException ex) {
            Logger.getLogger(TeacherViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshGUI();
        JOptionPane.showMessageDialog(TeacherViewer.this, "Teacher deleted successfully", "Teacher deleted", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDeleteContactActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed


    }//GEN-LAST:event_tableMousePressed

    /**
     * method will refresh the GUI showing the latest update on the table
     *
     */
    public void refreshGUI() {
        try {
            // get all teacher theough the DAO to a tempory List
            List teacherList = teacherDAO.getAllTeacher();

            // create the model and update the "table"
            TeacherTableModel model = new TeacherTableModel(teacherList);
            table.setModel(model);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(TeacherViewer.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
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

        //</editor-fold>
        try {
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherViewer(2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteContact;
    private javax.swing.JButton btnNewContact;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateContact;
    private javax.swing.JComboBox comboPara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JEditorPane txtQuickPane;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
