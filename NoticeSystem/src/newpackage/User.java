/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static newpackage.User.us;




public class User{

   
      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;
      
     private String s1,s2,s3,s4,s5,s6,s7;
     public static int us=0;
     
     
     //
      public void rejection(String s){
         s1=s;
         int numb= Integer.parseInt(s1);
              
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
          
          String SQL = "Update NoticeTable set Approve = ? where NoticeNum= ?";
        PreparedStatement pst = null;
          try {
               pst = con.prepareStatement(SQL);
               pst.setString(1,"Reject");
               pst.setInt(2, numb);
               
               
             int res = pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Notice  "+s1+"   Approved");  
            
        
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
 
         
     }
 
     
     public void approval(String s){
         s1=s;
         int numb= Integer.parseInt(s1);
              
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
          
          String SQL = "Update NoticeTable set Approve = ? where NoticeNum= ?";
        PreparedStatement pst = null;
          try {
               pst = con.prepareStatement(SQL);
               pst.setString(1,"yes");
               pst.setInt(2, numb);
               
               
             int res = pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Notice  "+s1+"   Approved");  
            
        
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
 
         
     }
 
     
   
     
     public int countrow() throws SQLException{
          try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select count(NoticeNum) from NoticeTable"; 
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM NoticeTable");

          rs = stmt.executeQuery("SELECT COUNT(*) FROM NoticeTable");
    // get the number of rows from the result set
    rs.next();
    int rowCount = rs.getInt(1);
    rs.close();
    stmt.close();
    con.close();


         
         return rowCount + 1;
     
     }
     
     
     
     
     
     
     
     
     

     //Login
      
      public int login(String a,String b){
          s1=a;
          s2=b;
          int retu=0;
          try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select * from AccountInfo where ID='"+s1+"' and Passwords ='"+s2+"'"; 
        try {  
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                retu = 1;
            }
            else{
                retu=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
          return retu;  
      }
      
      
      
      
      
      
      
      //Catagori cheker
      public int catagoriCheker(String a,String b){
          
          s5=a;
          s6=b;
          
          int retu=0;
          
          try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select * from AcademicInfo where ID='"+s5+"' and Catagori='"+s6+"'"; 
        try {  
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                retu = 1;
                
            }
            else{
                retu=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
          return retu;
          
      }
      
      
      
      
      
      
      //Signup
      
      public int signup(String a,String b,String c,String d) throws SQLException{
          s1=a;
          s2=b;
          s3=c;
          s4=d;
          int res=0;
          
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
          
          String SQL = "insert into AccountInfo(ID,SecurutyAnswer,Passwords,Batch) values(?, ?, ?, ?)";
        PreparedStatement pst = null;
          try {
               pst = con.prepareStatement(SQL);
               pst.setString(1,s1);
               pst.setString(2,s2);
               pst.setString(3,s3);
               pst.setString(4,s4);
               
               res= pst.executeUpdate();
        
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }
        return res;
      }
      
      
      
    public int forgotPass(String pss,String idd,String sec){
          s1=pss;
          s2=idd;
          s3=sec;
          
          int res=0;
          
        try {
            // TODO add your handling code here:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
          
          String SQL = "Update AccountInfo SET passwords= ? WHERE ID= ? and SecurutyAnswer = ?";
        PreparedStatement pst = null;
          try {
               pst = con.prepareStatement(SQL);
               pst.setString(1,s1);
               pst.setString(2,s2);
               pst.setString(3,s3);
               
               
               res= pst.executeUpdate();
        
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }

          return res;
          
          
      }
      
      
      public int beforePass(String a, String b){
          s1=a;
          s2=b;
          
          int retu=0;
          
          try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select * from AccountInfo where ID='"+s1+"' AND SecurutyAnswer= '"+s2+"'"; 
        try {  
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                retu = 1;
                
            }
            else{
                retu=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
          return retu;  
       
      }
      
      
      
      
      
     
      
      
      
      public int chekerAccount(String a){
          s3=a;
          
          int retu=0;
          try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select * from AccountInfo where ID='"+s3+"'"; 
        try {  
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                retu = 1;
            }
            else{
                retu=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
          return retu;    
      }
      
      
      
      
      
      
      
      public int chekerStm(String a){
         
          s1=a;
          
          
          int retu=0;
          
          try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SadPro;user=sa;Password =12345678";
        try {
            con = DriverManager.getConnection(connectionUrl);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQL = "Select * from AcademicInfo where ID='"+s1+"'"; 
        try {  
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stmt.executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                retu = 1;
                
            }
            else{
                retu=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
          return retu;  
      }   
    
}
