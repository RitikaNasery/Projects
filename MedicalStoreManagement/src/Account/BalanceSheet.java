
package Account;


import DB.Dbconn;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class BalanceSheet extends javax.swing.JInternalFrame {
    int valid = 0;
        String str = "";
        Dbconn conn;
        String datefrom,dateto,cashinhand,cashinbank,bankname,billrecivable,billpending,creditevoucher,billpayable;
         
    JFrame frame = new JFrame();
    DefaultTableModel modelItem;
    Date dtae;
    
    public BalanceSheet(JFrame parent, boolean modal) {
         initComponents();
        modelItem=(DefaultTableModel)jBalancesheet.getModel();
       
        refreshTable();
    }
     
   //////////////////////Refresh Table//////////////////////////////////////////////// 
    public void  refreshTable()
    {
      try
        {
            conn=new Dbconn();
            ResultSet rs=conn.execute_query("select * from balance_sheet where status=?",new String[]{"ACTIVE"});
            
          while(rs.next())
          {
              //date,cashinhand,cashinbank,billrecivable,billpending,creditevoucher,billpayable;
             datefrom=rs.getString("datefrom");
             dateto=rs.getString("dateto");
             cashinhand=rs.getString("cash_inhand");
             bankname=rs.getString("bank_name");
             cashinbank=rs.getString("cash_inbank");
             billrecivable=rs.getString("bill_recivable");
             billpending=rs.getString("bill_pending");
             creditevoucher=rs.getString("creditvoucher");
             billpayable=rs.getString("bill_payable");
             modelItem.addRow(new String[]{ datefrom, dateto,cashinhand,bankname,cashinbank,billrecivable,  billpending, creditevoucher, billpayable});
             }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbalancesheet_cashinhand = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbalancesheet_billpending = new javax.swing.JTextField();
        jbalancesheet_cashinbank = new javax.swing.JTextField();
        jbalancesheet_banknamecombo = new javax.swing.JComboBox();
        jbalancesheet_billrecievable = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbalancesheet_creditvoucher = new javax.swing.JTextField();
        jbalancesheet_billpayable = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBalancesheet = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jbalancesheet_dateto = new javax.swing.JTextField();
        jbalancesheet_datefrom = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Short Balance Sheet");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Short Balance Sheet");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Assets"));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Cash InHand");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Cash in Bank");

        jbalancesheet_cashinhand.setToolTipText("Cash In Hand");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Bills Recievable");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Bill Pending");

        jbalancesheet_billpending.setToolTipText("Pending Bill Amount");

        jbalancesheet_cashinbank.setToolTipText("Cash In Bank");

        jbalancesheet_banknamecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "Bank Of Maharashtra", "Bank Of India", "ICICI", "HDFC", "Dena Bank", "Punjab National Bank", "Bank Of Badoda", "Canara Bank", "State Bank Of India", "Ratnakar Bank", "Janata sahakari Bank", "Unioun Bank" }));

        jbalancesheet_billrecievable.setToolTipText("Recievable Bills");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbalancesheet_billpending, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbalancesheet_billrecievable, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbalancesheet_cashinhand, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbalancesheet_banknamecombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 231, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbalancesheet_cashinbank, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbalancesheet_cashinhand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbalancesheet_cashinbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbalancesheet_banknamecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jbalancesheet_billrecievable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbalancesheet_billpending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Liability"));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Credit Voucher");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Bill Payable");

        jbalancesheet_creditvoucher.setToolTipText("Credit Voucher");

        jbalancesheet_billpayable.setToolTipText("Bill Payble Amount");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbalancesheet_creditvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbalancesheet_billpayable, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jbalancesheet_creditvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jbalancesheet_billpayable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("Delete");
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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBalancesheet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datefrom", "Dateto", "CashInHand", "BankName", "CashInBank", "BillRecievable", "BillPending", "CreditVoucher", "BillPayable"
            }
        ));
        jBalancesheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBalancesheetMouseClicked(evt);
            }
        });
        jBalancesheet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBalancesheetKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBalancesheetKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jBalancesheet);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Date:");

        jButton5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton5.setText("Show");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("to");

        jbalancesheet_dateto.setToolTipText("Date To");

        jbalancesheet_datefrom.setToolTipText("Date From");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbalancesheet_datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbalancesheet_dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(251, 251, 251)))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jbalancesheet_datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jbalancesheet_dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jbalancesheet_datefrom.setText("");
        jbalancesheet_dateto.setText("");
        jbalancesheet_cashinhand.setText("");
        jbalancesheet_cashinbank.setText("");
        jbalancesheet_billrecievable.setText("");
        jbalancesheet_billpending.setText("");
        //jbalancesheet_date.setText("");
        jbalancesheet_creditvoucher.setText("");
        jbalancesheet_billpayable.setText("");

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       this.dispose();        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
//          Save Button coding
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         conn=new Dbconn();     
       
     if (jbalancesheet_cashinhand.getText().equals("")) 
       {
          str += "Cash inHand field is empty";
          valid = 1;
      } 
     if (jbalancesheet_datefrom.equals("")) {
           str +="\n" + "Plaese Select From  Date";
           valid = 1;
       } 
        if (jbalancesheet_dateto.equals("")) {
           str +="\n" + "Plaese Select To  Date";
           valid = 1;
       } 
     
      if (jbalancesheet_cashinbank.getText().equals("")) {
           str +="\n"+ "Plaese Enter Cash in bank";
           valid = 1;
       } 
        if (jbalancesheet_billrecievable.getText().equals("")) {
           str +="\n"+ "Plaese Enter BillRecivable";
            valid = 1;
        } 
          if (jbalancesheet_billpending.getText().equals("")) {
            str +="\n"+ "Plaese Enter pending bill";
            valid = 1;
        } 
           if (jbalancesheet_creditvoucher.getText().equals("")) {
            str += "\n"+"Plaese Enter creditvoucher";
           valid = 1;      
                   } 
           if (jbalancesheet_billpayable.getText().equals("")) {
            str +="\n"+ "Plaese Enter Bill Payble";
            valid = 1;
        } 
           
      
          if(valid==1)
       {
         JOptionPane.showMessageDialog(rootPane, str);
        }
           
       else
      {
         
             int s= JOptionPane.showConfirmDialog(null, "Do You Want To Save This..", "SAVE RECORD", JOptionPane.YES_NO_OPTION); 
        if(s==JOptionPane.YES_OPTION)
        {
         int i=conn.insert_data("insert into balance_sheet(datefrom,dateto,cash_inhand,bank_name,cash_inbank,bill_recivable,"
                + "bill_pending,creditvoucher,bill_payable,status)"
                + "values (?,?,?,?,?,?,?,?,?,?)", new String[]{jbalancesheet_datefrom.getText(),jbalancesheet_dateto.getText(),jbalancesheet_cashinhand.getText(),jbalancesheet_banknamecombo.getSelectedItem().toString(),jbalancesheet_cashinbank.getText(),
                    jbalancesheet_billrecievable.getText(),jbalancesheet_billpending.getText(),jbalancesheet_creditvoucher.getText(),
                    jbalancesheet_billpayable.getText(),"ACTIVE"});
        if (i > 0) {
                JOptionPane.showMessageDialog(rootPane, "Data save");
                //refreshTable();
               //this.dispose();
        }
        if(s==JOptionPane.NO_OPTION)
        {
            this.dispose();
        }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data not save");
           }
            
             
               // Setting Values to the Textbox
        
           String col1,col2,col3,col4,col5,col6,col7,col8,col9;
            
            col1=jbalancesheet_datefrom.getText();
            col2=jbalancesheet_dateto.getText();
            col3=jbalancesheet_cashinhand.getText();
            col4=jbalancesheet_banknamecombo.getSelectedItem().toString();
            col5=jbalancesheet_cashinbank.getText();
            col6=jbalancesheet_billrecievable.getText();
            col7=jbalancesheet_billpending.getText();
            col8=jbalancesheet_creditvoucher.getText();
            col9=jbalancesheet_billpayable.getText();
            
            //conn=new Dbconn();
           // modelItem=(DefaultTableModel)jBalancesheet.getModel();
            modelItem.addRow(new String[]{col1,col2,col3,col4,col5,col6,col7,col8,col9});
            
                //  
            jbalancesheet_datefrom.setText("");
            jbalancesheet_dateto.setText("");
            jbalancesheet_cashinhand.setText("");
            jbalancesheet_cashinbank.setText("");
            jbalancesheet_billrecievable.setText("");
            jbalancesheet_billpending.setText("");
            jbalancesheet_creditvoucher.setText("");
            jbalancesheet_billpayable.setText("");
   }
        
