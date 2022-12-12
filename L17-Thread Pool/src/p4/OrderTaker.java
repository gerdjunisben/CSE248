package p4;

public class OrderTaker extends Thread {
	private static int orderNumber = 1;
	
	private int count=0;
	private int maxOrder;
	private OrderQueue orderQueue;
	
	public OrderTaker(int orderCount,OrderQueue orderQueue)
	{
		this.maxOrder=orderCount;
		this.orderQueue = orderQueue;
	}

	public void run() {
		Order order;
		while(count<maxOrder)
		{
			order=new Order(getOrderNumber());
			orderQueue.pushOrder(order);
			System.out.println(order.toString() + " added");
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static synchronized int getOrderNumber() {
		return orderNumber++;
	}
}
