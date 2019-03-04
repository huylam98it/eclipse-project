package chuong2;

import java.util.Scanner;

public class Bai5 {

	Scanner sc = new Scanner(System.in);
	public int a;
	public int b;

	public void nhap() {
		System.out.println("nhap he so a: ");
		a = Integer.parseInt(sc.nextLine());
		System.out.println("nhap he so b: ");
		b = Integer.parseInt(sc.nextLine());
	}

	public void giai() {
		if (a == 0) {
			if (b == 0) {
				System.out.println("phuong trinh vo so nghiem");
			} else {
				System.out.println("phuong trinh vo nghiem");
			}
		} else {
			System.out.println("nghiem cua phuong trinh: " + (-(float)b / a));
		}
	}

	public static void main(String[] args) {
		Bai5 b5 = new Bai5();
		b5.nhap();
		b5.giai();
	}
}
