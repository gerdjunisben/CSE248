package Spices;

import Dishes.Dish;

public class Cinnamon extends SpiceDecorator {
private Dish dish;
	
	public Cinnamon(Dish dish)
	{
		this.dish = dish;
	}
	
	@Override
	public double cost() {
		return dish.cost() + 2.99;
	}

	@Override
	public String recipe() {
		return dish.recipe() + " with cinnamon";
	}
}
