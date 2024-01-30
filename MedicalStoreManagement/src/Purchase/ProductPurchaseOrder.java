/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Purchase;

import DB.*;
import Stock.Materialinward;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import master.*;

/**
 *
 * @author user
 */
public class ProductPurchaseOrder extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    int selectedrow;
    String temp="";
     TableRowSorter<TableModel> sorter;
  //  int rowcount,columncount;
    String po_no;
    Dbconn conn;
    ResultSet rs;
    PreparedStatement ps;
    Connection con;
    int flag=0;
    String from,pass,subject,body;
    
     
    int row,col,rowcount=0,colcount=0,index=0,row1;
  
    String distid,distname,dist_add,dist_officeno,dist_mobileno,dist_emailid;
    DefaultTableModel modelItem,distItem,orderItem;
    ResultSet rs_Distributor;
  
    ResultSet rs_1;
    String searchteaxt;

    String product_id,product_name,product_category,product_expdate,product_rateperunit,product_minstock,product_totalstock,product_orderedstock;
    
    
    public ProductPurchaseOrder(JFrame parent, boolean modal) {
        initComponents();
        conn=new Dbconn();
        
        modelItem=(DefaultTableModel)jDisttableproductllist.getModel();
        orderItem=(DefaultTableModel)jorderqtytable.getModel();
        sorter = new TableRowSorter<TableModel>(modelItem);
        jDisttableproductllist.setRowSorter(sorter);
        //refresh();
        refreshproduct();
        show_date();
      //************ Getting previous PO Number. ************
        increament();
            
    }
    
    
    ////To get distributor details
    
    
     public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from distributors_details where distributors_name='"+cellvalue+"'");
            while(rs.next())
            {
                
                
                jTextField1.setText(rs.getString("distributors_name"));
                jdistOfficeno.setText(rs.getString("distributors_officeno"));
                jdistmobileno.setText(rs.getString("distributors_mobileno"));
                jpdistemailid.setText(rs.getString("distributors_email"));
                jpdistAddress.setText(rs.getString("distributors_address"));
               // jdistmobileno.setText(rs.getString("distributors_email"));
                
                //distributors_address	

             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
 
      public void increament()
    {
        int x;
        String grx = null;
        ResultSet rs_grno;
        Dbconn conn = new Dbconn();
        rs_grno = conn.execute_query("Select MAX(po_no) from purchase_order where po_status=?", new String[]{"ACTIVE"});
        try {
            while(rs_grno.next())
            {
               //System.out.println(rs_grno.getString("MAX(GR_no)"));
                grx = rs_grno.getString("MAX(po_no)");
                if(grx==null)
                {
                    grx="0";
                }
             }
            x=Integer.parseInt(grx);
            x=x+1;
            grx=""+x;
            jpdistorderno.setText(grx);
        } catch (SQLException ex) {
            Logger.getLogger(Materialinward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jTextField7.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
    
     public void show_date()
    {
        Calendar c1=new GregorianCalendar();
      
        int month=c1.get(Calendar.MONTH);
        int day=c1.get(Calendar.DAY_OF_MONTH);
        int year=c1.get(Calendar.YEAR);
      jLabel3.setText(year+"/"+(month+1)+"/"+day);
        
    }
// public void refresh()
//    {
//    try
//    {
////    Statement st=con.createStatement();
//  
//    rs_1=conn.execute_query("select distributors_name from distributors_details where distributors_status=?", new String[]{"ACTIVE"});
//        while(rs_1.next())
//        {
//             distname=rs_1.getString("distributors_name");
////           a = (String) jexpiry_ExpiryTable.getValueAt(row, 0);
//           jdistnamecombo.addItem(distname);
//           
//          //System.out.print(distname);
//        }
//    }
//    catch(Exception ex)
//    {
//        ex.printStackTrace();
//    }
//    }
// 
 
 public void refreshproduct()
 {
       modelItem.setRowCount(0);
        
          rs_Distributor=conn.execute_query("select * from product_info where productstatus=?", new String[]{"ACTIVE"});
        
        try
        {
          while(rs_Distributor.next())
          {
         
           product_id =   rs_Distributor.getString("product_id");
           product_name=   rs_Distributor.getString("product_name");
           distname=rs_Distributor.getString("distributor_name");
           product_category =  rs_Distributor.getString("product_category");
           product_expdate=rs_Distributor.getString("product_expdate");
           product_minstock=rs_Distributor.getString("product_min");
           
           
           product_rateperunit  = rs_Distributor.getString("product_rateperunit");
           product_totalstock =  rs_Distributor.getString("totalstock");
           
           modelItem.addRow(new String[]{product_id, product_name,distname,
               product_category,product_expdate,product_minstock,product_rateperunit,product_totalstock});
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
 }
 
 
 public void refreshTable(String temp_id)
    {
          modelItem.setRowCount(0);
        
          rs_Distributor=conn.execute_query("select * from product_info where productstatus=?", new String[]{"ACTIVE",temp_id});
        
        try
        {
          while(rs_Distributor.next())
          {
         
           product_id =   rs_Distributor.getString("product_id");
           product_name=   rs_Distributor.getString("product_name");
           product_category =  rs_Distributor.getString("product_category");
           product_expdate=rs_Distributor.getString("product_expdate");
           product_minstock=rs_Distributor.getString("product_min");
           
           
           product_rateperunit  = rs_Distributor.getString("product_rateperunit");
           product_totalstock =  rs_Distributor.getString("totalstock");
           
           modelItem.addRow(new String[]{product_id, product_name,
                       product_category,product_expdate,product_minstock,product_rateperunit,product_totalstock});
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdistOfficeno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpdistAddress = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdistmobileno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jpdistemailid = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        sendemailbutton = new javax.swing.JButton();
        printOrderbutton = new javax.swing.JButton();
        Backbutton = new javax.swing.JButton();
        EditButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDisttableproductllist = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jorderqtytable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpdistorderno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("ProductPurchaseOrder");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Distributor Name");

        jdistOfficeno.setEditable(false);
        jdistOfficeno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdistOfficeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdistOfficenoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Office No.");

        jpdistAddress.setEditable(false);
        jpdistAddress.setColumns(20);
        jpdistAddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jpdistAddress.setRows(5);
        jScrollPane3.setViewportView(jpdistAddress);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Mobile No.");

        jdistmobileno.setEditable(false);
        jdistmobileno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdistmobileno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdistmobilenoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Email Id");

        jpdistemailid.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jpdistemailid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpdistemailidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(67, 67, 67)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdistmobileno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jdistOfficeno, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpdistemailid)
                            .addComponent(jTextField1))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jdistOfficeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jdistmobileno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jpdistemailid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SaveButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        sendemailbutton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendemailbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail-icon.png"))); // NOI18N
        sendemailbutton.setText("Send Via Email");
        sendemailbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendemailbuttonActionPerformed(evt);
            }
        });

        printOrderbutton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        printOrderbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print-icon.png"))); // NOI18N
        printOrderbutton.setText("Print Order");

        Backbutton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        Backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        Backbutton.setText("Back");
        Backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbuttonActionPerformed(evt);
            }
        });

        EditButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        EditButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        EditButton1.setText("Clear");
        EditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendemailbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printOrderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendemailbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printOrderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Distributor Wise Product List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jDisttableproductllist.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jDisttableproductllist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product Name", "Dist Name", "Category", "Exp. Date", "Min Stock", "Rate Per Unit", "Total Stock"
            }
        ));
        jDisttableproductllist.getTableHeader().setReorderingAllowed(false);
        jDisttableproductllist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDisttableproductllistMouseClicked(evt);
            }
        });
        jDisttableproductllist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDisttableproductllistKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDisttableproductllistKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jDisttableproductllist);

        jLabel2.setText("Search");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        AddButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add to card.png"))); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        RemoveButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        RemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordered Qty.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jorderqtytable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jorderqtytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product Name", "Category", "Quantity"
            }
        ));
        jorderqtytable.getTableHeader().setReorderingAllowed(false);
        jorderqtytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jorderqtytableMouseClicked(evt);
            }
        });
        jorderqtytable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jorderqtytableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jorderqtytableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jorderqtytable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Order No");

        jpdistorderno.setEditable(false);
        jpdistorderno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("Product Purchase Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(78, 78, 78)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jpdistorderno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(764, 764, 764))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jpdistorderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendemailbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendemailbuttonActionPerformed
  from = "uitesting1234@gmail.com";
        pass = "uniqueidea"; 
       String[] to = {"kumbharvijay01@gmail.com","sanket.girme@gmail.com"}; // list of recipient email addresses
        subject = "TESTING";
        body = "SUCCESSFULLLLLL";

        sendMail(from, pass,to, subject, body);
        
        JOptionPane.showMessageDialog(rootPane, "Mail sent successfully..!!!", "Confirm", JOptionPane.INFORMATION_MESSAGE);

        

        
// TODO add your handling code here:
    }//GEN-LAST:event_sendemailbuttonActionPerformed
