/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;
import DB.*;
import UserManagement.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import master.*;
import medicalstoremanagement.*;


/**
 *
 * @author user
 */
public class Materialinward extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    ///origibal file
    Dbconn conn,conn1,conn2;
    
    DefaultTableModel modelItem,modelItem1;
    ResultSet rs_material;
    
    String Grno,grddate,pono,batchno,brand,Supp_name,Name_of_medi,Quantity,avail_stock,stockto_update,total_stock,mfg_date,Expiry_date,Material_description;
    String povaluetxt,prod_category,descrip,status_mi,podate;
    int valid,row,col,rowcount,colcount;
    String error,a,b,c,d,e,f,g,h,x,j,k,l,m,y;
    int selectedrow;
    public Connection con;
    
    
        
    JFrame frame = new JFrame();
    public Materialinward(JFrame parent, boolean modal) {
        initComponents();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //System.out.println(dateFormat.format(date));
        jmi_Datetxt.setText(dateFormat.format(date));
        

        //************ Getting previous GR No. ************
        increament();
        
        //************************************************
        
    }

    
    public void increament()
    {
        int x;
        String grx = null;
        ResultSet rs_grno;
        Dbconn conn = new Dbconn();
        rs_grno = conn.execute_query("Select MAX(GR_no) from material_inward_info where Material_Status=?", new String[]{"ACTIVE"});
        try {
            while(rs_grno.next())
            {
               //System.out.println(rs_grno.getString("MAX(GR_no)"));
                grx = rs_grno.getString("MAX(GR_no)");
                if(grx==null)
                {
                    grx="0";
                }
             }
            x=Integer.parseInt(grx);
            x=x+1;
            grx=""+x;
            jmi_grNotxt.setText(grx);
        } catch (SQLException ex) {
            Logger.getLogger(Materialinward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RefreshTable(String a)
    {
        
        conn = new Dbconn();
        modelItem=(DefaultTableModel)jmi_PurchaseOrderTable.getModel();
        modelItem.setRowCount(0);
         try
        {
           
            rs_material=conn.execute_query("select * from purchase_order where po_no=?", new String[]{a});
            
            while(rs_material.next())
            {
                pono=rs_material.getString("po_no");
                Supp_name=rs_material.getString("distributors_name");
                Name_of_medi=rs_material.getString("product_name");
                stockto_update=rs_material.getString("product_orderedQty");
                prod_category=rs_material.getString("product_category");
                podate = rs_material.getString("podate");
             // batchno=rs_material.getString("item_code");
//              avail_stock=rs_material.getString("Available_stock");
                
                modelItem.addRow(new String[]{pono,Name_of_medi,prod_category,stockto_update});
            }
            jmi_supplierNametxt.setText(Supp_name);
            jmi_poDatetxt.setText(podate);
        }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jmi_grNotxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jmi_Datetxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jmi_poNotxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jmi_supplierNametxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jmi_poDatetxt = new javax.swing.JTextField();
        jmi_batchNotxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jmi_availStocktxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jmi_stockToUpdatetxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jmi_TotalStocktxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jmi_brandtxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jmi_ExpiryDatetxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jmi_MfgDatetxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jmi_descriptiontxt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jmi_pricePerUnittxt = new javax.swing.JTextField();
        jmi_TotalPricetxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jmi_Vat_Combo = new javax.swing.JComboBox();
        jmi_Name_Of_Medicinetxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jmi_PurchaseOrderTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jmi_MaterialInwardTable = new javax.swing.JTable();
        jmi_updatebtn = new javax.swing.JButton();
        jmi_backbtn = new javax.swing.JButton();
        jmi_clearbtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Material Inward");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1350, 575));
        setRequestFocusEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Material Details"));

        jmi_grNotxt.setEditable(false);
        jmi_grNotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_grNotxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Goods Received No.");

        jmi_Datetxt.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Date :");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jmi_poNotxt.setToolTipText("Enter P.O. Number");
        jmi_poNotxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jmi_poNotxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jmi_poNotxtFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("P. O. Number :");

        jmi_supplierNametxt.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Distributor Name");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("P.O. Date");

        jmi_poDatetxt.setEditable(false);

        jmi_batchNotxt.setToolTipText("Enter the Batch Number");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Batch Number :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jmi_poNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jmi_batchNotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jmi_poDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jmi_supplierNametxt))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jmi_poNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jmi_poDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jmi_batchNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmi_supplierNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jmi_grNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jmi_Datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmi_grNotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jmi_Datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Stock to update"));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Available Stock :");

        jmi_availStocktxt.setEditable(false);
        jmi_availStocktxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jmi_availStocktxtFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Stock to update :");

        jmi_stockToUpdatetxt.setToolTipText("Enter Quantity of Stock");
        jmi_stockToUpdatetxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jmi_stockToUpdatetxtFocusLost(evt);
            }
        });
        jmi_stockToUpdatetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jmi_stockToUpdatetxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Total stock :");

        jmi_TotalStocktxt.setEditable(false);
        jmi_TotalStocktxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jmi_TotalStocktxtFocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Product Name :");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Category :");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Expiry Date:");

        jmi_ExpiryDatetxt.setToolTipText("Enter Expiry Date Of product");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Mfg. Date :");

        jmi_MfgDatetxt.setToolTipText("Enter Manufacturing Date Of the product");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Description");

        jmi_descriptiontxt.setColumns(20);
        jmi_descriptiontxt.setRows(5);
        jmi_descriptiontxt.setToolTipText("Enter the Description");
        jmi_descriptiontxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jmi_descriptiontxtKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jmi_descriptiontxt);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add to card.png"))); // NOI18N
        jButton1.setText("ADD");
        jButton1.setToolTipText("Add to Product to Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Total Price:");

        jmi_pricePerUnittxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jmi_pricePerUnittxtFocusLost(evt);
            }
        });

        jmi_TotalPricetxt.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel18.setText("VAT :");

        jmi_Vat_Combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECT--", "5%", "12.5%" }));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Price Per Unit:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(jLabel13))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(282, 282, 282))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jmi_MfgDatetxt)
                                    .addComponent(jmi_Vat_Combo, 0, 84, Short.MAX_VALUE)
                                    .addComponent(jmi_availStocktxt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jmi_stockToUpdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jmi_pricePerUnittxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jmi_ExpiryDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jmi_Name_Of_Medicinetxt))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel7))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jmi_brandtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1)
                                .addComponent(jmi_TotalStocktxt, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(jmi_TotalPricetxt)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jmi_brandtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmi_Name_Of_Medicinetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jmi_availStocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmi_stockToUpdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jmi_TotalStocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jmi_pricePerUnittxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jmi_Vat_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jmi_TotalPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jmi_MfgDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jmi_ExpiryDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("Material Inward");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jmi_PurchaseOrderTable.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jmi_PurchaseOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P.O. Number", "Product Name", "Product Category", "Ordered Quantity"
            }
        ));
        jmi_PurchaseOrderTable.getTableHeader().setReorderingAllowed(false);
        jmi_PurchaseOrderTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jmi_PurchaseOrderTableFocusGained(evt);
            }
        });
        jmi_PurchaseOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmi_PurchaseOrderTableMouseClicked(evt);
            }
        });
        jmi_PurchaseOrderTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jmi_PurchaseOrderTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmi_PurchaseOrderTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jmi_PurchaseOrderTable);

        jmi_MaterialInwardTable.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jmi_MaterialInwardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Category", "Avail Stock", "Stock To update", "Total Stock", "VAT", "Unit Price", "Total Price", "mfg. Date", "Expiry Date", "Description"
            }
        ));
        jmi_MaterialInwardTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jmi_MaterialInwardTable);

        jmi_updatebtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmi_updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jmi_updatebtn.setText("Save & Finish");
        jmi_updatebtn.setToolTipText("Save the Data");
        jmi_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_updatebtnActionPerformed(evt);
            }
        });

        jmi_backbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmi_backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jmi_backbtn.setText("Back");
        jmi_backbtn.setToolTipText("Back To main Index");
        jmi_backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_backbtnActionPerformed(evt);
            }
        });

        jmi_clearbtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmi_clearbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        jmi_clearbtn.setText("Clear");
        jmi_clearbtn.setToolTipText("Clear all The Data");
        jmi_clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_clearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jmi_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jmi_clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jmi_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmi_backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmi_clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmi_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(541, 541, 541)
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_clearbtnActionPerformed
       
        jmi_poNotxt.setText("");
        jmi_batchNotxt.setText("");
        jmi_supplierNametxt.setText("");
        jmi_Name_Of_Medicinetxt.setText("");
        jmi_availStocktxt.setText("");
        jmi_stockToUpdatetxt.setText("");
        jmi_TotalStocktxt.setText("");
        jmi_brandtxt.setText("");
        jmi_MfgDatetxt.setText("");
        jmi_ExpiryDatetxt.setText("");
        jmi_pricePerUnittxt.setText("");
        jmi_TotalPricetxt.setText("");
        jmi_Vat_Combo.setSelectedIndex(0);
        jmi_descriptiontxt.setText("");
        modelItem=(DefaultTableModel)jmi_PurchaseOrderTable.getModel();
        modelItem.setRowCount(0);
        modelItem1 = (DefaultTableModel) jmi_MaterialInwardTable.getModel();
        modelItem1.setRowCount(0);
        
