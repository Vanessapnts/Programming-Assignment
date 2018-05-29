package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanessa
 */
public class UserDAO {

    
    
    public boolean checkLogin(String id, String pass) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stm = con.prepareStatement("SELECT * FROM login WHERE id = ? && pass = ? ");
            stm.setString(1, id);
            stm.setString(2, pass);

            rs = stm.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }

        return check;

        
        
        
    }
    

}
