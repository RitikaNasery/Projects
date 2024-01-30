/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;


import medicalstoremanagement.*;
import UserManagement.*;
import master.*;
import medicalstoremanagement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DB.*;
import java.sql.Connection;



public class CustomizedProductReport extends javax.swing.JInternalFrame {


    JFrame frame = new JFrame();
    Connection con;
    String categoryname,dist,productname;
    Dbconn conn;
    String para;
    public CustomizedProductReport(JFrame parent, boolean modal) {
        initComponents();
        conn=new Dbconn();
    refreshcategory();
    refreshDistributor();
    refreshproductlist();
    
  // refreshproduct();
    jproductcategorytxt.setVisible(false);
    jdist.setVisible(false);
    jproductdistributor.setVisible(false);
    
    
    }

    public void refreshcategory()
    {
    try
    {
         con=conn.getConnection();
    Statement st=con.createStatement();
    ResultSet rs;
    rs=conn.execute_query("select DISTINCT(product_category) from product_info where productstatus=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
            
            categoryname=rs.getString("product_category");
            jproductcategorytxt.addItem(categoryname);
         // System.out.print(distname);
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
    }
    
    public void refreshDistributor()
    {
        try
    {
         con=conn.getConnection();
    Statement st=con.createStatement();
    ResultSet rs;
    rs=conn.execute_query("select DISTINCT (distributor_name) from product_info where productstatus=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
            
            dist=rs.getString("distributor_name");
            
           jdist.addItem(dist);
         // System.out.print(distname);
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
    }
    public void refreshproductlist()
    {
            try
    {
         con=conn.getConnection();
    Statement st=con.createStatement();
    ResultSet rs;
    rs=conn.execute_query("select DISTINCT (product_name) from product_info where productstatus=?", new String[]{"ACTIVE"});
        while(rs.next())
        {
            
            productname=rs.getString("product_name");
            
           jproductdistributor.addItem(productname);
         // System.out.print(distname);
        }
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jprodallreport = new javax.swing.JRadioButton();
        jdistributor = new javax.swing.JRadioButton();
        javailablestock = new javax.swing.JRadioButton();
        jretailer = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jproductcategorytxt = new javax.swing.JComboBox();
        jdist = new javax.swing.JComboBox();
        jproductdistributor = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master Reports");
        setToolTipText("");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Customized Product Report");

        buttonGroup2.add(jprodallreport);
        jprodallreport.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jprodallreport.setText("Categeory Wise");
        jprodallreport.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jprodallreportItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jdistributor);
        jdistributor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdistributor.setText("Distributor Wise Product");
        jdistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdistributorActionPerformed(evt);
            }
        });

        buttonGroup2.add(javailablestock);
        javailablestock.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        javailablestock.setText("Available Stock Report");
        javailablestock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                javailablestockItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jretailer);
        jretailer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jretailer.setText("Product Wise Distributor");
        jretailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jretailerActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print-icon.png"))); // NOI18N
        jButton1.setText("View & Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jproductcategorytxt.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jproductcategorytxt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jproductcategorytxtItemStateChanged(evt);
            }
        });
        jproductcategorytxt.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jproductcategorytxtPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jdist.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jdist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jdistItemStateChanged(evt);
            }
        });
        jdist.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jdistPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jproductdistributor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jproductdistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jproductdistributorItemStateChanged(evt);
            }
        });
        jproductdistributor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jproductdistributorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(62, 62, 62)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(javailablestock)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jprodallreport)
                                    .addGap(130, 130, 130)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jretailer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jdistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jproductdistributor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jproductcategorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(147, 147, 147)
                                    .addComponent(jdist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jprodallreport)
                    .addComponent(jdistributor))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jproductcategorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(javailablestock)
                    .addComponent(jretailer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jproductdistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(jprodallreport.isSelected())
{
 
    ReportViewwithparam r=new ReportViewwithparam();
    String filename;
    filename="Reports/categorywisereport.jrxml";
    if("".equals(jproductcategorytxt.getSelectedItem().toString()))
    {
       JOptionPane.showMessageDialog(rootPane, "Please select category!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
         para=jproductcategorytxt.getSelectedItem().toString();
        r.generate(filename,para);
    }
   

}

if(javailablestock.isSelected())
{

    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/Availablestockreport.jrxml";
    para=null;

    r.generate(filename,para);

}

if(jdistributor.isSelected())
{
 
    ReportViewwithparam r=new ReportViewwithparam();
    String filename;
    filename="Reports/distributerwiseproductreport.jrxml";
    if("".equals(jproductcategorytxt.getSelectedItem().toString()))
    {
       JOptionPane.showMessageDialog(rootPane, "Please select Distributor!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        r.generate(filename,para);
    }
}

if(jretailer.isSelected())
{
 
    ReportViewwithparam r=new ReportViewwithparam();
    String filename;
    filename="Reports/productwisedistributorreport.jrxml";
    if("".equals(jproductcategorytxt.getSelectedItem().toString()))
    {
       JOptionPane.showMessageDialog(rootPane, "Please select Product!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
         
        r.generate(filename,para);
    }
   

}





    }//GEN-LAST:event_jButton1ActionPerformed

    private void jdistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdistributorActionPerformed

          jdist.setVisible(true);
        jproductcategorytxt.setVisible(false);
        jproductdistributor.setVisible(false);

    }//GEN-LAST:event_jdistributorActionPerformed

    private void jprodallreportItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jprodallreportItemStateChanged
        jproductcategorytxt.setVisible(true);
        jdist.setVisible(false);
        jproductdistributor.setVisible(false);

        
    }//GEN-LAST:event_jprodallreportItemStateChanged

    private void jdistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jdistItemStateChanged
        jdist.setVisible(true);
        jproductcategorytxt.setVisible(false);
        jproductdistributor.setVisible(false);
    para=jdist.getSelectedItem().toString();   
    }//GEN-LAST:event_jdistItemStateChanged

    private void jproductdistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jproductdistributorItemStateChanged
    
        jdist.setVisible(false);
        jproductcategorytxt.setVisible(false);
        jproductdistributor.setVisible(true);
          para=jproductdistributor.getSelectedItem().toString();   
        
