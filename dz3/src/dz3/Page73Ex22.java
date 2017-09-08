package dz3;

public class Page73Ex22 {

	public static void main(String[] args) {

		int[] a = new int[8];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10 + 1);
			System.out.print(a[i] + " ");
		}

		for (int i = 0; i < a.length; i += 2) {
			a[i] = 0;
		}

		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