// TODO add your handling code here:
    }//GEN-LAST:event_jmi_clearbtnActionPerformed

    private void jmi_backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_backbtnActionPerformed

   this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jmi_backbtnActionPerformed
    
    private void jmi_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_updatebtnActionPerformed

        //******************* Validation OF the Form********************
        
        error="";
        valid=0;
        if(jmi_grNotxt.getText().equals(""))
        {
            error+="\n"+"Please Enter The Goods Received Number.";
            valid=1;
        }
        if(jmi_batchNotxt.getText().equals(""))
        {
            error+="\n"+"Please Enter The Batch Number.";
            valid=1;
        }
        

       
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else
        {
            int yesorNo;
            yesorNo =  JOptionPane.showConfirmDialog(rootPane, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(yesorNo == 0)
            {
                //System.out.println("in if "+yesorNo);
            
            
            
        //**************************************************************
            conn=new Dbconn();
            String pno,pdate,did,dname,dadd,dofficeno,dmobno,demailid,dproductid,dproduproductname,dproductcategory,dproductorderqty,dproducttotalamount,postatus;
            String vat_purchase,prcperunit,totalprice;
            int k=0;
            int r,c;
            r=jmi_MaterialInwardTable.getRowCount();
            c=jmi_MaterialInwardTable.getColumnCount();
           // JOptionPane.showMessageDialog(rootPane, r, "Rows",JOptionPane.ERROR_MESSAGE);
           // JOptionPane.showMessageDialog(rootPane, c, "Columns", JOptionPane.ERROR_MESSAGE);
       
            for(int row=0; row<r;row++)
            {
                      
                Grno=jmi_grNotxt.getText();
            
                grddate=jmi_Datetxt.getText();
                batchno=jmi_batchNotxt.getText(); //did=distid;
                pono=jmi_poNotxt.getText();
                podate=jmi_poDatetxt.getText();// dname=distname;   
                Supp_name=jmi_supplierNametxt.getText();// dadd=dist_add;
                status_mi="ACTIVE";
                Name_of_medi=(String) jmi_MaterialInwardTable.getValueAt(row, 0); //  dofficeno=dist_officeno;
                brand = (String) jmi_MaterialInwardTable.getValueAt(row, 1);
                avail_stock = (String) jmi_MaterialInwardTable.getValueAt(row,2);
                stockto_update = (String) jmi_MaterialInwardTable.getValueAt(row, 3);
                total_stock = (String) jmi_MaterialInwardTable.getValueAt(row, 4);
                vat_purchase =(String) jmi_MaterialInwardTable.getValueAt(row, 5);
                prcperunit =(String) jmi_MaterialInwardTable.getValueAt(row, 6);
                totalprice =(String) jmi_MaterialInwardTable.getValueAt(row, 7);
                mfg_date = (String) jmi_MaterialInwardTable.getValueAt(row, 8);
                Expiry_date = (String) jmi_MaterialInwardTable.getValueAt(row, 9);
                descrip = (String) jmi_MaterialInwardTable.getValueAt(row, 10);
                
                Dbconn co=new Dbconn();
                con=co.getConnection();
                String query = "INSERT INTO material_inward_info(GR_no,GR_date,PO_number,PO_date,Batch_number,distributors_name,product_name,Brand,"
                                +"Available_stock,Stock_to_Update,Total_Stock,VAT_purchase,purchase_unit_price,total_purchase_price,Mfg_Date,Expiry_Date,Material_Status,Material_Description)"
                                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
                                String status="ACTIVE";
                                try
                                {
                                    PreparedStatement pst=con.prepareStatement(query);
                                    pst.setString(1, Grno);
                                    pst.setString(2, grddate);
                                    pst.setString(3, pono);
                                    pst.setString(4, podate);
                                    pst.setString(5, batchno);
                                    pst.setString(6, Supp_name);
                                    pst.setString(7, Name_of_medi);
                                    pst.setString(8, brand);
                                    pst.setString(9, avail_stock);
                                    pst.setString(10, stockto_update);
                                    pst.setString(11, total_stock);
                                    pst.setString(12, vat_purchase);
                                    pst.setString(13, prcperunit);
                                    pst.setString(14, totalprice);   
                                    pst.setString(15, mfg_date);
                                    pst.setString(16, Expiry_date);
                                    pst.setString(17, status_mi);
                                    pst.setString(18, descrip);
                                    k=pst.executeUpdate();
                                }
                                catch(Exception ex)
                                {
                                    JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
            
                                }
            
            //**************** Update Value in product table*************************
             
                                try
                               {
                                    Dbconn coon = new Dbconn();
                                    //con = coon.getConnection();
                                    int r12=jmi_MaterialInwardTable.getRowCount();
                                    int c12=jmi_MaterialInwardTable.getColumnCount();
                                    String mi_totalstock,mi_prod_name;
                                    mi_totalstock = (String) jmi_MaterialInwardTable.getValueAt(row, 4);
                                    mi_prod_name = (String) jmi_MaterialInwardTable.getValueAt(row, 0);
                                    for(int row12=0;row12<=r12;row12++)
                                    {
                
                                        int i = coon.update_data("update product_info SET totalstock =?"
                                        +" where product_name=?" , new String[]{mi_totalstock,mi_prod_name});
                                        if(i>0)
                                        {
                                            //JOptionPane.showMessageDialog(rootPane, "Rows Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        else
                                        {
                                            // JOptionPane.showMessageDialog(rootPane, "Not Saved", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }   
            
               
                                }
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
                                }
            //******************End of Insert Values in Product Table
 
                                if(k>0)
                                {
                                    if(row==r-1)
                                    {
                                    JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(rootPane, "Data Not Saved", "Warning!", JOptionPane.ERROR_MESSAGE);
                                }
    
            }    
            modelItem1 = (DefaultTableModel) jmi_MaterialInwardTable.getModel();
            modelItem1.setRowCount(0);
            
            modelItem=(DefaultTableModel)jmi_PurchaseOrderTable.getModel();
            modelItem.setRowCount(0);
            jmi_poNotxt.setText("");
            jmi_supplierNametxt.setText("");
            jmi_poDatetxt.setText("");
            jmi_batchNotxt.setText("");
            increament();
        }
            else
            {
               // System.out.println("in if "+yesorNo);
                
            }

            
    }//else Close

// TODO add your handling code here:
    }//GEN-LAST:event_jmi_updatebtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //********************Validation of The Fileds ************************
        error="";
        valid=0;
        if(jmi_TotalStocktxt.getText().equals(""))
        {
            error+="\n"+"Please Enter the total stock to update";
            valid=1;
        }
        if(jmi_ExpiryDatetxt.getText().equals(""))
        {
            error+="\n"+"Please Enter the Expiry Date of the Product.";
            valid=1;
        }
        if(jmi_MfgDatetxt.getText().equals(""))
        {
            error+="\n"+"Please Enter the Manufacturing Date.!";
            valid=1;
        }
        if(jmi_Vat_Combo.getSelectedIndex()==0)
        {
            error+="\n"+"Please Select the VAT Amount.!";
            valid=1;
        
        }
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error...", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        
            //********************************************************************s         
            String col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11;
        
            col1 = jmi_Name_Of_Medicinetxt.getText();
            col2 = jmi_brandtxt.getText();
            col3 = jmi_availStocktxt.getText();
            col4 = jmi_stockToUpdatetxt.getText();
            col5 = jmi_TotalStocktxt.getText();
            col6 = (String) jmi_Vat_Combo.getSelectedItem();
            col7 = jmi_pricePerUnittxt.getText();
            col8 = jmi_TotalPricetxt.getText();
            col9  = jmi_MfgDatetxt.getText();
            col10 = jmi_ExpiryDatetxt.getText();
            col11 = jmi_descriptiontxt.getText();
            
            
            
        
            conn = new Dbconn();
            modelItem1 =(DefaultTableModel) jmi_MaterialInwardTable.getModel();
            //modelItem1.setRowCount();
            modelItem1.addRow(new String[]{col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11});
        
            //***********Clear Data After Adding a Row**************
        
        
            jmi_Name_Of_Medicinetxt.setText("");
            jmi_availStocktxt.setText("");
            jmi_stockToUpdatetxt.setText("");
            jmi_TotalStocktxt.setText("");
            jmi_brandtxt.setText("");
            jmi_MfgDatetxt.setText("");
            jmi_ExpiryDatetxt.setText("");
            jmi_descriptiontxt.setText("");
            jmi_pricePerUnittxt.setText("");
            jmi_TotalPricetxt.setText("");
            jmi_Vat_Combo.setSelectedIndex(0);
        
           //**********************************************************
           // modelItem1.fireTableStructureChanged();;
            //modelItem1.fireTableRowsInserted(1, 8);
            jmi_MaterialInwardTable.updateUI();
        }   
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jmi_stockToUpdatetxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_stockToUpdatetxtFocusLost

        int avail,updat,ttal;
        avail = Integer.parseInt(jmi_availStocktxt.getText());
        updat = Integer.parseInt(jmi_stockToUpdatetxt.getText());
        ttal = avail+updat;
        
        jmi_TotalStocktxt.setText(Integer.toString(ttal));
        
        

// TODO add your handling code here:
    }//GEN-LAST:event_jmi_stockToUpdatetxtFocusLost

    private void jmi_PurchaseOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmi_PurchaseOrderTableMouseClicked


        if(evt.getClickCount()==1)
        {
            JTable target = (JTable) evt.getSource();
            selectedrow = target.getSelectedRow();
            Object selectedcellvalue = target.getValueAt(selectedrow, 1);
            jmi_Name_Of_Medicinetxt.setText((String) selectedcellvalue);
            selectedcellvalue = target.getValueAt(selectedrow, 2);
            jmi_brandtxt.setText((String) selectedcellvalue);
            selectedcellvalue = target.getValueAt(selectedrow, 3);
            jmi_stockToUpdatetxt.setText((String) selectedcellvalue);
           // refreshForm(selectedcellvalue);
        }
        
    }//GEN-LAST:event_jmi_PurchaseOrderTableMouseClicked

    private void jmi_PurchaseOrderTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmi_PurchaseOrderTableKeyPressed

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 1);  
      jmi_Name_Of_Medicinetxt.setText(selectedCellValue.toString());
      selectedCellValue = target.getValueAt(selectedrow, 2);
       jmi_brandtxt.setText((String) selectedCellValue);
       selectedCellValue = target.getValueAt(selectedrow, 3);
       jmi_stockToUpdatetxt.setText((String) selectedCellValue);
    //  JOptionPane.showMessageDialog(target, selectedCellValue, title, JOptionPane.ERROR_MESSAGE);
        //  refreshForm(selectedCellValue);
    }
    }//GEN-LAST:event_jmi_PurchaseOrderTableKeyPressed

    private void jmi_PurchaseOrderTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmi_PurchaseOrderTableKeyReleased

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedrow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedrow, 1);  
          jmi_Name_Of_Medicinetxt.setText((String) selectedCellValue);
          selectedCellValue = target.getValueAt(selectedrow, 2);
       jmi_brandtxt.setText((String) selectedCellValue);
       selectedCellValue = target.getValueAt(selectedrow, 3);
       jmi_stockToUpdatetxt.setText((String) selectedCellValue);
    }// TODO add your handling code here:
    }//GEN-LAST:event_jmi_PurchaseOrderTableKeyReleased

    private void jmi_PurchaseOrderTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_PurchaseOrderTableFocusGained

