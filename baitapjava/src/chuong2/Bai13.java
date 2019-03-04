package chuong2;

import java.util.Scanner;

public class Bai13 {

	public static Scanner sc = new Scanner(System.in);

	public void thucHien(String c) {
		c = c.trim();
		boolean r = false;
		for (int i = 0; i < c.length(); i++) {
			if (c.charAt(i) != ' ') {
				System.out.print(c.charAt(i));
				r = false;
			} else {
				if (!r) {
					System.out.println();
					r = true;
				} else {
					continue;
				}

			}
		}
	}

	public static void main(String[] args) {
		System.out.println("nhap chuoi: ");
		String str = sc.nextLine();
		System.out.println("sau khi thuc hien");
		new Bai13().thucHien(str);
	}
}
