package chuong3;

public class SinhVien {

	private int maSV;
	private String hoTen;
	private float diemTH;
	private float diemLT;

	public SinhVien() {
		super();
	}

	public SinhVien(int maSV, String hoTen, float diemTH, float diemLT) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemTH = diemTH;
		this.diemLT = diemLT;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public static void inTieuDe() {
		System.out.printf("%-20s%-20s%-20s%-20s\n", "ma SV", "ho ten SV", "diem LT", "diem TH");
	}

	public void inDuLieu() {
		System.out.printf("%-20d%-20s%-20f%-20f\n", this.maSV, this.hoTen, this.diemLT, this.diemTH);
	}
}
