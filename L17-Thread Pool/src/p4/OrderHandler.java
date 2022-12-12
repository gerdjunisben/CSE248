package p4;

public class OrderHandler extends Thread {
	
	private OrderQueue orderQueue;
	
	public OrderHandler(OrderQueue orderQueue)
	{
		this.orderQueue = orderQueue;
	}
	
	public void run()
	{
		Order order; 
		while(true)
		{
			order = orderQueue.pullOrder();
			System.out.println(order.toString() + " completed by " + this.getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
