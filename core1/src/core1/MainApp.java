package core1;

import java.util.ArrayList;

public class MainApp {

	public ArrayList<SinhVien> SVS;
	public int count = 1;

	public MainApp() {
		SVS = new ArrayList<SinhVien>();
	}

	public void show(ArrayList<SinhVien> sv) {
		System.out.println("thu: " + count++);
		for (SinhVien s : sv) {
			System.out.print(s.getName() + "||");
		}
		System.out.println("\n\n");
	}

	public void pickNext(ArrayList<SinhVien> listSV) {
		for (SinhVien sv : listSV) {
			if (!SVS.contains(sv)) {
				SVS.add(sv);
				if (SVS.size() == listSV.size()) {
					show(SVS);
					SVS.remove(SVS.size() - 1);
					return;
				}
				pickNext(listSV);
				SVS.remove(SVS.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		list.add(new SinhVien(1, "lam pham"));
		list.add(new SinhVien(2, "duc tran"));
		list.add(new SinhVien(3, "bang chu"));
		list.add(new SinhVien(4, "giang boy"));
		list.add(new SinhVien(5, "do loc"));
		list.add(new SinhVien(6, "minh duong"));

		new MainApp().pickNext(list);
	}
}
