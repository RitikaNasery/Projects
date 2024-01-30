package DB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.*;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


 public class Dbconn {
     String server;
    public Dbconn()
    {
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
        }
    }
    //get connection
    public Connection getConnection()
            
    {
        try
        {
          //  server=new inventry_erp.GlobalValues().server;

         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalstore","root","");  
         return con;
        }
        catch(SQLException e)
        {
        }
         return null;
    }
    

    //execu queries to get result set
    //args is Stringparamenters to set values
    public  ResultSet execute_query(String sql_string, String[] args)
     {
          ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps;
          int i=0,j=1;
         
          try
          {
              con=this.getConnection();
             
             ps=con.prepareStatement(sql_string);
             
             if(args.length>0)
             {
                for(i=0;i<args.length;i++)
                {
                    ps.setString(j, args[i]);
                    // System.out.println(j+" "+args[i]) ;
                    j++;

                }
             }
             System.out.println(ps.toString());
             rs=ps.executeQuery();
            
              
             return rs;
          }
          catch(Exception e)
          {
              e.printStackTrace();
              try
              {
              con.close();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
              return rs;
          }
     }
    public  ResultSet execute_query(String sql_string, ArrayList args)
     {
          ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps;
          int i=0,j=1;
         
          try
          {
              con=this.getConnection();
             ps=con.prepareStatement(sql_string);
             if(args.size()>0)
             {
                for(i=0;i<args.size();i++)
                {
                    ps.setString(j, args.get(i).toString());
                   //  System.out.println(j+" "+args.get(i).toString()) ;
                    j++;

                }
             }
             
             rs=ps.executeQuery();
            
             return rs;
          }
          catch(SQLException e)
          {
             e.printStackTrace();
              try
              {
              con.close();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
              return rs;
          }
     }
    //get emp name of given emp id
    public String get_emp_name(int staff_code)
    {
        ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps;
          int i=0,j=1;
         
          try
          {
              con=this.getConnection();
             ps=con.prepareStatement("select staff_name from staff where staff_code =?");
             ps.setInt(1,staff_code);

              
             rs=ps.executeQuery();
            if(rs.next())
            {
                return rs.getString("staff_name");
            }
            else
            {
                return "unknown";
            }
          }
          catch(SQLException e)
          {
              e.printStackTrace();
              try
              {
              con.close();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
             
              return "unknown";
          }
    }
    // insert data into database. 
    //paramenters are sql strint for prepared statement and string array
    public int insert_data(String sql_string, String[] args)
     {
          ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps=null;
          int i=0,j=1, insert_id=0;
          Statement s;
          try
          {
              con=getConnection();
              s=con.createStatement();
              ps=con.prepareStatement(sql_string, Statement.RETURN_GENERATED_KEYS);
          
             for(i=0;i<args.length;i++)
             {
                 ps.setString(j, args[i]);
                 j++;
                
                  //System.out.println(args[i]);
             }
           
             ps.executeUpdate();
             rs=ps.getGeneratedKeys();
             
             rs.next();
             
          //   return rs.getInt(1);
             return 1;
          }
          catch(Exception e)
          {
              e.printStackTrace();
              try
              {
              con.close();
              }
              catch(SQLException ex)
              {
                  e.printStackTrace();
              try
              {
              con.close();
              }
              catch(SQLException exd)
              {
                  exd.printStackTrace();
              }
              return 0;
              }
              
              return 0;
          }
     }
    
    //update and delete databse record
    //parametss are sql string for paremens and string array
    public int update_data(String sql_string, String[] args)
     {
          ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps=null;
          int i=0,j=1, insert_id=0;
          Statement s;
          try
          {
              con=getConnection();
              s=con.createStatement();
              ps=con.prepareStatement(sql_string);
          
             for(i=0;i<args.length;i++)
             {
                 ps.setString(j, args[i]);
                  System.out.println(j+" "+args[i]);
                 j++;
             }
           
             ps.executeUpdate();
         
             return 1;
            }
          catch(Exception e)
              {
                    e.printStackTrace();
              try
              {
                con.close();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
              
              
              return 0;
          }
     }
    
    //create log of user activitites
    //paramentr is string of activity done by user.
    //function will automaticly fetch login employee name
     public boolean write_log(String log)
     {
         ResultSet rs=null;
          Connection con=null;
          PreparedStatement ps=null;
          Statement s;
          try
          {
              con=getConnection();
              s=con.createStatement();
              ps=con.prepareStatement("insert into log(log_emp_id,log_message) values(?,?)");
            //  ps.setInt(1, new inventry_erp.GlobalValues().login_emp_id);
              ps.setString(2, log);
            
             ps.executeUpdate();
             s.executeUpdate("update rooms set room_no='dsfds' where room_no='dsfsdfdsfds111'");   
             return true;
          }
          catch(Exception e)
          {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              return false;
          }
     }
    public static void main(String agrs[])
    {
        Dbconn d=new Dbconn();
        d.getConnection();
        }
}
