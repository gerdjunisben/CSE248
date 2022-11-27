package Dishes;

public class Chicken extends Dish {
	public Chicken()
	{
		super();
		setName("Chicken");
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 4.99;
	}
}
