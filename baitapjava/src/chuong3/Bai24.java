package chuong3;

import java.util.Scanner;

public class Bai24 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		SinhVien sv1 = new SinhVien(1, "sinh vien 1", 7f, 8f);
		System.out.println("nhap thong tin sinh vien 1: ");
		System.out.println("nhap ma: ");
		sv1.setMaSV(Integer.parseInt(sc.nextLine()));
		sv1.setHoTen(sc.nextLine());
		sv1.setDiemLT(Float.parseFloat(sc.nextLine()));
		sv1.setDiemTH(Float.parseFloat(sc.nextLine()));

		SinhVien sv2 = new SinhVien(2, "sinh vien 2", 5f, 9f);
		SinhVien sv3 = new SinhVien();
		sv3.setMaSV(Integer.parseInt(sc.nextLine()));
		sv3.setHoTen(sc.nextLine());
		sv3.setDiemLT(Float.parseFloat(sc.nextLine()));
		sv3.setDiemTH(Float.parseFloat(sc.nextLine()));

		SinhVien.inTieuDe();
		sv1.inDuLieu();
		sv2.inDuLieu();
		sv3.inDuLieu();
	}
}
