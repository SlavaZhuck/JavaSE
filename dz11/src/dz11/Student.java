package dz11;

import java.util.LinkedList;

public class Student {

	public String name;
	public int course;

	Student(String name, int course) {
		this.name = name;
		this.course = course;
	}

	public String getName() {
		return this.name;
	}

	public int getCourse() {
		return this.course;
	}

	static public void rintStudents(LinkedList<Student> students, int course) {
		for (Student ob : students) {
			if (ob.course == course) {
				System.out.println(ob.name);
			}
		}
	}

	static public LinkedList<Student> union(LinkedList<Student> set1, LinkedList<Student> set2) {
		set1.addAll(set2);
		return set1;
	}

	static public LinkedList<Student> intersect(LinkedList<Student> set1, LinkedList<Student> set2) {
		LinkedList<Student> intersectList = new LinkedList<Student>();

		for (Student ob1 : set1) {
			for (Student ob2 : set2) {
				if (ob1.name.equals(ob2.name)) {
					intersectList.add(ob1);
				}
			}
		}

		return intersectList;
	}

}
