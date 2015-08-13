package malith.ui;


import chanaka.dao.StudentDAO;
import chanaka.data.Student;
import chanaka.gui.AddOrEditStudent;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import common.DbConnector;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



/**
 *
 * @author Malith - malith.13@cse.mrt.ac.lk
 */
public class StudentViewer extends javax.swing.JFrame {

    DbConnector dbConnector;
    StudentDAO studentDAO;

    /**
     * Creates new form ContactsBook
     */
    public StudentViewer(int accessPriviledge) {
     
        initComponents();

        try {
            // create the central DAO
            dbConnector = new DbConnector();
            // make a DAO for Student class by sending in the DB Connection from dbConnector
            studentDAO = new StudentDAO(dbConnector.getMyConn());

        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(StudentViewer.this, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
         switch (accessPriviledge) {
            case (1): // if a clerk has logged in        
            case (2): // if the principal has logged in
                  
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        btnNewContact.setText("Add New Student");
        btnNewContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewContactActionPerformed(evt);
            }
        });

        btnUpdateContact.setText("Update Student");
        btnUpdateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateContactActionPerformed(evt);
            }
        });

        btnDeleteContact.setText("Delete Student");
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(comboPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSearch)
                            .addGap(5, 5, 5))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            List<Student> student = null;

            // Call DAO and get students relevent to the "searchpara"
            if (keyWord != null && keyWord.trim().length() > 0) {
                student = studentDAO.searchStudent(keyWord, searchPara);
            } else {
                // If last name is empty, then get all employees
                student = studentDAO.getAllStudent();
            }

            // create the model and update the "table"
            StudentTableModel model = new StudentTableModel(student);
            table.setModel(model);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(StudentViewer.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewContactActionPerformed
        new AddOrEditStudent(studentDAO).setVisible(true);

    }//GEN-LAST:event_btnNewContactActionPerformed

    private void btnUpdateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateContactActionPerformed
        // get the selected row
        int row = table.getSelectedRow();

        //make sure a row is selected
        if (row < 0) {
            JOptionPane.showMessageDialog(StudentViewer.this, "You must select a student first!", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // get the selected current Student
        Student tempStudent = (Student) table.getValueAt(row, StudentTableModel.OBJECT_COL);
        
        new AddOrEditStudent(studentDAO, tempStudent).setVisible(true);
        

    }//GEN-LAST:event_btnUpdateContactActionPerformed

    private void btnDeleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteContactActionPerformed
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "You must select a student", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int response = JOptionPane.showConfirmDialog(rootPane, "This will delete this Contact!!!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response != JOptionPane.YES_OPTION) {
            return;
        }
        Student tempStudent = (Student) table.getValueAt(row, StudentTableModel.OBJECT_COL);
        try {
            studentDAO.deleteStudent(tempStudent.getAdmissionNumber());
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshGUI();
        JOptionPane.showMessageDialog(StudentViewer.this, "Student deleted successfully", "Student deleted", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDeleteContactActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed


    }//GEN-LAST:event_tableMousePressed

    /**
     * method will refresh the GUI showing the latest update on the table
     *
     */
    public void refreshGUI() {
        try {
            // get all student theough the DAO to a tempory List
            List studentList = studentDAO.getAllStudent();

            // create the model and update the "table"
            StudentTableModel model = new StudentTableModel(studentList);
            table.setModel(model);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(StudentViewer.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
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
                new StudentViewer(2).setVisible(true);
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