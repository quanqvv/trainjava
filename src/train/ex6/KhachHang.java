package train.ex6;

public class KhachHang {
    private String maKH;
    private String gioiTinh;
    private int doTuoi;

    public KhachHang(String maKH, String gioiTinh, int doTuoi) {
        this.maKH = maKH;
        this.gioiTinh = gioiTinh;
        this.doTuoi = doTuoi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getDoTuoi() {
        return doTuoi;
    }

    public void setDoTuoi(int doTuoi) {
        this.doTuoi = doTuoi;
    }
}
