/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modified;

import classes.LayBacLuong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PC
 */
public class QLBLModified {
   
     public static List<LayBacLuong> FindOnBACLUONG(String manv) throws SQLException{
        
         
         List<LayBacLuong> lbl = new ArrayList<LayBacLuong>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
            //query
            String sql = "SELECT nv.Manv, nv.HoTen,p.maphong, p.TenPhong, cv.Tenchucvu , bl.Mabac, bl.tenbac FROM quan_ly_nv.nhanvien as nv , quan_ly_nv.phong as p, quan_ly_nv.chucvu as cv, quan_ly_nv.bacluong as bl, quan_ly_nv.hdld as hd  where nv.Manv = ?  and  p.maphong = nv.maphong and hd.Manv = ?  and nv.Machucvu = cv.Machucvu And  hd.mabac = bl.mabac";
            statement = connection.prepareStatement(sql);
            statement.setString(1, manv);
            statement.setString(2, manv);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                LayBacLuong std = new LayBacLuong(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
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
     public static List<LayBacLuong> getAllBacLuongsTrongKeToan() throws SQLException{
         List<LayBacLuong> rs = new ArrayList<LayBacLuong>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT nv.Manv, nv.HoTen,p.maphong, p.TenPhong, cv.Tenchucvu, bl.Mabac, bl.tenbac FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.bacluong as bl, quan_ly_nv.hdld as hd,quan_ly_nv.chucvu as cv where p.maphong = nv.maphong and cv.Machucvu = nv.Machucvu and nv.Manv = hd.Manv and hd.Mabac = bl.Mabac ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    LayBacLuong nl = new LayBacLuong(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));
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
    
    
    public static void changeBacLuong (String manv, String mabac,double bac) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        PreparedStatement statement = null;
        String sql1= "UPDATE quan_ly_nv.hdld as hd  SET hd.Mabac = ? WHERE hd.manv = ?";
         String sql2= "UPDATE quan_ly_nv.hdld as hd  SET hd.hesoluong = ? WHERE hd.manv = ?";
        String sql3= "UPDATE quan_ly_nv.luongnv as hd  SET hd.bacluong = ? WHERE hd.manv = ?";
         String sql4= "UPDATE quan_ly_nv.luongnv as hd  SET hd.hesoluong = ? WHERE hd.manv = ?";
      /*  statement = connection.prepareStatement(sql);
        statement.setString(1, mabac);bac
        statement.setString(2, manv);
        ResultSet rs = statement.executeQuery();*/
        if (connection != null ) {
            try {
                statement = connection.prepareCall(sql1);
                statement.setString(1,mabac );
                //statement.setDouble(2, bac);
                statement.setString(2, manv);
                statement.execute();
                statement = connection.prepareCall(sql2);
                //statement.setString(1, mabac);
                statement.setDouble(1,bac );
                statement.setString(2, manv);
                statement.execute();
                statement = connection.prepareCall(sql3);
                statement.setString(1,mabac );
                //statement.setDouble(2, bac);
                statement.setString(2, manv);
                statement.execute();
                statement = connection.prepareCall(sql4);
                //statement.setString(1, mabac);
                statement.setDouble(1,bac );
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
    
    
    public static String getMaBac(Double bac) throws SQLException{
        String maBac = new String();
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT bl.Mabac FROM quan_ly_nv.bacluong as bl WHERE bl.bac = " + bac;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    maBac = resultSet.getString(1);
                }
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                
                return maBac;

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
