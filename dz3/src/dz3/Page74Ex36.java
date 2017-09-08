package dz3;

import java.util.Scanner;

public class Page74Ex36 {

	public static void main(String[] args) {

		int N = 8;
		int[][] a = new int[N][N];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 11) - 5;
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите номер строки");
		if (sc.hasNextDouble()) {
			num = sc.nextInt();
		} else {
			System.out.println("введено не число");
		}

		int indI = 0, max = a[0][0];
		for (int i = 0; i < a.length; i++) {
			//for (int j = 0; j < a[i].length; j++) {
				if ( a[i][i] > max) {
					max = a[i][i];
					indI = i;
			//	}
			}
		}
		System.out.println(indI);

		int[] temp = a[indI];
		a[indI] = a[num];
		a[num] = temp;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
