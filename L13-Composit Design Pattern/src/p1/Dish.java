package p1;

import java.time.LocalDate;

public class Dish implements Item {
	private String name;
	private double price;
	private LocalDate date;
	
	public Dish(String name,double price)
	{
		date = LocalDate.now();
		this.name = name;
		this.price = price;
	}
	
	public void print()
	{
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", date=" + date + "]";
	}
	
	
	
}
