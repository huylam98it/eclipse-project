package chuong2;

import java.util.Random;

public class Bai2 {

	public float chieuDai;
	public float chieuRong;

	public Bai2() {
		Random r = new Random();
		chieuDai = r.nextFloat() * 100 + 1;
		chieuRong = r.nextFloat() * 100 + 1;
	}

	public static void main(String[] args) {
		Bai2 b2 = new Bai2();
		System.out.println("chieu dai: " + b2.chieuDai);
		System.out.println("chieu rong: " + b2.chieuRong);
		System.out.println("chu vi: " + (b2.chieuDai + b2.chieuRong) * 2);
		System.out.println("chieu rong:" + b2.chieuDai * b2.chieuRong);
	}
}
