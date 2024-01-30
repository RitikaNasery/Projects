/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;


import DB.*;
import UserManagement.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import master.*;
import medicalstoremanagement.*;


/**
 *
 * @author user
 */
public class ExpiryStock extends javax.swing.JInternalFrame {

   
    
    DefaultTableModel model;
    ResultSet rs_expiry;
    Dbconn conn;
    String a,b,c,d,e,f,g;
    int row,col,rowcount=0,colcount=0,index=0,row1;
    DefaultTableModel modelItem;
    ResultSet rs_material,rs_prod;
    int selectedrow;
    String pro_name,qty,mfg_dt,expdt,error;
    String avlstkstr,expstkstr,totalstkstr,prodnm;
    int valid, availstk,expstk,totalstk;
    public Connection con;
    int flag;
    
    
    JFrame frame = new JFrame();
    public ExpiryStock(JFrame parent, boolean modal) {
        initComponents();
        
//        //*************** Accesing product Details from tables ***********************
        
        model = (DefaultTableModel) jexpiry_ProductTable.getModel();
        model.setRowCount(0);
       
        //**************** Initialise Expinry Number *********************
        
       
        increament();
        refreshtable();
        //****************************************************************
      
                
    }

    public void refreshtable()
    {
         model = (DefaultTableModel) jexpiry_ProductTable.getModel();
        model.setRowCount(0);
        
        
          conn = new Dbconn();
        rs_material=conn.execute_query("select * from product_info where productstatus=?",new String[]{"ACTIVE"});
        try {
            while(rs_material.next())
            {
                pro_name= rs_material.getString("product_name");
                qty = rs_material.getString("totalstock");
                mfg_dt= rs_material.getString("product_manfdate");
                expdt = rs_material.getString("product_expdate");
                modelItem=(DefaultTableModel)jexpiry_ProductTable.getModel();
                modelItem.addRow(new String[]{pro_name,qty,mfg_dt,expdt});
            }
           // conn = new Dbconn();
            
            try
            {

                 
                           
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jexpiry_ProductTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jexpiry_ExpiryTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jexpiry_addbtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jexpiry_removeBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jexpiry_FinishBtn = new javax.swing.JButton();
        jexpiry_ClearBtn = new javax.swing.JButton();
        jexpiry_backbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jexpiry_numbertxt = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Expiry Stock");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 575));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Expiry Stock");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Stock"));

        jexpiry_ProductTable.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jexpiry_ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Quantity", "Mfg. Date.", "Expiry Date"
            }
        ));
        jexpiry_ProductTable.setToolTipText("Product Table");
        jexpiry_ProductTable.getTableHeader().setReorderingAllowed(false);
        jexpiry_ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jexpiry_ProductTableMouseClicked(evt);
            }
        });
        jexpiry_ProductTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jexpiry_ProductTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jexpiry_ProductTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jexpiry_ProductTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(742, 742, 742))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Purachase return"));

        jexpiry_ExpiryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Mfg. Date", "Expiry Date"
            }
        ));
        jexpiry_ExpiryTable.getTableHeader().setReorderingAllowed(false);
        jexpiry_ExpiryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jexpiry_ExpiryTableMouseClicked(evt);
            }
        });
        jexpiry_ExpiryTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jexpiry_ExpiryTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jexpiry_ExpiryTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jexpiry_ExpiryTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Add / Remove"));

        jexpiry_addbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jexpiry_addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add to card.png"))); // NOI18N
        jexpiry_addbtn.setText("ADD");
        jexpiry_addbtn.setToolTipText("Add Product to Return Stock");
        jexpiry_addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexpiry_addbtnActionPerformed(evt);
            }
        });

        jexpiry_removeBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jexpiry_removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jexpiry_removeBtn.setText("REMOVE");
        jexpiry_removeBtn.setToolTipText("Remove From Purchase Retun");
        jexpiry_removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexpiry_removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jexpiry_removeBtn)
                    .addComponent(jexpiry_addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jexpiry_addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jexpiry_removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Go to Purchase Return"));

        jexpiry_FinishBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jexpiry_FinishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Select-icon.png"))); // NOI18N
        jexpiry_FinishBtn.setText("SAVE & FINISH");
        jexpiry_FinishBtn.setToolTipText("Save the Data");
        jexpiry_FinishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexpiry_FinishBtnActionPerformed(evt);
            }
        });

        jexpiry_ClearBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jexpiry_ClearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jexpiry_ClearBtn.setText("CLEAR");
        jexpiry_ClearBtn.setToolTipText("Clear All Data in Purchase return Table");
        jexpiry_ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexpiry_ClearBtnActionPerformed(evt);
            }
        });

        jexpiry_backbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jexpiry_backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jexpiry_backbtn.setText("Back");
        jexpiry_backbtn.setToolTipText("Back to Main Index");
        jexpiry_backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexpiry_backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jexpiry_FinishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jexpiry_ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jexpiry_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jexpiry_ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jexpiry_FinishBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jexpiry_backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Expiry Stock Number :");

        jexpiry_numbertxt.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jexpiry_numbertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jexpiry_numbertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(522, 522, 522)
                        .addComponent(jLabel1)
                        .addGap(220, 220, 220))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void increament()
    {
         int x;
        String grx = null;
        ResultSet rs_grno;
        Dbconn conn = new Dbconn();
        rs_grno = conn.execute_query("Select MAX(Expiry_product_id) from expiry_info where Expiry_Status=?", new String[]{"ACTIVE"});
        try {
            while(rs_grno.next())
            {
               //System.out.println(rs_grno.getString("MAX(GR_no)"));
                grx = rs_grno.getString("MAX(Expiry_product_id)");
                if(grx==null)
                {
                    grx="0";
                }
             }
            x=Integer.parseInt(grx);
            x=x+1;
            grx=""+x;
            jexpiry_numbertxt.setText(grx);
        } catch (SQLException ex) {
            Logger.getLogger(Materialinward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    private void jexpiry_ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexpiry_ClearBtnActionPerformed

        model = (DefaultTableModel) jexpiry_ExpiryTable.getModel();
        model.setRowCount(0);
        index=0;

// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ClearBtnActionPerformed

    private void jexpiry_backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexpiry_backbtnActionPerformed
     this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_backbtnActionPerformed
   
    private void jexpiry_FinishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexpiry_FinishBtnActionPerformed

       //******************* Validation OF the Form********************
        
        error="";
        valid=0;
        flag=1;
        if(jexpiry_numbertxt.getText().equals(""))
        {
            error+="\n"+"Please Entr Expiry Number";
            valid=1;
        }
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int yesorNo;
            yesorNo=  JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(yesorNo == 0)
            {
            //************************************************************
            conn=new Dbconn();
            String prod_name,qty,mfgDate,ExpDate,expNum,exp_Status;
            int k=0;
            int r,c;
            r=jexpiry_ExpiryTable.getRowCount();
            c=jexpiry_ExpiryTable.getColumnCount();
         //   JOptionPane.showMessageDialog(rootPane, r, "Rows",JOptionPane.ERROR_MESSAGE);
          //  JOptionPane.showMessageDialog(rootPane, c, "Columns", JOptionPane.ERROR_MESSAGE);
       
            for(int row=0; row<r;row++)
            {
                expNum = jexpiry_numbertxt.getText();
                prod_name=(String) jexpiry_ExpiryTable.getValueAt(row, 0); //  dofficeno=dist_officeno;
                qty = (String) jexpiry_ExpiryTable.getValueAt(row, 1);
                mfgDate = (String) jexpiry_ExpiryTable.getValueAt(row,2);
                ExpDate = (String) jexpiry_ExpiryTable.getValueAt(row, 3);
                exp_Status = "ACTIVE";
                
              
                Dbconn co=new Dbconn();
                con=co.getConnection();
           
                String query = "INSERT INTO expiry_info (Expiry_product_id,Product_name,Quantity,mgf_date,Expiry_date,Expiry_Status)"
                + " VALUES( ?, ?, ?, ?, ?, ?) ";
                String status="ACTIVE";
                try
                {
                    PreparedStatement pst=con.prepareStatement(query);
                    pst.setString(1, expNum);
                    pst.setString(2, prod_name);
                    pst.setString(3, qty);
                    pst.setString(4, mfgDate);
                    pst.setString(5, ExpDate);
                    pst.setString(6, exp_Status);
                
                    k=pst.executeUpdate();
                    
                    //********** Updation of the stock ****************
                    
                    try
                               {
                                    Dbconn coon = new Dbconn();
                                    //con = coon.getConnection();
                                    int r12=jexpiry_ExpiryTable.getRowCount();
                                    int c12=jexpiry_ExpiryTable.getColumnCount();
                                    String mi_totalstock,mi_prod_name;
                                    prodnm = (String) jexpiry_ExpiryTable.getValueAt(row, 0);
                                    expstkstr = (String) jexpiry_ExpiryTable.getValueAt(row, 1);
                                    
                                    Dbconn donn = new Dbconn();
                                    rs_prod = donn.execute_query("select * from product_info where product_name=? ", new String[]{prodnm});
                                    while(rs_prod.next())
                                    {
                                        avlstkstr = rs_prod.getString("totalstock");
                                    }
                                    availstk = Integer.parseInt(avlstkstr);
                                    expstk = Integer.parseInt(expstkstr);
                                    
                                    totalstk = availstk - expstk;
                                    totalstkstr =""+totalstk;
                                    
                                    System.out.println("Avail stk ="+availstk+"   expstk="+expstk+"    finalstk="+totalstk+""  );
                                    
                                    if(expstk>availstk)
                                    {
                                        JOptionPane.showMessageDialog(rootPane, "Expired Stock should not be more than Available stock", "Error", JOptionPane.ERROR_MESSAGE);
                                        flag=0;
                                        break;
                                    }
                                    
                                    
                                    for(int row12=0;row12<=r12;row12++)
                                    {
                
                                        int i = coon.update_data("update product_info SET totalstock =?"
                                        +" where product_name=?" , new String[]{totalstkstr,prodnm});
                                        if(i>0)
                                        {
                                            //JOptionPane.showMessageDialog(rootPane, "Rows Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        else
                                        {
                                            // JOptionPane.showMessageDialog(rootPane, "Not Saved", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }   
            
               
                                }
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
                                }
                    
                    
                    //************* End of the sstock updation**************
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(k>0)
                {
                    if(row==r-1)
                    {
                    JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Data Not Saved", "Warning!", JOptionPane.YES_NO_OPTION);
                }
            }
            if(flag!=0)
            {
            modelItem = (DefaultTableModel) jexpiry_ExpiryTable.getModel();
            modelItem.setRowCount(0);
            }
            increament();
            refreshtable();
        }
        }
//        else
//        {
//                }
    }//GEN-LAST:event_jexpiry_FinishBtnActionPerformed

    private void jexpiry_ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jexpiry_ProductTableMouseClicked

        if(evt.getClickCount()==1)
        {
            JTable target = (JTable) evt.getSource();
            selectedrow = target.getSelectedRow();
            Object selectedcellvalue = target.getValueAt(selectedrow, 0);
            row=selectedrow;
//            jdamage_totalstocktxt.setText((String) selectedcellvalue);
//             selectedcellvalue = target.getValueAt(selectedrow, 0);
//          jdamage_productnametxt.setText((String) selectedcellvalue);
           // refreshForm(selectedcellvalue);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ProductTableMouseClicked

    private void jexpiry_ProductTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jexpiry_ProductTableKeyPressed

         JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);
      row=selectedrow;
      //jdamage_totalstocktxt.setText(selectedCellValue.toString());
       //selectedCellValue = target.getValueAt(selectedrow, 0);
        //  jdamage_productnametxt.setText((String) selectedCellValue);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ProductTableKeyPressed

    private void jexpiry_ProductTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jexpiry_ProductTableKeyReleased

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row=selectedrow;
//          jdamage_totalstocktxt.setText((String) selectedCellValue);
//          selectedCellValue = target.getValueAt(selectedrow, 0);
//          jdamage_productnametxt.setText((String) selectedCellValue);
    }// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ProductTableKeyReleased

    private void jexpiry_removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexpiry_removeBtnActionPerformed

        try
        {
          rowcount = jexpiry_ExpiryTable.getSelectedRow();
          colcount = jexpiry_ExpiryTable.getSelectedColumn();
        if(rowcount==-1)
        {
            JOptionPane.showMessageDialog(rootPane, "There Is no Row to select", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {          
          modelItem=(DefaultTableModel)jexpiry_ExpiryTable.getModel();
          modelItem.removeRow(row1);
        }
        }
        catch(Exception e)
        {
           // JOptionPane.showMessageDialog(rootPane, "Select the row From Expiry Table...","Error.....", JOptionPane.INFORMATION_MESSAGE);
        }
          
     
    }//GEN-LAST:event_jexpiry_removeBtnActionPerformed

    private void jexpiry_ExpiryTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jexpiry_ExpiryTableKeyPressed

         JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);
      row1=selectedrow;
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ExpiryTableKeyPressed

    private void jexpiry_ExpiryTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jexpiry_ExpiryTableKeyReleased
JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row1=selectedrow;
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ExpiryTableKeyReleased

    private void jexpiry_ExpiryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jexpiry_ExpiryTableMouseClicked

        if(evt.getClickCount()==1)
        {
            JTable target = (JTable) evt.getSource();
            selectedrow = target.getSelectedRow();
            Object selectedcellvalue = target.getValueAt(selectedrow, 0);
            row1=selectedrow;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_ExpiryTableMouseClicked

    private void jexpiry_addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexpiry_addbtnActionPerformed

        rowcount = jexpiry_ProductTable.getSelectedRow();
        colcount = jexpiry_ProductTable.getSelectedColumn();

        //           for(row=0;row<=rowcount;row++)          //  row_count =1
        //        {
            try
            {
                a = (String) jexpiry_ProductTable.getValueAt(row, 0);
                b = (String) jexpiry_ProductTable.getValueAt(row, 1);
                c = (String) jexpiry_ProductTable.getValueAt(row, 2);
                d = (String) jexpiry_ProductTable.getValueAt(row, 3);
                //                        e = (String) jexpiry_ProductTable.getValueAt(row, 4);
                //                        f = (String) jexpiry_ProductTable.getValueAt(row, 5);
                //                        g = (String) jexpiry_ProductTable.getValueAt(row, 6);

                // int n =JOptionPane.showConfirmDialog(rootPane, "Aru you sure? \n You want to save Data?", "Confirm!", JOptionPane.YES_NO_OPTION);

                conn = new Dbconn();
                modelItem=(DefaultTableModel)jexpiry_ExpiryTable.getModel();
                //modelItem.setRowCount(index);
                try
                {
                    modelItem.addRow(new String[]{a,b,c,d});
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
            //                }
        //                //INSERT INTO `medicalstore`.`expiry_info` (`Expiry_product_id`, `Gr_number`, `Gr_date`, `Product_name`, `Quantity`, `mgf_date`, `Expiry_date`, `Expiry_Status`) VALUES ('1', '2', '2014-04-01', 'Tablet', '10', '2014-04-02', '2014-04-03', 'Active');
        //                //NSERT INTO table the columns of rownumber and then execute the query

        //            }
        //        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jexpiry_addbtnActionPerformed

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jexpiry_ClearBtn;
    private javax.swing.JTable jexpiry_ExpiryTable;
    private javax.swing.JButton jexpiry_FinishBtn;
    private javax.swing.JTable jexpiry_ProductTable;
    private javax.swing.JButton jexpiry_addbtn;
    private javax.swing.JButton jexpiry_backbtn;
    private javax.swing.JTextField jexpiry_numbertxt;
    private javax.swing.JButton jexpiry_removeBtn;
    // End of variables declaration//GEN-END:variables
}
