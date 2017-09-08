import java.util.Scanner;

public class Students {
	
	public String name;
	public int course;
	public int[] marks;

	public void initNameCourse (){
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите им€");
		if (sc.hasNext()) {
			this.name = sc.next();
		}// else {
		//	System.out.println("введено не число");
		//}
		Scanner sc1 = new Scanner(System.in);
		System.out.println("¬ведите курс");
		if (sc1.hasNextInt()) {
			this.course = sc1.nextInt();
		} else {
			System.out.println("введено не число");
		}
	}
	
	public void showNameCourse (){
		System.out.println(name + " " + course);
	}
	
	public void makeMarks (){
		int length = (int) (Math.random()  * 10 + 1);
		marks = new int[length];
		for (int i = 0; i < length; i++) {
			marks[i]= (int) (Math.random()  * 10 + 1);	
		}		
	}
	
	public void average (){
		double aver = 0;
		for (int i = 0; i < marks.length; i++) {
			aver += marks[i];	
		}		
		System.out.println("средний бал " + aver/marks.length);
	}
	
	static public void sameCourse (int course, Students ... i){
		for(Students j : i){
			if(j.course == course){
				System.out.print(j.name +" ");
			}
		}
		System.out.println();
	}	
	
	public void copy (Students stud){
		this.name = stud.name;
		this.course = stud.course;
		this.marks = stud.marks;		
	}
	
	public Students find_name (Students student, String name){
		if(student.name == name)
			return student;
		else
			return null;
	}
	
	
	
	
}
