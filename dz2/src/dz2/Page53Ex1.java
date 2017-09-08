package dz2;

import java.util.Scanner;

public class Page53Ex1 {

	public static void main(String[] args) {

		int month = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите число");
		if (sc.hasNextDouble()) {
			month = sc.nextInt();
		}else{
			System.out.println("введено не число");
		}
		
		switch (month) {
		case 12:
		case 1:
		case 2:
			System.out.println("зима");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("весна");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("лето");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("осень");
			break;
		default:
			System.out.println("неправильный мес€ц");
		}
		
		
	}

}
