package dz3;

public class Page67Ex3 {

	public static void main(String[] args) {

		int[][] a = new int[5][4];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) ((Math.random() - 0.5) * 10);
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		int umn = 1;
		int max = 0;
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				umn = umn * a[i][j];
			}
			umn = Math.abs(umn);
			if (umn > max) {
				max = umn;
				index = i;
			}
			umn = 1;

		}
		System.out.println(index);
	}

}