public void sendMail(String from, String pass, String[] to, String subject, String body)
    {
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) 
            {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) 
            {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch(Exception E)
        {
            JOptionPane.showMessageDialog(null, E, "eror", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }   
       
    private void jdistOfficenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdistOfficenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdistOfficenoActionPerformed

 
    public void valid()
    {
        
    }
    
    private void jdistmobilenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdistmobilenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdistmobilenoActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        valid();
        int yesorNo;
            yesorNo =  JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(yesorNo == 0)
            {
        
        conn=new Dbconn();
        String pno,pdate,did,dname,dadd,dofficeno,dmobno,demailid,dproductid,dproduproductname,dproductcategory,dproductorderqty,dproducttotalamount,postatus;
        int k=0;
        int r,c;
          r=jorderqtytable.getRowCount();
          c=jorderqtytable.getColumnCount();
//                JOptionPane.showMessageDialog(rootPane, r, "Rows",JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(rootPane, c, "Columns", JOptionPane.ERROR_MESSAGE);
       
        for(int row=0; row<r;row++)
        {
                      
            po_no=jpdistorderno.getText();
            
            pdate=jLabel3.getText();
            did=distid;
            dname=distname;   
            dadd=dist_add;
            dofficeno=dist_officeno;
            dmobno=dist_mobileno;
            demailid=dist_emailid;
            dproductid= (String) jorderqtytable.getValueAt(row, 0);
            dproduproductname=(String) jorderqtytable.getValueAt(row, 1);
            dproductcategory=(String) jorderqtytable.getValueAt(row,2);
            dproductorderqty=(String) jorderqtytable.getValueAt(row,3);
           System.out.println(po_no+" "+pdate+" "+did+" "+dname+" "+dadd+" "+dofficeno+" "+dmobno+" "+demailid+" "+dproductid+" "+dproduproductname+" "+ dproductcategory+" "+dproductorderqty);
         
            Dbconn co=new Dbconn();
           con=co.getConnection();
           
            String query = "INSERT INTO purchase_order(po_no, podate, distributors_id,distributors_name, distributors_address,"
        + " distributors_officeno, distributors_mobileno, distributors_email, product_id, product_name, product_category , product_orderedQty, po_status) "
        + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
            String status="ACTIVE";
           try
           {
               PreparedStatement pst=con.prepareStatement(query);
               pst.setString(1, po_no);
               pst.setString(2, pdate);
               pst.setString(3, did);
                pst.setString(4, dname);
                pst.setString(5, dadd);
                pst.setString(6, dofficeno);
                pst.setString(7, dmobno);
                pst.setString(8, demailid);
                pst.setString(9, dproductid);
                pst.setString(10, dproduproductname);
                pst.setString(11, dproductcategory);
                pst.setString(12, dproductorderqty);
                pst.setString(13, status);
                k=pst.executeUpdate();
               
           
           }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
         }
   
             if(k>0)
        {
            flag=1;
            clear();
        increament();
            printmessage();
        }
        }    
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed
public void printmessage()
{
    if(flag>0)
    {
        JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
    }
       else
        {
            JOptionPane.showMessageDialog(rootPane, "Data Not Saved", "Warning!", JOptionPane.ERROR_MESSAGE);
    
        }
    
}
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

  
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
//        if(!(temp=="")&&temp!=(String) jDisttableproductllist.getValueAt(row, 2)) 
//                     {
//                         JOptionPane.showMessageDialog(rootPane, "Your are Not Allow to Create PO for Multiple Distributor!!", "Error", JOptionPane.ERROR_MESSAGE);
//                     }
//                     else
//                     {
         rowcount = jDisttableproductllist.getSelectedRow();
          colcount = jDisttableproductllist.getSelectedColumn();
        String a,b,c,d;
//           for(row=0;row<=rowcount;row++)          //  row_count =1
//        {
                try
                {   
                    a = (String) jDisttableproductllist.getValueAt(row, 0);
                    temp=(String) jDisttableproductllist.getValueAt(row, 2);
                    b = (String) jDisttableproductllist.getValueAt(row, 1);
                    c = (String) jDisttableproductllist.getValueAt(row, 3);
                     
                        conn = new Dbconn();
                        modelItem=(DefaultTableModel)jorderqtytable.getModel();
                        //modelItem.setRowCount(index);
                        try
                        {
                              modelItem.addRow(new String[]{a,b,c});
                              //index++;
                                      
                        }
                
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
                        
    }       
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            
  // }

    }//GEN-LAST:event_AddButtonActionPerformed

    private void jDisttableproductllistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDisttableproductllistMouseClicked
        if(evt.getClickCount()==1)
        {
            JTable target = (JTable) evt.getSource();
            selectedrow = target.getSelectedRow();
            Object selectedcellvalue = target.getValueAt(selectedrow, 0);
            row=selectedrow;
            
                //To refresh form Distributor Details 
             Object selecteddistname=target.getValueAt(selectedrow, 2);  
            row=selectedrow;
            refreshForm(selecteddistname);
        }       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jDisttableproductllistMouseClicked

    private void jDisttableproductllistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDisttableproductllistKeyPressed

   JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row=selectedrow;
      
            //To refresh form Distributor Details
       Object selecteddistname=target.getValueAt(selectedrow, 2);  
      row=selectedrow;
      
      refreshForm(selecteddistname);
      
      
    }        

    }//GEN-LAST:event_jDisttableproductllistKeyPressed

    private void jDisttableproductllistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDisttableproductllistKeyReleased
   JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row=selectedrow;
      
         //To refresh form Distributor Details
       Object selecteddistname=target.getValueAt(selectedrow, 2);  
      row=selectedrow;
      
      refreshForm(selecteddistname);
      
    }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jDisttableproductllistKeyReleased

    private void jorderqtytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jorderqtytableMouseClicked
       if(evt.getClickCount()==1)
        {
            JTable target = (JTable) evt.getSource();
            selectedrow = target.getSelectedRow();
            Object selectedcellvalue = target.getValueAt(selectedrow, 0);
            row=selectedrow;
      
      

        }//       
