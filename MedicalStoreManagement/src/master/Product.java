/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

//import demon.*;
import DB.Dbconn;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author user
 */
public class Product extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    public Connection con;
    int selectedRow;
 int a,dis;
    int valid = 0;
        String str = "";
        Dbconn conn;
        float vat5;
        float vat12;
        Connection con1;
        ResultSet rs;
    ResultSet rs1;
        float rateperunit,actualprice;
        Date d;
        int index=1;
        DefaultTableModel modelItem,modalItem1;
        ResultSet rs_Product;
        ResultSet rs_productcheck,rs_dist;
        String distname,distid,disname;
        String categoryname,companyname;
                 TableRowSorter<TableModel> sorter;
        String productno,productname,productcategory,productraterperunit,product_availablestock;
    public Product(JFrame parent, boolean modal)
    {
        initComponents();
        conn=new Dbconn();
        modelItem=(DefaultTableModel)Jproductlist.getModel();
        sorter = new TableRowSorter<TableModel>(modelItem);
        Jproductlist.setRowSorter(sorter);
        String searchteaxt;
        refresh();
        refreshTable();
        refreshcategory();
        jproduct_name.requestFocus();
        show_date();
        
      
        
     }
    
    
     public void show_date()
    {
    Calendar c1=new GregorianCalendar();
      
     int month=c1.get(Calendar.MONTH);
        int day=c1.get(Calendar.DAY_OF_MONTH);
        int year=c1.get(Calendar.YEAR);
      jLabel22.setText(year+"/"+(month+1)+"/"+day);
        
    }
    public void refresh()
    {
    con=conn.getConnection();
    try
    {
    Statement st=con.createStatement();
    
    rs=conn.execute_query("select distributors_name from distributors_details where distributors_status=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
         //   String name;
            distname=rs.getString("distributors_name");
            
           jdistributorname.addItem(distname);
    //      System.out.print(distname);
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
   
    rs1=conn.execute_query("select * from companymaster where status=?", new String[]{"ACTIVE"});
    
   try
   {
    while(rs1.next())
    {
        companyname=rs1.getString("comp_name");
        jcompanyname.addItem(companyname);
    }
   }
   catch(Exception e)
   {

   }
    
    
    
    
    }
       public void refreshcategory()
    {
    con=conn.getConnection();
    try
    {
    Statement st=con.createStatement();
    ResultSet rs;
    rs=conn.execute_query("select Category_name from category_master where status=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
            
            categoryname=rs.getString("Category_name");
            
           jproductcategorytxt.addItem(categoryname);
         // System.out.print(distname);
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
    }
    public void refreshTable()
    {
        modelItem.setRowCount(0);
        //    index=1;
        
          rs_Product=conn.execute_query("select * from product_info where productstatus=?", new String[]{"ACTIVE"});
        
        try
        {
          while(rs_Product.next())
          {
         
           productno =   rs_Product.getString("product_id");
           productname=   rs_Product.getString("product_name");
           productcategory =  rs_Product.getString("product_category");
           productraterperunit  = rs_Product.getString("product_rateperunit");
           product_availablestock =  rs_Product.getString("totalstock");
           
           modelItem.addRow(new String[]{productno, productname,
                       productcategory,productraterperunit,product_availablestock});
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jprodut_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jproduct_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jproduct_batchno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jproduct_mfgdate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jproduct_expdate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jproduct_purchaserate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jproduct_mrprate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jproduct_desctiption = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jproductcategorytxt = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jproduct_minstock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jproduct_maxstock = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jproductvattxt = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jproduct_totalStock = new javax.swing.JTextField();
        jdistributorname = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jproduct_col = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jprodut_row = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jcompanyname = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jproductlist = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jexit = new javax.swing.JButton();
        jclear = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jupdate = new javax.swing.JButton();
        jsave = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Product");
        setPreferredSize(new java.awt.Dimension(1350, 550));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Product");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Prodcut Id");

        jprodut_id.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Prodcut Name");

        jproduct_name.setToolTipText("Enter Prtoduct Name");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Batch NO.");

        jproduct_batchno.setToolTipText("Enter Batch No");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Manufacture Date");

        jproduct_mfgdate.setToolTipText("Enter Date In d/m/y Formate");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Exp. Date");

        jproduct_expdate.setToolTipText("Enter Date In d/m/y Formate");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Purchase Rate");
        jLabel10.setToolTipText("");

        jproduct_purchaserate.setText("0");
        jproduct_purchaserate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jproduct_purchaserateKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("M.R.P.");

        jproduct_mrprate.setText("0");
        jproduct_mrprate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jproduct_mrprateFocusLost(evt);
            }
        });
        jproduct_mrprate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jproduct_mrprateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jproduct_mrprateKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Description");

        jproduct_desctiption.setColumns(20);
        jproduct_desctiption.setRows(5);
        jproduct_desctiption.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jproduct_desctiptionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jproduct_desctiption);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("(MM/YYYY)");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("(MM/YYYY)");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Category");

        jproductcategorytxt.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Stock Min");

        jproduct_minstock.setText("0");
        jproduct_minstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jproduct_minstockKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Stock Max");

        jproduct_maxstock.setText("0");
        jproduct_maxstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jproduct_maxstockKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("VAT(%)");
        jLabel15.setToolTipText("");

        jproductvattxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jproductvattxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "5", "12.5" }));
        jproductvattxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jproductvattxtFocusLost(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Total Stock");
        jLabel17.setToolTipText("");

        jproduct_totalStock.setText("0");
        jproduct_totalStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jproduct_totalStockFocusGained(evt);
            }
        });
        jproduct_totalStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jproduct_totalStockKeyTyped(evt);
            }
        });

        jdistributorname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdistributorname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jdistributornameItemStateChanged(evt);
            }
        });
        jdistributorname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jdistributornamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jdistributorname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdistributornamePropertyChange(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel18.setText("Distributor Name");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Column");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel20.setText("Row");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel23.setText("Company Name");

        jcompanyname.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jcompanyname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcompanynameItemStateChanged(evt);
            }
        });
        jcompanyname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcompanynamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jcompanyname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcompanynamePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jprodut_id, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdistributorname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jproduct_batchno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jproduct_name, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jproductcategorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jproduct_purchaserate, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jproduct_mrprate)
                            .addComponent(jproduct_col))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jproduct_totalStock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jproductvattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jprodut_row, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jproduct_mfgdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jproduct_minstock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jproduct_expdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jproduct_maxstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jprodut_id)
                        .addComponent(jLabel18)
                        .addComponent(jdistributorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jcompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jproduct_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jproduct_batchno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jproductcategorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jproduct_expdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jproduct_mfgdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jproduct_maxstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jproduct_minstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jproduct_purchaserate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jproductvattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jproduct_mrprate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jproduct_totalStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jproduct_col, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jprodut_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Jproductlist.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        Jproductlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Product Name", "Category", "Rate Per Unit", "Available Stock"
            }
        ));
        Jproductlist.getTableHeader().setReorderingAllowed(false);
        Jproductlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JproductlistMouseClicked(evt);
            }
        });
        Jproductlist.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JproductlistPropertyChange(evt);
            }
        });
        Jproductlist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JproductlistKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JproductlistKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Jproductlist);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jexit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jexit.setText("Back");
        jexit.setToolTipText("click to exit");
        jexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexitActionPerformed(evt);
            }
        });

        jclear.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jclear.setText("Clear");
        jclear.setToolTipText("click to clear");
        jclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jclearActionPerformed(evt);
            }
        });

        jdelete.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jdelete.setText("Delete");
        jdelete.setToolTipText("Click to delete");

        jupdate.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jupdate.setText("Update");
        jupdate.setToolTipText("click to update");
        jupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdateActionPerformed(evt);
            }
        });

        jsave.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jsave.setText("Save");
        jsave.setToolTipText("Click to save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jsave)
                .addGap(18, 18, 18)
                .addComponent(jupdate)
                .addGap(18, 18, 18)
                .addComponent(jdelete)
                .addGap(18, 18, 18)
                .addComponent(jclear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jexit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsave)
                    .addComponent(jupdate)
                    .addComponent(jdelete)
                    .addComponent(jclear)
                    .addComponent(jexit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enquiry.gif"))); // NOI18N

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel21.setText("Date:");

        jLabel22.setText("..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(232, 232, 232))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel21)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel19)
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void clear()
{
    jprodut_id.setText("");
        jproduct_name.setText("");
        jproduct_batchno.setText("");
        jproduct_mfgdate.setText("");
        jproduct_expdate.setText("");
        jproduct_purchaserate.setText("");
        jproduct_mrprate.setText("");
        jproduct_desctiption.setText("");
        jproductcategorytxt.setSelectedIndex(0);
        jproduct_maxstock.setText("");
        jproduct_minstock.setText("");
        jproductvattxt.setSelectedIndex(0);
        jproduct_totalStock.setText("");
        jproduct_col.setText("");
        jprodut_row.setText("");
 
}
    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jclearActionPerformed
       clear();
    }//GEN-LAST:event_jclearActionPerformed

  
    private void jexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jexitActionPerformed

    public void validate()
    {
       
    }
    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed

        valid=0;
        str="";
        conn=new Dbconn();

          if (jproduct_name.getText().equals("")) {
                str += "\n"+"Plaese fill Name!";
                valid = 1;
            }
//            if (jproduct_batchno.getText().equals("")) {
//                str += "\n"+"Plaese Enter Batch No!";
//                valid = 1;
//            }
//            if (jproduct_mfgdate.getText().equals("")) {
//                str += "\n"+"Plaese fill Mfg  MM/YY!";
//                valid = 1;
//            }
//            if (jproduct_expdate.getText().equals("")) {
//                str += "\n"+"Plaese fill exp date MM/YY!";
//                valid = 1;
//            }
//            if (jproduct_desctiption.getText().equals("")) 
//            {
//                str += "\n"+"Plaese fill Descrption!";
//                valid = 1;
//            }
//           if(jproductcategorytxt.getSelectedItem().equals("None"))
//           {
//               str+="\n"+" Please Selct Category";
//               valid=1;
//               
//           }
//           if(jproductvattxt.getSelectedItem().equals("None"))
//           {
//               str+="\n"+" Please Selct Valid VAT";
//               valid=1;
//               
//           }
//           if(jproduct_minstock.getText().equals("")||(jproduct_minstock.getText().length())>=3)
//           {
//               str+="\n"+" Please Enter Valid Data";
//               valid=1;
//           }
//        if (jproduct_col.getText().equals("")) 
//            {
//                str += "\n"+"Plaese fill Product Column !";
//                valid = 1;
//            }
//        if (jprodut_row.getText().equals("")) 
//            {
//                str += "\n"+"Plaese fill Product Rack Row!";
//                valid = 1;
//            }
//        
//        if (jcompanyname.getSelectedItem().toString().equals("")) 
//            {
//                str += "\n"+"Plaese fill Company !";
//                valid = 1;
//            }
        
         
        
    if(valid==1)
    {
        JOptionPane.showMessageDialog(rootPane, str, "Error",JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to save Data","Confirm", JOptionPane.YES_NO_OPTION);
     
        }
         if(a==0)
             {
                            int i=conn.insert_data("insert into product_info(distributors_id,distributor_name,companyname,product_name,"
                            + "product_batchno,product_category,product_manfdate,"
                            + "product_expdate,product_min,product_max,product_rateperunit,totalstock,col,row,"
                            + "product_vat,Actual_price,product_description,"
                            + "productstatus,dateofcreation)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]
                            {distid,disname,companyname,jproduct_name.getText(),jproduct_batchno.getText(),
                                jproductcategorytxt.getSelectedItem().toString(),jproduct_mfgdate.getText(),
                                jproduct_expdate.getText(),jproduct_minstock.getText(),jproduct_maxstock.getText(),
                                jproduct_purchaserate.getText(),jproduct_totalStock.getText(),jproduct_col.getText(),jprodut_row.getText(),jproductvattxt.getSelectedItem().toString(),
                                jproduct_mrprate.getText(),jproduct_desctiption.getText(),"ACTIVE",jLabel22.getText()});
    if (i > 0) 
    {
            JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
        //clear();
    } 
       else 
    {
        
        JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
          
    }
             
             }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jsaveActionPerformed

    public void refreshForm(Object cellvalue)
            
    {
        Dbconn conn=new Dbconn();
        con=conn.getConnection();
        ResultSet rs;
        try
        {
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from product_info where product_id="+cellvalue);
            while(rs.next())
            {
                jprodut_id.setText(rs.getString("product_id"));
                jproduct_name.setText(rs.getString("product_name"));
                jproduct_batchno.setText(rs.getString("product_batchno"));
                jproduct_mfgdate.setText(rs.getString("product_manfdate"));
                jproduct_expdate.setText(rs.getString("product_expdate"));
                jproduct_minstock.setText(rs.getString("product_min"));
                jproduct_maxstock.setText(rs.getString("product_max"));
                jproduct_purchaserate.setText(rs.getString("product_rateperunit"));
                jproduct_totalStock.setText(rs.getString("totalstock"));
                jproductcategorytxt.setSelectedItem(rs.getString("product_category"));
                jproductvattxt.setSelectedItem(rs.getString("product_vat"));
                jproduct_mrprate.setText(rs.getString("Actual_price"));
                jproduct_desctiption.setText(rs.getString("product_description"));
                jproduct_col.setText(rs.getString("col"));
                jprodut_row.setText(rs.getString("row"));
                jproductcategorytxt.setSelectedItem(rs.getString("product_category"));
                
                
                jdistributorname.setSelectedItem(rs.getString("distributor_name"));
                 jdistributorname.setSelectedItem(rs.getString("companyname"));
                //jproductcategorytxt.setSelectedItem(rs.getString("product_category"));
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void jproductvattxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jproductvattxtFocusLost

//        
//            rateperunit=  Float.parseFloat(jproduct_rpu.getText());
//            float temp;
//        if(jproductvattxt.getSelectedItem().equals("5"))
//        {
//            vat5=4.74f;
//            float percentage;
//           percentage=(rateperunit*vat5)/100;
//           jproduct_actualprice.setText(Float.toString(rateperunit-percentage));
//            
//        
//        }
//        if(jproductvattxt.getSelectedItem().equals("12.5"))
//        {
//         
//              vat12=11.11f;
//            float percentage;
//           percentage=(rateperunit*vat12)/100;
//          //       jproduct_actualprice.setText(Float.toString(percentage));
//           jproduct_actualprice.setText(Float.toString(rateperunit-percentage));
//        }
        
               
// TODO add your handling code here:
    }//GEN-LAST:event_jproductvattxtFocusLost

    private void JproductlistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JproductlistKeyPressed
    JTable target = (JTable)evt.getSource();  
        if(evt.getKeyCode()==KeyEvent.VK_UP)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
      refreshForm(selectedCellValue);
       //          System.out.println("selectedCellValue "+" "+selectedCellValue);  
   }    
        if(evt.getKeyCode()==KeyEvent.VK_DOWN)
    {
        selectedRow = target.getSelectedRow();  
        Object selectedCellValue=target.getValueAt(selectedRow, 0);  
        refreshForm(selectedCellValue);
      
      //  System.out.println("selectedCellValue "+" "+selectedCellValue);  
   
}
    }//GEN-LAST:event_JproductlistKeyPressed

    private void JproductlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JproductlistMouseClicked
                if (evt.getClickCount() == 1)  
                {  
                     String selectedData = null;  
                   JTable target = (JTable)evt.getSource();  
                selectedRow = target.getSelectedRow();
                Object selectedCellValue=target.getValueAt(selectedRow, 0);  
                refreshForm(selectedCellValue);
            System.out.print(selectedCellValue);
                
                }
        
    }//GEN-LAST:event_JproductlistMouseClicked

    private void JproductlistPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JproductlistPropertyChange

        // TODO add your handling code here:
    }//GEN-LAST:event_JproductlistPropertyChange

    private void JproductlistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JproductlistKeyReleased
  JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_JproductlistKeyReleased

    private void jdistributornamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdistributornamePropertyChange

        // TODO add your handling code here:
    }//GEN-LAST:event_jdistributornamePropertyChange

    private void jdistributornameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jdistributornameItemStateChanged
     con=conn.getConnection();
    try
    {
        Statement st=con.createStatement();
        ResultSet rs;
        rs=st.executeQuery("select * from distributors_details where distributors_name='"+distname+"'");
            while(rs.next())
            {
                distid=rs.getString("distributors_id");
                disname=rs.getString("distributors_name");
                System.out.print(distid);
            }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jdistributornameItemStateChanged
 private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jTextField1.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
   
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        sortTable();
    }//GEN-LAST:event_formKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
 sortTable();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jdistributornamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jdistributornamePopupMenuWillBecomeInvisible
