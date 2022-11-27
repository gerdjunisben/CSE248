package p1;

public class ShipFactory {
	public Ship createShip(String shipType) {
		switch(shipType) {
		case "large":return new LargeShip();
		case "medium":return new MediumShip();
		case "small":return new SmallShip();
		default: return null;
		}
	}
}
