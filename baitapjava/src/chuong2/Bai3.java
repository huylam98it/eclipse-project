package chuong2;

import java.text.DecimalFormat;

public class Bai3 {

	public static void customFormat(String template, float data) {
		DecimalFormat f = new DecimalFormat(template);
		System.out.println(f.format(data));
	}

	public static void main(String[] args) {
		customFormat("###.##", 123456.759f);
		customFormat("0000000.000", 123.78f);
		System.out.println(System.getProperty("user.name"));
	}
}
