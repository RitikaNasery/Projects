/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import DB.Dbconn;




import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;




public class PendingAccounts extends javax.swing.JInternalFrame {
    Dbconn conn;
    Connection con;
    DefaultTableModel modelItem;
    String creditorname, temp,customerid,creditormob,as;
    JFrame frame = new JFrame();
    TableRowSorter<TableModel> sorter;
    
    public PendingAccounts(JFrame parent, boolean modal) {
        initComponents();
         modelItem=(DefaultTableModel) jpendingaccounttable.getModel();
        sorter = new TableRowSorter<TableModel>(modelItem);
       jpendingaccounttable.setRowSorter(sorter);
         pending_acc_custserchtxt.setFocusable(true);
         as="";
       
        
    }

    

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpendingaccounttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pending_acc_custserchtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("PendingAccounts");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jpendingaccounttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Customer_Id", "Customer Name", "Contact No", "Pending Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jpendingaccounttable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Pending Accounts");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down arrow.png"))); // NOI18N
        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home icon.png"))); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pending_acc_custserchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pending_acc_custserchtxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pending_acc_custserchtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pending_acc_custserchtxtKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Search:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pending_acc_custserchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pending_acc_custserchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modelItem= (DefaultTableModel) jpendingaccounttable.getModel();
        modelItem.setRowCount(0);
        
        
         try
        {
            conn= new Dbconn();
            ResultSet rs;
            
            String s=""+0;
            
            rs = conn.execute_query("select * from creditors where pending_amount>? and status=?",new String[]{s,"ACTIVE"});
            
          while(rs.next())
          {
              customerid=rs.getString("creditors_id");
              creditorname=rs.getString("creditors_name");
              creditormob=rs.getString("creditors_mob");
              temp=rs.getString("pending_amount");
             
          
         
             modelItem.addRow(new String[]{customerid,creditorname, creditormob, temp});
             }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
         
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

      public Class getColumnClass(int column)
    {
    		
    	for (int row = 0; row < jpendingaccounttable.getRowCount(); row++)
    	{
    	    Object o = jpendingaccounttable.getValueAt(row, column);
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
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

      private void sortTable()
    {
        String searchteaxt;
        searchteaxt=pending_acc_custserchtxt.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" +searchteaxt));
    }
    
    
    private void pending_acc_custserchtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pending_acc_custserchtxtKeyTyped
       
//        char c = evt.getKeyChar();
//       int col=2;
//       getColumnClass(col);
//        
//       
//        DefaultRowSorter sorter = ((DefaultRowSorter)jpendingaccounttable.getRowSorter());
//    	ArrayList list = new ArrayList();
//    	list.add( new RowSorter.SortKey(2, SortOrder.ASCENDING) );
//    	sorter.setSortKeys(list);
    	sorter.sort(); 
        
        
    }//GEN-LAST:event_pending_acc_custserchtxtKeyTyped

    private void pending_acc_custserchtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pending_acc_custserchtxtKeyPressed
        // TODO add your handling code here:
         sortTable();
    }//GEN-LAST:event_pending_acc_custserchtxtKeyPressed

    private void pending_acc_custserchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pending_acc_custserchtxtKeyReleased
        // TODO add your handling code here:
         sortTable();
    }//GEN-LAST:event_pending_acc_custserchtxtKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jpendingaccounttable;
    private javax.swing.JTextField pending_acc_custserchtxt;
    // End of variables declaration//GEN-END:variables
}
