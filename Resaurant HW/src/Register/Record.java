package Register;

import Dishes.Dish;

public class Record {
	private Dish dish;
	public Record(Dish dish) {
		super();
		this.dish = dish;
	}
	
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
}
