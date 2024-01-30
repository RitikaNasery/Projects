/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Purchase;

import DB.*;
import Stock.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import master.*;

/**
 *
 * @author user
 */
public class PurchaseReturn extends javax.swing.JInternalFrame {

    Dbconn conn;
     Connection con;
     int selectedRow;
     String desc;
     int selectedrow,row;
     DefaultTableModel modelItem,modalItem1,modalItemprod;
    ResultSet rs_purchasereturn;
    String grno,grndate,distname,productname,damagestock,reason,returnqty;
    String productid,prodname,qty,mfgdate,expdate,prnno,prntype;
    int rowcount, colcount ;
    private String error;
    int valid=0, k=0;;
     
    public PurchaseReturn(JFrame parent, boolean modal) {
        initComponents();
        modelItem=(DefaultTableModel)jpurchasereturntable.getModel();
       modalItem1=(DefaultTableModel) jexpirytable.getModel();
       modalItemprod=(DefaultTableModel)jTable2.getModel();
        conn=new Dbconn();
          show_date();
          increament();
    }

    public void show_date()
    {
    Calendar c1=new GregorianCalendar();
      
     int month=c1.get(Calendar.MONTH);
        int day=c1.get(Calendar.DAY_OF_MONTH);
        int year=c1.get(Calendar.YEAR);
      jpurchasereturndate.setText(year+"/"+(month+1)+"/"+day);
        
    }
    
      public void increament()
    {
        int x;
        String grx = null;
        ResultSet rs_grno;
        Dbconn conn = new Dbconn();
        rs_grno = conn.execute_query("Select MAX(prn_number) from purchase_return where status=?", new String[]{"ACTIVE"});
        try {
            while(rs_grno.next())
            {
               //System.out.println(rs_grno.getString("MAX(GR_no)"));
                grx = rs_grno.getString("MAX(prn_number)");
                if(grx==null)
                {
                    grx="0";
                }
             }
            x=Integer.parseInt(grx);
            x=x+1;
            grx=""+x;
            jpurchasereturnno.setText(grx);
        } catch (SQLException ex) {
            Logger.getLogger(Materialinward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from damage_stock where GR_number="+cellvalue);
            while(rs.next())
            {
   
                jpurchasegrno.setText(rs.getString("GR_number"));
                jpurchasegrndate.setText(rs.getString("GRN_Date"));
                jpurchasereturndistname.setText(rs.getString("Distributor_Name"));

             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }          

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpurchasereturndistname = new javax.swing.JTextField();
        jpurchasereturndate = new javax.swing.JTextField();
        jpurchasereturnno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpurchasegrno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jpurchasegrndate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpurchasereturntable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jexpirytable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Jpurchasereturntype = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("PurchaseReturn");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Date");

        jpurchasereturndistname.setEditable(false);

        jpurchasereturnno.setToolTipText("Enter Invoice Number");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Purchase Return No");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("GRN no");

        jpurchasegrno.setEditable(false);
        jpurchasegrno.setToolTipText("Enter Invoice Number");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("GRN Date");

        jpurchasegrndate.setEditable(false);
        jpurchasegrndate.setToolTipText("Enter Invoice Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jpurchasereturndistname, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jpurchasereturnno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jpurchasegrno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpurchasegrndate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jpurchasereturndate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jpurchasereturnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jpurchasegrno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jpurchasegrndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jpurchasereturndistname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jpurchasereturndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Purchase Return");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordered Qty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jpurchasereturntable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jpurchasereturntable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN_No", "GRN Date", "Distributor Name", "Product Name", "DamageStock", "Reason"
            }
        ));
        jpurchasereturntable.getTableHeader().setReorderingAllowed(false);
        jpurchasereturntable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpurchasereturntableMouseClicked(evt);
            }
        });
        jpurchasereturntable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpurchasereturntableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jpurchasereturntable);

        jexpirytable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jexpirytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expiry Product No", "Product_name", "Quantity", "mgf_date", "Expiry_date"
            }
        ));
        jexpirytable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jexpirytable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane2.setViewportView(jTextArea1);

        jTable2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Qty", "Reason"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);

        Jpurchasereturntype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Expired Stock", "Damaged Stock" }));
        Jpurchasereturntype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JpurchasereturntypeFocusLost(evt);
            }
        });
        Jpurchasereturntype.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                JpurchasereturntypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Type");

        jLabel2.setText("Description");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton5.setText("Remove");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leftaddarrow.png"))); // NOI18N
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(Jpurchasereturntype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5)
                                .addComponent(jButton6))))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jpurchasereturntype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(26, 26, 26)
                                .addComponent(jButton5)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JpurchasereturntypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_JpurchasereturntypePopupMenuWillBecomeInvisible
