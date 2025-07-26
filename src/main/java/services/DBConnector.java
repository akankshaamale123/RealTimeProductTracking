/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


 
 
import java.sql.*;
 
 
 
public class DBConnector {
    
 public Connection con;
    public DBConnector() 
    {
    }
    
    public Connection connect()
    {
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
         
           con=DriverManager.getConnection("jdbc:mysql://avnadmin:AVNS_ifLbTHre7dCd0mTfx31@mysql-d0f06d1-real-60ef.i.aivencloud.com:21241/defaultdb?ssl-mode=REQUIRED");         
            System.out.println("Connected..");
        }
        catch(Exception e)
        {
            System.out.println("Error in connection : "+e.getMessage());
        }
        
    return con;
    }
    
    
    
}

