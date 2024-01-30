/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import DB.Dbconn;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Debtors extends javax.swing.JInternalFrame {
int valid = 0;
        String str = "";
        Dbconn conn;
        String debtors_id,debtorname,pono,date,paymentmode,totalamount,paidamount,pendingamount,temp,did,tamount,pamount;
       
    
    JFrame frame = new JFrame();
    DefaultTableModel modelItem,modelItem1;
    
    
    public Debtors(JFrame parent, boolean modal) {
       
        initComponents();
         modelItem1=(DefaultTableModel)jDebtorsTable.getModel();
          refreshTable();
    }

     public void  refreshTable()
    {
         
        
        try
        {
            conn=new Dbconn();
            ResultSet rs=conn.execute_query("select * from debtors where status=?",new String[]{"ACTIVE"});
            
          while(rs.next())
          {
               
       
         debtors_id=rs.getString("debtors_id");
         debtorname=rs.getString("debtors_name");
          pono=rs.getString("po_number");
         date=rs.getString("dated");
         paymentmode=rs.getString("payment_mode");
          totalamount=rs.getString("total_amount");
          paidamount=rs.getString("paid_amount");
         temp=rs.getString("pending_amount");
         
          
         
         modelItem1.addRow(new String[]{debtors_id, debtorname,pono,date, paymentmode,totalamount, paidamount, temp});
             }
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jdebtors_poorderbillno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        History = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTotal_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jpaid_amount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jbalance_amount = new javax.swing.JTextField();
        jdistributor_idhistory = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdebtors_id = new javax.swing.JTextField();
        jdebtors_name = new javax.swing.JTextField();
        jdebtors_ponumber = new javax.swing.JTextField();
        jdebtors_date = new javax.swing.JTextField();
        jdebtors_totalamount = new javax.swing.JTextField();
        jdebtors_paidamount = new javax.swing.JTextField();
        jdebtors_pendingamount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jdebtors_paymode = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDebtorsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jdebtor_history = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setClosable(true);
        setTitle("Debtors");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("DebtorsNote");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Enter Purchase Invoice Bill No:");

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Select-icon.png"))); // NOI18N
        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Dis.Id");

        History.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        History.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add to card.png"))); // NOI18N
        History.setText("History");
        History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Total Amount");

        jTotal_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTotal_amountFocusGained(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Paid Amount");

        jpaid_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpaid_amountFocusGained(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Balance Amount");

        jbalance_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbalance_amountFocusGained(evt);
            }
        });

        jdistributor_idhistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdistributor_idhistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jdebtors_poorderbillno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdistributor_idhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(History)
                .addGap(38, 38, 38)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpaid_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbalance_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jdebtors_poorderbillno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jTotal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jpaid_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jbalance_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(History, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdistributor_idhistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Debtors Id");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("DebtorsName");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Purchase Invoice  no");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Date");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("TotalAmount");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("PaidAmount");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("PendingAmount");

        jdebtors_paidamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jdebtors_paidamountFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Payment Mode");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jdebtors_paidamount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jdebtors_totalamount, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdebtors_date, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdebtors_ponumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdebtors_name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdebtors_id, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdebtors_pendingamount)
                    .addComponent(jdebtors_paymode))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jdebtors_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jdebtors_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jdebtors_ponumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdebtors_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jdebtors_paymode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jdebtors_totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdebtors_paidamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jdebtors_pendingamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jDebtorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Debtors id", "DebtorsName", "PO NO", "Date", "PayMode", "Total Amount", "PaidAmount", "Pending Amount"
            }
        ));
        jDebtorsTable.setName(""); // NOI18N
        jDebtorsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDebtorsTableMouseClicked(evt);
            }
        });
        jDebtorsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDebtorsTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDebtorsTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jDebtorsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton2.setText("Save");
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

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jButton5.setText("Delete");
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("History"));

        jdebtor_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "PO InvoiceNo", "Distributor Name", "Total Amount", "Paid Amount", "Pending Amount"
            }
        ));
        jScrollPane2.setViewportView(jdebtor_history);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(663, 663, 663))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1016, 1016, 1016))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        conn=new Dbconn();
       
        
        if (jdebtors_poorderbillno.getText().equals("")) 
        {
            str += "Plaese Enter Purchase Order Bill No";
            valid = 1;
        } 
         
        
        
        if (jdebtors_id.getText().equals("")) {
            str +="\n"+ "Plaese Enter Debtors Id";
            valid = 1;
        } 
         if (jdebtors_name.getText().equals("")) {
            str +="\n"+ "Plaese Enter Debtors Name";
            valid = 1;
        } 
          if (jdebtors_ponumber.getText().equals("")) {
            str +="\n"+ "Plaese Enter Purchase Order Number";
            valid = 1;
        } 
           if (jdebtors_date.getText().equals("")) {
            str += "\n"+"Plaese Enter Date";
            valid = 1;
        } 
            if (jdebtors_paymode.getText().equals("")) {
            str += "\n"+"Plaese Enter Payment Mode";
            valid = 1;
        } 
           if (jdebtors_totalamount.getText().equals("")) {
            str +="\n"+ "Plaese Enter Total Amount";
            valid = 1;
        } 
           if (jdebtors_paidamount.getText().equals("")) {
            str +="\n"+ "Plaese Enter Paid Amount";
            valid = 1;
        } 
           
           if (jdebtors_pendingamount.getText().equals("")) {
            str +="\n"+ "Plaese Enter Pending Amount";
            valid = 1;
        } 
             
           
      
           if(valid==1)
        {
           JOptionPane.showMessageDialog(rootPane, str);
        }
           
       else
       {
          
             int s= JOptionPane.showConfirmDialog(null, "Are You Save this..", "SAVE RECORD", JOptionPane.YES_NO_OPTION); 
        
         int i=conn.insert_data("insert into debtors(debtors_id,debtors_name,po_number,dated,"
                + "payment_mode,total_amount,paid_amount,pending_amount,status)"
                + "values (?,?,?,?,?,?,?,?,?)", new String[]{jdebtors_id.getText(),jdebtors_name.getText(),jdebtors_ponumber.getText(),
                    jdebtors_date.getText(),jdebtors_paymode.getText(),jdebtors_totalamount.getText(),jdebtors_paidamount.getText(),
                    jdebtors_pendingamount.getText(),"ACTIVE"});
        if (i > 0) {
                JOptionPane.showMessageDialog(rootPane, "Data save");
                //refreshTable();
                //this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data not save");
            }
             String col1,col2,col3,col4,col5,col6,col7,col8;
            
            col1=jdebtors_id.getText();
            col2=jdebtors_name.getText();
            col3=jdebtors_ponumber.getText();
            col4=jdebtors_date.getText();
            col5=jdebtors_totalamount.getText();
            col6=jdebtors_paidamount.getText();
            col7=jdebtors_pendingamount.getText();
            col8=jdebtors_paymode.getText();
             
             conn=new Dbconn();
              //modelItem=(DefaultTableModel)jDebtorsTable.getModel();
              modelItem1.addRow(new String[]{col1,col2,col3,col4,col8,col5,col6,col7});
            
    //  Clear Textbox
            jdebtors_poorderbillno.setText("");
            jdebtors_id.setText("");
            jdebtors_name.setText("");
            jdebtors_ponumber.setText("");
            jdebtors_date.setText("");
            jdebtors_paymode.setText("");
            jdebtors_totalamount.setText("");
            jdebtors_paidamount.setText("");
            jdebtors_pendingamount.setText("");

             
        
        
           
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        jdebtors_poorderbillno.setText("");
        jdebtors_id.setText("");
        jdebtors_name.setText("");
        jdebtors_ponumber.setText("");
        jdebtors_date.setText("");
        jdebtors_paymode.setText("");
        jdebtors_totalamount.setText("");
        jdebtors_paidamount.setText("");
        jdebtors_pendingamount.setText("");
        ///////////////History Text//////////////////////////
        jdistributor_idhistory.setText("");
        jTotal_amount.setText("");
        jpaid_amount.setText("");
        jbalance_amount.setText("");
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//          modelItem= (DefaultTableModel) jdebtor_history.getModel();
//         modelItem.setRowCount(0);
//        
//        jdistributor_id.setText("");
//        jTotal_amount.setText("");
//        jpaid_amount.setText("");
//        jbalance_amount.setText("");
//        
         
         
         temp=jdebtors_poorderbillno.getText();
        
         if(temp.equals(""))
         {
             //str += "Plaese Enter Purchase Order Bill No";
            //valid = 1;
             JOptionPane.showMessageDialog(null," Please Enter Purchase Invoice Bill No","Error", JOptionPane.ERROR_MESSAGE);
         }
        
         else{
         
          
          ResultSet rs=conn.execute_query("select * from purchase_invoice where status=? and invoice_no=?", new String[]{"ACTIVE",temp});
          
        try
        {
            while(rs.next())//getText from result set
            {
          
           debtors_id=rs.getString("distributor_id");
           debtorname=rs.getString("distributors_name");
           pono=rs.getString("invoice_no");
           date=rs.getString("invoice_date");
           paymentmode=rs.getString("payment_mode");
           totalamount=rs.getString("actual_amount");
           paidamount=rs.getString("amount_paid");
          // float t=Float.parseFloat(totalamount);
         //  float p=Float.parseFloat(paidamount);
           //float b=(t-p);
           pendingamount=rs.getString("balance_amount");
           
           //setText to Text box
          
          
           jdebtors_id.setText(debtors_id);
           jdebtors_name.setText(debtorname);
           jdebtors_ponumber.setText(pono);
           jdebtors_date.setText(date);
           jdebtors_paymode.setText(paymentmode);
           jdebtors_totalamount.setText(totalamount);
           jdebtors_paidamount.setText(paidamount);
           jdebtors_pendingamount.setText(pendingamount);
           
            }
        }catch(Exception e)
        {
             e.printStackTrace();
        }
        /*
        
        */
        
         }
         
          if(jdebtors_name.getText().equals("") && jdebtors_ponumber.getText().equals("") && jdebtors_date.getText().equals(""))
         {
             JOptionPane.showMessageDialog(rootPane, "Purchase Invoice Bill no is not Valid", "Error", JOptionPane.ERROR_MESSAGE);
         }
         
        
         
        
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jdebtors_paidamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdebtors_paidamountFocusLost

         float t=Float.parseFloat(jdebtors_totalamount.getText());
           float p=Float.parseFloat(jdebtors_paidamount.getText());
           float b=(t-p);
           jdebtors_pendingamount.setText(String.valueOf(b));
// TODO add your handling code here:
    }//GEN-LAST:event_jdebtors_paidamountFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
                     conn=new Dbconn();
       int s= JOptionPane.showConfirmDialog(null, "Are You Realy Wants to Delete this..", "Delete", JOptionPane.YES_NO_OPTION);
                 if (s==JOptionPane.YES_OPTION){
                           int selectedRow = jDebtorsTable.getSelectedRow();
                            
                          if(selectedRow != -1) 
                          {
                           modelItem1.removeRow(selectedRow);
                       
                           
                           String debid=jdebtors_id.getText();
                   
                       int s1=conn.update_data("delete from debtors where debtors_id=?", new String[]{debid});
                    if (s1==1)
                    {
                        JOptionPane.showMessageDialog(null,"Record deleted Successfuly", "Delete",JOptionPane.OK_OPTION);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Record is not Deleted");
                    }
                           
    }//GEN-LAST:event_jButton5ActionPerformed

                          
                           }
              if (s==JOptionPane.NO_OPTION)
                 {
                  this.dispose();
                 }
            }
    private void jDebtorsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDebtorsTableMouseClicked
         
 
         if(evt.getClickCount()==1)
         {
             JTable target=(JTable)evt.getSource();
             int selectedrow = target.getSelectedRow();
             
            Object selectedcellvalue = target.getValueAt(selectedrow,0);
            jdebtors_id.setText((String) selectedcellvalue);
              
            selectedcellvalue = target.getValueAt(selectedrow, 1);        
              
            jdebtors_name.setText((String) selectedcellvalue);
             
            selectedcellvalue = target.getValueAt(selectedrow, 2);
            jdebtors_poorderbillno.setText((String) selectedcellvalue);
                     
            selectedcellvalue = target.getValueAt(selectedrow, 2);
            jdebtors_ponumber.setText((String) selectedcellvalue);
              
            selectedcellvalue = target.getValueAt(selectedrow, 3);
            jdebtors_date.setText((String) selectedcellvalue);
                
            selectedcellvalue = target.getValueAt(selectedrow, 4);
            jdebtors_paymode.setText((String) selectedcellvalue);
                
            selectedcellvalue = target.getValueAt(selectedrow, 5);
            jdebtors_totalamount.setText((String) selectedcellvalue);
                
            selectedcellvalue = target.getValueAt(selectedrow, 6);
            jdebtors_paidamount.setText((String) selectedcellvalue);
                
            selectedcellvalue = target.getValueAt(selectedrow, 7);
            jdebtors_pendingamount.setText((String) selectedcellvalue);
              
         }
        
        
        
        
        
        
    }//GEN-LAST:event_jDebtorsTableMouseClicked
                //Key Pressed Event on Table data
    private void jDebtorsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDebtorsTableKeyPressed

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
     int selectedrow= target.getSelectedRow(); 
       Object selectedcellvalue = target.getValueAt(selectedrow,0);
             jdebtors_id.setText((String) selectedcellvalue);
              
                 selectedcellvalue = target.getValueAt(selectedrow, 1);
             
             
              jdebtors_name.setText((String) selectedcellvalue);
              
               selectedcellvalue = target.getValueAt(selectedrow, 2);
            jdebtors_poorderbillno.setText((String) selectedcellvalue);
            
              selectedcellvalue = target.getValueAt(selectedrow, 2);
             jdebtors_ponumber.setText((String) selectedcellvalue);
              
                 selectedcellvalue = target.getValueAt(selectedrow, 3);
                jdebtors_date.setText((String) selectedcellvalue);
                
                 selectedcellvalue = target.getValueAt(selectedrow, 4);
                jdebtors_paymode.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 5);
               jdebtors_totalamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 6);
                jdebtors_paidamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 7);
                jdebtors_pendingamount.setText((String) selectedcellvalue);
      
     
     
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jDebtorsTableKeyPressed

    private void jDebtorsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDebtorsTableKeyReleased
       
         JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
              int selectedrow= target.getSelectedRow(); 
             Object selectedcellvalue = target.getValueAt(selectedrow,0);
              jdebtors_id.setText((String) selectedcellvalue);
             
             
              
             selectedcellvalue = target.getValueAt(selectedrow, 1);
             jdebtors_name.setText((String) selectedcellvalue);
             
               selectedcellvalue = target.getValueAt(selectedrow, 2);
            jdebtors_poorderbillno.setText((String) selectedcellvalue);
            
              selectedcellvalue = target.getValueAt(selectedrow, 2);
             jdebtors_ponumber.setText((String) selectedcellvalue);
              
                 selectedcellvalue = target.getValueAt(selectedrow, 3);
                jdebtors_date.setText((String) selectedcellvalue);
                
                 selectedcellvalue = target.getValueAt(selectedrow, 4);
                jdebtors_paymode.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 5);
               jdebtors_totalamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 6);
                jdebtors_paidamount.setText((String) selectedcellvalue);
                
                  selectedcellvalue = target.getValueAt(selectedrow, 7);
                jdebtors_pendingamount.setText((String) selectedcellvalue);
      
    }
    }//GEN-LAST:event_jDebtorsTableKeyReleased

    private void jTotal_amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTotal_amountFocusGained

        
         conn=new Dbconn();
        did=jdistributor_idhistory.getText();
        try{
            
            ResultSet rs1=conn.execute_query("select SUM(total_amount)from debtors where status=? and debtors_id=?",new String[]{"ACTIVE",did});
            
            while(rs1.next())
            {
             tamount=rs1.getString("SUM(total_amount)");
             System.out.println(tamount);
             jTotal_amount.setText(tamount);
            }
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        

    }//GEN-LAST:event_jTotal_amountFocusGained

    private void jpaid_amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpaid_amountFocusGained

        
        conn=new Dbconn();
         did=jdistributor_idhistory.getText();
        try{
            
            ResultSet rs2=conn.execute_query("select SUM(paid_amount) from debtors  where status=? and debtors_id=?",new String[]{"ACTIVE",did});
            while(rs2.next())
            {
             pamount=rs2.getString("SUM(paid_amount)");
             System.out.println(pamount);
             jpaid_amount.setText(String.valueOf( pamount));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        


    }//GEN-LAST:event_jpaid_amountFocusGained

    private void jbalance_amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbalance_amountFocusGained

      
          
        conn=new Dbconn();
         did=jdistributor_idhistory.getText();
        try{
            
            ResultSet rs3=conn.execute_query("select SUM(pending_amount) from debtors where status=? and debtors_id=?",new String[]{"ACTIVE",did});
            while(rs3.next())
            {
            
           String penamount=rs3.getString("SUM(pending_amount)");
            System.out.println(penamount);
         jbalance_amount.setText(penamount);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
        
    }//GEN-LAST:event_jbalance_amountFocusGained

    private void HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryActionPerformed

        modelItem = (DefaultTableModel) jdebtor_history.getModel();
         modelItem.setRowCount(0);
         conn=new Dbconn();
         did=jdistributor_idhistory.getText();
       
        // modelItem = (DefaultTableModel) jdebtor_history.getModel();
         //modelItem.setRowCount(0);
       
      
       try
        {
            conn=new Dbconn();
            ResultSet rs=conn.execute_query("select * from debtors where status=? and debtors_id=?",new String[]{"ACTIVE",did});
            
          while(rs.next())
          {
            debtorname=rs.getString("debtors_name");
            pono=rs.getString("po_number");
            date=rs.getString("dated");
            totalamount=rs.getString("total_amount");
            paidamount=rs.getString("paid_amount");
            temp=rs.getString("pending_amount");
             
            
            modelItem=(DefaultTableModel)jdebtor_history.getModel();
            modelItem.addRow(new String[]{date, pono, debtorname,totalamount, paidamount,temp});
             
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        modelItem=(DefaultTableModel)jdebtor_history.getModel();
       if(modelItem.getRowCount()==0)
       {
            JOptionPane.showMessageDialog(rootPane, "History not Available/Enter Valide Distributor Id", "Error", JOptionPane.ERROR_MESSAGE);
        
       }
       
         if( jdebtors_name.getText().equals("") && jdebtors_ponumber.getText().equals("") &&jdebtors_date.getText().equals(""))
         {
            JOptionPane.showMessageDialog(rootPane, "May be Purchase Invoice Bill no is not Valid OR Empty ", "Error", JOptionPane.ERROR_MESSAGE);
             //jdistributor_idhistory.setText("");
         }
          //////////clear after history///////////////////////
       
       // jTotal_amount.setText("");
      //  jpaid_amount.setText("");
        //jbalance_amount.setText("");
        
// TODO add your handling code here:
    }//GEN-LAST:event_HistoryActionPerformed

    private void jdistributor_idhistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdistributor_idhistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdistributor_idhistoryActionPerformed

      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton History;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTable jDebtorsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTotal_amount;
    private javax.swing.JTextField jbalance_amount;
    private javax.swing.JTable jdebtor_history;
    private javax.swing.JTextField jdebtors_date;
    private javax.swing.JTextField jdebtors_id;
    private javax.swing.JTextField jdebtors_name;
    private javax.swing.JTextField jdebtors_paidamount;
    private javax.swing.JTextField jdebtors_paymode;
    private javax.swing.JTextField jdebtors_pendingamount;
    private javax.swing.JTextField jdebtors_ponumber;
    private javax.swing.JTextField jdebtors_poorderbillno;
    private javax.swing.JTextField jdebtors_totalamount;
    private javax.swing.JTextField jdistributor_idhistory;
    private javax.swing.JTextField jpaid_amount;
    // End of variables declaration//GEN-END:variables
}
