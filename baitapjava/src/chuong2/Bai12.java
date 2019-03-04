package chuong2;

import java.util.Scanner;

public class Bai12 {

	public static Scanner sc = new Scanner(System.in);

	public void thucHien(int k) {
		int result = 0;
		for (int i = 1; i < k; i++) {
			if (k % i == 0) {
				result += i;
			}
		}
		if (result <= k) {
			System.out.println("la so hoan hao");
		} else
			System.out.println("khong phai la so hoan hao");
	}

	public static void main(String[] args) {
		int k;
		System.out.println("nhap so : ");
		k = Integer.parseInt(sc.nextLine());
		new Bai12().thucHien(k);
	}
}
