package p1;

public abstract class Dish {
	CookBehavior cookBehavior;
	SpiceBehavior spiceBehavior;
	String name;
	
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
	
	public void setSpiceBehavior(SpiceBehavior spiceBehavior)
	{
		this.spiceBehavior = spiceBehavior;
	}
	
	public String spice()
	{
		return spiceBehavior.spice();
	}
	
	public String recipe()
	{
		
		return name + " " + cook() + " with " + spice() + ".";
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
