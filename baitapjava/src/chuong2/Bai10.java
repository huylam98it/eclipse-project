package chuong2;

import java.util.Scanner;

public class Bai10 {

	Scanner sc = new Scanner(System.in);
	public float a;
	public float b;
	public char c;
	public float kq;

	public void nhap() {
		System.out.println("nhap so thu nhat: ");
		a = Float.parseFloat(sc.nextLine());
		System.out.println("nhap so thu hai: ");
		b = Float.parseFloat(sc.nextLine());
		System.out.println("nhap ky tu bat ky: ");
		c = sc.nextLine().trim().charAt(0);
	}

	public void thucHien() {
		switch (c) {
		case 'C':
			kq = a + b;
			break;
		case 'c':
			kq=a+b;
			break;
		case 'T':
			kq = a - b;
			break;
		case 't':
			kq = a - b;
			break;
		case 'N':
			kq = a * b;
			break;
		case 'n':
			kq = a * b;
			break;
		case 'D':
			kq = a / b;
			break;
		case 'd':
			kq = a / b;
			break;
		default:
			break;
		}
		System.out.println("ket qua: " + kq);
	}

	public static void main(String[] args) {
		Bai10 b10 = new Bai10();
		b10.nhap();
		b10.thucHien();
	}
}
