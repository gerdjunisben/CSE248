package p1;

public class Fish extends Dish {
	
	public Fish(CookBehavior cookBehavior, SpiceBehavior spiceBehavior)
	{
		super();
		setSpiceBehavior(spiceBehavior);
		setCookBehavior(cookBehavior);
		setName("Fish");
	}
	
	@Override
	public void setSpiceBehavior(SpiceBehavior spice)
	{
		if(spice.getClass()== Cinnamon.class)
		{
			System.out.println("Cinnamon cannot be put on fish, pick another spice");
		}
		else
		{
			spiceBehavior = spice;
		}
	}
}
