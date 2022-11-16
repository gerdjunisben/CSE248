package p2;

public class Mocha extends CondimentDecorator{
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.49;
	}

	@Override
	public String description() {
		return beverage.description() + " with mocha";
	}
	
}
