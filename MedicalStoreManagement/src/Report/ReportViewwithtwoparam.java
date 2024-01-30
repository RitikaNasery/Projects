
package Report;
import DB.Dbconn;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportViewwithtwoparam
{
    Connection con;
    
    Dbconn conn=new Dbconn();
    String path;
    InputStream stream = null;
    InputStream stream1 = null;
    public ReportViewwithtwoparam() 
    {
        con=conn.getConnection();
    }
    public void generate(String filename, String paramameter1, String paramameter2)
    {
        try
        {
            con=conn.getConnection();
            JasperReport js1;
            File f = null;
            
            f = new File(filename);
            path = f.getAbsolutePath();
            System.out.print("Absolute Pathname "+ path);
     
            js1 = JasperCompileManager.compileReport(path);
              JasperPrint jp;
                 Map<String, Object> params = new HashMap<String,Object>();
                 
                 
               params.put("parameter1", paramameter1);
               params.put("parameter2", paramameter2);
               
                 jp= JasperFillManager.fillReport(js1, params,con);
                 
                 //Exporting To Excel and PDF file
                 
              // JasperExportManager.exportReportToPdfFile(jp,"e://sample_report.pdf");
              // JasperExportManager.exportReportToHtmlFile(jp,"e://samplere.html");
                
                JasperViewer.viewReport(jp,false);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            //JOptionPane.showMessageDialog( ex);
        }

    }
    
    
    
    
    public static void main(String atrs[])
    {
        
        
        
    }
    
}
