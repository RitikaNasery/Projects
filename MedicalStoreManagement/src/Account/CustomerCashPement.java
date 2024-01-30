/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import DB.Dbconn;
import Sales.*;
import UserManagement.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import master.*;
import medicalstoremanagement.*;


/**
 *
 * @author user
 */
public class CustomerCashPement extends javax.swing.JInternalFrame {

    Dbconn conn,coon;
    String customername,as,cn,date,cid,newpen,s,totalpaid;
    String custname,address,telno,pendamt,disct,paid;
      String newpendingamount;
    DefaultTableModel modelItem;
     TableRowSorter<TableModel> sorter;
     int valid = 0;
     String str = "";
     int a,i;
     ResultSet rs,rs_cust;
    float newpenamt,pda,opa,tpaid,npaid;
    JFrame frame = new JFrame();
    private int selectedrow;
    private int row;
    
    
    public CustomerCashPement(JFrame parent, boolean modal) {
        initComponents();
        refreshTable();
        sorter = new TableRowSorter<TableModel>(modelItem);
        jCustomercashpay_jtable.setRowSorter(sorter);
        
        modelItem=(DefaultTableModel)jCustomercashpay_jtable.getModel();
         jcustomercashpay_custname.setFocusable(true);
         as="";
         
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date date = new Date();
          jcustomercashpay_date.setText(dateFormat.format(date));
    }

    public void clear()
    {
        jcustomercashpay_name.setText("");
        jcustomercashpay_address.setText("");
        jcustomercashpay_contno.setText("");
        jcustomercashpay_pendingamt.setText("");
        jcustomercashpay_paidamt.setText("");
        jcustomercashpay_disct.setText("");
        //jcustomercashpay_date.setText("");
         jLabel9.setText("");
    }
    
