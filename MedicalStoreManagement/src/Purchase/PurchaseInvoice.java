/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Purchase;

import master.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DB.*;
import Stock.Materialinward;
import java.sql.*;
import javax.swing.JTable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PurchaseInvoice extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    int actualamount,paidamount,balanceamount,a,k;
    Dbconn conn,c;
    String error="";
    int valid=0;
     String gr1="";
    Connection con;
    DefaultTableModel modelItem;
    ResultSet rs_GRNumber;
    String grno,grdate,podate,dist_name,grstatus;
    int selectedRow;
    
    
    public PurchaseInvoice(JFrame parent, boolean modal) {
        initComponents();
        conn=new Dbconn();
        modelItem =(DefaultTableModel)jgrnumbertable.getModel();
         refreshTable();
         show_date();
         
         
           increament();
      //   jPaymentpanel.setVisible(false);
          //jPaymentpanel.show(false);
         
    }
     public void show_date()
    {
    Calendar c1=new GregorianCalendar();
      
     int month=c1.get(Calendar.MONTH);
        int day=c1.get(Calendar.DAY_OF_MONTH);
        int year=c1.get(Calendar.YEAR);
      jpurchase_invoucedate.setText(year+"/"+(month+1)+"/"+day);
        
    }
    
     public void increament()
    {
        int x;
        String grx = null;
        ResultSet rs_grno;
        Dbconn conn = new Dbconn();
        rs_grno = conn.execute_query("Select MAX(invoice_no) from purchase_invoice where status=?", new String[]{"ACTIVE"});
        try {
            while(rs_grno.next())
            {
               //System.out.println(rs_grno.getString("MAX(GR_no)"));
                grx = rs_grno.getString("MAX(invoice_no)");
                if(grx==null)
                {
                    grx="0";
                }
             }
            x=Integer.parseInt(grx);
            x=x+1;
            grx=""+x;
            jpurachase_invoiceno.setText(grx);
        } catch (SQLException ex) {
            Logger.getLogger(Materialinward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
public void refreshTable()
    {
        grno="";
       
       modelItem.setRowCount(0);
        try
        {
            rs_GRNumber=conn.execute_query("select * from material_inward_info where Material_Status=?", new String[]{"ACTIVE"});
            int r=jgrnumbertable.getRowCount();
            while (rs_GRNumber.next()) 
            {
                 gr1=grno;
                grno=rs_GRNumber.getString("GR_no");
             
              if(grno.equals(gr1))
              {
                  break;
              }
                 dist_name=rs_GRNumber.getString("distributors_name");
                 grdate=rs_GRNumber.getString("GR_date");
               
                grstatus=rs_GRNumber.getString("Material_Status");
                 modelItem.addRow(new String[]{grno,dist_name,grdate,grstatus});
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
            rs=st.executeQuery("select * from material_inward_info where GR_no="+cellvalue);
            while(rs.next())
            {
                jpurchasegrno.setText(rs.getString("GR_no"));
      
                jpurchase_disttname.setText(rs.getString("distributors_name"));
                
                jpurchase_ponumber.setText(rs.getString("PO_number"));
                
                jpurache_podate.setText(rs.getString("PO_date"));
                 
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jpurchaseinvoice_actualamount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jpurchasepaymentcombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jvatcombo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jpurchasepaymenttype = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jpurhase_amountpaid = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jpurchase_invoicebalanceamt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPaymentpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpurchasebankname = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jpurchase_refno = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpurachase_invoiceno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jpurchasegrno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jpurchase_ponumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jpurchase_invoucedate = new javax.swing.JTextField();
        jpurache_podate = new javax.swing.JTextField();
        jpurchase_disttname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jpurache_distributorid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jgrnumbertable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setTitle("PurchaseInvoice");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Purchase Invoice");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Actual Amount");

        jpurchaseinvoice_actualamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpurchaseinvoice_actualamountFocusGained(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Payment Mode");

        jpurchasepaymentcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Cheque", "OnlineTransfer" }));
        jpurchasepaymentcombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpurchasepaymentcomboFocusLost(evt);
            }
        });
        jpurchasepaymentcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpurchasepaymentcomboActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Vat:(Y/N)");

        jvatcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Yes", "No" }));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Payment Type");

        jpurchasepaymenttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full Payment", "Partial Payment" }));
        jpurchasepaymenttype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpurchasepaymenttypeFocusLost(evt);
            }
        });
        jpurchasepaymenttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpurchasepaymenttypeActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel20.setText("Amout Paid");

        jpurhase_amountpaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpurhase_amountpaidFocusLost(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel22.setText("Balance Amount");

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculate.png"))); // NOI18N
        jButton5.setText("Calculate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPaymentpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Details"));

        jLabel1.setText("Bank Name");

        jLabel19.setText("Party Account Number/Cheque Number");

        javax.swing.GroupLayout jPaymentpanelLayout = new javax.swing.GroupLayout(jPaymentpanel);
        jPaymentpanel.setLayout(jPaymentpanelLayout);
        jPaymentpanelLayout.setHorizontalGroup(
            jPaymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaymentpanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPaymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPaymentpanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jpurchase_refno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPaymentpanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpurchasebankname, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPaymentpanelLayout.setVerticalGroup(
            jPaymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaymentpanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPaymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jpurchasebankname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPaymentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpurchase_refno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPaymentpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jpurchasepaymentcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jpurchasepaymenttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpurchaseinvoice_actualamount, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jvatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpurchase_invoicebalanceamt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpurhase_amountpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpurchaseinvoice_actualamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jpurchasepaymentcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jpurchasepaymenttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPaymentpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jvatcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jpurhase_amountpaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpurchase_invoicebalanceamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("GRN no");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("PO Number");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Invoice No");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Name");

        jpurchasegrno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpurchasegrnoFocusGained(evt);
            }
        });
        jpurchasegrno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpurchasegrnoActionPerformed(evt);
            }
        });
        jpurchasegrno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpurchasegrnoPropertyChange(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("InvoiceDate:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("PO Date");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jButton6.setText("Get Dtails");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Distributor_id");

        jpurache_distributorid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jpurache_distributoridFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpurchasegrno)
                    .addComponent(jpurachase_invoiceno, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpurchase_ponumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpurache_podate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpurchase_disttname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpurache_distributorid, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jpurchase_invoucedate))
                .addGap(269, 269, 269))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpurchasegrno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jpurchase_disttname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jpurchase_invoucedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpurachase_invoiceno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17)
                    .addComponent(jLabel3)
                    .addComponent(jpurchase_ponumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jpurache_podate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jpurache_distributorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jgrnumbertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GR #", "Distributor Name", "GR Date", "GR Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jgrnumbertable.getTableHeader().setReorderingAllowed(false);
        jgrnumbertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jgrnumbertableMouseClicked(evt);
            }
        });
        jgrnumbertable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jgrnumbertableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jgrnumbertableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jgrnumbertable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpurchasegrnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpurchasegrnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasegrnoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpurchasepaymentcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpurchasepaymentcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasepaymentcomboActionPerformed

    private void jgrnumbertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jgrnumbertableMouseClicked

         if (evt.getClickCount() == 1)  
                {  
                 JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
                }// TODO add your handling code here:
    }//GEN-LAST:event_jgrnumbertableMouseClicked

    private void jgrnumbertableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jgrnumbertableKeyPressed
       
        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jgrnumbertableKeyPressed

    private void jgrnumbertableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jgrnumbertableKeyReleased

        
        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jgrnumbertableKeyReleased

    private void jpurchasegrnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurchasegrnoFocusGained
       
       

