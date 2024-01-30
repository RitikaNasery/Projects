/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;


import medicalstoremanagement.*;
import UserManagement.*;
import master.*;
import medicalstoremanagement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DB.*;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JPanel;



public class StockReports extends javax.swing.JInternalFrame {


    JFrame frame = new JFrame();
    Connection con;
    String categoryname,dist,productname;
    Dbconn conn;
    String para,mon;
    String parameter1,parameter2;
    public String fromdate,todate;
    private  Date d;
    String distname;
    public StockReports(JFrame parent, boolean modal) {
        initComponents();
        conn=new Dbconn();
//    refreshcategory();
       
      refreshDistributor();
//    refreshproductlist();
 
  // refreshproduct();
    jLabel2.setVisible(false);
   jLabel3.setVisible(false);
     jLabel4.setVisible(false);
     jLabel5.setVisible(false);
     jLabel6.setVisible(false);
 jLabel7.setVisible(false);
jLabel8.setVisible(false);

jcombodistributor.setVisible(false);
jDateChooser1.setVisible(false);
jDateChooser2.setVisible(false);
jDateChooser3.setVisible(false);
jDateChooser4.setVisible(false);
jDateChooser5.setVisible(false);
jDateChooser6.setVisible(false);
jTextField2.setVisible(true);
jTextField2.setEditable(false);
        
    }
    
