public interface IHanhKhach {
    void datVe(String hangGhe);
    void huyVe(int indexVe);
    void doiVe(int indexVe, String hangGheMoi);
    void kiemTraTrangThaiVe();
    void tichLuyDiemBay(double diemBay);
}

class HanhKhach implements IHanhKhach {
    private String id;
    private String tenHanhKhach;
    private int namSinh;
    private String soHoChieu;
    private String idHangBay;
    private String maTheThanhVien;
    private double soDiemBayTichLuy;
    private char hangTheThanhVien;
    private String[] danhSachVeDaDat;
    private String diaChi;
    private int soVeDaDat;

    public HanhKhach(String id, String tenHanhKhach, int namSinh, String soHoChieu, String idHangBay, String maTheThanhVien, char hangTheThanhVien, String diaChi) {
        this.id = id;
        this.tenHanhKhach = tenHanhKhach;
        this.namSinh = namSinh;
        this.soHoChieu = soHoChieu;
        this.idHangBay = idHangBay;
        this.maTheThanhVien = maTheThanhVien;
        this.hangTheThanhVien = hangTheThanhVien;
        this.diaChi = diaChi;
        this.soDiemBayTichLuy = 0;
        this.danhSachVeDaDat = new String[5];
        this.soVeDaDat = 0;
    }

    @Override
    public void datVe(String hangGhe) {
        if (soVeDaDat >= 5) {
            System.out.println("Khong the dat them ve. Da dat so luong toi da (5 ve).\n");
            return;
        }
        danhSachVeDaDat[soVeDaDat] = hangGhe;
        soVeDaDat++;
        System.out.println("Da dat ve hang ghe: " + hangGhe + " thanh cong.\n");
    }

    @Override
    public void huyVe(int indexVe) {
        if (indexVe < 0 || indexVe >= soVeDaDat) {
            System.out.println("Khong tim thay ve tai vi tri nay.\n");
            return;
        }
        System.out.println("Huy ve hang ghe: " + danhSachVeDaDat[indexVe] + " thanh cong.\n");
        for (int i = indexVe; i < soVeDaDat - 1; i++) {
            danhSachVeDaDat[i] = danhSachVeDaDat[i + 1];
        }
        danhSachVeDaDat[soVeDaDat - 1] = null;
        soVeDaDat--;
    }

    @Override
    public void doiVe(int indexVe, String hangGheMoi) {
        if (indexVe < 0 || indexVe >= soVeDaDat) {
            System.out.println("Khong tim thay ve tai vi tri nay.\n");
            return;
        }
        System.out.println("Doi ve tu hang ghe: " + danhSachVeDaDat[indexVe] + " sang hang ghe: " + hangGheMoi + " thanh cong.\n");
        danhSachVeDaDat[indexVe] = hangGheMoi;
    }

    @Override
    public void kiemTraTrangThaiVe() {
        System.out.println("Danh sach ve da dat:");
        for (int i = 0; i < soVeDaDat; i++) {
            System.out.println((i + 1) + ". Hang ghe: " + danhSachVeDaDat[i]);
        }
        if (soVeDaDat == 0) {
            System.out.println("Chua dat ve nao.\n");
        }
    }

    @Override
    public void tichLuyDiemBay(double diemBay) {
        soDiemBayTichLuy += diemBay;
        System.out.println("Da tich luy them " + diemBay + " diem bay. Tong diem hien tai: " + soDiemBayTichLuy + "\n");
    }

    public String getId() {
        return id;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getSoDiemBayTichLuy() {
        return soDiemBayTichLuy;
    }
}
