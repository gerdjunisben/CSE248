package p1;

public class Swan extends Duck {
	private AttackBehavior attackBehavior;
	
	
	public Swan(FlyBehavior fb,QuackBehavior qb,AttackBehavior ab)
	{
		super();
		setFlyBehavior(fb);
		setQuackBehavior(qb);
		setAttackBehavior(ab);
	}
	
	public void setAttackBehavior(AttackBehavior attackBehavior)
	{
		this.attackBehavior = attackBehavior;
	}
	
	public void doAttack()
	{
		attackBehavior.attack();
	}
}
