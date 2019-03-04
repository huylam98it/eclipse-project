package chuong2;

import java.util.Scanner;

public class Bai11 {

	public static Scanner sc = new Scanner(System.in);

	public int inNguoc(int k) {
		if (k > 0) {
			int tam = k % 10;
			System.out.print(tam);
			return tam + inNguoc(k / 10);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("nhap so tu nhien bat ky");
		int k = Integer.parseInt(sc.nextLine());
		System.out.println("in nguoc: ");
		int kq = new Bai11().inNguoc(k);
		System.out.println("\ntong cac chu so: " + kq);
	}
}
