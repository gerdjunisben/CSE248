package Dishes;

import Cooks.CookBehavior;

public abstract class Dish {
	CookBehavior cookBehavior;
	String name;
	
	public abstract double cost();
	
	public Dish()
	{
		
	}
	
	public void setCookBehavior(CookBehavior cookBehavior)
	{
		this.cookBehavior = cookBehavior;
	}
	
	
	public String cook()
	{
		return cookBehavior.cook();
	}
	
	
	
	public String recipe()
	{
		
		return name + " " + cook();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
}
