package dz11;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Student stud1 = new Student("A", 1);
		Student stud2 = new Student("B", 1);
		Student stud3 = new Student("C", 1);
		Student stud4 = new Student("D", 2);
		Student stud5 = new Student("E", 2);
		Student stud6 = new Student("F", 2);
		Student stud7 = new Student("G", 3);
		Student stud8 = new Student("H", 3);
		Student stud9 = new Student("I", 3);
		Student stud10 = new Student("J", 3);

		Student stud11 = new Student("K", 1);
		Student stud12 = new Student("L", 1);
		Student stud13 = new Student("M", 1);
		Student stud14 = new Student("N", 2);
		Student stud15 = new Student("O", 2);
		Student stud16 = new Student("P", 2);
		Student stud17 = new Student("Q", 3);
		Student stud18 = new Student("R", 3);
		Student stud19 = new Student("S", 3);
		Student stud20 = new Student("T", 3);

		LinkedList<Student> listStudent1 = new LinkedList<Student>();
		listStudent1.add(stud1);
		listStudent1.add(stud2);
		listStudent1.add(stud3);
		listStudent1.add(stud4);
		listStudent1.add(stud5);
		listStudent1.add(stud6);
		listStudent1.add(stud7);
		listStudent1.add(stud8);
		listStudent1.add(stud9);
		listStudent1.add(stud10);

		LinkedList<Student> listStudent2 = new LinkedList<Student>();
		listStudent2.add(stud11);
		listStudent2.add(stud12);
		listStudent2.add(stud13);
		listStudent2.add(stud14);
		listStudent2.add(stud15);
		listStudent2.add(stud16);
		listStudent2.add(stud17);
		listStudent2.add(stud18);
		listStudent2.add(stud19);
		listStudent2.add(stud20);
		Student.rintStudents(listStudent1, 2);
		System.out.println();
		// LinkedList <Student> unionLIST = Student.union(listStudent1,
		// listStudent2);

		// for(Student ob : unionLIST){
		// System.out.println(ob.name);
		// }
		System.out.println();

		LinkedList<Student> intersectLIST = Student.intersect(listStudent1, listStudent2);

		System.out.println(intersectLIST);

		// for(Student ob : intersectLIST){
		// System.out.println(ob.name);
		// }

	}

}
