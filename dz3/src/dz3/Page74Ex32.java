package dz3;

public class Page74Ex32 {

	public static void main(String[] args) {

		int[][] a = new int[6][7];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 10);
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length - 1; j++) {
				for (int k = j + 1; k < a[i].length; k++) {
					if (a[i][k] > a[i][j]) {
						int temp = a[i][k];
						a[i][k] = a[i][j];
						a[i][j] = temp;
					}
				}
			}
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
