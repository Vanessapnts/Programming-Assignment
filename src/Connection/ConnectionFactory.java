/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author Vanessa
 */
public class ConnectionFactory {

    
      public Connection con;
     public Statement stmt;
    public  ResultSet rs;
    
     String DRIVER = "com.mysql.jdbc.Driver";
     String url = "jdbc:mysql://localhost:3306/CollegeDatabase";
     String user = "root";
     String pass = "11elephant11";
    
    
    
    
    public void openConnectionMySql()
        {
    
    try{
        Class.forName(DRIVER).newInstance();
        con = DriverManager.getConnection(url, user, pass);
        stmt = con.createStatement();
        
    }
    
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error database", "Error",
                JOptionPane.ERROR_MESSAGE, null);
    }
        
        
  
}
    
    
    
    
    
    
    
    
    
    
   /* public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Error Connection: ", ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stm) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
  

}