//try
//{
//    Connection con;
//  con=new Dbconn().getConnection();
//  Statement st=con.createStatement();
//  ResultSet rs;
//  rs=st.executeQuery("select * from distributors_details where distributors_name='"+jdistributorname.getSelectedItem().toString()+"'");
//  while(rs.next())
//  {
//   dis   
//  }
//}
//catch(Exception ex)
//{
//    
//}
//        
// TODO add your handling code here:
    }//GEN-LAST:event_jdistributornamePopupMenuWillBecomeInvisible

    private void jproduct_desctiptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_desctiptionKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    jsave.requestFocus();
} // TODO add your handling code here:
    }//GEN-LAST:event_jproduct_desctiptionKeyPressed

    
    private void jupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdateActionPerformed
 valid=0;
        str="";
        conn=new Dbconn();

          if (jproduct_name.getText().equals("")) {
                str += "\n"+"Plaese fill Name!";
                valid = 1;
            }
            if (jproduct_batchno.getText().equals("")) {
                str += "\n"+"Plaese Enter Batch No!";
                valid = 1;
            }
            if (jproduct_mfgdate.getText().equals("")) {
                str += "\n"+"Plaese fill Mfg  MM/YY!";
                valid = 1;
            }
            if (jproduct_expdate.getText().equals("")) {
                str += "\n"+"Plaese fill exp date MM/YY!";
                valid = 1;
            }
            if (jproduct_desctiption.getText().equals("")) 
            {
                str += "\n"+"Plaese fill Descrption!";
                valid = 1;
            }
           if(jproductcategorytxt.getSelectedItem().equals("None"))
           {
               str+="\n"+" Please Selct Category";
               valid=1;
               
           }
           if(jproductvattxt.getSelectedItem().equals("None"))
           {
               str+="\n"+" Please Selct Valid VAT";
               valid=1;
               
           }
           if(jproduct_minstock.getText().equals("")||(jproduct_minstock.getText().length())>=3)
           {
               str+="\n"+" Please Enter Valid Data";
               valid=1;
           }
        if (jproduct_col.getText().equals("")) 
            {
                str += "\n"+"Plaese fill Product Column !";
                valid = 1;
            }
        if (jprodut_row.getText().equals("")) 
            {
                str += "\n"+"Plaese fill Product Rack Row!";
                valid = 1;
            }
        
         
        
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
                 int k=conn.update_data("UPDATE  product_info  SET  product_min=?, product_max =?, product_rateperunit=?, "
                         + "totalstock =?,col=?,row=?,product_vat=?,Actual_price=? "
                         + " WHERE  product_id=?", 
                         new String[]{jproduct_minstock.getText(),jproduct_maxstock.getText(),jproduct_purchaserate.getText(),jproduct_totalStock.getText(),
                         jproduct_col.getText(),jprodut_row.getText(),jproductvattxt.getSelectedItem().toString(),jproduct_mrprate.getText(),jprodut_id.getText()});
                 
    if (k > 0) 
    {
            JOptionPane.showMessageDialog(rootPane, "Prodcut Details Updated Sucessfully", "Update", JOptionPane.INFORMATION_MESSAGE);
        //   this.dispose();
            refreshTable();
    } 
       else 
    {
        
        JOptionPane.showMessageDialog(rootPane, "Data Not Saved!!", "Warning", JOptionPane.ERROR_MESSAGE);
           }
             }
    }        
        




    }//GEN-LAST:event_jupdateActionPerformed

    private void jproduct_mrprateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jproduct_mrprateFocusLost

       


    }//GEN-LAST:event_jproduct_mrprateFocusLost

    private void jproduct_mrprateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_mrprateKeyReleased
        // TODO add your handling code here:
