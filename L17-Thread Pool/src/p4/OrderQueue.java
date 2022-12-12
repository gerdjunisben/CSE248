package p4;

import java.util.LinkedList;

public class OrderQueue {
	private LinkedList<Order> orderQueue = new LinkedList<>();
	
	public synchronized void pushOrder(Order order)
	{
		orderQueue.addLast(order);
	}
	
	public synchronized Order pullOrder()
	{
		while(orderQueue.size() == 0) {
			try {
				wait();
			}
			catch(Exception e)
			{
				
			}
		}
		return orderQueue.removeFirst();
	}
}
