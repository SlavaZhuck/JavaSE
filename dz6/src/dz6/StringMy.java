package dz6;

import java.util.Scanner;

public class StringMy {
	public int N;
	public String[] mas ;
	

	public void inputString (){
		mas = new String[N];
		boolean endIs = false;
		for(int i = 0 ; i < N ; i++){
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Введите строку № " + (i+1) + " : ");
			if (sc1.hasNextLine() && endIs == false) {
				mas[i] = new String(sc1.nextLine());
				if(mas[i].contains("end")){
					endIs = true;
				}
			} else {
				mas[i] = String.valueOf(i);
			}
		}
	}
	
	public void show(){
		for(int i = 0 ; i < N ; i++){		
			System.out.println("Here is our mas:");
			System.out.println(mas[i]);
		} 			
	}	
	
	public void sort(){
		System.out.println("Begin sorting!");
		for(int i = 0; i < mas.length - 1; i++){
			for(int j = i + 1; j < mas.length; j++){
				if(mas[i].length() > mas[j].length()){
					String  temp = mas[i];
					mas[i] = mas[j];
					mas[j] = temp;
				}
			}
		}	
		System.out.println(" 3 символа самой длинной строки " + mas[mas.length - 1].substring(mas[mas.length - 1].length()-3));
	}		
	
	public boolean findTheSame(){
		for(int i = 0; i < mas.length - 1; i++){
			for(int j = i + 1; j < mas.length; j++){
				if(mas[i].equals(mas[j])){
					System.out.println("We have same Strings!");
					return(true);
				}
			}
		}
		System.out.println("We don't have same Strings!");
		return false;
	}		
	
	public void secondStringHigh(){
		if(N>1){
			mas[1].toUpperCase();
			System.out.println(mas[1]);
		} else {
			System.out.println("Less than 2 Strings");
		}
	}	
	
	public void divideLongestString(){
		//String [] splited = new String();
		String [] splited = mas[mas.length - 1].split(" ");
		System.out.println("Splited mas : ");
		for(int i = 0 ; i < splited.length ; i++){		
			System.out.println(splited[i]);
		} 				
	}
	
	public void checkSecondSymbolOfShortestStringIsNumber(){
		if(Character.isDigit(mas[0].charAt(1))){	
			
			System.out.print("Second symbol of second String is a number : ");
			System.out.println(Character.isDigit(mas[1].charAt(1)));
		} else {
			System.out.println("Second symbol of second String is not a number.");
		}				
		
	}	
}