//           int a,b,c;
//
//a=Integer.parseInt(jproduct_purchaserate.getText());
//b=Integer.parseInt(jproduct_mrprate.getText());
//if(a>b)
//{
//    JOptionPane.showMessageDialog(rootPane, "Purchase Rate Should Not be more than MRP !", "Error", JOptionPane.ERROR_MESSAGE);
//}

    }//GEN-LAST:event_jproduct_mrprateKeyReleased

    private void jproduct_totalStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jproduct_totalStockFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jproduct_totalStockFocusGained

    private void jcompanynameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcompanynameItemStateChanged
//     con=conn.getConnection();
//    try
//    {
//        Statement st=con.createStatement();
//        ResultSet rs;
//        rs=st.executeQuery("select * from companymaster where comp_name='"+companyname+"'");
//            while(rs.next())
//            {
//                distid=rs.getString("distributors_id");
//                companyname=rs.getString("distributors_name");
//                System.out.print(distid);
//            }
//    }
//    catch(Exception ex)
//    {
//        ex.printStackTrace();
//    }
//        


// TODO add your handling code here:
    }//GEN-LAST:event_jcompanynameItemStateChanged

    private void jcompanynamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcompanynamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jcompanynamePopupMenuWillBecomeInvisible

    private void jcompanynamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcompanynamePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jcompanynamePropertyChange

    private void jproduct_minstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_minstockKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Data","Error",JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:

        

