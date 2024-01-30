/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import DB.Dbconn;
import Sales.*;
import UserManagement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import master.*;




public class BankAccountCrediteDebitStatus extends javax.swing.JInternalFrame {
     Dbconn conn;
      ResultSet rs;
      String bankname,ty,b,c;
      String date,partyname,bname,accno,openingbal,type,amount,totalamount,cn,newtotalbalance,srno;
      DefaultTableModel modelItem,modelItem1;
      int valid=0;
      String s="";
       private int selectedrow;
       int a,obal,tbal,bal,i,n,o;
      
       
    JFrame frame = new JFrame();
    public BankAccountCrediteDebitStatus(JFrame parent, boolean modal) {
        initComponents();
        modelItem=(DefaultTableModel)jBanklisttbl.getModel();
        
          refreshBankTable();
         modelItem1=(DefaultTableModel)jBankaccountstatustbl.getModel();
        // refreshmainTable();
         
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date date1 = new Date();
          jdate.setText(dateFormat.format(date1));
         
    }

    

   public void clear()
   {
         jBankcreditdebitStatus_partyname.setText("");
         jBankcreditdebitStatus_bankname.setText("");
         jBankcreditdebitStatus_accno.setText("");
         jBankcreditdebitStatus_openingbal.setText("");
         jBankcreditdebitStatus_amount.setText("");
         jBankcreditdebitStatus_totalamount.setText("");
         jCurrentBalanceLabel.setText("");
   }
   //*****************************************refereshtable
   public void refreshBankTable()
   {
          modelItem=(DefaultTableModel)jBanklisttbl.getModel();
      
       
            conn=new Dbconn();
            rs=conn.execute_query("select DISTINCT(bank_name) from bank_info where status=?",new String[]{"ACTIVE"});
            
         try
        {    
          while(rs.next())
          {
              
              modelItem=(DefaultTableModel)jBanklisttbl.getModel();
              bankname=rs.getString("bank_name");
              System.out.println(bankname);
              modelItem.addRow(new String[]{bankname});
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e);
        }
       
   }
   //**************************referesh table main**********************************
   