//        // TODO add your handling code here:

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBalancesheetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBalancesheetKeyPressed

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
     int selectedrow= target.getSelectedRow(); 
        Object selectedcellvalue = target.getValueAt(selectedrow,0);
       // jDateChooser1.setDate((Date date) selectedcellvalue);
       
         jbalancesheet_datefrom.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 1);
        jbalancesheet_dateto.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 2);
        jbalancesheet_cashinhand.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 3);
       jbalancesheet_banknamecombo.setSelectedItem((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 4);
        jbalancesheet_cashinbank.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 5);
        jbalancesheet_billrecievable.setText((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 6);
        jbalancesheet_billpending.setText((String) selectedcellvalue);

                           
        selectedcellvalue = target.getValueAt(selectedrow, 7);
        jbalancesheet_creditvoucher.setText((String) selectedcellvalue);
                           
        selectedcellvalue = target.getValueAt(selectedrow, 8);
        jbalancesheet_billpayable.setText((String) selectedcellvalue);
      
    
    
   }
// TODO add your handling code here:
    }//GEN-LAST:event_jBalancesheetKeyPressed

    private void jBalancesheetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBalancesheetKeyReleased

          JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
     int selectedrow= target.getSelectedRow(); 
        Object selectedcellvalue = target.getValueAt(selectedrow,0);
       // jDateChooser1.setDate((Date date) selectedcellvalue);
       
         jbalancesheet_datefrom.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 1);
        jbalancesheet_dateto.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 2);
        jbalancesheet_cashinhand.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 3);
       jbalancesheet_banknamecombo.setSelectedItem((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 4);
        jbalancesheet_cashinbank.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 5);
        jbalancesheet_billrecievable.setText((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 6);
        jbalancesheet_billpending.setText((String) selectedcellvalue);

                           
        selectedcellvalue = target.getValueAt(selectedrow, 7);
        jbalancesheet_creditvoucher.setText((String) selectedcellvalue);
                           
        selectedcellvalue = target.getValueAt(selectedrow, 8);
        jbalancesheet_billpayable.setText((String) selectedcellvalue);
      
    
    
   }
