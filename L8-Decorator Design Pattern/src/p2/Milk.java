package p2;

public class Milk extends CondimentDecorator {
	private Beverage beverage;
	
	public Milk(Beverage beverage)
	{
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return beverage.cost() + 0.99;
	}

	@Override
	public String description() {
		return beverage.description() + " with milk";
	}

}