     public void  refreshmainTable()
    {
         
        
        try
        {
            conn=new Dbconn();
            rs=conn.execute_query("select * from bankcreditdebite_status where status=?",new String[]{"ACTIVE"});
            
          while(rs.next())
          {
             
           srno=rs.getString("Sr_No");
           date=rs.getString("tr_date");
           partyname=rs.getString("party_name");
           bname=rs.getString("bank_name");
           accno=rs.getString("account_no");
           openingbal=rs.getString("opening_balance");
           type=rs.getString("type");
           amount=rs.getString("amount");
           totalamount=rs.getString("total_amount");
          
         
          modelItem1.addRow(new String[]{srno,date,partyname, bname,accno, openingbal,type,amount, totalamount});
          
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
   
   
   
   
   
   
   
   
   //****************************Set data to the text feilds***************************************
   public void setdatatoTextfeild(String str)
   {
        cn=str;
        System.out.println(cn);
       
           
       
            try
        {
            conn=new Dbconn();
            rs=conn.execute_query("select * from bank_info where status=? and bank_name=?",new String[]{"ACTIVE",cn});
            
          while(rs.next())
          {
            // String date,partyname,bname,accno,openingbal,type,amount,totalamount,cn;
       
            bname=rs.getString("bank_name");
            accno=rs.getString("account_no");
            openingbal=rs.getString("opening_balance");
            
           
          
             System.out.println("in next()");
             System.out.println(bname);
             System.out.println(accno);
             System.out.println(openingbal);
             //System.out.println(totalamount);
             
       
           jBankcreditdebitStatus_bankname.setText(bname);
           jBankcreditdebitStatus_accno.setText(accno);
           jBankcreditdebitStatus_openingbal.setText(openingbal);
            
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
            //*******************setting current balance to the lable***********
             try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                     jCurrentBalanceLabel.setText(b);
                    
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane, e);  
                   }
       
       
       
   }
   ///***********************************insert data in table**************************
   public void insert()
   {
             
     
           date=jdate.getText();
           partyname=jBankcreditdebitStatus_partyname.getText();
           bname=jBankcreditdebitStatus_bankname.getText();
           accno=jBankcreditdebitStatus_accno.getText();
           openingbal=jBankcreditdebitStatus_openingbal.getText();
           type=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
           amount=jBankcreditdebitStatus_amount.getText();
           totalamount=jBankcreditdebitStatus_totalamount.getText();
           
           o=Integer.parseInt(amount);
           
           if(jBankcreditdebitStatus_partyname.getText().equals(""))
           {
               s+= "Plaese Enter Party Customer Name/Choose Bank name First";
            valid = 1;
           }
            if(jBankcreditdebitStatus_bankname.getText().equals(""))
           {
               s+= "Plaese Enter Bank Name/Select Bank name First";
            valid = 1;
           }
           
         
            
            
             if(valid==1)
          {
           JOptionPane.showMessageDialog(rootPane, s);
          }
            else
          {
           if(valid==0)
          {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Are You Sure..","Confirm", JOptionPane.YES_NO_OPTION);
     
          }
            
        
            if(a==0)
             {
                 if(o>=0)
                 {
               //String date,partyname,bname,accno,openingbal,type,amount,totalamount,cn;
                
               date=jdate.getText();
               partyname=jBankcreditdebitStatus_partyname.getText();
               bname=jBankcreditdebitStatus_bankname.getText();
               accno=jBankcreditdebitStatus_accno.getText();
               type=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
               amount=jBankcreditdebitStatus_amount.getText();
               openingbal=jBankcreditdebitStatus_openingbal.getText();
               
             //   bal=Integer.parseInt(amount);
                obal=Integer.parseInt(openingbal);
              //  tbal=obal+bal;
               // newtotalbalance=tbal+"";
                
                //jBankcreditdebitStatus_totalamount.setText(tbal+"");
           
                if(obal>=0)
                {
                  conn=new Dbconn();
               
                i=conn.insert_data("insert into bankcreditdebite_status(tr_date,party_name,bank_name,account_no,opening_balance,type,"
                + "amount,total_amount,status)"
                + "values (?,?,?,?,?,?,?,?,?)", new String[]{date,partyname,bname,accno,openingbal,type,amount,totalamount,"ACTIVE"});
             
                 System.out.println(newtotalbalance);
//               System.out.println(paymode);
//               System.out.println(totalamount);
//               System.out.println(pendingamount);
             
                      if (i > 0) {
                          JOptionPane.showMessageDialog(rootPane, "Data save");
                          updateTable();
                          clear();
                          } 
                
                         }
                
               
                      else {
                          JOptionPane.showMessageDialog(rootPane, "Data not save");
                         // clear();
                        
                          }
                 }
                  else
                 {
                   JOptionPane.showMessageDialog(rootPane, "Please Enter the valide Amount Greter than 0");  
                 }
                 
         
             }
          }   
           
           
           
      
   }
   
   //*************************************Update Table**************************
   public void updateTable()
   {
             ty=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
            
              
             System.out.println(cn);
                if(ty.equals("credite"))
               {
                   
                    bname=jBankcreditdebitStatus_bankname.getText();
                    amount=jBankcreditdebitStatus_amount.getText();
                    openingbal=jBankcreditdebitStatus_openingbal.getText();
                    o=Integer.parseInt(amount);
                    if(o>=0)
                    {
                   try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                          System.out.println("max of amount of bank"+b);
                    n=Integer.parseInt(b);
                    bal=Integer.parseInt(amount);
                    //obal=Integer.parseInt(openingbal);
                    n=n+bal;
                    //tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                   
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane,e);  
                   }
                    }
                    else
                    {
                       JOptionPane.showMessageDialog(rootPane, "Please Enter Valide Amount "); 
                    }
                   try
                   {
                     conn=new Dbconn();
                      i=conn.update_data("update bankcreditdebite_status set total_amount=? where bank_name=?",new String[]{n+"",bname});
                       
                      if(i>0)
                      {
                          JOptionPane.showMessageDialog(rootPane, "Record is updated successfuly");
                            modelItem1=(DefaultTableModel)jBankaccountstatustbl.getModel();
                          refreshmainTable();
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(rootPane, "Record is not updated");
                      }
                      
                      
                      
                      
                   }catch(Exception e)
                   {
                       JOptionPane.showMessageDialog(rootPane, "Error");
                   }
                   
                   
                 }
                //****************************************debite update****
                
                 ty=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
            
              
             System.out.println(cn);
                if(ty.equals("debite"))
               {
                   
                    bname=jBankcreditdebitStatus_bankname.getText();
                    amount=jBankcreditdebitStatus_amount.getText();
                    openingbal=jBankcreditdebitStatus_openingbal.getText();
                    o=Integer.parseInt(amount);
                   try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                          System.out.println("max of amount of bank"+b);
                    n=Integer.parseInt(b);
                    bal=Integer.parseInt(amount);
                    //obal=Integer.parseInt(openingbal);
                   
                    n=n-bal;
                    //tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                   
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane,e);  
                   }
                   try
                   {
                     conn=new Dbconn();
                      i=conn.update_data("update bankcreditdebite_status set total_amount=? where bank_name=?",new String[]{n+"",bname});
                       
                      if(i>0)
                      {
                          JOptionPane.showMessageDialog(rootPane, "Record is updated successfuly");
                            modelItem1=(DefaultTableModel)jBankaccountstatustbl.getModel();
                          refreshmainTable();
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(rootPane, "Record is not updated");
                      }
                      
                      
                      
                      
                   }catch(Exception e)
                   {
                       JOptionPane.showMessageDialog(rootPane, e);
                   }
                   
                   
                 }
                
   }
   
   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBankcreditdebitStatus_partyname = new javax.swing.JTextField();
        jBankcreditdebitStatus_bankname = new javax.swing.JTextField();
        jBankcreditdebitStatus_accno = new javax.swing.JTextField();
        jBankcreditdebitStatus_openingbal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBankcreditdebitStatus_amount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBankcreditdebitStatus_typecombo1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jBankcreditdebitStatus_totalamount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCurrentBalanceLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBanklisttbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jSavebtn = new javax.swing.JButton();
        jClearbtn = new javax.swing.JButton();
        jBankcreditdebitStatus_homebtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jBankaccountstatustbl = new javax.swing.JTable();
        jdate = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("BankAccountCrediteDebitStatus");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Bank Account Credit Debit Status");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Date:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Party Name:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Bank Name");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Account No:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Opening Balance:");

        jBankcreditdebitStatus_accno.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel7.setText("Amount:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Type:");

        jBankcreditdebitStatus_typecombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "credite", "debite" }));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Total Amount");

        jBankcreditdebitStatus_totalamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBankcreditdebitStatus_totalamountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jBankcreditdebitStatus_totalamountFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Current Balance:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBankcreditdebitStatus_bankname, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(72, 72, 72))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBankcreditdebitStatus_accno, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBankcreditdebitStatus_partyname, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBankcreditdebitStatus_openingbal, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jBankcreditdebitStatus_typecombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCurrentBalanceLabel))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBankcreditdebitStatus_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBankcreditdebitStatus_totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBankcreditdebitStatus_bankname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBankcreditdebitStatus_partyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBankcreditdebitStatus_accno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBankcreditdebitStatus_openingbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jBankcreditdebitStatus_typecombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jCurrentBalanceLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBankcreditdebitStatus_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jBankcreditdebitStatus_totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bank List"));

        jBanklisttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bank Name"
            }
        ));
        jBanklisttbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBanklisttblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jBanklisttbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSavebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jSavebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jSavebtn.setText("Save");
        jSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSavebtnActionPerformed(evt);
            }
        });

        jClearbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jClearbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jClearbtn.setText("Clear");
        jClearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearbtnActionPerformed(evt);
            }
        });

        jBankcreditdebitStatus_homebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jBankcreditdebitStatus_homebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon.png"))); // NOI18N
        jBankcreditdebitStatus_homebtn.setText("Home");
        jBankcreditdebitStatus_homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBankcreditdebitStatus_homebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jSavebtn)
                .addGap(69, 69, 69)
                .addComponent(jClearbtn)
                .addGap(64, 64, 64)
                .addComponent(jBankcreditdebitStatus_homebtn)
                .addGap(99, 99, 99))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSavebtn)
                    .addComponent(jClearbtn)
                    .addComponent(jBankcreditdebitStatus_homebtn))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBankaccountstatustbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "Date", "Party Name", "Bank Name", "Account No", "Opening Balance", "Type", "Amount", "TotalAmount"
            }
        ));
        jScrollPane2.setViewportView(jBankaccountstatustbl);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jdate.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(462, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearbtnActionPerformed
             clear();
       
    }//GEN-LAST:event_jClearbtnActionPerformed

    private void jBanklisttblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBanklisttblMouseClicked

       
          JTable target = (JTable)evt.getSource();
          if(evt.getClickCount()==1)
         {
            
             selectedrow = target.getSelectedRow();
             Object selectedCellValue=target.getValueAt(selectedrow, 0);
             jBankcreditdebitStatus_bankname.setText(selectedCellValue.toString());
             System.out.println(selectedCellValue);
             setdatatoTextfeild((String) selectedCellValue); 
         }
        
        


    }//GEN-LAST:event_jBanklisttblMouseClicked

    private void jSavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSavebtnActionPerformed
        insert();
    }//GEN-LAST:event_jSavebtnActionPerformed

    private void jBankcreditdebitStatus_totalamountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBankcreditdebitStatus_totalamountFocusGained
        
        ty=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
         if(ty.equals("credite"))
               {
                   // bname=jBankcreditdebitStatus_bankname.getText();
                    amount=jBankcreditdebitStatus_amount.getText();
                    openingbal=jBankcreditdebitStatus_openingbal.getText();
                    
                    try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                     jCurrentBalanceLabel.setText(b);
                     n=Integer.parseInt(b);
                    System.out.println("max of amount of bank"+n);
                    
                    bal=Integer.parseInt(amount);
                   // obal=Integer.parseInt(openingbal);
                    n=n+bal;
                   // tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                    jBankcreditdebitStatus_totalamount.setText(n+"");
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane, e);  
                   }
               
               // bal=Integer.parseInt(amount);
               // obal=Integer.parseInt(openingbal);
               // tbal=obal+bal;
               // newtotalbalance=tbal+"";
               
               }
         else
         {
                 amount=jBankcreditdebitStatus_amount.getText();
                  openingbal=jBankcreditdebitStatus_openingbal.getText();
                    
                    try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                     jCurrentBalanceLabel.setText(b);
                     n=Integer.parseInt(b);
                    System.out.println("max of amount of bank"+n);
                    
                    bal=Integer.parseInt(amount);
                   // obal=Integer.parseInt(openingbal);
                    if(n>=bal)
                    {
                    n=n-bal;
                   // tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                    jBankcreditdebitStatus_totalamount.setText(n+"");
                    }
                    else
                    {
                         jBankcreditdebitStatus_totalamount.setText("");
                       JOptionPane.showMessageDialog(rootPane, "Error:/Please Enter Amount less than current Balance"); 
                      
                    }
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane, e);  
                   }
               
         }
        
    }//GEN-LAST:event_jBankcreditdebitStatus_totalamountFocusGained

    private void jBankcreditdebitStatus_totalamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBankcreditdebitStatus_totalamountFocusLost
         
        ty=jBankcreditdebitStatus_typecombo1.getSelectedItem().toString();
         if(ty.equals("credite"))
               {
                   // bname=jBankcreditdebitStatus_bankname.getText();
                    amount=jBankcreditdebitStatus_amount.getText();
                    openingbal=jBankcreditdebitStatus_openingbal.getText();
                    
                    try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                     jCurrentBalanceLabel.setText(b);
                     n=Integer.parseInt(b);
                    System.out.println("max of amount of bank"+n);
                    
                    bal=Integer.parseInt(amount);
                   // obal=Integer.parseInt(openingbal);
                    n=n+bal;
                   // tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                    jBankcreditdebitStatus_totalamount.setText(n+"");
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane, e);  
                   }
               
               // bal=Integer.parseInt(amount);
               // obal=Integer.parseInt(openingbal);
               // tbal=obal+bal;
               // newtotalbalance=tbal+"";
               
               }
         else
         {
                 amount=jBankcreditdebitStatus_amount.getText();
                  openingbal=jBankcreditdebitStatus_openingbal.getText();
                    
                    try
                   {
                    conn=new Dbconn();
                    rs=conn.execute_query("select max(total_amount) from bankcreditdebite_status where status=? and bank_name=?",new String[]{"ACTIVE",bname});
                    while(rs.next())
                    {
                     b=rs.getString("max(total_amount)");
                     jCurrentBalanceLabel.setText(b);
                     n=Integer.parseInt(b);
                    System.out.println("max of amount of bank"+n);
                    
                    bal=Integer.parseInt(amount);
                   // obal=Integer.parseInt(openingbal);
                    if(n>=bal)
                    {
                    n=n-bal;
                   // tbal=Integer.parseInt(b);
                    System.out.println("after crediting  the amount total amount is"+n);
                    jBankcreditdebitStatus_totalamount.setText(n+"");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Please Enter Debite amount less than Current Balance");  
                    }
                    }
                   }
                   catch(Exception e)
                   {
                     JOptionPane.showMessageDialog(rootPane, e);  
                   }
               
         }
        
    }//GEN-LAST:event_jBankcreditdebitStatus_totalamountFocusLost

    private void jBankcreditdebitStatus_homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBankcreditdebitStatus_homebtnActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jBankcreditdebitStatus_homebtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jBankaccountstatustbl;
    private javax.swing.JTextField jBankcreditdebitStatus_accno;
    private javax.swing.JTextField jBankcreditdebitStatus_amount;
    private javax.swing.JTextField jBankcreditdebitStatus_bankname;
    private javax.swing.JButton jBankcreditdebitStatus_homebtn;
    private javax.swing.JTextField jBankcreditdebitStatus_openingbal;
    private javax.swing.JTextField jBankcreditdebitStatus_partyname;
    private javax.swing.JTextField jBankcreditdebitStatus_totalamount;
    private javax.swing.JComboBox jBankcreditdebitStatus_typecombo1;
    private javax.swing.JTable jBanklisttbl;
    private javax.swing.JButton jClearbtn;
    private javax.swing.JLabel jCurrentBalanceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton jSavebtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jdate;
    // End of variables declaration//GEN-END:variables
}
