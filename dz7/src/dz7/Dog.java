package dz7;

public class Dog extends Animals{

	public Dog(Animals animal) {
		super(animal);
	}

	@Override
	public void sound() {
		System.out.println("Gav-Gav!");
	}

	
}
