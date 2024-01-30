package medicalstoremanagement;

import DB.Dbconn;
import java.awt.Container;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;

public class ReportView
{
//private DatabaseConnectionClass con;

Dbconn conn= new Dbconn();
Connection con= conn.getConnection();

public ReportView()
{
  //  cc= DatabaseConnectionClass.create();
   File f=null;
   String path;
  JasperReport js1;
   try
    {
        
        f = new File("Reports/Distributor.jrxml");
            path = f.getAbsolutePath();
            System.out.print("Absolute Pathname "+ path);
     
            js1 = JasperCompileManager.compileReport(path);
              JasperPrint jp;
                 Map<String, Object> params = new HashMap<String,Object>();
                 
        JasperPrint print = JasperFillManager.fillReport(js1, params, con);  
        //JasperPrint print=JasperFillManager.fillReport(filename, para, con);
        JRViewer viewer=new JRViewer(print);
       }
    catch(Exception e)
    {
        System.out.println(e);
    }
   
}
}
