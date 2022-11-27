package dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao{
    public static Connection conectabd() {
        Connection conn = null;
              
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","macaco123");
        
            Statement stmt=conn.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
        }
      
        catch(Exception e)
        {
            System.out.println(e);
             
        }
       return conn;
      
    }
        
        
        
        
        
        
    }
