package p1;

public class Demo {

	public static void main(String[] args) {
		Ship ship1 = new ShipFactory().createShip("small");
		Ship ship2 = new ShipFactory().createShip("medium");
		Ship ship3 = new ShipFactory().createShip("large");
	}

}
