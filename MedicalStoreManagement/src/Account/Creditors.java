/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import DB.Dbconn;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.math.*;



import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class Creditors extends javax.swing.JInternalFrame {

    int valid = 0;
        String str = "";
        Dbconn conn;
        String address;
        String temp,creditorid,creditorname,sono,date,paymode,totalamount,paidamount,pendingamount,cname,cid,tamount,pamount,cid1,creditormob,mobno;
        int sono1;
         DefaultTableModel modelItem,modelItem1;
         Connection con;
    int a;
   // float tamount,pamount,penamount;
   
    JFrame frame = new JFrame();
    public Creditors(JFrame parent, boolean modal) {
        initComponents();
         modelItem1=(DefaultTableModel)jcreditortable.getModel();
         
          refreshTable();
    }

    
     public void  refreshTable()
    {
         
        
        try
        {
            conn=new Dbconn();
            ResultSet rs=conn.execute_query("select * from creditors where status=?",new String[]{"ACTIVE"});
            
          while(rs.next())
          {
             
       
         creditorid=rs.getString("creditors_id");
         creditorname=rs.getString("creditors_name");
         address=rs.getString("creditor_address");
         creditormob=rs.getString("creditors_mob");
         sono=rs.getString("so_number");
         date=rs.getString("dated");
         paymode=rs.getString("pay_mode");
         totalamount=rs.getString("total_amount");
         paidamount=rs.getString("paid_amount");
         temp=rs.getString("pending_amount");
         
          
         
         modelItem1.addRow(new String[]{creditorid,creditorname,address, creditormob,sono, date,paymode,totalamount, paidamount, temp});
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcreditor_saleorderbillno = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jcreditor_PD = new javax.swing.JTextField();
        jcreditor_BA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcreditor_hisid = new javax.swing.JTextField();
        jcreditor_TA = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcreditor_creditorid = new javax.swing.JTextField();
        jcreditor_name = new javax.swing.JTextField();
        jcreditor_sono = new javax.swing.JTextField();
        jcreditor_date = new javax.swing.JTextField();
        jcreditor_totalamount = new javax.swing.JTextField();
        jcreditor_paidamount = new javax.swing.JTextField();
        jcreditor_pendingamount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcreditor_paymode = new javax.swing.JTextField();
        jcreditor_contactno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcreditor_address = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcreditortable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jcreditor_historytable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setResizable(true);
        setTitle("Creditors");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Creditor Note");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Enter Sale Order Bill No");

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Select-icon.png"))); // NOI18N
        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton6.setText("History");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jcreditor_PD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcreditor_PDFocusGained(evt);
            }
        });

        jcreditor_BA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcreditor_BAFocusGained(evt);
            }
        });

        jLabel11.setText("Total Amount");

        jLabel12.setText("Paid Amount");

        jLabel13.setText("Balance Amount");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Cus.id");

        jcreditor_TA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcreditor_TAFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jcreditor_saleorderbillno, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(23, 23, 23)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcreditor_hisid, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcreditor_TA, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcreditor_PD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcreditor_BA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcreditor_saleorderbillno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jcreditor_PD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcreditor_BA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jcreditor_hisid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcreditor_TA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Creditor Detail"));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Customer Id");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Customer Name");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Sales Oder No");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Date");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Total Amount");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Paid Amount");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Pending Amount");

        jcreditor_paidamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcreditor_paidamountFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Payment Mode");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Contact No");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Customer Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcreditor_contactno)
                    .addComponent(jcreditor_creditorid)
                    .addComponent(jcreditor_name)
                    .addComponent(jcreditor_sono)
                    .addComponent(jcreditor_date)
                    .addComponent(jcreditor_totalamount)
                    .addComponent(jcreditor_paidamount)
                    .addComponent(jcreditor_pendingamount, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jcreditor_paymode)
                    .addComponent(jcreditor_address))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_creditorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jcreditor_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_sono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_paymode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcreditor_paidamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcreditor_pendingamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon.png"))); // NOI18N
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jcreditortable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CreditorId", "CreditorName", "Address", "Mob.no", "SONO", "Date", "paymode", "TotalAmount", "PaidAmount", "PendingAmount"
            }
        ));
        jcreditortable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcreditortableMouseClicked(evt);
            }
        });
        jcreditortable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcreditortableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcreditortableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jcreditortable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jcreditor_historytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Bill_no", "Customer_Name", "TotalAmount", "Paid_Amount", "Pending_Amount"
            }
        ));
        jScrollPane2.setViewportView(jcreditor_historytable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(761, 761, 761))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         this.dispose();
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        
        
        jcreditor_saleorderbillno.setText("");
        jcreditor_creditorid.setText("");
        jcreditor_name.setText("");
        jcreditor_contactno.setText("");
        jcreditor_sono.setText("");
        jcreditor_date.setText("");
        jcreditor_paymode.setText("");
        jcreditor_totalamount.setText("");
        jcreditor_paidamount.setText("");
        jcreditor_pendingamount.setText("");
        jcreditor_hisid.setText("");
         jcreditor_TA.setText("");
         jcreditor_PD.setText("");
         jcreditor_BA.setText("");
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//  int k=0;
//        conn=new Dbconn();
//       String cust_id,cust_name,cust_date,sales_orderno,pay_mode,total_amount,paid_amount,pending_amount;
//      
//       cust_id=jcreditor_creditorid.getText();
//       cust_name=jcreditor_name.getText();
//      sales_orderno=jcreditor_saleorderbillno.getText();
//      cust_date=jcreditor_date.getText();
//      pay_mode=jcreditor_paymode.getText();
//      total_amount=jcreditor_totalamount.getText();
//      paid_amount=jcreditor_paidamount.getText();
//      pending_amount=jcreditor_pendingamount.getText();
//      
        //String sql="insert into creditors(creditors_id,creditors_name,so_number,dated,pay_mode,total_amount,paid_amount,pending_amount,status)Values(?,?,?,?,?,?,?,?,Active)";
