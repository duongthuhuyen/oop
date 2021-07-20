/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author PC
 */
public class LayLuong {
    private String manv,tennv,phong,chucvu;
    private double phucap,hesoluong,luongcoban;

    public LayLuong(String manv, String tennv, String phong, String chucvu, double phucap, double hesoluong, double luongcoban) {
        this.manv = manv;
        this.tennv = tennv;
        this.phong = phong;
        this.chucvu = chucvu;
        this.phucap = phucap;
        this.hesoluong = hesoluong;
        this.luongcoban = luongcoban;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public double getPhucap() {
        return phucap;
    }

    public void setPhucap(double phucap) {
        this.phucap = phucap;
    }

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }

    public double getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(double luongcoban) {
        this.luongcoban = luongcoban;
    }
    public double getLuong(){
        return hesoluong*luongcoban+phucap;
    }
}
