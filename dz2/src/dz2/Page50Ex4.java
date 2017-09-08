package dz2;

import java.util.Scanner;

public class Page50Ex4 {

	public static void main(String[] args) {

		int num = 0, count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите число");
		if (sc.hasNextDouble()) {
			num = sc.nextInt();
		}else{
			System.out.println("введено не число");
		}
		
		for(int i = 1 ; i<=num ; i++)
			if(num % i == 0){
				System.out.println(i);
				count++;
			}
		System.out.println("количество делителей = " + count);
	}

}
