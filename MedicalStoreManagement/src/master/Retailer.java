/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import DB.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user
 */
public class Retailer extends javax.swing.JInternalFrame 
{
    Dbconn conn;
        int selectedRow;
        int valid = 0;
        public Connection con;
        String str = "";
        ResultSet rs_retailer;
        String retailerid,retail_name,retail_add,retail_contactno,retail_officeno,retail_email;
         DefaultTableModel modelItem;
      //  Dbconn conn;
        
     TableRowSorter<TableModel> sorter;
      
    
    public Retailer(JFrame parent, boolean modal) {
        initComponents();
         //initComponents();
        conn=new Dbconn();
        jLabel8.setVisible(false);
      modelItem=(DefaultTableModel)jretailertable.getModel();
      sorter = new TableRowSorter<TableModel>(modelItem);
        jretailertable.setRowSorter(sorter);
        String searchteaxt;
        //modelItem=(DefaultTableModel)jproductList.getModel();
        refreshTable();
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Retailername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Retaileraddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Retailercontactno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Retailerofficeno = new javax.swing.JTextField();
        Retaileremailid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jretailertable = new javax.swing.JTable();
        Retailername1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Retailer");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Retailer");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Retailer Name");

        Retailername.setToolTipText("Enter name of the Retailer");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Address");

