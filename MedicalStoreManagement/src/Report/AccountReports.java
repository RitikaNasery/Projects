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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class AccountReports extends javax.swing.JInternalFrame {


    JFrame frame = new JFrame();
    public AccountReports(JFrame parent, boolean modal) {
        initComponents();
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jprodallreport = new javax.swing.JRadioButton();
        jVouchers = new javax.swing.JRadioButton();
        jdebtors = new javax.swing.JRadioButton();
        jcreditor = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master Reports");
        setToolTipText("");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Account Reports");

        buttonGroup2.add(jprodallreport);
        jprodallreport.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jprodallreport.setText("Bouce Cheque Reports");

        buttonGroup2.add(jVouchers);
        jVouchers.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jVouchers.setText("Vouchers Report");
        jVouchers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVouchersActionPerformed(evt);
            }
        });

        buttonGroup2.add(jdebtors);
        jdebtors.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdebtors.setText("All Debtors Reports");

        buttonGroup2.add(jcreditor);
        jcreditor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jcreditor.setText("All Creditors Reports");
        jcreditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcreditorActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdebtors)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jprodallreport)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcreditor)
                                    .addComponent(jVouchers)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jprodallreport)
                    .addComponent(jVouchers))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdebtors)
                    .addComponent(jcreditor))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(31, Short.MAX_VALUE))
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
 
    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/BouceChequeReport.jrxml";
    para=null;

    r.generate(filename,para);

}

if(jVouchers.isSelected())
{

    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/Distributor.jrxml";
    para=null;

    r.generate(filename,para);

}

if(jdebtors.isSelected())
{
   
    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/DebtorsReport.jrxml";
    para=null;

    r.generate(filename,para);
}


if(jcreditor.isSelected())
{
  
    ReportView r=new ReportView();
    String para,filename;
    filename="Reports/CreditorsReport.jrxml";
    para=null;

    r.generate(filename,para);
}


// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jVouchersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVouchersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jVouchersActionPerformed

    private void jcreditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcreditorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcreditorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jVouchers;
    private javax.swing.JRadioButton jcreditor;
    private javax.swing.JRadioButton jdebtors;
    private javax.swing.JRadioButton jprodallreport;
    // End of variables declaration//GEN-END:variables
}
