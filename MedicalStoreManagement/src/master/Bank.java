/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;


import DB.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;
import java.sql.Statement;


public class Bank extends javax.swing.JInternalFrame {

   DefaultTableModel modelItem;
    JFrame frame = new JFrame();
    Dbconn conn;
    String bankid;
   
    public Connection con; 
    String error="";
    int valid=0;
    String bankname,bankaddress,acctype,accno,micrcode,ifsccode,openingbalance;
    int selectedRow;
    
    
    public Bank(JFrame parent, boolean modal) {
        initComponents();
         modelItem=(DefaultTableModel)jBanktable.getModel();
          refreshTable();
          jbankid.setVisible(false);
        
    }
   
     public void refreshTable()
    {
         
        modelItem.setRowCount(0);
        try
        {
            conn=new Dbconn();
            
             ResultSet rs=conn.execute_query("select * from bank_info where status=?", new String[]{"ACTIVE"});
          while(rs.next())
          {
                bankid=rs.getString("bank_id");
            bankname=rs.getString("bank_name");
            bankaddress=rs.getString("bank_address");
            acctype=rs.getString("account_type");
            accno=rs.getString("account_no");
             micrcode=rs.getString("micr_code");
             ifsccode=rs.getString("ifsc_code");
            openingbalance=rs.getString("opening_balance");
         
          
         
         modelItem.addRow(new String[]{bankid,bankname, bankaddress, acctype, accno, micrcode,ifsccode,openingbalance});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
           
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
            rs=st.executeQuery("select * from bank_info where bank_id="+cellvalue);
            while(rs.next())
            {
                
                jbankid.setText(rs.getString("bank_id"));
                jbankname.setText(rs.getString("bank_name"));
                jbankaddress.setText(rs.getString("bank_address"));
                jbankaccounttype.setSelectedItem(rs.getString("account_type"));
                jbankaccountnumber.setText(rs.getString("account_no"));
                jbankmicr.setText(rs.getString("micr_code"));
                jbankifsccode.setText(rs.getString("ifsc_code"));
                jbankOpeningbalance.setText(rs.getString("opening_balance"));
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jBanktable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbankname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbankaccounttype = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbankaddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jbankaccountnumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbankOpeningbalance = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbankmicr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jbankifsccode = new javax.swing.JTextField();
        jbankid = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Bank Details");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("BankAcounts"));

        jBanktable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jBanktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bank Id", "BankName", "Address", "Acc.Type", "Acc.No", "MICR code", "IFSC", "OpeningBalance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jBanktable.setAlignmentX(0.6F);
        jBanktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBanktableMouseClicked(evt);
            }
        });
        jBanktable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBanktableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBanktableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jBanktable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(33, 33, 33)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jbankname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbankname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jbanknameFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Account Type");

        jbankaccounttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Saving", "Current", "Recurring" }));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Address");

