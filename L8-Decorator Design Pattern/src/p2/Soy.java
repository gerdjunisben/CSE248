package p2;

public class Soy extends CondimentDecorator{
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.69;
	}

	@Override
	public String description() {
		return beverage.description() + " with soy";
	}

}
