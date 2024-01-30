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
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user
 */
public class Distributor extends javax.swing.JInternalFrame {
Dbconn conn;
public Connection con;
   DefaultTableModel modelItem;
    ResultSet rs_Distributor;
    int selectedRow;
String dist_id,dist_name,distaddress,distofficeno,distmobile,distemailid,str;
 int valid = 0;
 Object dist;
 TableRowSorter<TableModel> sorter;

    /**
     * Creates new form attendance
     */
    public Distributor(JFrame parent, boolean modal) {
        initComponents();
         conn=new Dbconn();
        
         modelItem=(DefaultTableModel)JDistTable.getModel();
        sorter = new TableRowSorter<TableModel>(modelItem);
        JDistTable.setRowSorter(sorter);
        String searchteaxt;
         refreshTable();
    }
        public void refreshTable()
    {
           modelItem.setRowCount(0);
                  rs_Distributor=conn.execute_query("select * from distributors_details where distributors_status=?", new String[]{"ACTIVE"});
        
        try
        {
          while(rs_Distributor.next())
          {
         
              dist_id =   rs_Distributor.getString("distributors_id");
           dist_name=   rs_Distributor.getString("distributors_name");
           distaddress =  rs_Distributor.getString("distributors_address");
           distofficeno  = rs_Distributor.getString("distributors_officeno");
           distmobile =  rs_Distributor.getString("distributors_mobileno");
           distemailid  = rs_Distributor.getString("distributors_email");
         
           
           modelItem.addRow(new String[]{dist_id,dist_name,distaddress,distofficeno,distmobile,distemailid});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jdname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdaddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jdcontactno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jdmono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JDistTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jdsave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Distributor Details");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Distributors Details");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jdname.setToolTipText("Enter Distributor Name");
        jdname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jdnameFocusLost(evt);
            }
        });
        jdname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Name :");

        jdaddress.setColumns(20);
        jdaddress.setRows(5);
        jdaddress.setToolTipText("Enter Address");
        jdaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jdaddressFocusLost(evt);
            }
        });
        jdaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdaddressKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jdaddress);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Address");

        jdcontactno.setToolTipText("Enter Office no");
        jdcontactno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdcontactnoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Office no :");

        jdmono.setToolTipText("Enter Mobile Number(only digit)");
        jdmono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdmonoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Mobile No :");

        jdemail.setToolTipText("Enter Email Address");
        jdemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdemailKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("E-mail :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jdcontactno, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdemail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdmono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdname, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jdcontactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdmono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JDistTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        JDistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Distributor Name", "Address", "Office No", "Mobile No", "Email Address"
            }
        ));
        JDistTable.getTableHeader().setReorderingAllowed(false);
        JDistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JDistTableMouseClicked(evt);
            }
        });
        JDistTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDistTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JDistTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(JDistTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jdsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jdsave.setText("Save");
        jdsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdsaveActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdsave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(503, 503, 503)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdnameActionPerformed

     public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from distributors_details where distributors_id="+cellvalue);
            while(rs.next())
            {
                
            //   dist =rs_Distributor.getString("distributors_id");
        //    dist_id = rs_Distributor.getString("distributors_id");
            jdname.setText(rs.getString("distributors_name"));
            jdaddress.setText(rs.getString("distributors_address"));
           jdcontactno.setText(rs.getString("distributors_officeno"));
           jdmono.setText(rs.getString("distributors_mobileno"));
           jdemail.setText(rs.getString("distributors_email"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        public void clear()
        {
             jdname.setText("");
        jdaddress.setText("");
        jdcontactno.setText("");
        jdmono.setText("");
        jdemail.setText("");
        }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public void validate()
    {
         
        valid=0;
                 
         str = "";

        if (jdname.getText().equals("")) {
            str += "\n Plaese fill Name !";
            valid = 1;
        }
             if (jdaddress.getText().equals("")) {
            str += "\n Plaese fill Address !";
            valid = 1;
        }
                  if (jdcontactno.getText().equals("")) {
            str += "\n Plaese fill Office no !";
            valid = 1;
        }
                           if (jdmono.getText().equals("")) {
            str += "\n Plaese fill Mobile NO !";
            valid = 1;
        }
                                             if (jdemail.getText().equals("")) {
            str += "\n Plaese fill Email address !";
            valid = 1;
        }
    }
    private void jdsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdsaveActionPerformed
        conn=new Dbconn();
        validate();
        if (valid == 1)
        {
            JOptionPane.showMessageDialog(rootPane, str, "Error",JOptionPane.ERROR_MESSAGE);
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
            int i=conn.insert_data("insert into distributors_details (distributors_name,distributors_address,distributors_officeno,distributors_mobileno,"
                    + "distributors_email,distributors_status) values (?,?,?,?,?,?)", new String[]{jdname.getText(),jdaddress.getText(),jdcontactno.getText(),jdmono.getText(),jdemail.getText(),"ACTIVE"});
     
          
            if (i > 0)
            {
                    JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
                //    this.dispose();
                    refreshTable();

            } else 
            {
                JOptionPane.showMessageDialog(rootPane, "Data Not Saved !", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jdsaveActionPerformed

    private void JDistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JDistTableMouseClicked


        
       if (evt.getClickCount() == 1)  
                {  
                  
                   JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
        //    System.out.print(selectedCellValue);
                
                }

// TODO add your handling code here:
    }//GEN-LAST:event_JDistTableMouseClicked

    private void JDistTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDistTableKeyPressed
  JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
               //  System.out.println("selectedCellValue "+" "+selectedCellValue);  
   } 
        
    }//GEN-LAST:event_JDistTableKeyPressed

    private void JDistTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDistTableKeyReleased
  JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_JDistTableKeyReleased

    private void jdcontactnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcontactnoKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jdcontactnoKeyTyped

    private void jdmonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdmonoKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jdmonoKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jdnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdnameFocusLost
        // TODO add your handling code here:
        String temp=jdname.getText();

jdname.setText(temp.toUpperCase()); 
    }//GEN-LAST:event_jdnameFocusLost

    private void jdaddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdaddressFocusLost

String temp=jdaddress.getText();

jdaddress.setText(temp.toUpperCase());         
// TODO add your handling code here:
    }//GEN-LAST:event_jdaddressFocusLost
 private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jTextField1.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
    sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
     sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jdaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdaddressKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jdcontactno.requestFocus();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jdaddressKeyPressed

    private void jdemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdemailKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jdsave.requestFocus();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jdemailKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      validate();
    int a=0;
      if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, str, "Error", JOptionPane.ERROR_MESSAGE);
        }
         a=JOptionPane.showConfirmDialog(rootPane, "Do Your Want to Update This Distributor !", "Confirm", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            
                int k=conn.update_data("UPDATE  distributors_details  SET  distributors_address=?, distributors_officeno =?, distributors_mobileno=?, "
                 + "distributors_email =?"
                 + " WHERE  distributors_id=?", 
                 new String[]{jdaddress.getText(),jdcontactno.getText(),jdmono.getText(),jdemail.getText(),dist_id});

        if (k > 0) 
    {
            JOptionPane.showMessageDialog(rootPane, "Distributor Details Updated Sucessfully", "Update", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
            clear();

    } 
            else 
         {
             JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
         }
        }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        validate();
if(valid==1)
{
    JOptionPane.showMessageDialog(rootPane, str, "Error!", JOptionPane.ERROR_MESSAGE);
}
        else
    {
       
      int a=JOptionPane.showConfirmDialog(rootPane, "Do Your Want to Delete This Distributor !", "Confirm", JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
      try
        {
        conn=new Dbconn();
    int i = conn.update_data("update distributors_details SET distributors_status =?"
                                        +" where distributors_id=?" , new String[]{"DEACTIVE",dist_id});
         if(i>0)
         {
        JOptionPane.showMessageDialog(rootPane, "Distributor Deleted Sucessfully", "Deleted! ", JOptionPane.INFORMATION_MESSAGE);
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
        
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JDistTable;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jdaddress;
    private javax.swing.JTextField jdcontactno;
    private javax.swing.JTextField jdemail;
    private javax.swing.JTextField jdmono;
    private javax.swing.JTextField jdname;
    private javax.swing.JButton jdsave;
    // End of variables declaration//GEN-END:variables
}