// try{
//  PreparedStatement pst=con.prepareStatement(sql);
//               pst=con.prepareStatement(sql);
//              pst.setString(1, cust_id);
//              System.out.println("cust_id");
//               pst.setString(2, cust_name);
//               System.out.println("cust_name");
//               pst.setString(3, sales_orderno);
//                pst.setString(4,  cust_date);
//                pst.setString(5, pay_mode);
//                pst.setString(6, total_amount);
//                 pst.setString(7, paid_amount);
//                  pst.setString(8, pending_amount);
//               
//      

//                k=pst.executeUpdate(sql);
//                JOptionPane.showMessageDialog(rootPane, "save");
// 
// }
// catch(Exception e)
// {
//     JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
// }
 
    
 
       // conn=conn.getConnection();
 
  if (    jcreditor_saleorderbillno.getText().equals("")) 
        {
            str += "Plaese Enter Sale Order Bill No";
            valid = 1;
        } 
  if (    jcreditor_creditorid.getText().equals("")) 
        {
            str += "\n"+"Plaese Enter creditor Id";
            valid = 1;
        } 
  if (    jcreditor_name.getText().equals("")) 
        {
            str +="\n"+ "Plaese Enter Creditor Name";
            valid = 1;
        } 
    if (    jcreditor_contactno.getText().equals("")) 
        {
            str +="\n"+ "Plaese Enter Contact No";
            valid = 1;
        } 
  
   if (   jcreditor_sono.getText().equals("")) 
        {
            str +="\n"+"Plaese Enter Sale Order Bill No";
            valid = 1;
        } 
  if (    jcreditor_date.getText().equals("")) 
        {
            str += "\n"+"Plaese Enter date";
            valid = 1;
        } 
    if (    jcreditor_paymode.getText().equals("")) 
        {
            str += "\n"+"Plaese Enter paymentmode";
            valid = 1;
        } 
  if (    jcreditor_totalamount.getText().equals("")) 
        {
            str += "\n"+"Plaese Enter Total amount";
            valid = 1;
        } 
  if (    jcreditor_paidamount.getText().equals("")) 
        {
            str +="\n"+ "Plaese Enter Paid amount";
            valid = 1;
        } 
  if (        jcreditor_pendingamount.getText().equals("")) 
        {
            str += "\n"+"Plaese Enter Pending amount ";
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
        if(a==0)
             {
            
                conn=new Dbconn();
               
                int i=conn.insert_data("insert into creditors(creditors_id,creditors_name,creditor_address,creditors_mob,so_number,dated,pay_mode,"
                + "total_amount,paid_amount,pending_amount,status)"
                + "values (?,?,?,?,?,?,?,?,?,?,?)", new String[]{jcreditor_creditorid.getText(),jcreditor_name.getText(),jcreditor_address.getText(),jcreditor_contactno.getText(),jcreditor_sono.getText(),
                 jcreditor_date.getText(),jcreditor_paymode.getText(),jcreditor_totalamount.getText(),jcreditor_paidamount.getText(),
                jcreditor_pendingamount.getText(),"ACTIVE"});
             
//               System.out.println(creditorid);
//               System.out.println(paymode);
//               System.out.println(totalamount);
//               System.out.println(pendingamount);
             
        if (i > 0) {
                     JOptionPane.showMessageDialog(rootPane, "Data saved Sucessfully.","Save",JOptionPane.INFORMATION_MESSAGE);
               
                  } 
        else {
               JOptionPane.showMessageDialog(rootPane, "Data not save","Error.",JOptionPane.ERROR_MESSAGE);
            }
         
        
        String col1,col2,col3,col4,col5,col6,col7,col8,col9,col10;
           
           col1=jcreditor_creditorid.getText();
            col2=jcreditor_name.getText();
            col10=jcreditor_address.getText();
            col3=jcreditor_contactno.getText();
            col4=jcreditor_sono.getText();
           col5= jcreditor_date.getText();
            col6= jcreditor_paymode.getText();
            col7=jcreditor_totalamount.getText();
            col8=jcreditor_paidamount.getText();
            col9=jcreditor_pendingamount.getText();
            
            
              
             modelItem1.addRow(new String[]{col1,col2,col10,col3,col4,col5,col6,col7,col8,col9});            
              //textbox clear
              jcreditor_saleorderbillno.setText("");
              jcreditor_creditorid.setText("");
              jcreditor_name.setText("");
              jcreditor_address.setText("");
              jcreditor_contactno.setText("");
              jcreditor_sono.setText("");
              jcreditor_date.setText("");
              jcreditor_paymode.setText("");
              jcreditor_totalamount.setText("");
              jcreditor_paidamount.setText("");
              jcreditor_pendingamount.setText("");

             }
            
          
             
  
       }
 //TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

         modelItem= (DefaultTableModel) jcreditor_historytable.getModel();
         modelItem.setRowCount(0);
         
        jcreditor_hisid.setText("");
        jcreditor_TA.setText("");
        jcreditor_PD.setText("");
        jcreditor_BA.setText("");
        
        
        
       // jcreditor_saleorderbillno.setText("");
              jcreditor_creditorid.setText("");
              jcreditor_name.setText("");
              jcreditor_address.setText("");
              jcreditor_contactno.setText("");
              jcreditor_sono.setText("");
              jcreditor_date.setText("");
              jcreditor_paymode.setText("");
              jcreditor_totalamount.setText("");
              jcreditor_paidamount.setText("");
              jcreditor_pendingamount.setText("");
              
