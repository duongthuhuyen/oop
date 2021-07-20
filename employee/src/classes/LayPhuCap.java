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
public class LayPhuCap {
    private String manv, tennv, phong;
    private double phucap,ngachluong,bacluong;

    public LayPhuCap(String manv, String tennv, String phong, double ngachluong,double bacluong,double phucap) {
        this.manv = manv;
        this.tennv = tennv;
        this.phong = phong;
        this.phucap = phucap;
        this.ngachluong = ngachluong;
        this.bacluong = bacluong;
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

    public double getPhucap() {
        return phucap;
    }

    public void setPhucap(double phucap) {
        this.phucap = phucap;
    }

    public double getNgachluong() {
        return ngachluong;
    }

    public void setNgachluong(double ngachluong) {
        this.ngachluong = ngachluong;
    }

    public double getBacluong() {
        return bacluong;
    }

    public void setBacluong(double bacluong) {
        this.bacluong = bacluong;
    }

    
   
}
