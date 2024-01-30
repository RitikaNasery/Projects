/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;


import DB.Dbconn;
import UserManagement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import master.*;
import medicalstoremanagement.*;


/**
 *
 * @author user
 */
public class Product_Information extends javax.swing.JInternalFrame {

    /**
     * Creates new form attendance
     */
    String as,ass,prod_id,prod_name,prod_category,rate_per_unit,total_stock,col,row;
    ResultSet rs_expiry;
    DefaultTableModel modelItem;
     TableRowSorter<TableModel> sorter;
   
    
    JFrame frame = new JFrame();
    public Product_Information(JFrame parent, boolean modal) {
        initComponents();
        modelItem = (DefaultTableModel) jprod_info_table.getModel();
        modelItem.setRowCount(0);
        sorter = new TableRowSorter<TableModel>(modelItem);
        jprod_info_table.setRowSorter(sorter);
        String searchteaxt;
       // refreshTable();
        
        jprod_info_searchtxt.setFocusable(true);
        as="";
      
        Dbconn conn = new Dbconn();
        rs_expiry = conn.execute_query("select * from product_info where productstatus=?", new String[]{"ACTIVE"});
        try {
            while(rs_expiry.next())
            {
                prod_id = rs_expiry.getString("product_id");
                prod_name = rs_expiry.getString("product_name");
                prod_category = rs_expiry.getString("product_category");
                rate_per_unit = rs_expiry.getString("product_rateperunit");
                total_stock = rs_expiry.getString("totalstock");
                col=rs_expiry.getString("col");
                row=rs_expiry.getString("row");
                
                modelItem.addRow(new String[] {prod_id,prod_name,prod_category,rate_per_unit,total_stock,col,row});
            }
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jprod_info_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jprod_info_searchtxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Purchase Order");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 575));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jprod_info_table.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jprod_info_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prduct Id", "Product name", "Category", "Rate Per Unit", "Total Stock", "Column", "Row"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jprod_info_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jprod_info_table);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Search :");

        jprod_info_searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jprod_info_searchtxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jprod_info_searchtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jprod_info_searchtxtKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jprod_info_searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jprod_info_searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("PRODUCT INFORMATION");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(564, 564, 564))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public Class getColumnClass(int column)
    {
    		
    	for (int row = 0; row < jprod_info_table.getRowCount(); row++)
    	{
    	    Object o = jprod_info_table.getValueAt(row, column);
     		if (o != null)
    		return o.getClass();
    	}
        return Object.class;
    	              
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
    
    
    private void jprod_info_searchtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jprod_info_searchtxtKeyTyped

       char c = evt.getKeyChar();
       int col=2;
       getColumnClass(col);
        
       
        DefaultRowSorter sorter = ((DefaultRowSorter)jprod_info_table.getRowSorter());
    	ArrayList list = new ArrayList();
    	list.add( new RowSorter.SortKey(2, SortOrder.ASCENDING) );
    	sorter.setSortKeys(list);
    	sorter.sort();
       
       
       
       //RefreshTable(c);
        

         
         
//        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
//        {
//            getToolkit().beep();
//            evt.consume();
//           
//        }

// TODO add your handling code here:
    }//GEN-LAST:event_jprod_info_searchtxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

     private void sortTable()
    {
        String searchteaxt;
        searchteaxt=jprod_info_searchtxt.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
   
    private void jprod_info_searchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jprod_info_searchtxtKeyReleased
  sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jprod_info_searchtxtKeyReleased

    private void jprod_info_searchtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jprod_info_searchtxtKeyPressed
     sortTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jprod_info_searchtxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jprod_info_searchtxt;
    private javax.swing.JTable jprod_info_table;
    // End of variables declaration//GEN-END:variables
}