// TODO add your handling code here:
    }//GEN-LAST:event_jproductdistributorItemStateChanged

    private void jretailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jretailerActionPerformed
        jdist.setVisible(false);
        jproductcategorytxt.setVisible(false);
        jproductdistributor.setVisible(true);
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jretailerActionPerformed

    private void jproductcategorytxtItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jproductcategorytxtItemStateChanged
para=jproductcategorytxt.getSelectedItem().toString();        // TODO add your handling code here:
    }//GEN-LAST:event_jproductcategorytxtItemStateChanged

    private void javailablestockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_javailablestockItemStateChanged

        
  jdist.setVisible(false);
        jproductcategorytxt.setVisible(false);
        jproductdistributor.setVisible(false);
        para=null;

    }//GEN-LAST:event_javailablestockItemStateChanged

    private void jproductcategorytxtPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jproductcategorytxtPopupMenuWillBecomeInvisible

        para=jproductcategorytxt.getSelectedItem().toString(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jproductcategorytxtPopupMenuWillBecomeInvisible

    private void jdistPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jdistPopupMenuWillBecomeInvisible
  para=jdist.getSelectedItem().toString();   
    }//GEN-LAST:event_jdistPopupMenuWillBecomeInvisible

    private void jproductdistributorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jproductdistributorPopupMenuWillBecomeInvisible
     para=jproductdistributor.getSelectedItem().toString();

        
    }//GEN-LAST:event_jproductdistributorPopupMenuWillBecomeInvisible

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton javailablestock;
    private javax.swing.JComboBox jdist;
    private javax.swing.JRadioButton jdistributor;
    private javax.swing.JRadioButton jprodallreport;
    private javax.swing.JComboBox jproductcategorytxt;
    private javax.swing.JComboBox jproductdistributor;
    private javax.swing.JRadioButton jretailer;
    // End of variables declaration//GEN-END:variables
}
