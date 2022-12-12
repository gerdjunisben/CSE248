package p4;

public class Order {
	private int orderNumber;
	
	public Order(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	public String toString()
	{
		return "Order:" + orderNumber;
	}
}
