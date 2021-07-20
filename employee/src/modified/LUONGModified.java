/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modified;
import classes.LayLuong;
import java.sql.*;
//import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class LUONGModified {
     public static List<LayLuong> getAll()  throws Exception{
         List<LayLuong> rs = new ArrayList<LayLuong>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        String sql = "SELECT nv.Manv, nv.HoTen,p.tenPhong, cv.Tenchucvu,hd.phucap,bl.bac,lnv.luongcoban"
                + " FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.bacluong as bl, quan_ly_nv.hdld as hd,quan_ly_nv.chucvu as cv,quan_ly_nv.luongnv as lnv  "
                + "where p.maphong = nv.maphong and cv.Machucvu = nv.Machucvu and nv.Manv = hd.Manv and hd.Mabac = bl.Mabac and lnv.manv=nv.Manv";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ) {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LayLuong nl = new LayLuong(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7));
                rs.add(nl);
            }
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
            return rs;
           
        }
        return null;
        
    }
     public static List<LayLuong> FindLUONG(String manv) throws Exception{
        
         
         List<LayLuong> lbl = new ArrayList<LayLuong>();
        Connection connection = null;
        PreparedStatement statement = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_nv", "root", "");
        //query
        String sql =  "SELECT nv.Manv, nv.HoTen,p.tenPhong, cv.Tenchucvu,hd.phucap,bl.bac,lnv.luongcoban"
                + " FROM quan_ly_nv.nhanvien as NV , quan_ly_nv.phong as P, quan_ly_nv.bacluong as bl, quan_ly_nv.hdld as hd,quan_ly_nv.chucvu as cv,quan_ly_nv.luongnv as lnv  "
                + "where p.maphong = nv.maphong and cv.Machucvu = nv.Machucvu and nv.Manv = hd.Manv and hd.Mabac = bl.Mabac and lnv.manv=nv.Manv and nv.manv=?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, manv);
        //statement.setString(2, manv);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            LayLuong std = new LayLuong(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getDouble(6),
                    rs.getDouble(7));
            lbl.add(std);
        }
        if (statement  != null) {
            
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return lbl;
    
    
    }
    
}
