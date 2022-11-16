package p2;

public class Demo {

	public static void main(String[] args) {
		Beverage houseBlend = new HouseBlend();
		CondimentDecorator withMilk = new Milk(houseBlend);
		CondimentDecorator with2Milk = new Milk(withMilk);
		

		System.out.println(houseBlend.description() + " is " + houseBlend.cost());
		System.out.println(withMilk.description() + " is " + withMilk.cost());
		System.out.println(with2Milk.description() + " is " + with2Milk.cost());
	}

}
