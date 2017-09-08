package dz8;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix implements Arith {

	int n;
	int m;
	int[][] mas;
	
	public void create (){
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Введите количество строк");
			if (sc.hasNextInt()) {
				n = sc.nextInt();
				break;
			} else {
				System.out.println("неа");
			}
		}

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Введите количество столбцов");
			if (sc.hasNextInt()) {
				m = sc.nextInt();
				break;
			} else {
				System.out.println("неа");
			}
		}
		
		mas = new int[n][m];
//		for(int i = 0; i < mas.length; i++){
//			for(int j = 0; j < mas[i].length; j++){
//				int temp;
//				while (true) {
//					Scanner sc = new Scanner(System.in);
//					System.out.println("Введите элемент" + i + " " + j);
//					if (sc.hasNextInt()) {
//						temp = sc.nextInt();
//						break;
//					} else {
//						System.out.println("неа");
//					}
//				}
//				mas[i][j] = temp;
//			}			
//		}		
	}	
	
	public void fillrandom(){
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				mas[i][j] = (int)(Math.random() * 10 + 1);
			}			
		}
	}	
	
	public void show(){
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void divide(int d){
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				mas[i][j] = mas[i][j] /d;
			}
		}
	}
	
	public void showElem(int n, int m){
		System.out.println(mas[n][m] );
	}
	
	@Override
	public void plus(Arith a) {
		Matrix b = (Matrix) a;
		
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				this.mas[i][j] = this.mas[i][j] + b.mas[i][j];
			}
		}			
	}

	@Override
	public boolean sravn(Arith a) {
		Matrix b = (Matrix) a;		
		for(int i = 0; i < mas.length; i++){
			for(int j = 0; j < mas[i].length; j++){
				if(this.mas[i][j] != b.mas[i][j]){
					return false;	
				}					
			}
		}
		return true;			
	}

}
