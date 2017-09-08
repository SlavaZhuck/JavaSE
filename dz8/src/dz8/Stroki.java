package dz8;

import java.util.Scanner;

public class Stroki implements Arith {
	char[] ch;
	
	public void create (){
		String temp;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("¬ведите строку");
			if (sc.hasNext()) {
				temp = sc.next();
				break;
			} else {
				System.out.println("неа");
			}
		}
		ch = temp.toCharArray();		
	}	

	public void show(){
		for(int i = 0; i < ch.length; i++){
			System.out.print(ch[i] + "\t");
		}
		System.out.println();
	}
	
	public void showEl(int n){		
		System.out.print(ch[n]);
		System.out.println();
	}	
	
	@Override
	public void plus(Arith a) {
		Stroki b = (Stroki) a;
		System.out.println(String.valueOf(ch) + String.valueOf(b.ch));
	}

	@Override
	public boolean sravn(Arith a) {
		Stroki b = (Stroki) a;
		for(int i = 0; i < ch.length; i++){
				if(this.ch[i] != b.ch[i]){
					return false;	
				}
		}
		return true;		
	}

}
