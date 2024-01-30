/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

//import demon.*;
import DB.*;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


/**
 *
 * @author user
 */
public class Employee extends javax.swing.JInternalFrame 
{
    int selectedRow;
    public Connection con;
           
    String empname,empedu,empcntctno,empbloodgrp,empdob,empage,empemail,empaddress,empid;
    String error="";
    String empgender;
    int valid=0;
    Dbconn conn;
    ResultSet rs_Emp;
    DefaultTableModel modelItem;
   // DefaultTableModel modalItem;
    public Employee(JFrame parent, boolean modal) {
        initComponents();
        
        modelItem=(DefaultTableModel)jemployeetable.getModel();
         conn=new Dbconn();
          refreshTable();
    }
       
        
    public void refreshTable()
    {
       modelItem.setRowCount(0);
        try
        {
            rs_Emp=conn.execute_query("select * from employee_info where employee_status=?", new String[]{"ACTIVE"});
            
            while (rs_Emp.next()) 
            {
                empid=rs_Emp.getString("employee_id");
                empname=rs_Emp.getString("employee_name");
                empaddress=rs_Emp.getString("employee_address");
                empedu=rs_Emp.getString("employee_education");
                empcntctno=rs_Emp.getString("employee_contactno");
                empemail=rs_Emp.getString("employee_email");
               
                modelItem.addRow(new String[]{empid,empname,empaddress,empedu,empcntctno,empemail});
                        
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
            rs=st.executeQuery("select * from employee_info where employee_id="+cellvalue);
            while(rs.next())
            {
                
                jemployee_idtxt.setText(rs.getString("employee_id"));
                jemployee_nametxt.setText(rs.getString("employee_name"));
                jemployee_contactnotxt.setText(rs.getString("employee_contactno"));
                jemployee_dobtxt.setText(rs.getString("employee_dob"));
                jemployee_addresstxt.setText(rs.getString("employee_address"));
                jemployee_educationtxt.setText(rs.getString("employee_education"));
                jemployee_gender.setSelectedItem(rs.getString("employee_gender"));
               
                   jemployee_bloodgrp.setSelectedItem(rs.getString("employee_bloodgroup"));

                jemployee_agetxt.setText(rs.getString("employee_age"));
                jemployee_emailtxt.setText(rs.getString("employee_email"));
             }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
    public void validat()
   {
        error="";
       valid=0;
        
        if(empname.equals(""))
        {
            error+="\n"+"Please Enter the name";
            valid=1;
        }
        
         if(empedu.equals(""))
        {
            error+="\n"+"Please Enter the Education";
            valid=1;
        }
         
        if(empgender.equals("---Select---"))
        {
            error+="\n"+"Select the Gender.";
            valid=1;
                    
        }
         
          
           
       
         if(empbloodgrp.equals("Select Blood Group"))
        {
            error+="\n"+"Select the Blood group";
            valid=1;
                    
        }
           
            if(empdob.equals(""))
        {
            error+="\n"+"Please Enter the Date Of Birth";
            valid=1;
        }
        
        if(empage.equals("") || (empage.length()>=3))
        {
            error+="\n"+"Please Enter the age";
            valid=1;
        }
        
        if(empemail.equals(""))
        {
            error+="\n"+"Please Enter the Email-ID.";
            valid=1;
        }
        
        if(empaddress.equals(""))
        {
            error+="\n"+"Please Enter the Address";
            valid=1;
        }
        
       
        if(empcntctno.equals("") || (empcntctno.length()<=9) || (empcntctno.length()>=11) )
        {
            error+="\n"+"Please Enter VALID Contact Number";
            valid=1;
                    
        }
        
         boolean no;
       no= Numbervalidate(empcntctno);
       
       if(no==false)
       {
           error+="\n"+"Please enter the VALID CONTACT NUMBER";
           //JOptionPane.showMessageDialog(rootPane, "Please enter the VALID CONTACT NUMBER.", "Error",JOptionPane.ERROR_MESSAGE);
           valid=1;
       }
       no= Numbervalidate(empage);
       if(no==false)
       {
           error+="\n"+"Please enter the VALID AGE.";
           //JOptionPane.showMessageDialog(rootPane, "Please enter the VALID AGE.", "Error",JOptionPane.ERROR_MESSAGE);
           valid=1;
       }
       
       try {
            String lineIwant = empemail;
            String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Boolean b = lineIwant.matches(emailreg);
                if (b == false) {
                    error+="\n"+"Enter Valid Email Id";
                    valid=1;
                }


        } 
       catch (Exception e)
       {

        //   JOptionPane.showMessageDialog(rootPane, e, "Error",JOptionPane.ERROR_MESSAGE);
           
        }
       // dob validation
       try {
            String lineIwant = empdob;
            String dobreg = ("\\d{4}-\\d{2}-\\d{2}");
            Boolean b = lineIwant.matches(dobreg);
                if (b == false) {
                    error+="\n"+"Please enter the Date of Birth";
                    valid=1;
                   // JOptionPane.showMessageDialog(rootPane, "Please enter the VALID EMAIL-ID", "Error",JOptionPane.ERROR_MESSAGE);
                }


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }
       
        
    }
    //Number format validation
     public boolean Numbervalidate(String str)
     {
//         if (empcntctno == null || empcntctno.length() == 0)
//            return false;
        
        for (int i = 0; i < str.length(); i++) {
 
            //If we find a non-digit character we return false.
            if (!Character.isDigit(str.charAt(i)))
            
                return false;
        }
        
        return true; 
     
     }   
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        save1 = new javax.swing.JButton();
        jupdate1 = new javax.swing.JButton();
        jdelete1 = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        jexit1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jemployee_idtxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jemployee_nametxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jemployee_educationtxt = new javax.swing.JTextField();
        jemployee_contactnotxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jemployee_dobtxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jemployee_addresstxt = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jemployee_gender = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jemployee_bloodgrp = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jemployee_agetxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jemployee_emailtxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jemployeetable = new javax.swing.JTable();

        setClosable(true);
        setTitle("Employee");
        setPreferredSize(new java.awt.Dimension(1350, 550));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        save1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        save1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        save1.setText("Submit");
        save1.setToolTipText("Click Here To Submit Data");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        jupdate1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jupdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateicon.png"))); // NOI18N
        jupdate1.setText("Update");
        jupdate1.setToolTipText("Click to Update Emp. Data");
        jupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdate1ActionPerformed(evt);
            }
        });