// TODO add your handling code here:
    }//GEN-LAST:event_jBalancesheetKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   
        int s= JOptionPane.showConfirmDialog(null, "Are You Realy Wants to Delete this..", "Delete", JOptionPane.YES_NO_OPTION);
                    if (s==JOptionPane.YES_OPTION){
                           int selectedRow = jBalancesheet.getSelectedRow();
                           
                          if(selectedRow != -1) 
                         {
                          modelItem.removeRow(selectedRow);     
                           
                         }                                        

                    }
                  if (s==JOptionPane.NO_OPTION)
                     {
                         this.dispose();
                      }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBalancesheetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBalancesheetMouseClicked

        if(evt.getClickCount()==1)
         {
             JTable target=(JTable)evt.getSource();
             int selectedrow = target.getSelectedRow();  
              Object selectedcellvalue = target.getValueAt(selectedrow,0);
       
       
         jbalancesheet_datefrom.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 1);
        jbalancesheet_dateto.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 2);
        jbalancesheet_cashinhand.setText((String) selectedcellvalue);
        
         selectedcellvalue = target.getValueAt(selectedrow, 3);
       jbalancesheet_banknamecombo.setSelectedItem((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 4);
        jbalancesheet_cashinbank.setText((String) selectedcellvalue);
              
        selectedcellvalue = target.getValueAt(selectedrow, 5);
        jbalancesheet_billrecievable.setText((String) selectedcellvalue);
                
        selectedcellvalue = target.getValueAt(selectedrow, 6);
        jbalancesheet_billpending.setText((String) selectedcellvalue);

                           
        selectedcellvalue = target.getValueAt(selectedrow, 7);
        jbalancesheet_creditvoucher.setText((String) selectedcellvalue);
                           
        selectedcellvalue = target.getValueAt(selectedrow, 8);
        jbalancesheet_billpayable.setText((String) selectedcellvalue);
         }

    }//GEN-LAST:event_jBalancesheetMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jBalancesheet;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jbalancesheet_banknamecombo;
    private javax.swing.JTextField jbalancesheet_billpayable;
    private javax.swing.JTextField jbalancesheet_billpending;
    private javax.swing.JTextField jbalancesheet_billrecievable;
    private javax.swing.JTextField jbalancesheet_cashinbank;
    private javax.swing.JTextField jbalancesheet_cashinhand;
    private javax.swing.JTextField jbalancesheet_creditvoucher;
    private javax.swing.JTextField jbalancesheet_datefrom;
    private javax.swing.JTextField jbalancesheet_dateto;
    // End of variables declaration//GEN-END:variables
}
