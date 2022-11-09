package p1;

public class Demo {
	//have gui
	//ask discord server for details
	public static void main(String[] args) {
		
		Fish fish = new Fish(new Grill(),new Cinnamon());
		fish.setSpiceBehavior(new Garlic());
		fish.recipe();
		

	}

}