        jdelete1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jdelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteicon.png"))); // NOI18N
        jdelete1.setText("Delete");
        jdelete1.setToolTipText("Click to Delete emp detail");

        clear1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        clear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        clear1.setText("Clear");
        clear1.setToolTipText("Click to reset");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        jexit1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jexit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jexit1.setText("Exit");
        jexit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jupdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdelete1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jexit1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jupdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jexit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Employee Id");

        jemployee_idtxt.setEditable(false);
        jemployee_idtxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_idtxt.setToolTipText("Enter emp id");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Name");

        jemployee_nametxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_nametxt.setToolTipText("Enter Emp. Name");

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel22.setText("Education");

        jemployee_educationtxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_educationtxt.setToolTipText("Enter Emp. Edcucation");
        jemployee_educationtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jemployee_educationtxtFocusLost(evt);
            }
        });

        jemployee_contactnotxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_contactnotxt.setToolTipText("Enter Date Of Birth");
        jemployee_contactnotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jemployee_contactnotxtKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Contact No");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Date Of Birth");

        jemployee_dobtxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_dobtxt.setToolTipText("Enter Emp. Contact no");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Address");

        jemployee_addresstxt.setColumns(20);
        jemployee_addresstxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_addresstxt.setRows(5);
        jemployee_addresstxt.setToolTipText("Enter Address ");
        jemployee_addresstxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jemployee_addresstxtFocusLost(evt);
            }
        });
        jemployee_addresstxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jemployee_addresstxtKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jemployee_addresstxt);

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel21.setText("Gender");

        jemployee_gender.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select---", "Male", "Female", "Other" }));
        jemployee_gender.setToolTipText("Select Gender");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel20.setText("Blood Group");

        jemployee_bloodgrp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_bloodgrp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Blood Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel19.setText("Age");

        jemployee_agetxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_agetxt.setToolTipText("Enter Emp. Age");
        jemployee_agetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jemployee_agetxtKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel18.setText("Email");

        jemployee_emailtxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployee_emailtxt.setToolTipText("Enter Emp. Email Adress");
        jemployee_emailtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jemployee_emailtxtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jemployee_idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(231, 231, 231))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jemployee_nametxt)
                                .addGap(44, 44, 44))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel22)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jemployee_emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jemployee_contactnotxt)
                                    .addComponent(jemployee_dobtxt)
                                    .addComponent(jemployee_educationtxt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jemployee_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jemployee_agetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jemployee_bloodgrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jemployee_idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jemployee_nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jemployee_educationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jemployee_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jemployee_contactnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jemployee_bloodgrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jemployee_dobtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(jemployee_agetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jemployee_emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jemployeetable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jemployeetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Employee Name", "Addresss", "Education", "Contact No", "Email Id"
            }
        ));
        jemployeetable.getTableHeader().setReorderingAllowed(false);
        jemployeetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jemployeetableMouseClicked(evt);
            }
        });
        jemployeetable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jemployeetableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jemployeetableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jemployeetable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        jemployee_addresstxt.setText("");
        jemployee_agetxt.setText("");
        jemployee_contactnotxt.setText("");
        jemployee_dobtxt.setText("");
        jemployee_educationtxt.setText("");
        jemployee_idtxt.setText("");
        jemployee_nametxt.setText("");


    }//GEN-LAST:event_clear1ActionPerformed
    private void jexit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexit1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jexit1ActionPerformed
    private void jupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdate1ActionPerformed
    }//GEN-LAST:event_jupdate1ActionPerformed
    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        conn=new Dbconn();
        empname= jemployee_nametxt.getText();
        empedu = jemployee_educationtxt.getText();
        empcntctno = jemployee_contactnotxt.getText();
        empdob = jemployee_dobtxt.getText();
        empage = jemployee_agetxt.getText();
        empaddress = jemployee_addresstxt.getText();
        empemail = jemployee_emailtxt.getText();
        empbloodgrp = jemployee_bloodgrp.getSelectedItem().toString();
        empgender = jemployee_gender.getSelectedItem().toString();

        validat();
        if(valid==1)
        {
            JOptionPane.showMessageDialog(rootPane, error, "Error",JOptionPane.ERROR_MESSAGE);
        }
        
        int a;
         if(valid==0)
        {
            
            a =  JOptionPane.showConfirmDialog(rootPane, "Do you want to save Data","Confirm", JOptionPane.YES_NO_OPTION);
            System.out.println(a);
            
            if(a==0)
            {
            //insert query....
                int i=conn.insert_data("insert into employee_info (employee_name,employee_contactno,employee_dob,employee_address,"
                    + "employee_education,employee_gender,employee_bloodgroup,employee_age,"
                     + "employee_email,employee_status) values (?,?,?,?,?,?,?,?,?,?)", new String[]{jemployee_nametxt.getText(),
                         jemployee_contactnotxt.getText(),jemployee_dobtxt.getText(),jemployee_addresstxt.getText(),jemployee_educationtxt.getText()
                             , jemployee_gender.getSelectedItem().toString(),jemployee_bloodgrp.getSelectedItem().toString(),
                             jemployee_agetxt.getText(),jemployee_emailtxt.getText(),"ACTIVE"});
     if (i > 0)
            {
                //JOptionPane.showMessageDialog(rootPane, "Data save");
                JOptionPane.showMessageDialog(rootPane, "Data Saved Sucessfully", "SAVE", JOptionPane.INFORMATION_MESSAGE);
    
             //   this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Data Saved Not Saved!", "Warning", JOptionPane.ERROR_MESSAGE);
  }    
            }
            
            
        }
        
 
 // TODO add your handling code here:
    }//GEN-LAST:event_save1ActionPerformed

    private void jemployeetableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemployeetableKeyPressed

        JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==evt.VK_UP)||(evt.getKeyCode()==evt.VK_DOWN))
        {
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
     
      
    }//GEN-LAST:event_jemployeetableKeyPressed

    private void jemployeetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jemployeetableMouseClicked
        if(evt.getClickCount()==1)
        {
            JTable target=(JTable)evt.getSource();
            selectedRow=target.getSelectedRow();
            Object SelectedCellValue=target.getValueAt(selectedRow, 0);
            refreshForm(SelectedCellValue);
        }
        
    }//GEN-LAST:event_jemployeetableMouseClicked

    private void jemployeetableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemployeetableKeyReleased
     JTable target = (JTable)evt.getSource();  
        if((evt.getKeyCode()==KeyEvent.VK_UP)|| evt.getKeyCode()==KeyEvent.VK_DOWN)
    {   
      selectedRow= target.getSelectedRow();  
      Object selectedCellValue=target.getValueAt(selectedRow, 0);  
          refreshForm(selectedCellValue);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jemployeetableKeyReleased

    private void jemployee_contactnotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemployee_contactnotxtKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
           
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_contactnotxtKeyTyped

    private void jemployee_agetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemployee_agetxtKeyTyped
char c = evt.getKeyChar();

        if (!((c >= '0') && (c <= '9') || (c == '.')  || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, JOptionPane.MESSAGE_PROPERTY);
           
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_agetxtKeyTyped

    private void jemployee_educationtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jemployee_educationtxtFocusLost
String temp=jemployee_nametxt.getText();

jemployee_nametxt.setText(temp.toUpperCase());         // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_educationtxtFocusLost

    private void jemployee_emailtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jemployee_emailtxtFocusLost
String temp=jemployee_emailtxt.getText();

jemployee_emailtxt.setText(temp.toUpperCase());          // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_emailtxtFocusLost

    private void jemployee_addresstxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jemployee_addresstxtFocusLost
      String temp=jemployee_addresstxt.getText();

jemployee_addresstxt.setText(temp.toUpperCase());   
        // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_addresstxtFocusLost

    private void jemployee_addresstxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemployee_addresstxtKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_TAB)
{
    save1.requestFocus();
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jemployee_addresstxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jdelete1;
    private javax.swing.JTextArea jemployee_addresstxt;
    private javax.swing.JTextField jemployee_agetxt;
    private javax.swing.JComboBox jemployee_bloodgrp;
    private javax.swing.JTextField jemployee_contactnotxt;
    private javax.swing.JTextField jemployee_dobtxt;
    private javax.swing.JTextField jemployee_educationtxt;
    private javax.swing.JTextField jemployee_emailtxt;
    private javax.swing.JComboBox jemployee_gender;
    private javax.swing.JTextField jemployee_idtxt;
    private javax.swing.JTextField jemployee_nametxt;
    private javax.swing.JTable jemployeetable;
    private javax.swing.JButton jexit1;
    private javax.swing.JButton jupdate1;
    private javax.swing.JButton save1;
    // End of variables declaration//GEN-END:variables
}
