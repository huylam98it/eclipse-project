package chuong3;

import java.util.Scanner;

public class PhuongTrinhBac2 {

	Scanner sc = new Scanner(System.in);
	public float a;
	public float b;
	public float c;

	public void nhap() {
		System.out.println("nhap a: ");
		this.a = Float.parseFloat(sc.nextLine());
		System.out.println("nhap b: ");
		this.b = Float.parseFloat(sc.nextLine());
		System.out.println("nhap c: ");
		this.c = Float.parseFloat(sc.nextLine());
	}

	public void thucHien() {
		float delta = b * b - 4 * a * c;
		if (delta < 0) {
			System.out.println("phuong trinh vo nghiem");
		} else if (delta == 0) {
			System.out.println("phuong trinh co nghiem duy nhat: " + (-b - Math.sqrt(delta)) / (2 * a));
		} else {
			float x1 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
			float x2 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
			System.out.println("phuong trinh co hai nghiem la: " + x1 + " va : " + x2);
		}
	}

}
