package p1;

public class Fish extends Dish {
	
	public Fish()
	{
		super();
		setName("Fish");
	}
	
	@Override
	public void setSpiceBehavior(SpiceBehavior spice)
	{
		if(spice.getClass()== Cinnamon.class)
		{
			spiceBehavior = new InvalidSpice();
		}
		else
		{
			spiceBehavior = spice;
		}
	}
}
