package Dishes;

import Cooks.Boil;
import Cooks.CookBehavior;
import Cooks.InvalidCook;

public class Beef extends Dish {
	public Beef()
	{
		super();
		setName("Beef");
	}
	
	@Override
	public void setCookBehavior(CookBehavior cook)
	{
		if(cook.getClass()== Boil.class)
		{
			cookBehavior = new InvalidCook();
		}
		else
		{
			cookBehavior = cook;
		}
	}

	@Override
	public double cost() {
		return 6.99;
	}
}
