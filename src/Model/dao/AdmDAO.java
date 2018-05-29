/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

*/
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.bean.Adm;

/**
 *
 * @author Vanessa
 */
public class AdmDAO {

    public void create(Adm p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("Faculty Inforamtion (ID, Name, Address, Phone, Email)VALUES(?,?,?,?,?)");
            stm.setInt(1, p.getFacultyId());
            stm.setString(2, p.getFacultyName());
            stm.setString(3, p.getFacultyAddress());
            stm.setInt(4, p.getFacultyPhone());
            stm.setString(5, p.getFacultyEmail());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Success !");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }

    }

    public List<Adm> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Adm> adms = new ArrayList<>();

        try {
            stm = con.prepareStatement("SELECT * FROM faculty");
            rs = stm.executeQuery();

            while (rs.next()) {

                Adm adm = new Adm();

                adm.setFacultyId(rs.getInt("Id"));
                adm.setFacultyName(rs.getString("Name"));
                adm.setFacultyAddress(rs.getString("Address"));
                adm.setFacultyPhone(rs.getInt("Phone"));
                adm.setFacultyEmail(rs.getString("Email"));
                adms.add(adm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }

        return adms;

    }
   
    
             public void update(Adm p) {

             Connection con = ConnectionFactory.getConnection();
        
             PreparedStatement stm = null;

             try {
            stm = con.prepareStatement("UPDATE faculty SET Name = ?,Address = ?,Phone = ?,Email = ? WHERE id = ?");
            stm.setInt(1, p.getFacultyId());
            stm.setString(2, p.getFacultyName());
            stm.setString(3, p.getFacultyAddress());
            stm.setInt(4, p.getFacultyPhone());
            stm.setString(5, p.getFacultyEmail());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Done updated !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error not updated " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }

    }
    public void delete(Adm p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("DELETE FROM faculty WHERE id = ?");
            stm.setInt(1, p.getFacultyId());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Done deleted!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error nor deleted: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }

    }

}