//        String availstock = jmi_Name_Of_Medicinetxt.getText();
//       
    }//GEN-LAST:event_jmi_PurchaseOrderTableFocusGained

    private void jmi_availStocktxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_availStocktxtFocusGained

        conn = new Dbconn();
        String medi_name=jmi_Name_Of_Medicinetxt.getText();
        String availstk=null;
        rs_material=conn.execute_query("select * from product_info where product_name=?", new String[]{medi_name});
        try {
            while(rs_material.next())
            {
               availstk= (rs_material.getString("totalstock"));
               System.out.println(availstk);

            }
            if(availstk==null)
            {
                jmi_availStocktxt.setText("0");
                        
            }
            else
            {
            jmi_availStocktxt.setText(availstk);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e, "", selectedrow);
        }
            
            // TODO add your handling code here:
    }//GEN-LAST:event_jmi_availStocktxtFocusGained

    private void jmi_TotalStocktxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_TotalStocktxtFocusGained

        int avail,updat,ttal;
        avail = Integer.parseInt(jmi_availStocktxt.getText());
        updat = Integer.parseInt(jmi_stockToUpdatetxt.getText());
        ttal = avail+updat;
        
        jmi_TotalStocktxt.setText(Integer.toString(ttal));
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_TotalStocktxtFocusGained

    private void jmi_pricePerUnittxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_pricePerUnittxtFocusLost

        int stok2updt,prcperUnit,totalprice;
        String a;
        stok2updt= Integer.parseInt(jmi_stockToUpdatetxt.getText());
        prcperUnit= Integer.parseInt(jmi_pricePerUnittxt.getText());
        totalprice =stok2updt*prcperUnit;
       Math.round(totalprice);
       a=""+totalprice;
        jmi_TotalPricetxt.setText(a);
