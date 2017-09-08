package dz2;

public class Page50Ex3 {

	public static void main(String[] args) {

		int sum = 0;
		for(int i = -20 ; i <= 20 ; i++)
			if(i % 2 == 0)
				sum+=i;
		
		System.out.println("сумма = " + sum);
	}

}
