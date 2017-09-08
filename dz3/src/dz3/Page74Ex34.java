package dz3;

public class Page74Ex34 {

	public static void main(String[] args) {

		int N = 4;
		int[][] a = new int[N][N];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 11) - 5;
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		int sum = 0;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a[i].length; j++) {
				if (j > i && a[i][j] > 0)
					sum += a[i][j];
			}

		}

		System.out.println("Sum = " + sum);
	}

}
