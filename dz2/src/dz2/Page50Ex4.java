package dz2;

import java.util.Scanner;

public class Page50Ex4 {

	public static void main(String[] args) {

		int num = 0, count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������� �����");
		if (sc.hasNextDouble()) {
			num = sc.nextInt();
		}else{
			System.out.println("������� �� �����");
		}
		
		for(int i = 1 ; i<=num ; i++)
			if(num % i == 0){
				System.out.println(i);
				count++;
			}
		System.out.println("���������� ��������� = " + count);
	}

}
