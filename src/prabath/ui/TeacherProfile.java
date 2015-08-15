/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prabath.ui;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import prabath.dao.DbConnector;
import prabath.dao.TeacherDAO;
import prabath.data.Teacher;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import malith.ui.TeacherViewer;

/**
 *
 * @author prabath s
 */
public class TeacherProfile extends javax.swing.JDialog {

    /**
     * Creates new form AddTeacher1
     */
    DefaultTableModel tm;
    DbConnector dbConnector;
    TeacherDAO teacherDAO;
    AddService addService;
    ManageTables manageTables1;
    ManageTables manageTables2;
    SubjectsAndClasses subjectsAndClasses;
    
    
    boolean updateMode;
    Teacher selectedTeacher;
    String previousNIC;

    // default constructor
    public TeacherProfile(java.awt.Frame parent, boolean modal) {
    }

    public TeacherProfile( java.awt.Frame parent, boolean modal, TeacherDAO teacherDAO, Teacher selectedTeacher) {
        
        super(parent, modal);
        initComponents();
        //populateGUI(selectedTeacher);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
        // bDayDateChooser.setDateFormat(df1);
        //this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
        this.setSize(dim.width, dim.height - 35);
        jScrollPane1.setSize(dim.width, dim.height - 35);
        nameWithInTxt.setEditable(false);
        nicTxt.setEditable(false);
        fullNameTxt.setEditable(false);
                
       
        this.teacherDAO = teacherDAO;
        
        this.selectedTeacher = selectedTeacher;

        addService = new AddService(parent, modal);
        manageTables1 = new ManageTables(addService.getTable(), 5, 10);
        subjectsAndClasses = new SubjectsAndClasses(parent, modal);
        manageTables2 = new ManageTables(subjectsAndClasses.getTable(), 2, 10);
        wrning1.setVisible(false);
        wrning2.setVisible(false);
        wrning3.setVisible(false);
        saveBtn.setEnabled(false);
        if (updateMode) {
            setTitle("Update Teacher");
            //call the method to populate gui with current teacher details
            populateGUI(selectedTeacher);
            previousNIC = selectedTeacher.getNIC();
        }
        this.setVisible(true);
    }
    
    
    