    public void refreshDistributor()
    {
        try
    {
         con=conn.getConnection();
    Statement st=con.createStatement();
    ResultSet rs;
    rs=conn.execute_query("select DISTINCT (distributors_name) from material_inward_info where Material_Status=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
            
            dist=rs.getString("distributors_name");
            jcombodistributor.addItem(dist);
    
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton_DAMAGESTOCKRPT = new javax.swing.JRadioButton();
        jRadioButton_DATE_DAMAGESTOCK = new javax.swing.JRadioButton();
        jRadioButton_EXPIRYSTOCK = new javax.swing.JRadioButton();
        jRadioButton_DATE_EXPRPT = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton_DIST_MIREPORT = new javax.swing.JRadioButton();
        jcombodistributor = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton_DATE_MIREPORT = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton_MIREPORT = new javax.swing.JRadioButton();
        jRadioButton_PO_MIREPORT = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Stock Reports");
        setToolTipText("");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Stock Report");

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print-icon.png"))); // NOI18N
        jButton1.setText("View & Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup2.add(jRadioButton_DAMAGESTOCKRPT);
        jRadioButton_DAMAGESTOCKRPT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_DAMAGESTOCKRPT.setText("Damage Stock Report");

        buttonGroup2.add(jRadioButton_DATE_DAMAGESTOCK);
        jRadioButton_DATE_DAMAGESTOCK.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_DATE_DAMAGESTOCK.setText("Specific Duration Damage Stock  Report");
        jRadioButton_DATE_DAMAGESTOCK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_DATE_DAMAGESTOCKItemStateChanged(evt);
            }
        });
        jRadioButton_DATE_DAMAGESTOCK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRadioButton_DATE_DAMAGESTOCKFocusLost(evt);
            }
        });

        buttonGroup2.add(jRadioButton_EXPIRYSTOCK);
        jRadioButton_EXPIRYSTOCK.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_EXPIRYSTOCK.setText("Expiry Stock Report");
        jRadioButton_EXPIRYSTOCK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_EXPIRYSTOCKActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton_DATE_EXPRPT);
        jRadioButton_DATE_EXPRPT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_DATE_EXPRPT.setText("Specific Duration Expiry Stock  Report");
        jRadioButton_DATE_EXPRPT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_DATE_EXPRPTItemStateChanged(evt);
            }
        });
        jRadioButton_DATE_EXPRPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_DATE_EXPRPTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("From");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("To");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("From");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("To");

        jPanel3.setPreferredSize(new java.awt.Dimension(336, 100));

        buttonGroup2.add(jRadioButton_DIST_MIREPORT);
        jRadioButton_DIST_MIREPORT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_DIST_MIREPORT.setText("Distributor Wise M I Report");
        jRadioButton_DIST_MIREPORT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_DIST_MIREPORTItemStateChanged(evt);
            }
        });

        jcombodistributor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jcombodistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcombodistributorItemStateChanged(evt);
            }
        });
        jcombodistributor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcombodistributorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton_DIST_MIREPORT)
                    .addComponent(jcombodistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jRadioButton_DIST_MIREPORT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcombodistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        buttonGroup2.add(jRadioButton_DATE_MIREPORT);
        jRadioButton_DATE_MIREPORT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_DATE_MIREPORT.setText("Specific Duration M I Report");
        jRadioButton_DATE_MIREPORT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_DATE_MIREPORTItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("From");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("To");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButton_DATE_MIREPORT)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jRadioButton_DATE_MIREPORT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23))
        );

        buttonGroup2.add(jRadioButton_MIREPORT);
        jRadioButton_MIREPORT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_MIREPORT.setText("Material Inward Report");
        jRadioButton_MIREPORT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_MIREPORTItemStateChanged(evt);
            }
        });
        jRadioButton_MIREPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_MIREPORTActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton_PO_MIREPORT);
        jRadioButton_PO_MIREPORT.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton_PO_MIREPORT.setText("Material Inward Against P.O.");
        jRadioButton_PO_MIREPORT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_PO_MIREPORTItemStateChanged(evt);
            }
        });
        jRadioButton_PO_MIREPORT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton_PO_MIREPORTStateChanged(evt);
            }
        });
        jRadioButton_PO_MIREPORT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButton_PO_MIREPORTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRadioButton_PO_MIREPORTFocusLost(evt);
            }
        });
        jRadioButton_PO_MIREPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_PO_MIREPORTActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("PO Number");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton_MIREPORT)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton_PO_MIREPORT)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton_MIREPORT)
                .addGap(91, 91, 91)
                .addComponent(jRadioButton_PO_MIREPORT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton_DAMAGESTOCKRPT)
                    .addComponent(jRadioButton_EXPIRYSTOCK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jRadioButton_DATE_DAMAGESTOCK))
                            .addGap(68, 68, 68))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jRadioButton_DATE_EXPRPT)
                            .addGap(144, 144, 144)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton_DAMAGESTOCKRPT)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton_DATE_DAMAGESTOCK)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_DATE_EXPRPT)
                    .addComponent(jRadioButton_EXPIRYSTOCK))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(183, 183, 183))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(178, 178, 178))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void setdate()
    {
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
        if(jRadioButton_MIREPORT.isSelected())
{

    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/MaterialInwardReport.jrxml";
    para=null;

    r.generate(filename,para);

}

        
    if(jRadioButton_DAMAGESTOCKRPT.isSelected())
{

    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/DamageStockReport.jrxml";
    para=null;

    r.generate(filename,para);

}      
        
         if(jRadioButton_EXPIRYSTOCK.isSelected())
{

    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/ExpiryProductReoprt.jrxml";
    para=null;

    r.generate(filename,para);

}   
        
         
         //Customised Reports  Specific Po Report
         
         
         
                 if(jRadioButton_PO_MIREPORT.isSelected())
                 {
                     
                     ReportViewwithparam r=new ReportViewwithparam();
    String filename;
    filename="Reports/MaterialInwardReportPO.jrxml";
    if(jTextField2.getText()=="")
    {
       JOptionPane.showMessageDialog(rootPane, "Please select PO Number!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        para=jTextField2.getText();
        r.generate(filename,para);
    }
    }
        
         
         

         
         
         
         
         //Distributor Wise M I Report 
         
if(jRadioButton_DIST_MIREPORT.isSelected())
{
 
    ReportViewwithparam r=new ReportViewwithparam();
    String filename;
    filename="Reports/MateiralInwardDistributorwiseReport.jrxml";
    if("".equals(jcombodistributor.getSelectedItem().toString()))
    {
       JOptionPane.showMessageDialog(rootPane, "Please select Distributor!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        para=jcombodistributor.getSelectedItem().toString();
        r.generate(filename,para);
    }
}

//Specific Duration M I Report

if(jRadioButton_DATE_MIREPORT.isSelected())
{
 
    ReportViewwithtwoparam r=new ReportViewwithtwoparam();
    String filename;
    //Enter file name
    filename="Reports/MateiralInwardDistributorwiseReport.jrxml";
    if((jDateChooser1.getDate().toString()=="")&&(jDateChooser2.getDate().toString()==""))
    {
       JOptionPane.showMessageDialog(rootPane, "Please Enter From And To Date!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {

        String frm[] = jDateChooser1.getDate().toString().split(" ");
            for (int i = 0; i < frm.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(frm[1].equals("Jan")){ mon = "01";}if(frm[1].equals("Feb")){ mon = "02";}
                if(frm[1].equals("Mar")){ mon = "03";}if(frm[1].equals("Apr")){ mon = "04";}
                if(frm[1].equals("May")){ mon = "05";}if(frm[1].equals("Jun")){ mon = "06";}
                if(frm[1].equals("Jul")){ mon = "07";}if(frm[1].equals("Aug")){ mon = "08";}
                if(frm[1].equals("Sep")){ mon = "09";}if(frm[1].equals("Oct")){ mon = "10";}
                if(frm[1].equals("Nov")){ mon = "11";}if(frm[1].equals("Dec")){ mon = "12";}
                  
                fromdate = (frm[5] + "-" +mon+ "-" + frm[2]);
            }
            
            String to[] = jDateChooser2.getDate().toString().split(" ");
            for (int i = 0; i < to.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(to[1].equals("Jan")){ mon = "01";}if(to[1].equals("Feb")){ mon = "02";}
                if(to[1].equals("Mar")){ mon = "03";}if(to[1].equals("Apr")){ mon = "04";}
                if(to[1].equals("May")){ mon = "05";}if(to[1].equals("Jun")){ mon = "06";}
                if(to[1].equals("Jul")){ mon = "07";}if(to[1].equals("Aug")){ mon = "08";}
                if(to[1].equals("Sep")){ mon = "09";}if(to[1].equals("Oct")){ mon = "10";}
                if(to[1].equals("Nov")){ mon = "11";}if(to[1].equals("Dec")){ mon = "12";}
                  
                todate = (to[5] + "-" +mon+ "-" + to[2]);
            }
        

     //   r.generate(filename,fromdate,todate);
            System.out.print(fromdate+"     "+todate);
    }
}
    
   //Specific Duration Damage Stock  Report
    
    if(jRadioButton_DATE_DAMAGESTOCK.isSelected())
{
  //  JOptionPane.showMessageDialog(rootPane, "hi Clicked");
    
 
    ReportViewwithtwoparam re=new ReportViewwithtwoparam();
    
    String filename1;
    //Enter file name
    filename1="Reports/MateiralInwardDistributorwiseReport.jrxml";
    if((jDateChooser3.getDate().toString()=="")&&(jDateChooser4.getDate().toString()==""))
    {
       JOptionPane.showMessageDialog(rootPane, "Please Enter From And To Date!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        String frm[] = jDateChooser3.getDate().toString().split(" ");
            for (int i = 0; i < frm.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(frm[1].equals("Jan")){ mon = "01";}if(frm[1].equals("Feb")){ mon = "02";}
                if(frm[1].equals("Mar")){ mon = "03";}if(frm[1].equals("Apr")){ mon = "04";}
                if(frm[1].equals("May")){ mon = "05";}if(frm[1].equals("Jun")){ mon = "06";}
                if(frm[1].equals("Jul")){ mon = "07";}if(frm[1].equals("Aug")){ mon = "08";}
                if(frm[1].equals("Sep")){ mon = "09";}if(frm[1].equals("Oct")){ mon = "10";}
                if(frm[1].equals("Nov")){ mon = "11";}if(frm[1].equals("Dec")){ mon = "12";}
                  
                fromdate = (frm[5] + "-" +mon+ "-" + frm[2]);
            }
            String to[] = jDateChooser4.getDate().toString().split(" ");
            for (int i = 0; i < to.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(to[1].equals("Jan")){ mon = "01";}if(to[1].equals("Feb")){ mon = "02";}
                if(to[1].equals("Mar")){ mon = "03";}if(to[1].equals("Apr")){ mon = "04";}
                if(to[1].equals("May")){ mon = "05";}if(to[1].equals("Jun")){ mon = "06";}
                if(to[1].equals("Jul")){ mon = "07";}if(to[1].equals("Aug")){ mon = "08";}
                if(to[1].equals("Sep")){ mon = "09";}if(to[1].equals("Oct")){ mon = "10";}
                if(to[1].equals("Nov")){ mon = "11";}if(to[1].equals("Dec")){ mon = "12";}
                  
                todate = (to[5] + "-" +mon+ "-" + to[2]);
            }
        
            //   re.generate(filename,fromdate,todate);
            System.out.print(fromdate+"     "+todate);
    }
    
}




 // Specific Duration Expiry Stock  Report
    if(jRadioButton_DATE_EXPRPT.isSelected())
    {
        
      //  JOptionPane.showMessageDialog(rootPane, "hi Clicked");
        
         ReportViewwithtwoparam re=new ReportViewwithtwoparam();
    String filename1;
    //Enter file name
    filename1="Reports/MateiralInwardDistributorwiseReport.jrxml";
    if((jDateChooser5.getDate().toString()=="")&&(jDateChooser6.getDate().toString()==""))
    {
       JOptionPane.showMessageDialog(rootPane, "Please Enter From And To Date!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        String frm[] = jDateChooser5.getDate().toString().split(" ");
            for (int i = 0; i < frm.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(frm[1].equals("Jan")){ mon = "01";}if(frm[1].equals("Feb")){ mon = "02";}
                if(frm[1].equals("Mar")){ mon = "03";}if(frm[1].equals("Apr")){ mon = "04";}
                if(frm[1].equals("May")){ mon = "05";}if(frm[1].equals("Jun")){ mon = "06";}
                if(frm[1].equals("Jul")){ mon = "07";}if(frm[1].equals("Aug")){ mon = "08";}
                if(frm[1].equals("Sep")){ mon = "09";}if(frm[1].equals("Oct")){ mon = "10";}
                if(frm[1].equals("Nov")){ mon = "11";}if(frm[1].equals("Dec")){ mon = "12";}
                  
                fromdate = (frm[5] + "-" +mon+ "-" + frm[2]);
            }
            String to[] = jDateChooser6.getDate().toString().split(" ");
            for (int i = 0; i < to.length; i++) {
                //  System.out.println(dob[i]+" "+i);
                if(to[1].equals("Jan")){ mon = "01";}if(to[1].equals("Feb")){ mon = "02";}
                if(to[1].equals("Mar")){ mon = "03";}if(to[1].equals("Apr")){ mon = "04";}
                if(to[1].equals("May")){ mon = "05";}if(to[1].equals("Jun")){ mon = "06";}
                if(to[1].equals("Jul")){ mon = "07";}if(to[1].equals("Aug")){ mon = "08";}
                if(to[1].equals("Sep")){ mon = "09";}if(to[1].equals("Oct")){ mon = "10";}
                if(to[1].equals("Nov")){ mon = "11";}if(to[1].equals("Dec")){ mon = "12";}
                  
                todate = (to[5] + "-" +mon+ "-" + to[2]);
            }
        
            //   re.generate(filename,fromdate,todate);
            System.out.print(fromdate+"     "+todate);
    }
    
    }
    
    
    
    



    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton_PO_MIREPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_PO_MIREPORTActionPerformed

    }//GEN-LAST:event_jRadioButton_PO_MIREPORTActionPerformed

    private void jRadioButton_PO_MIREPORTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton_PO_MIREPORTFocusLost
        //      jTextField1.setVisible(false);  // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_PO_MIREPORTFocusLost

    private void jRadioButton_PO_MIREPORTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton_PO_MIREPORTFocusGained

    }//GEN-LAST:event_jRadioButton_PO_MIREPORTFocusGained

    private void jRadioButton_PO_MIREPORTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton_PO_MIREPORTStateChanged
        // TODO add your handling code here:
        jTextField2.setEditable(true);
        if(jRadioButton_PO_MIREPORT.isSelected())
        {
            para=jTextField2.getText();

        }
        if(!(jRadioButton_PO_MIREPORT.isSelected()))
        {
            jTextField2.setText("");
            jTextField2.setEditable(false);

        }

    }//GEN-LAST:event_jRadioButton_PO_MIREPORTStateChanged

    private void jRadioButton_PO_MIREPORTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_PO_MIREPORTItemStateChanged

    }//GEN-LAST:event_jRadioButton_PO_MIREPORTItemStateChanged

    private void jRadioButton_MIREPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_MIREPORTActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_MIREPORTActionPerformed

    private void jRadioButton_MIREPORTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_MIREPORTItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_MIREPORTItemStateChanged

    private void jRadioButton_DATE_MIREPORTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_DATE_MIREPORTItemStateChanged
        if(jRadioButton_DATE_MIREPORT.isSelected())
        {
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jDateChooser1.setVisible(true);
            jDateChooser2.setVisible(true);
        }
        if(!(jRadioButton_DATE_MIREPORT.isSelected()))
        {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser2.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DATE_MIREPORTItemStateChanged

    private void jcombodistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcombodistributorItemStateChanged

    }//GEN-LAST:event_jcombodistributorItemStateChanged

    private void jRadioButton_DIST_MIREPORTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_DIST_MIREPORTItemStateChanged
        if(jRadioButton_DIST_MIREPORT.isSelected())
        {
            jcombodistributor.setVisible(true);
        }

        if(!(jRadioButton_DIST_MIREPORT.isSelected()))
        {
            jcombodistributor.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DIST_MIREPORTItemStateChanged

    private void jRadioButton_DATE_EXPRPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_DATE_EXPRPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DATE_EXPRPTActionPerformed

    private void jRadioButton_DATE_EXPRPTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_DATE_EXPRPTItemStateChanged
        if(jRadioButton_DATE_EXPRPT.isSelected())
        {
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jDateChooser5.setVisible(true);
            jDateChooser6.setVisible(true);
        }
        if(!(jRadioButton_DATE_EXPRPT.isSelected()))
        {
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jDateChooser5.setVisible(false);
            jDateChooser6.setVisible(false);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DATE_EXPRPTItemStateChanged

    private void jRadioButton_DATE_DAMAGESTOCKFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton_DATE_DAMAGESTOCKFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DATE_DAMAGESTOCKFocusLost

    private void jRadioButton_DATE_DAMAGESTOCKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_DATE_DAMAGESTOCKItemStateChanged

        if(jRadioButton_DATE_DAMAGESTOCK.isSelected())
        {
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jDateChooser3.setVisible(true);
            jDateChooser4.setVisible(true);
        }
        if(!(jRadioButton_DATE_DAMAGESTOCK.isSelected()))
        {
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jDateChooser3.setVisible(false);
            jDateChooser4.setVisible(false);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_DATE_DAMAGESTOCKItemStateChanged

    private void jcombodistributorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcombodistributorPopupMenuWillBecomeInvisible
distname=jcombodistributor.getSelectedItem().toString();
// TODO add your handling code here:
    }//GEN-LAST:event_jcombodistributorPopupMenuWillBecomeInvisible

    private void jRadioButton_EXPIRYSTOCKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_EXPIRYSTOCKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_EXPIRYSTOCKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton_DAMAGESTOCKRPT;
    private javax.swing.JRadioButton jRadioButton_DATE_DAMAGESTOCK;
    private javax.swing.JRadioButton jRadioButton_DATE_EXPRPT;
    private javax.swing.JRadioButton jRadioButton_DATE_MIREPORT;
    private javax.swing.JRadioButton jRadioButton_DIST_MIREPORT;
    private javax.swing.JRadioButton jRadioButton_EXPIRYSTOCK;
    private javax.swing.JRadioButton jRadioButton_MIREPORT;
    private javax.swing.JRadioButton jRadioButton_PO_MIREPORT;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox jcombodistributor;
    // End of variables declaration//GEN-END:variables
}
