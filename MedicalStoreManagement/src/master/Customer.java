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
public class Customer extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    int selectedRow;
    int valid = 0;
        String str = "";
        Dbconn conn;
        public Connection con;
        ResultSet rs_Customer;
         DefaultTableModel modelItem;
         String Customer_name,Cust_add,Cust_gender,Cust_age,Cust_Contactno,Cust_refereddocname,custid;
         TableRowSorter<TableModel> sorter;
        public Customer(JFrame parent, boolean modal) 
        {
        initComponents();
       conn=new Dbconn();
         modelItem=(DefaultTableModel)Jtablecustomer.getModel();
         
         
        refreshTable();
       
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcustomer_nametxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcustomer_addresstxt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jcustomer_gender = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcustomer_agetxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcustomer_docname = new javax.swing.JTextField();
        jcustomer_contactnotxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtablecustomer = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jcustomersearch = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Customer");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("CUSTOMER");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Customer Name");

        jcustomer_nametxt.setToolTipText("Enter the Name of Customer");
        jcustomer_nametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcustomer_nametxtFocusLost(evt);
            }
        });
        jcustomer_nametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcustomer_nametxtKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Address");

        jcustomer_addresstxt.setColumns(20);
        jcustomer_addresstxt.setRows(5);
        jcustomer_addresstxt.setToolTipText("Enter the Address of Th Customer");
        jcustomer_addresstxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcustomer_addresstxtFocusLost(evt);
            }
        });
        jcustomer_addresstxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcustomer_addresstxtKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jcustomer_addresstxt);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Gender");

        jcustomer_gender.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jcustomer_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Male", "Female", "Other" }));
        jcustomer_gender.setToolTipText("Select Gender");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Age");

        jcustomer_agetxt.setToolTipText("Enter the Age of the Customer");
        jcustomer_agetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcustomer_agetxtActionPerformed(evt);
            }
        });
        jcustomer_agetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcustomer_agetxtKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Refered Doctor Name");

        jcustomer_docname.setToolTipText("Enter Name of the Doctor");
        jcustomer_docname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcustomer_docnameFocusLost(evt);
            }
        });

        jcustomer_contactnotxt.setToolTipText("Contact Numbr of Customer");
        jcustomer_contactnotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcustomer_contactnotxtKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Contact Number:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcustomer_docname))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3))
                            .addGap(64, 64, 64)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcustomer_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcustomer_agetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jcustomer_contactnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jcustomer_nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcustomer_nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jcustomer_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcustomer_agetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcustomer_contactnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcustomer_docname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.setToolTipText("Save Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.setToolTipText("Clear All Contents");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.setToolTipText("Back to Master");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Jtablecustomer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        Jtablecustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Customer Name", "Address", "Gender", "Age", "Contact No.", "Reffered Doc.Nme"
            }
        ));
        Jtablecustomer.getTableHeader().setReorderingAllowed(false);
        Jtablecustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtablecustomerMouseClicked(evt);
            }
        });
        Jtablecustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtablecustomerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtablecustomerKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Jtablecustomer);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Search :");

        jcustomersearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcustomersearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcustomersearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jcustomersearch, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcustomersearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(621, 621, 621))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jcustomer_nametxt.setText("");
        jcustomer_agetxt.setText("");
        jcustomer_addresstxt.setText("");
        jcustomer_contactnotxt.setText("");
        jcustomer_docname.setText("");
        jcustomer_gender.setSelectedIndex(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
public void refreshTable()
    {
           modelItem.setRowCount(0);
                  rs_Customer=conn.execute_query("select * from customer_info where customerstatus=? ", new String[]{"ACTIVE"});
        
        try
        {
          while(rs_Customer.next())
          {
         
           //dist_id =   rs_Distributor.getString("distributors_id");
           custid=rs_Customer.getString("customer_id");
           Customer_name=   rs_Customer.getString("customer_name");
           Cust_add =  rs_Customer.getString("customer_address");
            Cust_gender  = rs_Customer.getString("customer_gender");
           Cust_age =  rs_Customer.getString("customer_age");
           Cust_Contactno  = rs_Customer.getString("customer_contactnumber");
           Cust_refereddocname=rs_Customer.getString("customer_docname");
         
           System.out.print(Cust_Contactno);
           modelItem.addRow(new String[]{custid,Customer_name,Cust_add,Cust_gender,Cust_age,Cust_Contactno,Cust_refereddocname});
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    private void jcustomer_nametxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomer_nametxtKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_nametxtKeyPressed

    private void jcustomer_agetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcustomer_agetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_agetxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

           
conn=new Dbconn();

     // String customermobno=jcustomer_contactnotxt.getText();
        
          //  int custage=Integer.parseInt(jcustomer_agetxt.getText());
        
            if (jcustomer_nametxt.getText().equals("")) {
                str += "Plaese fill Name";
                valid = 1;
            }
            if (jcustomer_addresstxt.getText().equals("")) {
            str += "\n" + "Plaese fill Address";
            valid = 1;
        }   
            if(jcustomer_gender.getSelectedItem().toString()==("None"))
            {
                str+="\n"+"Please Select Gender";
            }
            
       
       
       
        

    if(valid==1)
    {
        JOptionPane.showMessageDialog(rootPane, str);
    }
    else
    {
        int a=1;
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to save Data","Confirm", JOptionPane.YES_NO_OPTION);
     
        }
        if(a==0)
        //System.out.print("error");
        {
        int i=conn.insert_data("insert into customer_info(customer_name,customer_address,customer_gender,"
                + "customer_age,customer_contactnumber,customer_docname,customerstatus)"
                + "values (?,?,?,?,?,?,?)", new String[]{jcustomer_nametxt.getText(),jcustomer_addresstxt.getText(),
                    jcustomer_gender.getSelectedItem().toString(),jcustomer_agetxt.getText(),jcustomer_contactnotxt.getText(),
                    jcustomer_docname.getText(),"ACTIVE"});
    if (i > 0) {
              JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
    
 // this.dispose();

            } 
        else {
             JOptionPane.showMessageDialog(rootPane, "Data Not Saved!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
    
    }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from Customer_info where customer_id="+cellvalue);
            while(rs.next())
            {
                
                
                jcustomer_nametxt.setText(rs.getString("customer_name"));
                jcustomer_addresstxt.setText(rs.getString("customer_address"));
                jcustomer_gender.setSelectedItem(rs.getString("customer_gender"));
                jcustomer_agetxt.setText(rs.getString("customer_age"));
               jcustomer_contactnotxt.setText(rs.getString("customer_contactnumber"));
                        
               jcustomer_docname.setText(rs.getString("customer_docname"));
                  
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JtablecustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtablecustomerKeyPressed
    JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
               //  System.out.println("selectedCellValue "+" "+selectedCellValue);  
   }    
      

    }//GEN-LAST:event_JtablecustomerKeyPressed

    private void JtablecustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtablecustomerMouseClicked
     if (evt.getClickCount() == 1)  
                {  
                   //  String selectedData = null;  
                   JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
        //    System.out.print(selectedCellValue);
                
                }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_JtablecustomerMouseClicked

    private void JtablecustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtablecustomerKeyReleased
        // TODO add your handling code here:
        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
               //  System.out.println("selectedCellValue "+" "+selectedCellValue);  
   }    
    }//GEN-LAST:event_JtablecustomerKeyReleased

    private void jcustomer_agetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomer_agetxtKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_agetxtKeyTyped

     private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jcustomersearch.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
   
    private void jcustomer_contactnotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomer_contactnotxtKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_contactnotxtKeyTyped

    private void jcustomersearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomersearchKeyTyped
sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcustomersearchKeyTyped

    private void jcustomersearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomersearchKeyPressed
        // TODO add your handling code here:
sortTable();
    }//GEN-LAST:event_jcustomersearchKeyPressed

    private void jcustomer_nametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcustomer_nametxtFocusLost
String temp=jcustomer_nametxt.getText();

jcustomer_nametxt.setText(temp.toUpperCase());         // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_nametxtFocusLost

    private void jcustomer_addresstxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcustomer_addresstxtFocusLost
 
        
String temp=jcustomer_addresstxt.getText();

jcustomer_addresstxt.setText(temp.toUpperCase());    // TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_addresstxtFocusLost

    private void jcustomer_docnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcustomer_docnameFocusLost
 
        String temp=jcustomer_docname.getText();

jcustomer_docname.setText(temp.toUpperCase()); 
// TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_docnameFocusLost

    private void jcustomer_addresstxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomer_addresstxtKeyPressed

if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jcustomer_gender.requestFocus();
}

// TODO add your handling code here:
    }//GEN-LAST:event_jcustomer_addresstxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtablecustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTextArea jcustomer_addresstxt;
    private javax.swing.JTextField jcustomer_agetxt;
    private javax.swing.JTextField jcustomer_contactnotxt;
    private javax.swing.JTextField jcustomer_docname;
    private javax.swing.JComboBox jcustomer_gender;
    private javax.swing.JTextField jcustomer_nametxt;
    private javax.swing.JTextField jcustomersearch;
    // End of variables declaration//GEN-END:variables
}