// TODO add your handling code here:
    }//GEN-LAST:event_jpurchasegrnoFocusGained

    private void jpurchasepaymenttypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurchasepaymenttypeFocusLost

    // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasepaymenttypeFocusLost

    private void jpurchasepaymenttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpurchasepaymenttypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasepaymenttypeActionPerformed

    private void jpurchasepaymentcomboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurchasepaymentcomboFocusLost

        // TODO add your handling code here:
      
    }//GEN-LAST:event_jpurchasepaymentcomboFocusLost

    private void jpurchasegrnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpurchasegrnoPropertyChange
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jpurchasegrnoPropertyChange

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        
        String temp=grno.toString();
        
        
        try
        {
            ResultSet rs=conn.execute_query("select SUM(total_purchase_price) from material_inward_info where Material_Status=? AND GR_no=?", new String[]{"ACTIVE",temp});
           while(rs.next())
             {
            jpurchaseinvoice_actualamount.setText(rs.getString("SUM(total_purchase_price)"));
            
            System.out.println("Inside the show button code");
             }
        }
        catch(Exception ex)
        {
                     JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   actualamount=Integer.parseInt(jpurchaseinvoice_actualamount.getText());
   paidamount=Integer.parseInt(jpurhase_amountpaid.getText());
   balanceamount=actualamount-paidamount;
   String temp=""+balanceamount;
   jpurchase_invoicebalanceamt.setText(temp);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jpurhase_amountpaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurhase_amountpaidFocusLost
actualamount=Integer.parseInt(jpurchaseinvoice_actualamount.getText());
   paidamount=Integer.parseInt(jpurhase_amountpaid.getText());
   balanceamount=actualamount-paidamount;
   String temp=""+balanceamount;
   jpurchase_invoicebalanceamt.setText(temp);        // TODO add your handling code here:
    }//GEN-LAST:event_jpurhase_amountpaidFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        System.out.println("in SAVE button");
        
        error="";
        valid=0;
    if(jpurchasegrno.getText().equals(""))
    {
        error +="\n"+"Please Select GR No";
        valid=1;
    }
    if(jpurchase_disttname.getText().equals(""))
    {
        error +="\n"+"Please Select GR No For Distributor Name !";
        valid=1;
        
    }
   
    
     if(jpurache_distributorid.getText().equals(""))
    {
        error +="\n"+"Please Select GR No For Distributor Id !";
        valid=1;
    }
    
    if(jpurache_podate.getText().equals(""))
    {
        error +="\n"+"Please Select GR No For Purchase Order Date !";
        valid=1;
    }
   
    if(jpurhase_amountpaid.getText().equals(""))
    {
     error +="\n"+"Please Enter Amount to Be Paid";
        valid=1;   
    }
    if(jpurachase_invoiceno.getText().equals(""))
    {
     error +="\n"+"Please Enter Invoice Number !";
        valid=1;   
    }
    if(jvatcombo.getSelectedIndex()==0)
    {
     error +="\n"+"Please Select VAT Mode";
        valid=1;   
    }
    if(jpurchase_invoicebalanceamt.getText().equals(""))
    {
        error +="\n"+"Please Calculate Amount";
        valid=1;
        
    }
    
    if(valid==1)
    {
        JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    else
    {
         System.out.println("Inside Else part");
        
   // }
///////////////////////////////////////////new edit code///////////////////////////
       
     
          a=JOptionPane.showConfirmDialog(rootPane, "Do You Want To Save Purchase Invoice ?", "Confirm", JOptionPane.YES_NO_OPTION);
       
          System.out.print(a);
      
       if(a==JOptionPane.YES_OPTION)
       {
          c=new Dbconn();
          con=c.getConnection();
          
          String a,b,c,d,e,f,g,h,i,j,k1,l,m,n,o,p;
          
          a=jpurchasegrno.getText();
          //System.out.println(a);
          b=jpurchase_disttname.getText();
          c=jpurache_distributorid.getText();
          d=jpurachase_invoiceno.getText();
          e=jpurchase_invoucedate.getText();
          f=jpurchase_ponumber.getText();
          g=jpurache_podate.getText();
          h=jpurchasepaymentcombo.getSelectedItem().toString();
          i=jpurchasepaymenttype.getSelectedItem().toString();
          j=jpurchaseinvoice_actualamount.getText();
          k1=jvatcombo.getSelectedItem().toString();
          l=jpurhase_amountpaid.getText();
          m=jpurchase_invoicebalanceamt.getText();
          n=jpurchasebankname.getText();
          o=jpurchase_refno.getText();
                
         System.out.println("near insert query");
      
             String query = "INSERT INTO purchase_invoice(GR_no,distributors_name,distributor_id,invoice_no,invoice_date,"
                     + "PO_number,podate,payment_mode,"
                + "payment_type,actual_amount,VAT,amount_paid,balance_amount,"
                     + "bank,ref_no,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
           // String status="ACTIVE";
           
            try
            {
               String status="ACTIVE";
               PreparedStatement pst=con.prepareStatement(query);
               pst.setString(1,a);
               pst.setString(2,b);
               pst.setString(3,c);
               pst.setString(4,d);
               pst.setString(5,e);
               pst.setString(6,f);
               pst.setString(7,g);
               pst.setString(8,h);
               pst.setString(9,i);
               pst.setString(10,j);
               pst.setString(11,k1);
               pst.setString(12,l);
               pst.setString(13,m);
               pst.setString(14,n);
               pst.setString(15,o);
               pst.setString(16,status);
               
               k=pst.executeUpdate();
               System.out.println("Record inserted");
                  if(k>0)
                  {
                   JOptionPane.showMessageDialog(rootPane, "Data Saved Successfully !!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                  }
                 else
                   {
                   JOptionPane.showConfirmDialog(jPaymentpanel, "Data Not Saved !!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
               
             }
            catch(Exception ex)
             {
                JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
             }
         }//new update   //end of if
          
//           if(k>0)
//          {
//               JOptionPane.showMessageDialog(rootPane, "Data Saved Successfully !!", "Saved", JOptionPane.INFORMATION_MESSAGE);
//           }
              else//new update
           {
              JOptionPane.showConfirmDialog(jPaymentpanel, "Data Not Saved !!", "Error", JOptionPane.ERROR_MESSAGE);
           }
        
    System.out.println("out of else");
    
    }
   // }new update
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpurchaseinvoice_actualamountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurchaseinvoice_actualamountFocusGained
 String temp=grno.toString();
        
        
        try
        {
            ResultSet rs=conn.execute_query("select SUM(total_purchase_price) from material_inward_info where Material_Status=? AND GR_no=?", new String[]{"ACTIVE",temp});
           while(rs.next())
             {
            jpurchaseinvoice_actualamount.setText(rs.getString("SUM(total_purchase_price)"));
            
            System.out.println("Inside the show button code");
             }
        }
        catch(Exception ex)
        {
                     JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);

        }      
        

// TODO add your handling code here:
    }//GEN-LAST:event_jpurchaseinvoice_actualamountFocusGained

    private void jpurache_distributoridFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpurache_distributoridFocusGained
 String temp=grno.toString();
        
        
        try
        {
            ResultSet rs=conn.execute_query("select * from distributors_details where distributors_status=?", new String[]{"ACTIVE"});
           while(rs.next())
             {
                 //new edit 13-5
             jpurache_distributorid.setText(rs.getString("distributors_id"));
            jpurchase_disttname.setText(rs.getString("distributors_name"));
            
            System.out.println("Inside the show button code");
             }
        }
        catch(Exception ex)
        {
                     JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);

        }   

    }//GEN-LAST:event_jpurache_distributoridFocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
   
    
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPaymentpanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jgrnumbertable;
    private javax.swing.JTextField jpurachase_invoiceno;
    private javax.swing.JTextField jpurache_distributorid;
    private javax.swing.JTextField jpurache_podate;
    private javax.swing.JTextField jpurchase_disttname;
    private javax.swing.JTextField jpurchase_invoicebalanceamt;
    private javax.swing.JTextField jpurchase_invoucedate;
    private javax.swing.JTextField jpurchase_ponumber;
    private javax.swing.JTextField jpurchase_refno;
    private javax.swing.JTextField jpurchasebankname;
    private javax.swing.JTextField jpurchasegrno;
    private javax.swing.JTextField jpurchaseinvoice_actualamount;
    private javax.swing.JComboBox jpurchasepaymentcombo;
    private javax.swing.JComboBox jpurchasepaymenttype;
    private javax.swing.JTextField jpurhase_amountpaid;
    private javax.swing.JComboBox jvatcombo;
    // End of variables declaration//GEN-END:variables
}
