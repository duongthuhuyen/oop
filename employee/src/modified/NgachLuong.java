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
import classes.LayNgachLuong;
import java.sql.Connection;
import java.sql.*;
//import static connection.JDBCConnection.getJDBCConnection;
//import java.awt.List;
import classes.*;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author My_Laptop
 */



public class NgachLuong{

    /**
     *
     * @return
     */
    
    
   /* public static List<LayNgachLuong> getNgachLuong(String manv) throws SQLException{
        
        List<LayNgachLuong> results = new ArrayList<LayNgachLuong>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");        
        String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, cv.Tenchucvu , nl.Mangach, nl.Ngach "
                + "FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.chucvu as cv,  "
                + "quan_ly_nv.ngachluong as NL, quan_ly_nv.hdld as hd "
                + "where nv.Manv = " + manv + " and  p.maphong = nv.maphong and hd.Manv = " + manv + " and "
                + "nv.Machucvu = cv.Machucvu And  hd.Mangach = nl.Mangach;";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet  = statement.executeQuery();
                while (resultSet.next()) {
                    LayNgachLuong data = new LayNgachLuong(resultSet.getString(1),
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
    public static List<LayNgachLuong> getNgachLuong(String manv) throws SQLException{
        
         
         List<LayNgachLuong> lbl = new ArrayList<LayNgachLuong>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
            //query
            String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, cv.Tenchucvu , nl.mangach,nl.ngach FROM quan_ly_nv.nhanvien as nv , quan_ly_nv.phong as p, quan_ly_nv.chucvu as cv, quan_ly_nv.ngachluong as nl, quan_ly_nv.hdld as hd  where nv.Manv = ?  and  p.maphong = nv.maphong and hd.Manv = ?  and nv.Machucvu = cv.Machucvu And  hd.mangach = nl.mangach";
            statement = connection.prepareStatement(sql);
            statement.setString(1, manv);
            statement.setString(2, manv);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                LayNgachLuong std = new LayNgachLuong(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
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
    
    public static List<LayNgachLuong> getAllNgachLuongTrongKeToan() throws SQLException{
        List<LayNgachLuong> rs = new ArrayList<LayNgachLuong>();
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT nv.Manv, nv.HoTen, p.TenPhong, cv.Tenchucvu, nl.Mangach, nl.Ngach"
                + " FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.ngachluong as nl, quan_ly_nv.hdld as hd,quan_ly_nv.chucvu as cv "
                + "where p.maphong = nv.maphong and cv.Machucvu = nv.Machucvu and nv.Manv = hd.Manv and hd.Mangach = nl.Mangach  ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    LayNgachLuong nl = new LayNgachLuong(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6));
                    rs.add(nl);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return rs;

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
    
    
    /*public static void changeNgachLuong (String manv, String mangach) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "UPDATE quan_ly_nv.hdld as hd  SET hd.Mangach = ?  WHERE hd.manv = ?";
        PreparedStatement statement = null;
        if (connection != null ) {
            try {
                statement = connection.prepareCall(sql);
                statement.setString(1, mangach);
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
    
    
    public static String getMaNgach(String ngach) throws SQLException{
        String maNgach = new String();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT nl.Mangach FROM quan_ly_nv.ngachluong as nl WHERE nl.Ngach = " + ngach;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    maNgach = resultSet.getString(1);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return maNgach;

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
    public static void changeBacLuong (String manv, String mangach,double ngach) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        PreparedStatement statement = null;
        String sql1= "UPDATE quan_ly_nv.hdld as hd  SET hd.Mangach = ? WHERE hd.manv = ?";
        
        String sql3= "UPDATE quan_ly_nv.luongnv as hd  SET hd.luongcoban = ? WHERE hd.manv = ?";
        
        if (connection != null ) {
            try {
                statement = connection.prepareCall(sql1);
                statement.setString(1,mangach);
               statement.setString(2, manv);
                statement.execute();
                statement = connection.prepareCall(sql3);
                statement.setDouble(1,ngach );
                //statement.setDouble(2, bac);
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
    
    
    public static String getMaNgach(Double ngach) throws SQLException{
        String mangach = new String();
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT bl.Mangach FROM quan_ly_nv.ngachluong as bl WHERE bl.ngach = " + ngach;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    mangach = resultSet.getString(1);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return mangach;

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

}