    public void populateGUI(Teacher teacher) {
       
         //get data from teacher object and set them in GUI
         nicTxt.setText(teacher.getNIC());
         idTxt.setText(teacher.getRNo());
         nameWithInTxt.setText(teacher.getNameWithin());
         fullNameTxt.setText(teacher.getFullName());
         if(teacher.getGender().equals("female")){femaleRadioBtn.setSelected(true);}
         else{maleRadioBtn.setSelected(true);}
         dobDateChooser.setDate(new java.util.Date(teacher.getDob().getTime()));
         civilCbox.setSelectedItem(teacher.getCivilStatus());
         addressTxt.setText(teacher.getAddress());
         mobileTelTxt.setText(teacher.getTelNoMobile());
         recidentTelNo.setText(teacher.getTelNoRecident());
         if(teacher.getDateOfAssignAsTeacher()!=null){doaDateChooser.setDate(new java.util.Date(teacher.getDateOfAssignAsTeacher().getTime()));}
         if(teacher.getDateOfAssignToSchool()!=null){dosDateChooser.setDate(new java.util.Date(teacher.getDateOfAssignToSchool().getTime()));}
         if(teacher.getDateOfPromotion()!=null){doaDateChooser.setDate(new java.util.Date(teacher.getDateOfPromotion().getTime()));}
         eQualTxt.setText(teacher.getEducationQual());
         pQualTxt.setText(teacher.getProfessionalQual());
         if(!teacher.getSubjectsAndClasses().equals("")){manageTables2.loadToTable(teacher.getSubjectsAndClasses());}
         subjectWishToTeachTxt.setText(teacher.getSubjectsWishToTeach());
         gradesWishToTeachTxt.setText(teacher.getGradesWishToTeach());
         natureCbox.setSelectedItem(teacher.getNatureOfPresentPost());
         grdTxt.setText(teacher.getGradeOfService());
         sectionCbox.setSelectedItem(teacher.getSectionTaught());
         if(!teacher.getServiceRecord().equals("")){manageTables1.loadToTable(teacher.getServiceRecord());}
         positionTxt.setText(teacher.getPositionInSchool());
                 
         
         
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fullNameTxt = new javax.swing.JTextField();
        maleRadioBtn = new javax.swing.JRadioButton();
        femaleRadioBtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nicTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        civilCbox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mobileTelTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eQualTxt = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pQualTxt = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        grdTxt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        positionTxt = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        sectionCbox = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        add1Btn = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        recidentTelNo = new javax.swing.JTextField();
        dobDateChooser = new com.toedter.calendar.JDateChooser();
        doaDateChooser = new com.toedter.calendar.JDateChooser();
        dosDateChooser = new com.toedter.calendar.JDateChooser();
        dopDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        subjectWishToTeachTxt = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        gradesWishToTeachTxt = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        natureCbox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        wrning1 = new javax.swing.JLabel();
        wrning2 = new javax.swing.JLabel();
        wrning3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        nameWithInTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("My Profile");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Name with initials:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Full name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Gender");

        fullNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fullNameTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fullNameTxtFocusLost(evt);
            }
        });
        fullNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fullNameTxtMousePressed(evt);
            }
        });

        maleRadioBtn.setText("Male");
        maleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioBtnActionPerformed(evt);
            }
        });

        femaleRadioBtn.setText("Female");
        femaleRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Date of birth:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("NIC:");

        nicTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nicTxtFocusLost(evt);
            }
        });
        nicTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nicTxtMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Civil Status:");

        civilCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not given", "Unmarried", "Married" }));
        civilCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                civilCboxActionPerformed(evt);
            }
        });
        civilCbox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                civilCboxPropertyChange(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Private Address:");

        addressTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressTxtKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Telephone no:");

        mobileTelTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileTelTxtKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Date of appoinment as a teacher:");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Date of appoinment in this school:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Educational qualifications:");

        eQualTxt.setColumns(20);
        eQualTxt.setRows(5);
        eQualTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eQualTxtKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(eQualTxt);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setText("Proffessional qualifications:");

        pQualTxt.setColumns(20);
        pQualTxt.setRows(5);
        pQualTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pQualTxtKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(pQualTxt);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Grade of teaching service:");

        grdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grdTxtActionPerformed(evt);
            }
        });
        grdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grdTxtKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Date promoted to that grade:");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Position held in scohool:");

        positionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                positionTxtKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setText("Section taught:");

        sectionCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not given", "Primary", "O/L", "A/L" }));
        sectionCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionCboxActionPerformed(evt);
            }
        });
        sectionCbox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sectionCboxPropertyChange(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("Service record:");

        add1Btn.setText("Add");
        add1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1BtnActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setText("Teacher Id");

        idTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTxtKeyTyped(evt);
            }
        });

        saveBtn.setText("Save changes");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel15.setText("Mobile:");

        jLabel19.setText("Recident:");

        recidentTelNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                recidentTelNoKeyTyped(evt);
            }
        });

        dobDateChooser.setDateFormatString("dd/MM/yyyy");
        dobDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dobDateChooserPropertyChange(evt);
            }
        });

        doaDateChooser.setDateFormatString("dd/MM/yyyy");
        doaDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                doaDateChooserPropertyChange(evt);
            }
        });

        dosDateChooser.setDateFormatString("dd/MM/yyyy");
        dosDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dosDateChooserPropertyChange(evt);
            }
        });

        dopDateChooser.setDateFormatString("dd/MM/yyyy");
        dopDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dopDateChooserPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Subjects and classes:");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Subjects wish to teach:");

        subjectWishToTeachTxt.setColumns(20);
        subjectWishToTeachTxt.setRows(5);
        subjectWishToTeachTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subjectWishToTeachTxtKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(subjectWishToTeachTxt);

        gradesWishToTeachTxt.setColumns(20);
        gradesWishToTeachTxt.setRows(5);
        gradesWishToTeachTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gradesWishToTeachTxtKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(gradesWishToTeachTxt);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Nature of current position:");

        natureCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Graduated", "Trained" }));
        natureCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                natureCboxActionPerformed(evt);
            }
        });
        natureCbox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                natureCboxPropertyChange(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Grades wish to teach:");

        wrning1.setBackground(new java.awt.Color(255, 255, 255));
        wrning1.setForeground(new java.awt.Color(204, 0, 0));
        wrning1.setText("You need administration permission to change this ");

        wrning2.setBackground(new java.awt.Color(255, 255, 255));
        wrning2.setForeground(new java.awt.Color(204, 0, 0));
        wrning2.setText("You need administration permission to change this ");

        wrning3.setBackground(new java.awt.Color(255, 255, 255));
        wrning3.setForeground(new java.awt.Color(204, 0, 0));
        wrning3.setText("You need administration permission to change this ");

        jButton2.setText("Go Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nameWithInTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameWithInTxtFocusLost(evt);
            }
        });
        nameWithInTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameWithInTxtMousePressed(evt);
            }
        });
        nameWithInTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameWithInTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14))
                .addGap(185, 185, 185)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(idTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(natureCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(344, 344, 344))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addGap(18, 18, 18)))
                            .addComponent(saveBtn))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add1Btn, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(maleRadioBtn)
                        .addGap(80, 80, 80)
                        .addComponent(femaleRadioBtn))
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(civilCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobileTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recidentTelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(nicTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                            .addComponent(wrning3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nameWithInTxt)
                                .addComponent(fullNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(wrning2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(wrning1, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addComponent(dobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dosDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(doaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dopDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 227, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(608, 608, 608))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel6))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel2)
                                                    .addComponent(wrning1)
                                                    .addComponent(nameWithInTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(fullNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(wrning2))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(maleRadioBtn)
                                                    .addComponent(femaleRadioBtn))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(dobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(nicTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(wrning3))
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel10)
                                                    .addComponent(civilCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel11)
                                                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel12)
                                                    .addComponent(mobileTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel19)
                                                    .addComponent(recidentTelNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel13))
                                            .addComponent(doaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25)
                                            .addComponent(dosDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel28)
                                            .addComponent(grdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel29))
                                    .addComponent(dopDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(positionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sectionCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35)
                                    .addComponent(add1Btn))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(natureCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        int k = 0;
        int r = 0;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        //bDayDateChooser.se
        //String a=df.format(dobDateChooser.getDate());
        //System.out.println(dobDateChooser.getDate());
        //jDateChooser2.setDate(jDateChooser1.getDate());
        java.util.Date u = new java.util.Date();
        u=dobDateChooser.getDate();
        java.sql.Date d=new java.sql.Date(u.getTime());
        System.out.println("Sql date:"+d);
        java.util.Date ua=new java.util.Date(d.getTime());
        //String aa=df.format(ua);
        System.out.println("util date:"+ua);
        if (nameWithInTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Name with initials must be given");
            k = 1;
        } else if (fullNameTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Fullname must be given");
            k = 1;
        } else if (!maleRadioBtn.isSelected()) {
            if (!femaleRadioBtn.isSelected()) {
                JOptionPane.showMessageDialog(this, "Gender should be selected");
                k = 1;
            }
        } else if (maleRadioBtn.isSelected() && femaleRadioBtn.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please only select one gender");
            k = 1;
        } else if (nicTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "NIC must be given");
            k = 1;
        } else if (idTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Teacher ID must be given");
            k = 1;
        } else if (!mobileTelTxt.getText().equals("")) {
            System.out.println("inside:" + mobileTelTxt.getText().length());

            try {
                Integer.parseInt(mobileTelTxt.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid mobile telephone number");
                k = 1;
            }
            if (mobileTelTxt.getText().length() != 10) {
                System.out.println("inside if:" + mobileTelTxt.getText().length());
                JOptionPane.showMessageDialog(this, "Invalid mobile telephone number");
                k = 1;
            }

        } else if (!recidentTelNo.getText().equals("")) {
            System.out.println("inside recident");
            try {
                Integer.parseInt(recidentTelNo.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid mobile telephone number");
                k = 1;
            }
            if (recidentTelNo.getText().length() != 10) {

                JOptionPane.showMessageDialog(this, "Invalid mobile telephone number");
                k = 1;
            }

        } else if (nicTxt.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Invalid NIC");
            k = 1;
        } else if (r == 0) {
            try {
                Date a = new java.sql.Date(dobDateChooser.getDate().getTime());
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Date of birth should be given");
                k = 1;
            }
        }

        if (k == 0) {
            //java.sql.Date sqldate1=new java.sql.Date(new java.util.Date().getDate());
            String serviceRecordStr = null;
            String subjectsAndClassesStr = null;
            System.out.println("inside 1");
            if (manageTables1.getK() == 1) {
                serviceRecordStr = manageTables1.encodeDataFormTable();
            }
            if (manageTables2.getK() == 1) {
                subjectsAndClassesStr = manageTables2.encodeDataFormTable();
            }

            Date dateOfAssignmentAsTeacher = null;
            try {
                dateOfAssignmentAsTeacher = new java.sql.Date(doaDateChooser.getDate().getTime());
            } catch (NullPointerException e) {
            }

            Date dateOfAssignmentToSchool = null;
            try {
                dateOfAssignmentToSchool = new java.sql.Date(dosDateChooser.getDate().getTime());
            } catch (NullPointerException e) {
            }

            Date dateOfPromotion = null;
            try {
                dateOfPromotion = new java.sql.Date(dopDateChooser.getDate().getTime());
            } catch (NullPointerException e) {
            }
            String nameWithIn = nameWithInTxt.getText();
            String fullName = fullNameTxt.getText();
            String rNo = idTxt.getText();
            String gender = getTheGender(maleRadioBtn, femaleRadioBtn);
            Date dob = new java.sql.Date(dobDateChooser.getDate().getTime());
            String nic = nicTxt.getText();
            String civilStates = civilCbox.getSelectedItem().toString();
            String address = addressTxt.getText();
            System.out.println("in");
            String telNoMobile = mobileTelTxt.getText();
            System.out.println(telNoMobile);
            String telNoRecident = recidentTelNo.getText();
            // Date dateOfAssignmentAsTeacher = new java.sql.Date(doaDateChooser.getDate().getTime());
            // Date dateOfAssignmentToSchool = new java.sql.Date(dosDateChooser.getDate().getTime());
            String educationalQual = eQualTxt.getText();
            String proffessionalQual = pQualTxt.getText();
            String subjectsWishToTeach = subjectWishToTeachTxt.getText();
            String gradesWishToTeach = gradesWishToTeachTxt.getText();
            String natureOfPresentPossition = natureCbox.getSelectedItem().toString();
            String gradeOfService = grdTxt.getText();
            // Date dateOfPromotion = new java.sql.Date(dopDateChooser.getDate().getTime());
            String sectionTaught = sectionCbox.getSelectedItem().toString();
            String positionInSchool = positionTxt.getText();

            Teacher tempTeacher = selectedTeacher;
            
               

                
                 // this should be optimizes to select from only updated fields...
                 tempTeacher.setNameWithin(nameWithIn);
                 tempTeacher.setFullName(fullName);
                 tempTeacher.setRNo(rNo);
                 tempTeacher.setGender(gender);
                 tempTeacher.setDob(dob);
                 tempTeacher.setNIC(nic);
                 tempTeacher.setCivilStatus(civilStates);
                 tempTeacher.setAddress(address);
                 tempTeacher.setTelNoMobile(telNoMobile);
                 tempTeacher.setTelNoRecident(telNoRecident);
                 tempTeacher.setEducationQual(educationalQual);
                 tempTeacher.setProfessionalQual(proffessionalQual);
                 tempTeacher.setSubjectsWishToTeach(subjectsWishToTeach);
                 tempTeacher.setGradesWishToTeach(gradesWishToTeach);
                 tempTeacher.setNatureOfPresentPost(natureOfPresentPossition);
                 tempTeacher.setGradeOfService(gradeOfService);
                 tempTeacher.setSectionTaught(sectionTaught);
                 tempTeacher.setPositionInSchool(positionInSchool);
                 tempTeacher.setServiceRecord(serviceRecordStr);
                 tempTeacher.setSubjectsAndClasses(subjectsAndClassesStr);
                 tempTeacher.setDateOfAssignAsTeacher(dateOfAssignmentAsTeacher);
                 tempTeacher.setDateOfAssignToSchool(dateOfAssignmentToSchool);
                 tempTeacher.setDateOfPromotion(dateOfPromotion);
                 
                
            

            try {

                
                    teacherDAO.updateTeacher(tempTeacher, previousNIC);
                

                //close addNewContact dialog
                setVisible(false);
                dispose();
                
                //refersh GUI
                
                
                // show success message
                JOptionPane.showMessageDialog(null, "Changes are saved successfully");

            } catch (SQLException ex) {
                Logger.getLogger(TeacherProfile.class.getName()).log(Level.SEVERE, null, ex);
            }

            k = 0;
            
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    
    private void add1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1BtnActionPerformed
        // TODO add your handling code here:

        //AddService a = new AddService(new javax.swing.JFrame(), true);
        addService.setVisible(true);
        manageTables1.setK();
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }

        System.out.println("pressed");
    }//GEN-LAST:event_add1BtnActionPerformed

    private void grdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grdTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //SubjectsAndClasses a = new SubjectsAndClasses(new javax.swing.JFrame(), true);
        subjectsAndClasses.setVisible(true);
        manageTables2.setK();
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fullNameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullNameTxtFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fullNameTxtFocusGained

                                   

    
    
    private void fullNameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullNameTxtFocusLost
        // TODO add your handling code here:
        wrning2.setVisible(false);
    }//GEN-LAST:event_fullNameTxtFocusLost

    private void fullNameTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullNameTxtMousePressed
        // TODO add your handling code here:
        wrning2.setVisible(true);
    }//GEN-LAST:event_fullNameTxtMousePressed

    private void nicTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nicTxtMousePressed
        // TODO add your handling code here:
        wrning3.setVisible(true);
    }//GEN-LAST:event_nicTxtMousePressed

    private void nicTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nicTxtFocusLost
        // TODO add your handling code here:
        wrning3.setVisible(false);
    }//GEN-LAST:event_nicTxtFocusLost

    private void maleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioBtnActionPerformed
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_maleRadioBtnActionPerformed

    private void femaleRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioBtnActionPerformed
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_femaleRadioBtnActionPerformed

    private void dobDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dobDateChooserPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_dobDateChooserPropertyChange

    private void civilCboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_civilCboxPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_civilCboxPropertyChange

    private void addressTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_addressTxtKeyTyped

    private void mobileTelTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileTelTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_mobileTelTxtKeyTyped

    private void recidentTelNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recidentTelNoKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_recidentTelNoKeyTyped

    private void doaDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_doaDateChooserPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_doaDateChooserPropertyChange

    private void dosDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dosDateChooserPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_dosDateChooserPropertyChange

    private void eQualTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eQualTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_eQualTxtKeyTyped

    private void pQualTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pQualTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_pQualTxtKeyTyped

    private void grdTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grdTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_grdTxtKeyTyped

    private void dopDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dopDateChooserPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_dopDateChooserPropertyChange

    private void positionTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_positionTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_positionTxtKeyTyped

    private void sectionCboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sectionCboxPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_sectionCboxPropertyChange

    private void idTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_idTxtKeyTyped

    private void subjectWishToTeachTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectWishToTeachTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_subjectWishToTeachTxtKeyTyped

    private void gradesWishToTeachTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradesWishToTeachTxtKeyTyped
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_gradesWishToTeachTxtKeyTyped

    private void natureCboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_natureCboxPropertyChange
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_natureCboxPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sectionCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionCboxActionPerformed
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_sectionCboxActionPerformed

    private void natureCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_natureCboxActionPerformed
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_natureCboxActionPerformed

    private void civilCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_civilCboxActionPerformed
        // TODO add your handling code here:
        if(!saveBtn.isEnabled()){
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_civilCboxActionPerformed

    private void nameWithInTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameWithInTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameWithInTxtActionPerformed

    private void nameWithInTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameWithInTxtMousePressed
        // TODO add your handling code here:
        wrning1.setVisible(true);
    }//GEN-LAST:event_nameWithInTxtMousePressed

    private void nameWithInTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameWithInTxtFocusLost
        // TODO add your handling code here:
        wrning1.setVisible(false);
    }//GEN-LAST:event_nameWithInTxtFocusLost

    public String getTheDate(JComboBox year, JComboBox mnt, JComboBox date) {
        String s = "";
        s = year.getSelectedItem().toString() + mnt.getSelectedItem().toString() + date.getSelectedItem().toString();
        System.out.println(s);
        //bDayDateChooser.getSelectedDate().toString();
        return s;
    }

    public String getTheGender(JRadioButton male, JRadioButton female) {
        String s = "";
        if (male.isSelected()) {
            s = "male";
        } else if (female.isSelected()) {
            s = "female";
        }
        return s;
    }
//populate GUI with a given person object

   
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TeacherProfile dialog = new TeacherProfile(new javax.swing.JFrame(), true);
               
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1Btn;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JComboBox civilCbox;
    private com.toedter.calendar.JDateChooser doaDateChooser;
    private com.toedter.calendar.JDateChooser dobDateChooser;
    private com.toedter.calendar.JDateChooser dopDateChooser;
    private com.toedter.calendar.JDateChooser dosDateChooser;
    private javax.swing.JTextArea eQualTxt;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JTextArea gradesWishToTeachTxt;
    private javax.swing.JTextField grdTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JTextField mobileTelTxt;
    private javax.swing.JTextField nameWithInTxt;
    private javax.swing.JComboBox natureCbox;
    private javax.swing.JTextField nicTxt;
    private javax.swing.JTextArea pQualTxt;
    private javax.swing.JTextField positionTxt;
    private javax.swing.JTextField recidentTelNo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox sectionCbox;
    private javax.swing.JTextArea subjectWishToTeachTxt;
    private javax.swing.JLabel wrning1;
    private javax.swing.JLabel wrning2;
    private javax.swing.JLabel wrning3;
    // End of variables declaration//GEN-END:variables
}