//         TODO add your handling code here:
    }//GEN-LAST:event_jorderqtytableMouseClicked

    private void jorderqtytableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jorderqtytableKeyPressed
  JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row=selectedrow;
//          jdamage_totalstocktxt.setText((String) selectedCellValue);
//          selectedCellValue = target.getValueAt(selectedrow, 0);
//          jdamage_productnametxt.setText((String) selectedCellValue);
    }// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jorderqtytableKeyPressed

    private void jorderqtytableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jorderqtytableKeyReleased
 JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 0);  
      row=selectedrow;

    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jorderqtytableKeyReleased

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed

          try
        {
          rowcount = jorderqtytable.getSelectedRow();
          colcount = jorderqtytable.getSelectedColumn();
        if(rowcount==-1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Rows Selected", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else
        {
          modelItem=(DefaultTableModel)jorderqtytable.getModel();
          modelItem.removeRow(row1);
        }
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(rootPane, e,"Error.....", JOptionPane.INFORMATION_MESSAGE);
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void jpdistemailidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpdistemailidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpdistemailidActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void BackbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbuttonActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_BackbuttonActionPerformed

    public void clear()
    {
        jpdistAddress.setText("");
        modelItem.setRowCount(0);
        distItem.setRowCount(0);
        orderItem.setRowCount(0);
        jdistOfficeno.setText("");
        jdistmobileno.setText("");
        jpdistemailid.setText("");
        
    }
    private void EditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButton1ActionPerformed

        
        jpdistAddress.setText("");
        modelItem.setRowCount(0);
        distItem.setRowCount(0);
        orderItem.setRowCount(0);
        jdistOfficeno.setText("");
        jdistmobileno.setText("");
        jpdistemailid.setText("");
        
       
// add your handling code here:
    }//GEN-LAST:event_EditButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Backbutton;
    private javax.swing.JButton EditButton1;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTable jDisttableproductllist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jdistOfficeno;
    private javax.swing.JTextField jdistmobileno;
    private javax.swing.JTable jorderqtytable;
    private javax.swing.JTextArea jpdistAddress;
    private javax.swing.JTextField jpdistemailid;
    private javax.swing.JTextField jpdistorderno;
    private javax.swing.JButton printOrderbutton;
    private javax.swing.JButton sendemailbutton;
    // End of variables declaration//GEN-END:variables
}
