package dz3;

public class Page61Ex1 {

	public static void main(String[] args) {
		int[] a = new int[10];

		for (int i = 1; i <= a.length; i++) {
			a[i - 1] = i * 2;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}

		System.out.println();
		System.out.println();

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