// TODO add your handling code here:
              modalItem1.setRowCount(0);
     modelItem.setRowCount(0);
if(Jpurchasereturntype.getSelectedIndex()==2)
{

                  rs_purchasereturn=conn.execute_query("select * from damage_stock where status=?", new String[]{"ACTIVE"});

        try
        {
          while(rs_purchasereturn.next())
          {
         
           grno =   rs_purchasereturn.getString("GR_number");
           grndate=   rs_purchasereturn.getString("GRN_Date");
           distname =  rs_purchasereturn.getString("Distributor_Name");
           productname  = rs_purchasereturn.getString("product_name");
           damagestock =  rs_purchasereturn.getString("damage_stock");
           reason  = rs_purchasereturn.getString("Reason");
         
           
           modelItem.addRow(new String[]{grno,grndate,distname,productname,damagestock,reason});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
}
if(Jpurchasereturntype.getSelectedIndex()==1)
{
    modelItem.setRowCount(0);
    modalItem1.setRowCount(0);
                  rs_purchasereturn=conn.execute_query("select * from expiry_info where Expiry_Status=?", new String[]{"ACTIVE"});
        
        try
        {
          while(rs_purchasereturn.next())
          {
           productid =   rs_purchasereturn.getString("Expiry_product_id");
           prodname=   rs_purchasereturn.getString("Product_name");
           qty =  rs_purchasereturn.getString("Quantity");
           mfgdate  = rs_purchasereturn.getString("Quantity");
           expdate =  rs_purchasereturn.getString("Expiry_date");
          // reason  = rs_purchasereturn.getString("Reason");
           modalItem1.addRow(new String[]{grno,grndate,distname,productname,damagestock,reason});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

}
    }//GEN-LAST:event_JpurchasereturntypePopupMenuWillBecomeInvisible

    
    public void refreshTable()
    {
           modalItemprod.setRowCount(0);
           ResultSet rs;
             rs=conn.execute_query("select * from distributors_details where distributors_status=?", new String[]{"ACTIVE"});
             try
        {
          while(rs.next())
          {
         
           prodname =   rs.getString("product_name");
          returnqty =   rs.getString("damage_stock");

           modelItem.addRow(new String[]{prodname,returnqty});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
    
    private void JpurchasereturntypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JpurchasereturntypeFocusLost
        // TODO add your handling code here:
   
        
    }//GEN-LAST:event_JpurchasereturntypeFocusLost

    private void jpurchasereturntableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpurchasereturntableMouseClicked
     if (evt.getClickCount() == 1)  
                {  
                   //  String selectedData = null;  
                   JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
        // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasereturntableMouseClicked
    }
    private void jpurchasereturntableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpurchasereturntableKeyReleased


// TODO add your handling code here:
    }//GEN-LAST:event_jpurchasereturntableKeyReleased
public void valid()
{
    error="";
    if(jpurchasereturnno.getText().equals(""))
            {
              error +="\n"+" Purchase Return Number Should Not Empty..";
              valid=1;
            }
    if(jpurchasegrno.getText().equals(""))
            {
              error +="\n"+" GRN Number Should Not Empty..";
              valid=1;
                
            }
    if(jpurchasegrndate.getText().equals(""))
            {
              error +="\n"+" Purchase GRN Date  Should Not Empty..";
              valid=1;
                
            }
    if(jpurchasereturndistname.getText().equals(""))
            {
              error +="\n"+" Distributor Name Should Not Empty..";
              valid=1;
                
            }
    if(jpurchasereturndate.getText().equals(""))
            {
              error +="\n"+" Purchase Return Date Should Not Empty..";
              valid=1;
                
            }
    
    
    
    
    
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
valid();
        
        
        
   
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error",JOptionPane.ERROR_MESSAGE);
        }
        
        int a;
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to save Data","Confirm", JOptionPane.YES_NO_OPTION);
            System.out.println(a);
            
            if(a==0) 
        {
            conn=new Dbconn();
        String pno,pdate,did,dname,dadd,dofficeno,dmobno,demailid,dproductid,dproduproductname,dproductcategory,dproductorderqty,dproducttotalamount,postatus;
        
        int r,c;
          r=jTable2.getRowCount();
          c=jTable2.getColumnCount();
//                JOptionPane.showMessageDialog(rootPane, r, "Rows",JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(rootPane, c, "Columns", JOptionPane.ERROR_MESSAGE);
//       
        for(int row=0; row<r;row++)
        {
                      
           prnno=jpurchasereturnno.getText();
        prntype=Jpurchasereturntype.getSelectedItem().toString();
        grno=jpurchasegrno.getText();
        grndate=jpurchasegrndate.getText();
        distname=jpurchasereturndistname.getText();
        prodname=(String)jTable2.getValueAt(row,0);
        qty=(String)jTable2.getValueAt(row, 1);
        desc=jTextArea1.getText();
       // reason=(String)jTable2.getValueAt(row, 3);
        //desc=jTextArea1.getText();
           System.out.println(prnno+" "+prntype+" "+grno+" "+grndate+" "+distname+" "+prodname+" "+qty+" "+reason+" "+desc );
         
            Dbconn co=new Dbconn();
           con=co.getConnection();
           
            String query = "INSERT INTO purchase_return(prn_number, prntype, "
                    + "GRN_number,grndate,distributorname,"
        + " product_name, qty, description, reason, status) "
        + " VALUES(?, ?, ?, ?, ?, ?, ?, ?,?,?)" ;
            String status="ACTIVE";
           try
           {
                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1, prnno);
                pst.setString(2, prntype);
                pst.setString(3, grno);
                pst.setString(4, grndate);
                pst.setString(5, distname);
                pst.setString(6, prodname);
                pst.setString(7, qty);
                pst.setString(8, desc);
                pst.setString(9, reason);
               pst.setString(10, status);
                k=pst.executeUpdate();
               
           }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
         }

        }
        }
                 
             if(k>0)
        {
        JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Data Not Saved", "Warning!", JOptionPane.ERROR_MESSAGE);
      }
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      rowcount = jpurchasereturntable.getSelectedRow();
          colcount = jpurchasereturntable.getSelectedColumn();
        String a,b,c,d;
//           for(row=0;row<=rowcount;row++)          //  row_count =1
//        {
                try
                {                                          
                        a = (String) jpurchasereturntable.getValueAt(row, 3);
                        b = (String) jpurchasereturntable.getValueAt(row, 4);
                        c = (String) jpurchasereturntable.getValueAt(row, 5);
                        
                       // int n =JOptionPane.showConfirmDialog(rootPane, "Aru you sure? \n You want to save Data?", "Confirm!", JOptionPane.YES_NO_OPTION);
                       
                       // conn = new Dbconn();
                        modalItemprod=(DefaultTableModel)jTable2.getModel();
                        //modelItem.setRowCount(index);
                        try
                        {
                              modalItemprod.addRow(new String[]{a,b,c});
                              //index++;
                                      
                        }
                
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
                        
                        
                }       
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(rootPane, e,"Error", JOptionPane.ERROR_MESSAGE);
                }
//           }
        
// TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Jpurchasereturntype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable jexpirytable;
    private javax.swing.JTextField jpurchasegrndate;
    private javax.swing.JTextField jpurchasegrno;
    private javax.swing.JTextField jpurchasereturndate;
    private javax.swing.JTextField jpurchasereturndistname;
    private javax.swing.JTextField jpurchasereturnno;
    private javax.swing.JTable jpurchasereturntable;
    // End of variables declaration//GEN-END:variables
}
