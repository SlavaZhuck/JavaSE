import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 
		+ * 1) Создать класс Students
		+ * 2) В классе Students создаём три поля (имя студента, курс студента, массив оценок)
		+ * 3) Создаём метод, в котором с консоли заполняем имя и курс студента.
		+ * 4) Создаём метод, которыцй выводит на консоль имя и курс студента.
		 * 5) Создаём метод, который создаёт и заполняет массив студента 
		 * ранедомными значениями ( 1- 9) и рандомной длиной
		 * 6) Создаём метод, который выводит на консоль средний балл студента.
		 * 7) Создаём метод, который принимает в качестве параметра пять студентов и 
		 * выводит на консоль имена тех студентов, которе обучаются на N курсе
		 * (N передаём вместе со студентами)
		 * 8) Создаём метод, который принимает одного студента и копипастит инфу в другого студента,
		 * который вызывает данный метод
		 * 9) Методы должны вызываться с консоли(тобишь делаем менюшку при помощи switch)
		 *  
		 */
		
		Students first = new Students();
		Students second = new Students();
		Students third = new Students();
		Students fourth = new Students();
		Students fifth = new Students();
		first.initNameCourse();
		second.initNameCourse();
		third.initNameCourse();
		fourth.initNameCourse();
		fifth.initNameCourse();	

		while (true){
			Students current_student;
			String currentName;
			System.out.println("Введите имя студента для работы");
			Scanner scCurrent_student = new Scanner(System.in);
			System.out.println("Введите имя");
			if (scCurrent_student.hasNext()) {
				currentName = scCurrent_student.next();
			}			
			
			System.out.println(
					"Выберите действие");
			System.out.println(
					"1 - Создаём метод, в котором с консоли заполняем имя и курс студента");
			System.out.println(
					"2 - Создаём метод, которыцй выводит на консоль имя и курс студента");
			System.out.println(
					"3 - Создаём метод, который создаёт и заполняет массив студента ранедомными значениями ( 1- 9) и рандомной длиной");
			System.out.println(
					"4 - Создаём метод, который выводит на консоль средний балл студента");
			System.out.println(
					"5 - Создаём метод, который принимает в качестве параметра пять студентов и выводит на консоль имена тех студентов, которе обучаются на N курсе");
			System.out.println(
					"6 - Создаём метод, который принимает одного студента и копипастит инфу в другого студента,который вызывает данный метод");
			
			int choise = 0;
			Scanner scChoise = new Scanner(System.in);
			System.out.println("Введите действие");
			if (scChoise.hasNextInt()) {
				choise = scChoise.nextInt();
			} else {
				System.out.println("введено не число");
			}
			
			switch(choise){
			case 1:
				first.initNameCourse();
				System.out.println();
				break;
			case 2:
				first.showNameCourse();
				System.out.println();
				break;			
			case 3:
				first.makeMarks();
				System.out.println();
				break;			
			case 4:
				first.average();
				System.out.println();
				break;				
			case 5:
				int sravnenie = 0;
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Введите курс для сравнения");
				if (sc1.hasNextInt()) {
					sravnenie = sc1.nextInt();
				} else {
					System.out.println("введено не число");
				}
				Students.sameCourse(sravnenie, first, second, third, fourth, fifth);
				System.out.println();
				break;
			case 6:
				Students copy = new Students();
				copy.copy(first);
				System.out.println();
				break;				
			}		
		}	
	}
}