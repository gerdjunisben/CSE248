package p1;

public abstract class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public Duck()
	{
		
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior)
	{
		this.flyBehavior = flyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior)
	{
		this.quackBehavior = quackBehavior;
	}
	
	public void doFly()
	{
		flyBehavior.fly();
	}
	
	public void doQuack()
	{
		quackBehavior.quack();
	}
}
