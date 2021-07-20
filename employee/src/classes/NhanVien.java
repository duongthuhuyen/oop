package classes;



import classes.KTKL;
import classes.LuongNV;
import classes.Nguoidung;
import java.util.Date;

public class NhanVien {
    private String Manv;
    private String HoTen;
    private Boolean GioiTinh;
    private Date Ngaysinh;
    private String Thuongtru; 
    private String Tamtru;
    private String SoCMTND;
    private Date Ngaycap;
    private String NoiCap;
    private String Mob;
    private String Machucvu;
    private String Maphong;
    private String Sotaikhoan;
    private String Nganhang;
    private Nguoidung nd;
    private LuongNV lnv;
    private KTKL ktkt;
    public String getManv() {
        return Manv;
}

    public void setManv(String Manv) {
        this.Manv = Manv;
}

    public String getHoTen() {
        return HoTen;
}

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
}


}