        Retaileraddress.setColumns(20);
        Retaileraddress.setRows(5);
        Retaileraddress.setToolTipText("Enter Address of the Retailer");
        Retaileraddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RetaileraddressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Retaileraddress);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Contact Number:");

        Retailercontactno.setToolTipText("Enter Mobile Number of Retailer");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Office Number");

        Retailerofficeno.setToolTipText("Enter Office Land-Line number of the Retailer\n");

        Retaileremailid.setToolTipText("Enter Email-Id of the Retailer");
        Retaileremailid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RetaileremailidKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("E-mail ID");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Retailer Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Retailername, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(60, 60, 60)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Retailercontactno, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(Retailerofficeno)
                            .addComponent(Retaileremailid))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Retailername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Retailercontactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Retailerofficeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retaileremailid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.setToolTipText("Save the Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.setToolTipText("Back to Master");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jButton4.setText("Update");
        jButton4.setToolTipText("Clear al Contents");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.setToolTipText("Clear al Contents");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton5.setText("Delete");
        jButton5.setToolTipText("Clear al Contents");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(19, 19, 19))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Retailer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jretailertable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jretailertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Retailer Name", "Address", "Contact No", "Office No", "Email Id"
            }
        ));
        jretailertable.getTableHeader().setReorderingAllowed(false);
        jretailertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jretailertableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jretailertableMouseEntered(evt);
            }
        });
        jretailertable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jretailertableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jretailertableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jretailertable);

        Retailername1.setToolTipText("Enter name of the Retailer");
        Retailername1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Retailername1KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Retailer Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Retailername1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retailername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void clear()
{   
    Retailername.setText("");
        Retaileraddress.setText("");
        Retailercontactno.setText("");
        Retailerofficeno.setText("");
        Retaileremailid.setText("");

    
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
public void refreshTable()
{
    modelItem.setRowCount(0);
    conn=new Dbconn();
    try
    {
    rs_retailer=conn.execute_query("select * from retailer_info where retailer_status=?", new String[]{"ACTIVE"});
    while(rs_retailer.next())
    {
        retailerid=rs_retailer.getString("retailer_id");
        retail_name=rs_retailer.getString("retailer_name");
        retail_add=rs_retailer.getString("retailer_address");
        retail_contactno=rs_retailer.getString("retailer_contactno");
        retail_officeno=rs_retailer.getString("retailer_officeno");
        retail_email=rs_retailer.getString("retailer_email");
        
        modelItem.addRow(new String[]{retailerid,retail_name,retail_add,retail_contactno,retail_officeno,retail_email});
        
    }
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
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
            rs=st.executeQuery("select * from retailer_info where retailer_id="+cellvalue);
            while(rs.next())
            {
                jLabel8.setText(rs.getString("retailer_id"));
                Retailername.setText(rs.getString("retailer_name"));
                Retaileraddress.setText(rs.getString("retailer_address"));
                Retailercontactno.setText(rs.getString("retailer_contactno"));
                Retailerofficeno.setText(rs.getString("retailer_officeno"));
                Retaileremailid.setText(rs.getString("retailer_email"));
            
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

public void validate()
{
    str="";
    valid=0;
    if (Retailername.getText().equals("")) {
                str += "Plaese fill Name";
                valid = 1;
            }
     
            if (Retaileraddress.getText().equals(""))
            {
            str += "\n" + "Plaese fill Address";
            valid = 1;
            }   
            if(Retailercontactno.getText().equals(""))
            {
                str+="\n"+"Please Select Contact no";
                valid = 1;
            }
             if(Retailerofficeno.getText().equals(""))
            {
                str+="\n"+"Please Select Office no";
                valid = 1;
            }
             if(Retaileremailid.getText().equals(""))
            {
                str+="\n"+"Please Select Email address";
                valid = 1;
            }
        

    
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       conn=new Dbconn();

      validate();
    if(valid==1)
    {
        JOptionPane.showMessageDialog(rootPane, str, "Error!", JOptionPane.ERROR_MESSAGE);
        }
   else
    {
        
       // conn=new Dbconn();
        int i=conn.insert_data("insert into retailer_info(retailer_name,retailer_address,retailer_contactno,retailer_officeno,retailer_email,retailer_status) values(?,?,?,?,?,?)", new String[]{Retailername.getText(),Retaileraddress.getText(),Retailercontactno.getText(),Retailerofficeno.getText(),Retaileremailid.getText(),"ACTIVE"});
        if(i>0)
        {
        JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
         refreshTable();
         
        clear();
         
    
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Data Not Saved", "Warning!", JOptionPane.YES_NO_OPTION);
    
        }
    }   
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        conn=new Dbconn();
        validate();
        int a=0;
                
    if(valid==1)
    {
        JOptionPane.showMessageDialog(rootPane, str, "Error",JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to Update Data","Confirm", JOptionPane.YES_NO_OPTION);
     
        }
         if(a==0)
             {
        
               conn=new Dbconn();
                 int k=conn.update_data("UPDATE  retailer_info  SET  retailer_address=?, retailer_contactno=?, retailer_officeno=?, "
                         + "retailer_email =? WHERE  retailer_id=?", 
                         new String[]{Retaileraddress.getText(),Retailercontactno.getText(),Retailerofficeno.getText(),Retaileremailid.getText(),jLabel8.getText()});
                 
    if (k > 0) 
    {
            JOptionPane.showMessageDialog(rootPane, "Retailer Details Updated Sucessfully", "Update", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
            clear();
            //   this.dispose();
    } 
       else 
    {
        
        JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
           }
             }
    }        
        





        
        



    }//GEN-LAST:event_jButton4ActionPerformed

    private void jretailertableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jretailertableKeyPressed
        JTable target=(JTable)evt.getSource();
        if((evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object selectedcellValue=target.getValueAt(selectedRow, 0);
            refreshForm(selectedcellValue);
        }
            
          
      
    }//GEN-LAST:event_jretailertableKeyPressed

     private void sortTable()
    {
        String searchteaxt;
        searchteaxt=Retailername1.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
    private void jretailertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jretailertableMouseClicked
     if (evt.getClickCount() == 1)  
                {  
                 JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
                }
    }//GEN-LAST:event_jretailertableMouseClicked

    private void jretailertableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jretailertableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jretailertableMouseEntered

    private void jretailertableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jretailertableKeyReleased
  JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jretailertableKeyReleased

    private void Retailername1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Retailername1KeyTyped
        // TODO add your handling code here:
        sortTable();
    }//GEN-LAST:event_Retailername1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RetaileraddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetaileraddressKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    Retailercontactno.requestFocus();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_RetaileraddressKeyPressed

    private void RetaileremailidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetaileremailidKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jButton1.requestFocus();
}
        
// TODO add your handling code here:
    }//GEN-LAST:event_RetaileremailidKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        validate();
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, str, "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
          else
    {
       
      int a=JOptionPane.showConfirmDialog(rootPane, "Do Your Want to Delete This Retailer !", "Confirm", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
      try
        {
        conn=new Dbconn();
            int i = conn.update_data("update retailer_info SET retailer_status =?"
                                        +" where retailer_id=?" , new String[]{"DEACTIVE",jLabel8.getText()});
         if(i>0)
         {
        JOptionPane.showMessageDialog(rootPane, "Retailer Deleted Sucessfully", "Deleted! ", JOptionPane.INFORMATION_MESSAGE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Retaileraddress;
    private javax.swing.JTextField Retailercontactno;
    private javax.swing.JTextField Retaileremailid;
    private javax.swing.JTextField Retailername;
    private javax.swing.JTextField Retailername1;
    private javax.swing.JTextField Retailerofficeno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jretailertable;
    // End of variables declaration//GEN-END:variables
}