        jbankaddress.setColumns(20);
        jbankaddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbankaddress.setRows(5);
        jbankaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jbankaddressFocusLost(evt);
            }
        });
        jbankaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbankaddressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jbankaddress);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Account No");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Opening Balance");

        jbankOpeningbalance.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbankOpeningbalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbankOpeningbalanceKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("MICR Code");

        jbankmicr.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("IFSC Code");

        jbankifsccode.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jbankid.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbankid.setText("Account Type");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbankOpeningbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbankname, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbankid))
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel4)
                                        .addGap(29, 29, 29)
                                        .addComponent(jbankaccounttype, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbankaccountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jbankmicr, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbankifsccode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jbankaccounttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbankid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jbankname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jbankaccountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jbankmicr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jbankifsccode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jbankOpeningbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Bank");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(562, 562, 562)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void valid()
{
    error="";
    if(jbankname.getText().equals(""))
    {
        error +="\n"+"Please Enter Bank Name";
        valid=1;
    }
    if(jbankifsccode.getText().equals(""))
    {
        error +="\n"+"Please Enter Bank IFSC Code!";
        valid=1;
    }
    if(jbankaccounttype.getSelectedIndex()==0)
    {
        error +="\n"+" Please Enter Account Type";
        valid=1;
    }
    if(jbankmicr.getText().equals(""))
        
    {
        error +="\n"+" Please Enter MICR Code";
        valid=1;
    }
    if(jbankaccountnumber.getText().equals(""))
    {
        error +="\n"+" Please Enter Account Number!";
        valid=1;
    }
    if(jbankOpeningbalance.getText().equals(""))
    {
        error +="\n"+" Enter Opening Balance";
        valid=1;
    }
    if(jbankaddress.getText().equals(""))
    {
         error +="\n"+" Enter Bank Address";
         valid=1;
    }

}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    valid();
    conn=new Dbconn();
    int i=0;
    if(valid==1)
    
       {
        JOptionPane.showMessageDialog(rootPane, error, "Error",JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        int a=1;
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to save Data","Confirm", JOptionPane.YES_NO_OPTION);
     
        }
         if(a==0)
             {
            i=conn.insert_data("insert into bank_info(bank_name,bank_address,"
                + "account_type,account_no,micr_code,"
                + "ifsc_code,opening_balance,status)values (?,?,?,?,?,?,?,?)", new String[]
                {jbankname.getText(),jbankaddress.getText(),jbankaccounttype.getSelectedItem().toString(),
                    jbankaccountnumber.getText(),jbankmicr.getText(),jbankifsccode.getText(),
                    jbankOpeningbalance.getText(),"ACTIVE"});
    }
         if(a>0)
         {
        JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
             
         }
        if (i > 0) 
        {
    
              JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
           refreshTable();
           
           clear();
           
        } 
       else 
    {
        
        JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
           }
             }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        
           this.dispose();        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
public void clear()
        
{  
    jbankname.setText("");
       jbankaddress.setText("");
       jbankaccountnumber.setText("");
       jbankifsccode.setText("");
       jbankmicr.setText("");
       jbankOpeningbalance.setText("");
jbankaccounttype.setSelectedIndex(0);
    
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   clear();
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBanktableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBanktableKeyPressed
 JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
  
     
     
    
// TODO add your handling code here:
    }//GEN-LAST:event_jBanktableKeyPressed

    private void jBanktableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBanktableKeyReleased
 JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
     
  
// TODO add your handling code here:
    }//GEN-LAST:event_jBanktableKeyReleased

    private void jBanktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBanktableMouseClicked
       if(evt.getClickCount()==1)
        {
            JTable target=(JTable)evt.getSource();
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
        
    
// TODO add your handling code here:
    }//GEN-LAST:event_jBanktableMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
valid();
if(valid==1)
{
    JOptionPane.showMessageDialog(rootPane, error, "Error!", JOptionPane.ERROR_MESSAGE);
}
        else
    {
       
      int a=JOptionPane.showConfirmDialog(rootPane, "Do Your Want to Delete This Bank !", "Confirm", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
      try
        {
        conn=new Dbconn();
    int i = conn.update_data("update bank_info SET status =?"
                                        +" where bank_id=?" , new String[]{"DEACTIVE",jbankid.getText()});
         if(i>0)
         {
        JOptionPane.showMessageDialog(rootPane, "Bank Deleted Sucessfully", "Deleted! ", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
        clear();
         }
         else
         {
              JOptionPane.showMessageDialog(rootPane, "Problem In Delete!!", "Error! ", JOptionPane.ERROR_MESSAGE);
  
         }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, "Contact To Service Provider", "Error! ", JOptionPane.ERROR_MESSAGE);
        }
        }
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         refreshTable();
           
           clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbanknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbanknameFocusLost
String temp=jbankname.getText();

jbankname.setText(temp.toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_jbanknameFocusLost

    private void jbankaddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbankaddressFocusLost
String temp=jbankaddress.getText();

jbankaddress.setText(temp.toUpperCase()); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jbankaddressFocusLost

    private void jbankaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbankaddressKeyPressed

if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jbankaccountnumber.requestFocus();
}        

// TODO add your handling code here:
    }//GEN-LAST:event_jbankaddressKeyPressed

    private void jbankOpeningbalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbankOpeningbalanceKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jButton1.requestFocus();
}
    }//GEN-LAST:event_jbankOpeningbalanceKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jBanktable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jbankOpeningbalance;
    private javax.swing.JTextField jbankaccountnumber;
    private javax.swing.JComboBox jbankaccounttype;
    private javax.swing.JTextArea jbankaddress;
    private javax.swing.JLabel jbankid;
    private javax.swing.JTextField jbankifsccode;
    private javax.swing.JTextField jbankmicr;
    private javax.swing.JTextField jbankname;
    // End of variables declaration//GEN-END:variables
}
