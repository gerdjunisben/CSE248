package p1;

public class Demo {

	public static void main(String[] args) 
	{
		ItemStore store = new ItemStore();
		store.add(new Dish("Beef",29.99));
		store.add(new Wine("Familia Torress",2020,59.99,13.5));
		store.displayItems();

	}

}
