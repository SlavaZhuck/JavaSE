package dz3;

public class Page67Ex2 {

	public static void main(String[] args) {

		int[][] a = new int[5][8];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) ((Math.random() - 0.5) * 200);
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		int max = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
				}
			}
		}

		System.out.println(max);

	}

}
