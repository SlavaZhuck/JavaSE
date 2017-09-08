package dz7;

public abstract class Animals {

	private int age;
	private int weight;
	private String name;
	
	public Animals(int age, int weight, String name){
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	
	public Animals(Animals animal){
		this.age = animal.age;
		this.weight = animal.weight;
		this.name = animal.name;
	}	
	
	public void show(){
		System.out.print(name + " " + age + " " + weight);
		if(this.getClass().getSimpleName().equals("Animals")){
			System.out.println();
		}		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public abstract void sound();	
	
}