//              modelItem1= (DefaultTableModel) jcreditortable.getModel();
//              modelItem1.setRowCount(0);
        
        
        
        
        temp=jcreditor_saleorderbillno.getText();
                     cname=jcreditor_name.getText();
                       if(temp.equals(""))
         {
             str += "Plaese Enter Sale Order Bill No";
            valid = 1;
             
         }
            else{
         
          conn=new Dbconn();
          ResultSet rs=conn.execute_query("select * from sales_store where bill_id=?", new String[]{temp});
         
        try
        {
            while(rs.next())//getText from result set
            {
                       
           creditorid=rs.getString("cust_id");
           creditorname=rs.getString("cust_name");
           address=rs.getString("address");
           creditormob=rs.getString("phn_no");
           sono=rs.getString("bill_id");
           date=rs.getString("saledate");
           paymode=rs.getString("pay_mode");
           totalamount=rs.getString("bill_total");
           paidamount=rs.getString("paid_amount");
           //float t=Float.parseFloat(totalamount);
          // float p=Float.parseFloat(paidamount);
           //float b=(t-p);
           //pendingamount=""+b;
           pendingamount=rs.getString("remaning_amount");
           
           //setText to Text box
            
               jcreditor_creditorid.setText(creditorid);
               jcreditor_name.setText(creditorname);
               jcreditor_address.setText(address);
               jcreditor_contactno.setText(creditormob);
               jcreditor_sono.setText(sono);
               jcreditor_date.setText(date);
               jcreditor_paymode.setText(paymode);
               jcreditor_totalamount.setText(totalamount);
               jcreditor_paidamount.setText(paidamount);
               jcreditor_pendingamount.setText(pendingamount);
           
            }
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
         }
                       
         if(jcreditor_name.getText().equals("") && jcreditor_sono.getText().equals("") && jcreditor_date.getText().equals(""))
         {
             JOptionPane.showMessageDialog(rootPane, "Bill no is not Valid", "Error", JOptionPane.ERROR_MESSAGE);
         }
                       
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jcreditor_paidamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcreditor_paidamountFocusLost
     float t=Float.parseFloat(jcreditor_totalamount.getText());
           float p=Float.parseFloat(jcreditor_paidamount.getText());
           float b=(t-p);
          jcreditor_pendingamount.setText(String.valueOf(b));
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jcreditor_paidamountFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             conn=new Dbconn();
             //modelItem = (DefaultTableModel) jcreditortable.getModel();
             
       int s= JOptionPane.showConfirmDialog(null, "Are You Conform..", "Delete", JOptionPane.YES_NO_OPTION);
                 if (s==JOptionPane.YES_OPTION){
                           int selectedRow = jcreditortable.getSelectedRow();
                            
                          if(selectedRow != -1) 
                          {
                           modelItem1.removeRow(selectedRow);
                       
                           
                           String creditorid=jcreditor_creditorid.getText();
                   
                       int s1=conn.update_data("delete from creditors where creditors_id=?", new String[]{creditorid});
                    if (s1==1)
                    {
                        JOptionPane.showMessageDialog(null,"Record deleted Successfully", "Delete",JOptionPane.OK_OPTION);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Record is not Deleted");
                    }
                           
    }                                        

                          
                           }
              if (s==JOptionPane.NO_OPTION)
                 {
                  this.dispose();
                 }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcreditortableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcreditortableMouseClicked
        if(evt.getClickCount()==1)
         {
             JTable target=(JTable)evt.getSource();
             int selectedrow = target.getSelectedRow();
             
             Object selectedcellvalue = target.getValueAt(selectedrow,0);
              jcreditor_creditorid.setText((String) selectedcellvalue);
              
              selectedcellvalue = target.getValueAt(selectedrow, 1);        
              jcreditor_name.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 2);        
              jcreditor_address.setText((String) selectedcellvalue);
              
               
              selectedcellvalue = target.getValueAt(selectedrow, 3);        
              jcreditor_contactno.setText((String) selectedcellvalue);
             
              selectedcellvalue = target.getValueAt(selectedrow, 4);
            jcreditor_sono.setText((String) selectedcellvalue);
            
            selectedcellvalue = target.getValueAt(selectedrow, 5);
            jcreditor_date.setText((String) selectedcellvalue);
            
              selectedcellvalue = target.getValueAt(selectedrow, 6);
            jcreditor_paymode.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 7);
               jcreditor_totalamount.setText((String) selectedcellvalue);
                
                 selectedcellvalue = target.getValueAt(selectedrow, 8);
             jcreditor_paidamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 9);
               jcreditor_pendingamount.setText((String) selectedcellvalue);
               
               selectedcellvalue = target.getValueAt(selectedrow, 4);
           jcreditor_saleorderbillno.setText((String) selectedcellvalue);
                
                  
        
         }
        
        
        
        
        
    }//GEN-LAST:event_jcreditortableMouseClicked

    private void jcreditortableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcreditortableKeyPressed
    /*   JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
          int selectedrow= target.getSelectedRow(); 
           Object selectedcellvalue = target.getValueAt(selectedrow,0);
            jcreditor_creditorid.setText((String) selectedcellvalue);
              
                 selectedcellvalue = target.getValueAt(selectedrow, 1);
             
             
             jcreditor_name.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 2);
           jcreditor_sono.setText((String) selectedcellvalue);
            
              selectedcellvalue = target.getValueAt(selectedrow, 2);
            jcreditor_saleorderbillno.setText((String) selectedcellvalue);
              
                 selectedcellvalue = target.getValueAt(selectedrow, 3);
               jcreditor_date.setText((String) selectedcellvalue);
                
                 selectedcellvalue = target.getValueAt(selectedrow, 4);
                jdebtors_paymode.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 5);
               jdebtors_totalamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 6);
                jdebtors_paidamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 7);
                jdebtors_pendingamount.setText((String) selectedcellvalue);
      
     
     
    }*/
        
    }//GEN-LAST:event_jcreditortableKeyPressed

    private void jcreditortableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcreditortableKeyReleased
       
         JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
      {   
             int selectedrow= target.getSelectedRow(); 
             Object selectedcellvalue = target.getValueAt(selectedrow,0);
              jcreditor_creditorid.setText((String) selectedcellvalue);
              
              selectedcellvalue = target.getValueAt(selectedrow, 1);        
              jcreditor_name.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 2);        
              jcreditor_address.setText((String) selectedcellvalue);
              
               
              selectedcellvalue = target.getValueAt(selectedrow, 3);        
              jcreditor_contactno.setText((String) selectedcellvalue);
             
              selectedcellvalue = target.getValueAt(selectedrow, 4);
            jcreditor_sono.setText((String) selectedcellvalue);
            
            selectedcellvalue = target.getValueAt(selectedrow, 5);
            jcreditor_date.setText((String) selectedcellvalue);
            
              selectedcellvalue = target.getValueAt(selectedrow, 6);
            jcreditor_paymode.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 7);
               jcreditor_totalamount.setText((String) selectedcellvalue);
                
                 selectedcellvalue = target.getValueAt(selectedrow, 8);
             jcreditor_paidamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 9);
               jcreditor_pendingamount.setText((String) selectedcellvalue);
               
               selectedcellvalue = target.getValueAt(selectedrow, 4);
           jcreditor_saleorderbillno.setText((String) selectedcellvalue);
                
        
         }
        
        
    }//GEN-LAST:event_jcreditortableKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       conn=new Dbconn();
       
       if( jcreditor_hisid.getText().equals(""))
       {
           JOptionPane.showMessageDialog(null, "Enter the customer id first...","Error", JOptionPane.ERROR_MESSAGE);
       }
       String cid=jcreditor_hisid.getText();
       
      modelItem = (DefaultTableModel) jcreditor_historytable.getModel();
       modelItem.setRowCount(0);
       
      
       try
        {
            conn=new Dbconn();
            ResultSet rs=conn.execute_query("select * from creditors where status=? and creditors_id=?",new String[]{"ACTIVE",cid});
            
          while(rs.next())
          {
            creditorname=rs.getString("creditors_name");
           // mobno=rs.getString("creditors_mob");
            sono=rs.getString("so_number");
            date=rs.getString("dated");
            totalamount=rs.getString("total_amount");
            paidamount=rs.getString("paid_amount");
            temp=rs.getString("pending_amount");
             
            
            modelItem=(DefaultTableModel)jcreditor_historytable.getModel();
            modelItem.addRow(new String[]{ date,sono,creditorname,totalamount, paidamount,temp});
          }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       
        modelItem=(DefaultTableModel)jcreditor_historytable.getModel();
       if(modelItem.getRowCount()==0)
       {
            JOptionPane.showMessageDialog(rootPane, "History not Available/Enter valide CustomerID", "Error", JOptionPane.ERROR_MESSAGE);
            jcreditor_hisid.setText("");
       }
       ///////////clear after history click/////////////////
//         jcreditor_TA.setText("");
//         jcreditor_PD.setText("");
//         jcreditor_BA.setText("");
  //     
//        
//         if(  jcreditor_name.getText().equals("") &&  jcreditor_creditorid.getText().equals("") && jcreditor_sono.getText().equals(""))
//         {
//            JOptionPane.showMessageDialog(rootPane, "May be Sales Invoice Bill no is not Valid OR Empty ", "Error", JOptionPane.ERROR_MESSAGE);
//        
//         }
       
       
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    
    
    private void jcreditor_PDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcreditor_PDFocusGained
        
        conn=new Dbconn();
         cid1=jcreditor_hisid.getText();
        try{
            
            ResultSet rs2=conn.execute_query("select SUM(paid_amount) from creditors  where status=? and creditors_id=?",new String[]{"ACTIVE",cid1});
            while(rs2.next())
            {
             pamount=rs2.getString("SUM(paid_amount)");
             System.out.println(pamount);
              jcreditor_PD.setText(String.valueOf( pamount));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jcreditor_PDFocusGained

    private void jcreditor_BAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcreditor_BAFocusGained
       
        conn=new Dbconn();
        cid1=jcreditor_hisid.getText();
        try{
            
            ResultSet rs3=conn.execute_query("select SUM(pending_amount) from creditors where status=? and creditors_id=?",new String[]{"ACTIVE",cid1});
            while(rs3.next())
            {
            
           String penamount=rs3.getString("SUM(pending_amount)");
            System.out.println(penamount);
         jcreditor_BA.setText(penamount);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
//        try{
//            
//            ResultSet rs3=conn.execute_query("select SUM(pending_amount) from creditors where status=? and creditors_id=?",new String[]{"ACTIVE",cid});
//            while(rs3.next())
//            {
//            
//           String penamount=rs3.getString("SUM(pending_amount)");
//            System.out.println(penamount);
//         jcreditor_BA.setText(penamount);
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
        
    }//GEN-LAST:event_jcreditor_BAFocusGained

    private void jcreditor_TAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcreditor_TAFocusGained

        
         conn=new Dbconn();
        cid1=jcreditor_hisid.getText();
        try{
            
            ResultSet rs3=conn.execute_query("select SUM(total_amount) from creditors where status=? and creditors_id=?",new String[]{"ACTIVE",cid1});
            while(rs3.next())
            {
            
           String totalamount=rs3.getString("SUM(total_amount)");
            System.out.println(totalamount);
          jcreditor_TA.setText(totalamount);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        








// TODO add your handling code here:
    }//GEN-LAST:event_jcreditor_TAFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jcreditor_BA;
    private javax.swing.JTextField jcreditor_PD;
    private javax.swing.JTextField jcreditor_TA;
    private javax.swing.JTextField jcreditor_address;
    private javax.swing.JTextField jcreditor_contactno;
    private javax.swing.JTextField jcreditor_creditorid;
    private javax.swing.JTextField jcreditor_date;
    private javax.swing.JTextField jcreditor_hisid;
    private javax.swing.JTable jcreditor_historytable;
    private javax.swing.JTextField jcreditor_name;
    private javax.swing.JTextField jcreditor_paidamount;
    private javax.swing.JTextField jcreditor_paymode;
    private javax.swing.JTextField jcreditor_pendingamount;
    private javax.swing.JTextField jcreditor_saleorderbillno;
    private javax.swing.JTextField jcreditor_sono;
    private javax.swing.JTextField jcreditor_totalamount;
    private javax.swing.JTable jcreditortable;
    // End of variables declaration//GEN-END:variables
}
