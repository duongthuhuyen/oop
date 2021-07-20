/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modified;

/**
 *
 * @author My_Laptop
 */
import classes.LayPhuCap;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
//import static connection.JDBCConnection.getJDBCConnection;
//import java.awt.List;
import classes.*;
import com.mysql.cj.xdevapi.PreparableStatement;



/**
 *
 * @author My_Laptop
 */



public class PhuCap{

    /**
     *
     * @return
     */
    
    
    
    public static List<LayPhuCap> getAllPhuCapTrongKeToan() throws SQLException{
        List<LayPhuCap> results = new ArrayList<LayPhuCap>();
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, nl.Ngach, bl.Bac, hd.Phucap FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.ngachluong as nl,  quan_ly_nv.hdld as hd,quan_ly_nv.bacluong as bl  where p.maphong = nv.maphong and nv.Manv = hd.Manv and hd.Mangach = nl.Mangach and hd.Mabac = bl.Mabac";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    LayPhuCap pc = new LayPhuCap( resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getDouble(5),
                            resultSet.getDouble(6) );
                    results.add(pc);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return results;

            } catch (SQLException e) {
                return null;
            }
            
            finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch(SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
    
    
    public static String getPassWord(String ID) throws SQLException{
        String pass = new String();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT  nd.Pass FROM quan_ly_nv.nguoidung as Nd where nd.id = " + ID;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    pass = resultSet.getString(2);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return pass;

            } catch (SQLException e) {
                return null;
            }
            
            finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch(SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
    
   /* public static List<LayPhuCap> getPhuCap(String manv) throws SQLException{
        
        List<LayPhuCap> results = new ArrayList<LayPhuCap>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");     
        String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, nl.Ngach,bl.Bac, hd.Phucap "
                + "FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.ngachluong "
                + "as nl, quan_ly_nv.hdld as hd, quan_ly_nv.bacluong as bl "
                + "where nv.Manv = " + manv + " and  p.maphong = nv.maphong and hd.Manv = " + manv + " and "
                + "hd.Mangach = nl.Mangach And hd.Mabac = bl.Mabac;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet  = statement.executeQuery();
                while (resultSet.next()) {
                    LayPhuCap data = new LayPhuCap(resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getDouble(6));
                    results.add(data);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return results;

            } catch (SQLException e) {
                return null;
            }
            
            finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();
                } catch(SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }*/
      public static List<LayPhuCap> getPHUCAP(String manv) throws SQLException{
        
         
         List<LayPhuCap> lbl = new ArrayList<LayPhuCap>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
            //query
             String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, nl.Ngach,bl.Bac, hd.Phucap "
                + "FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.ngachluong "
                + "as nl, quan_ly_nv.hdld as hd, quan_ly_nv.bacluong as bl "
                + "where nv.Manv = ? and  p.maphong = nv.maphong and hd.Manv = ? and "
                + "hd.Mangach = nl.Mangach And hd.Mabac = bl.Mabac;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, manv);
            statement.setString(2, manv);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                LayPhuCap std = new LayPhuCap(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6));
                        
               lbl.add(std);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement  != null) {
                
            try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return lbl;
    
    
    }   
    
    public static void changePhuCap (String manv, Double phucap) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "UPDATE quan_ly_nv.hdld as hd  SET hd.phucap = ?  WHERE hd.manv = ?";
        PreparedStatement statement = null;
        if (connection != null ) {
            try {
                statement = connection.prepareCall(sql);
                statement.setDouble(1, phucap);
                statement.setString(2, manv);
                statement.execute();
                
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                

            } catch (SQLException e) {
            }
            
            finally {
                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }
}