// TODO add your handling code here:
    }//GEN-LAST:event_jmi_pricePerUnittxtFocusLost

    private void jmi_grNotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_grNotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_grNotxtActionPerformed

    private void jmi_stockToUpdatetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmi_stockToUpdatetxtKeyTyped

        char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jmi_stockToUpdatetxtKeyTyped

    private void jmi_poNotxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_poNotxtFocusLost

//        jmi_supplierNametxt.setText("");
//        jmi_poDatetxt.setText("");
        
        
         try
        {
            povaluetxt="";
            error="";
            valid=0;
            povaluetxt=jmi_poNotxt.getText();
//            if(povaluetxt.equals(""))
//            {
//                error+="\n"+"Please enter the P.O. Number.!";                
//                valid=1;
//            }
            if(valid==1)
            {
                JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                  RefreshTable(povaluetxt);
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
         
//         if(jmi_supplierNametxt.getText().equals("") && jmi_poDatetxt.getText().equals(""))
//         {
//             JOptionPane.showMessageDialog(rootPane, "Please Enter Valid P.O. Number", "Error", JOptionPane.ERROR_MESSAGE);
//         }
         
         
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_poNotxtFocusLost

    private void jmi_poNotxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmi_poNotxtFocusGained
//       jmi_supplierNametxt.setText("");
//        jmi_poDatetxt.setText("");
        
// TODO add your handling code here:
    }//GEN-LAST:event_jmi_poNotxtFocusGained

    private void jmi_descriptiontxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmi_descriptiontxtKeyPressed

        
       if(evt.getKeyCode()==KeyEvent.VK_TAB)
        {
             jButton1.requestFocus();
        }
    
    
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_descriptiontxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jmi_Datetxt;
    private javax.swing.JTextField jmi_ExpiryDatetxt;
    private javax.swing.JTable jmi_MaterialInwardTable;
    private javax.swing.JTextField jmi_MfgDatetxt;
    private javax.swing.JTextField jmi_Name_Of_Medicinetxt;
    private javax.swing.JTable jmi_PurchaseOrderTable;
    private javax.swing.JTextField jmi_TotalPricetxt;
    private javax.swing.JTextField jmi_TotalStocktxt;
    private javax.swing.JComboBox jmi_Vat_Combo;
    private javax.swing.JTextField jmi_availStocktxt;
    private javax.swing.JButton jmi_backbtn;
    private javax.swing.JTextField jmi_batchNotxt;
    private javax.swing.JTextField jmi_brandtxt;
    private javax.swing.JButton jmi_clearbtn;
    private javax.swing.JTextArea jmi_descriptiontxt;
    private javax.swing.JTextField jmi_grNotxt;
    private javax.swing.JTextField jmi_poDatetxt;
    private javax.swing.JTextField jmi_poNotxt;
    private javax.swing.JTextField jmi_pricePerUnittxt;
    private javax.swing.JTextField jmi_stockToUpdatetxt;
    private javax.swing.JTextField jmi_supplierNametxt;
    private javax.swing.JButton jmi_updatebtn;
    // End of variables declaration//GEN-END:variables
}