    public void refreshTable()
    {
        
        
            coon=new Dbconn();
            rs=coon.execute_query("select DISTINCT(cust_name) from sales_store where status=? and remaning_amount>?",new String[]{"ACTIVE",""+0});
            
         try
        {    
          while(rs.next())
          {
              
              modelItem=(DefaultTableModel)jCustomercashpay_jtable.getModel();
            customername=rs.getString("cust_name");
             System.out.println(customername);
            modelItem.addRow(new String[]{customername});
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
       public void RefreshTable(char a)
    {
        
//        if((a == java.awt.event.KeyEvent.VK_BACK_SPACE))
//        {
//           as=ass;
//        }
//        else
//        { }
//        JOptionPane.showMessageDialog(rootPane, as, "Error", JOptionPane.ERROR_MESSAGE);
//            ass=as;
        
        
            as+=a;
        
      
        
       
        
    }
    
    //*************sorter table*********************
       private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jcustomercashpay_custname.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
       
       
        public Class getColumnClass(int column)
    {
    		
    	for ( row = 0; row < jCustomercashpay_jtable.getRowCount(); row++)
    	{
    	    Object o = jCustomercashpay_jtable.getValueAt(row, column);
     		if (o != null)
    		return o.getClass();
    	}
        return Object.class;
    	              
    }
       //*******************setdata to textfeilds***********************
       public void setdatatoTextfeild(String str)
       {
           

           cn=str;
          System.out.println(cn);
         
           
           //*********************getting customer details from creditors table***********************************
            try
        {
            conn=new Dbconn();
            rs_cust=conn.execute_query("select * from creditors where status=? and creditors_name=?",new String[]{"ACTIVE",cn});
            
          while(rs_cust.next())
          {
            
            custname=rs_cust.getString("creditors_name");
            address=rs_cust.getString("creditor_address");
            telno=rs_cust.getString("creditors_mob");
           // pendamt=rs.getString("pending_amount");
            //disct=rs_cust.getString("sales_discount");
          
             System.out.println("in next()");
             System.out.println(custname);
             System.out.println(address);
             System.out.println(telno);
            // System.out.println(pendamt);
             
              jcustomercashpay_name.setText(custname);
              jcustomercashpay_address.setText(address);
              jcustomercashpay_contno.setText(telno);
              //jcustomercashpay_pendingamt.setText(pendamt);
             
             // jcustomercashpay_disct.setText(disct);
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
            //************************************getting pending amount from creditor table*******************
             try
          {
              conn=new Dbconn();
              rs=conn.execute_query("select min(pending_amount)from creditors where status=? and creditors_name=?",new String[]{"ACTIVE",cn});
              
              while(rs.next())
              {
                  pendamt=rs.getString("min(pending_amount)");
                 jcustomercashpay_pendingamt.setText(pendamt);
              }
          }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,e);
          }
             
             //******************************getting customer id*************************//
             
            
              try
          {
              conn=new Dbconn();
              cn=str;
              System.out.println(cn);
              rs=conn.execute_query("select * from creditors where status=? and creditors_name=?",new String[]{"ACTIVE",cn});
              
              while(rs.next())
              {
                  cid=rs.getString("creditors_id");
                 jLabel9.setText(cid);
              }
          }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(null,e);
          }
       }
      
       //***************************************update Table Creditors*********************************
    public void updateTable()
    {
//           date=jcustomercashpay_date.getText();
           custname=jcustomercashpay_name.getText();
//           address=jcustomercashpay_address.getText();
//           telno=jcustomercashpay_contno.getText();
           pendamt=jcustomercashpay_pendingamt.getText();
           paid=jcustomercashpay_paidamt.getText();
           npaid=Float.parseFloat(paid);
//            disct=jcustomercashpay_disct.getText();
            
            // float newpenamt,pda,opa;
           
           
         
         
          pda=Float.parseFloat(pendamt);//total pending amount
          opa=Float.parseFloat(paid);// new paid amount
                  //new total paid amount=pev totalpaid+new paid amount
         
          pda=pda-opa;
          s=""+pda;
         if(pda>=0 && opa<=pda)
         {
        try
        {
            System.out.println(s);
            System.out.println(custname);
           conn=new Dbconn();
           a=conn.update_data("update creditors set pending_amount=? where creditors_name=?",new String[]{s,custname});
                     getpaidAmount();//***********get paid amount method
                     updatepaidAmount();//*******call updtae paid amount method 
          if (a > 0) {
                     JOptionPane.showMessageDialog(rootPane, "Data is updated in creditor table");
                   //  getpaidAmount();//***********get paid amount method
                     //updatepaidAmount();//*******call updtae paid amount method
                  } 
                 else {
                         JOptionPane.showMessageDialog(rootPane, "Data not updated");
                       }
            
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e); 
        }
        
        //***************************Getting previous paid amount***********************
//          try
//           {
//                conn=new Dbconn();
//                rs=conn.execute_query("select max(paid_amount) from creditors where status=? creditors_name=?",new String[]{"ACTIVE",custname});
//                totalpaid=rs.getString("max(paid_amount)");
//                System.out.println("total paid amount "+totalpaid);
//                tpaid=Float.parseFloat(totalpaid);//total paid amount
//                tpaid=tpaid+opa; 
//                System.out.println(tpaid);
//           }catch(Exception e)
//           {
//              
//               JOptionPane.showMessageDialog(rootPane,e);
//           }
       
        //***********************paid amount value is updated******************
//         try
//         {
//            conn=new Dbconn();
//           i=conn.update_data("update creditors set paid_amount=? where creditors_name=?",new String[]{tpaid+"",custname}); 
//         
//            if (i > 0) {
//                         JOptionPane.showMessageDialog(rootPane, "Data is updated in creditor table");
//                         clear();
//                      } 
//            else {
//                          JOptionPane.showMessageDialog(rootPane, "Data not updated");
//                  }
//         
//         
//         
//         }catch(Exception e)
//         {
//           JOptionPane.showMessageDialog(null,e); 
//         }
         }
        
         else
         {
              JOptionPane.showMessageDialog(rootPane, "pending amount may be negative or paid amount may be gretter ");
         }
    }
     public void updatepaidAmount()
       {
           
           try
         {
            conn=new Dbconn();
           i=conn.update_data("update creditors set paid_amount=? where creditors_name=?",new String[]{opa+"",custname}); 
         
            if (i > 0) {
                         JOptionPane.showMessageDialog(rootPane, "Data is updated in creditor table");
                         clear();
                      } 
            else {
                          JOptionPane.showMessageDialog(rootPane, "Data not updated");
                  }
         
         
         
         }catch(Exception e)
         {
           JOptionPane.showMessageDialog(null,e); 
         }
           
       }
     //*********************************************Get paid amount from table
     public void getpaidAmount()
     {
          try
           {
                conn=new Dbconn();
                rs=conn.execute_query("select max(paid_amount) from creditors where status=? creditors_name=?",new String[]{"ACTIVE",custname});
                totalpaid=rs.getString("max(paid_amount)");
                System.out.println("total paid amount "+totalpaid);
                tpaid=Float.parseFloat(totalpaid);//total paid amount
                tpaid=tpaid+opa; 
                System.out.println(tpaid);
           }catch(Exception e)
           {
              
               JOptionPane.showMessageDialog(rootPane,e);
           }
     }
    
    
    
    
    //********************************show date***********************************
    public void showDate()
    {
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCustomercashpay_jtable = new javax.swing.JTable();
        jcustomercashpay_custname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcustomercashpay_name = new javax.swing.JTextField();
        jcustomercashpay_address = new javax.swing.JTextField();
        jcustomercashpay_contno = new javax.swing.JTextField();
        jcustomercashpay_pendingamt = new javax.swing.JTextField();
        jcustomercashpay_paidamt = new javax.swing.JTextField();
        jcustomercashpay_disct = new javax.swing.JTextField();
        jcustomercashpay_date = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Customer Cash Payment");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 750));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Customer Cash Payment");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer List:"));

        jCustomercashpay_jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jCustomercashpay_jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCustomercashpay_jtableMouseClicked(evt);
            }
        });
        jCustomercashpay_jtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCustomercashpay_jtableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCustomercashpay_jtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jCustomercashpay_jtable);

        jcustomercashpay_custname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcustomercashpay_custnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcustomercashpay_custnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcustomercashpay_custnameKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcustomercashpay_custname))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jcustomercashpay_custname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon.png"))); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Contact No:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Pend.Amt:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Paid.Amt:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Disct:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Date:");

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("C");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcustomercashpay_name)
                                        .addComponent(jcustomercashpay_address, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jcustomercashpay_contno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jcustomercashpay_pendingamt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcustomercashpay_paidamt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcustomercashpay_disct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton1)
                                .addGap(62, 62, 62)
                                .addComponent(jButton2)
                                .addGap(60, 60, 60)
                                .addComponent(jButton3)))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcustomercashpay_date, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcustomercashpay_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcustomercashpay_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcustomercashpay_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcustomercashpay_contno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcustomercashpay_pendingamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcustomercashpay_paidamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcustomercashpay_disct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(67, 67, 67))
        );

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Voucher No:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(322, 390, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           date=jcustomercashpay_date.getText();
           custname=jcustomercashpay_name.getText();
           address=jcustomercashpay_address.getText();
           telno=jcustomercashpay_contno.getText();
           pendamt=jcustomercashpay_pendingamt.getText();
           paid=jcustomercashpay_paidamt.getText();
            disct=jcustomercashpay_disct.getText();
            
            // float newpenamt,pda,opa;
          
          
           
           
           if (jcustomercashpay_name.getText().equals(""))
        {
            str += "Plaese Enter Valide Customer Name/Enter Customer Details First";
            valid = 1;
        } 
  
  
         if(valid==1)
          {
           JOptionPane.showMessageDialog(rootPane, str);
          }
            else
          {
           if(valid==0)
          {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Are You Sure..","Confirm", JOptionPane.YES_NO_OPTION);
     
          }
          pendamt=jcustomercashpay_pendingamt.getText();
           paid=jcustomercashpay_paidamt.getText();
          pda=Float.parseFloat(pendamt);
          opa=Float.parseFloat(paid); 
          pda=pda-opa;
           
        if(a==0)
             {
                if(pda>=0 && opa<=pda)
                {
                conn=new Dbconn();
               
                int i=conn.insert_data("insert into customer_cashpay(date,cust_name,address,cont_no,pending_amt,paid_amt,"
                + "disct,status)"
                + "values (?,?,?,?,?,?,?,?)", new String[]{date,custname,address,telno,pendamt,paid,disct,"ACTIVE"});
             
//               System.out.println(creditorid);
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
                          JOptionPane.showMessageDialog(rootPane, "Data not save/Enter valide Paid Amount");
                          clear();
                          }
         
             }
           
           
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /*
         
         /////////////////////////////////////////////
         
         
         */
    
    
    }
    private void jCustomercashpay_jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCustomercashpay_jtableMouseClicked
          JTable target = (JTable)evt.getSource();
          if(evt.getClickCount()==1)
         {
            
             selectedrow = target.getSelectedRow();
             Object selectedCellValue=target.getValueAt(selectedrow, 0);
             jcustomercashpay_custname.setText(selectedCellValue.toString());
             System.out.println(selectedCellValue);
             setdatatoTextfeild((String) selectedCellValue); 
         }
    }//GEN-LAST:event_jCustomercashpay_jtableMouseClicked

    private void jCustomercashpay_jtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCustomercashpay_jtableKeyReleased
        // TODO add your handling code here:
       
         JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
             selectedrow= target.getSelectedRow();  
             Object selectedCellValue=target.getValueAt(selectedrow, 0); 
             jcustomercashpay_custname.setText(selectedCellValue.toString());
             setdatatoTextfeild((String) selectedCellValue);   
        }
        
    }//GEN-LAST:event_jCustomercashpay_jtableKeyReleased

    private void jCustomercashpay_jtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCustomercashpay_jtableKeyPressed
        
        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
             selectedrow= target.getSelectedRow();  
             Object selectedCellValue=target.getValueAt(selectedrow, 0);
              jcustomercashpay_custname.setText(selectedCellValue.toString());
             setdatatoTextfeild((String) selectedCellValue);   
        }// TODO add your handling code here:
    }//GEN-LAST:event_jCustomercashpay_jtableKeyPressed

    private void jcustomercashpay_custnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomercashpay_custnameKeyTyped
        // TODO add your handling code here:
        //sorter.sort();
        sortTable(); 
    }//GEN-LAST:event_jcustomercashpay_custnameKeyTyped

    private void jcustomercashpay_custnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomercashpay_custnameKeyPressed
        // TODO add your handling code here:
        sortTable(); 
         
    }//GEN-LAST:event_jcustomercashpay_custnameKeyPressed

    private void jcustomercashpay_custnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcustomercashpay_custnameKeyReleased
        // TODO add your handling code here:
       sortTable(); 
         
    }//GEN-LAST:event_jcustomercashpay_custnameKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTable jCustomercashpay_jtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jcustomercashpay_address;
    private javax.swing.JTextField jcustomercashpay_contno;
    private javax.swing.JTextField jcustomercashpay_custname;
    private javax.swing.JTextField jcustomercashpay_date;
    private javax.swing.JTextField jcustomercashpay_disct;
    private javax.swing.JTextField jcustomercashpay_name;
    private javax.swing.JTextField jcustomercashpay_paidamt;
    private javax.swing.JTextField jcustomercashpay_pendingamt;
    // End of variables declaration//GEN-END:variables
}
