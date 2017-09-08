package dz3;

public class Page74Ex37 {

	public static void main(String[] args) {

		int N = 6, M = 5;
		int[][] a = new int[N][M];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 11) - 5;
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		int temp_max = 0, indMax = 0,  indMin = 0, temp_min = 0;

		for (int i = 0; i < a.length; i++) {
			int max = a[i][0];
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
					indMax = j;
				}

			}
			//max = -100;
			temp_max = a[i][0];
			a[i][0] = a[i][indMax];
			a[i][indMax] = temp_max;

		}

		for (int i = 0; i < a.length; i++) {
			int min = a[i][0];
			for (int j = 0; j < a[i].length; j++) {

				if (a[i][j] < min) {
					min = a[i][j];
					indMin = j;
				}
			}

			//min = 100;
			temp_min = a[i][a[i].length - 1];
			a[i][a[i].length - 1] = a[i][indMin];
			a[i][indMin] = temp_min;
		}

		System.out.println();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
