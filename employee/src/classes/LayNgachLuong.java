/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author My_Laptop
 */
public class LayNgachLuong {
    private String manv, tennv, phong, chucvu ,mangachluong ;
    double ngachluong;

    public String getManv() {
        return manv;
    }

    public String getTennv() {
        return tennv;
    }

    public String getPhong() {
        return phong;
    }

    public String getChucvu() {
        return chucvu;
    }

    public String getMangachluong() {
        return mangachluong;
    }

    public double getNgachluong() {
        return ngachluong;
    }

    public LayNgachLuong(String manv, String tennv, String phong, String chucvu, String mangachluong, double ngachluong) {
        this.manv = manv;
        this.tennv = tennv;
        this.phong = phong;
        this.chucvu = chucvu;
        this.mangachluong = mangachluong;
        this.ngachluong = ngachluong;
    }

}
