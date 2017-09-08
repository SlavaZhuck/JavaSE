package dz7;

public class Kitty extends Cat {
	private int timeToFeed;

	public Kitty(int age, int weight, String name, int catchedAnimals, int timeToFeed) {
		super(age, weight, name, catchedAnimals);
		this.timeToFeed = timeToFeed;
	}

	public Kitty(Kitty kitty) {
		super(kitty);
		this.timeToFeed = kitty.timeToFeed;
	}
	
	public void show(){
		super.show();
		System.out.print(" " + timeToFeed);
		if(this.getClass().getSimpleName().equals("Kitty")){
			System.out.println();
		}		
	}	

}
