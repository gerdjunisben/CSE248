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
	
	
	public void cook()
	{
		cookBehavior.cook();
	}
	
	public void setSpiceBehavior(SpiceBehavior spiceBehavior)
	{
		this.spiceBehavior = spiceBehavior;
	}
	
	public void spice()
	{
		spiceBehavior.spice();
	}
	
	public void recipe()
	{
		System.out.print(name +" ");
		cook();
		System.out.print(" with ");
		spice();
		System.out.println(".");
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
