package dz2;

import java.util.Scanner;

public class Page48Ex3 {

	public static void main(String[] args) {

		int i = 0, j = 1;
		int f = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("������� �����");
		if (sc.hasNextDouble()) {
			i = sc.nextInt();
		} else {
			System.out.println("������� �� �����");
		}

		while (true) {
			if (j > i) {
				break;
			}
			f = f * j;
			j++;
		}

		System.out.println("���������" + f);
	}

}
