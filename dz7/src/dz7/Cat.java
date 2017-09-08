package dz7;

public class Cat extends Animals {
	
	private int catchedAnimals;

	public int getCatchedAnimals() {
		return catchedAnimals;
	}

	public Cat(Cat cat) {
		super(cat);
		this.catchedAnimals = cat.catchedAnimals;
	}

	public Cat(int age, int weight, String name, int catchedAnimals) {
		super(age, weight, name);
		this.catchedAnimals = catchedAnimals;		
	}

	public void setCatchedAnimals(int catchedAnimals) {
		this.catchedAnimals = catchedAnimals;
	}
	
	public void show(){
		super.show();
		System.out.print(" " + catchedAnimals);
		if(this.getClass().getSimpleName().equals("Cat")){
			System.out.println();
		}		
	}

	@Override
	public void sound() {
		System.out.println("Myau!");
	}		

}
