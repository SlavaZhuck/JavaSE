package dz3;

public class Page61Ex2 {

	public static void main(String[] args) {

		int[] a = new int[50];

		for (int i = 0; i < a.length; i++) {
			a[i] = i * 2 + 1;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}

		System.out.println();
		System.out.println();

		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + "\t");
		}

	}

}