// TODO add your handling code here:
    }//GEN-LAST:event_jproduct_minstockKeyTyped

    private void jproduct_maxstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_maxstockKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Data","Error",JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jproduct_maxstockKeyTyped

    private void jproduct_purchaserateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_purchaserateKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
             JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Data","Error",JOptionPane.ERROR_MESSAGE);
           
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jproduct_purchaserateKeyTyped

    private void jproduct_mrprateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_mrprateKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
             JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Data","Error",JOptionPane.ERROR_MESSAGE);
           
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jproduct_mrprateKeyTyped

    private void jproduct_totalStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jproduct_totalStockKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Data","Error",JOptionPane.ERROR_MESSAGE);
           
        }        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jproduct_totalStockKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jproductlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jclear;
    private javax.swing.JComboBox jcompanyname;
    private javax.swing.JButton jdelete;
    private javax.swing.JComboBox jdistributorname;
    private javax.swing.JButton jexit;
    private javax.swing.JTextField jproduct_batchno;
    private javax.swing.JTextField jproduct_col;
    private javax.swing.JTextArea jproduct_desctiption;
    private javax.swing.JTextField jproduct_expdate;
    private javax.swing.JTextField jproduct_maxstock;
    private javax.swing.JTextField jproduct_mfgdate;
    private javax.swing.JTextField jproduct_minstock;
    private javax.swing.JTextField jproduct_mrprate;
    private javax.swing.JTextField jproduct_name;
    private javax.swing.JTextField jproduct_purchaserate;
    private javax.swing.JTextField jproduct_totalStock;
    private javax.swing.JComboBox jproductcategorytxt;
    private javax.swing.JComboBox jproductvattxt;
    private javax.swing.JTextField jprodut_id;
    private javax.swing.JTextField jprodut_row;
    private javax.swing.JButton jsave;
    private javax.swing.JButton jupdate;
    // End of variables declaration//GEN-END:variables
}
