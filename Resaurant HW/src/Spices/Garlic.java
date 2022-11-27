package Spices;

import Dishes.Dish;

public class Garlic extends SpiceDecorator {
private Dish dish;
	
	public Garlic(Dish dish)
	{
		this.dish = dish;
	}
	
	@Override
	public double cost() {
		return dish.cost() + 1.99;
	}

	@Override
	public String recipe() {
		return dish.recipe() + " with garlic";
	}
}
