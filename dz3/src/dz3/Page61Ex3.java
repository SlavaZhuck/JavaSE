package dz3;

public class Page61Ex3 {

	public static void main(String[] args) {
		int[] a = new int[15];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 9);
			System.out.print(a[i] + "\t");
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0)
				count++;
		}
		System.out.println();
		System.out.print(count);

	}

}
