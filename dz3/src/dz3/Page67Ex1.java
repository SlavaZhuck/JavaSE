package dz3;

public class Page67Ex1 {

	public static void main(String[] args) {

		int[][] a = new int[8][5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 90 + 10);
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
