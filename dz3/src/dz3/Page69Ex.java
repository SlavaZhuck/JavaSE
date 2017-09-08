package dz3;

import java.util.Scanner;

public class Page69Ex {

	public static void main(String[] args) {

		int n = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("¬ведите количество строк");
			if (sc.hasNextInt()) {
				n = sc.nextInt();
				break;
			} else {
				System.out.println("неа");
			}
		}
		
		int[][] mas = new int[n][];
		for(int i = 0; i < mas.length; i++){
			mas[i] = new int[(int)(Math.random() * 10 + 1)];
		}
		
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				mas[i][j] = (int)(Math.random() * 10 + 1);
			}
		}
		
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}
		
		for(int i = 0; i < mas.length - 1; i++){
			for(int j = i + 1; j < mas.length; j++){
				if(mas[i].length > mas[j].length){
					int [] temp = mas[i];
					mas[i] = mas[j];
					mas[j] = temp;
				}
			}
		}
		System.out.println();
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}
		

	}

}
