package p1;

public class Demo {
	public static void main(String[] args)
	{
		//if the behavior are available after the object is destroyed it is aggregation not composition 
		Swan swan = new Swan(new FlyAway(),new Mute(),new Peck());
		swan.doFly();
		swan.doQuack();
		swan.doAttack();
		
		swan.setAttackBehavior(new Laser());
		swan.setFlyBehavior(new Jets());
		swan.setQuackBehavior(new Greet());
		
		swan.doFly();
		swan.doQuack();
		swan.doAttack();
	}
}
