/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
    private static Connection con=null;
    
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/pos";
            con=DriverManager.getConnection(url,"root","");
            System.out.println("Connection open");
            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("MyConnection driver not load="+e);
        }
        catch(SQLException e)
        {
            System.out.println("MyConnection "+e);  
        }
    }
    public static Connection getConnection()
    {
    return con;
    }
    public static void close()
    {
    try
    {
       
    
      con.close();
        System.out.println("myConnection close=");
      
    }
    catch(SQLException e)
    
    {
        System.out.println("MyConnection close"+e);
    }
    } 
}
