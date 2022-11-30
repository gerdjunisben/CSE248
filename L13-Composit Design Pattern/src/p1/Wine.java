package p1;

public class Wine implements Item {
	private String producer;
	private int vintage;
	private double price;
	private double abv;

	
	
	
	
	public Wine(String producer, int vintage, double price, double abv) {
		super();
		this.producer = producer;
		this.vintage = vintage;
		this.price = price;
		this.abv = abv;
	}





	public void print() {
		System.out.println(this);

	}





	@Override
	public String toString() {
		return "Wine [producer=" + producer + ", vintage=" + vintage + ", price=" + price + ", abv=" + abv + "]";
	}
	
	

}
