package dz6;

import java.util.Scanner;

public class Page146Ex1 {

	public static void main(String[] args) {		
		
		StringMy stringsClass = new StringMy();		
		int numberOfStrings = 0;
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("¬ведите количество строк");
		if (sc1.hasNextInt()) {
			numberOfStrings = sc1.nextInt();
		} else {
			System.out.println("введено не число");
		}
		
		stringsClass.N = numberOfStrings;
		stringsClass.inputString();
		stringsClass.sort();
		stringsClass.findTheSame();
		stringsClass.secondStringHigh();
		stringsClass.divideLongestString();
		stringsClass.checkSecondSymbolOfShortestStringIsNumber();
		stringsClass.show();
	}
}