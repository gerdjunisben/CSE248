package p1;

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
}
