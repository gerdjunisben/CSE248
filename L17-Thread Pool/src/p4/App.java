package p4;

public class App {

	public static void main(String[] args) {
		final int TAKER_COUNT = 3; //number of orderTaker threads
		final int ORDER_COUNT = 3;//number of orders per orderTaker
		final int HANDLER_COUNT = 2;//number of orderHandler threads
		
		OrderQueue queue = new OrderQueue();
		
		System.out.println("Starting order queue");
		
		System.out.println("Starting " + TAKER_COUNT + " order takers,"+
		" each producing " + ORDER_COUNT + " orders");
		
		System.out.println("Starting " + HANDLER_COUNT + " order handlers,");
		
		String s = "OrderTaker Threads                   OrderHandler Threads \n";
		
		System.out.println(s);
		
		for(int i =0;i<TAKER_COUNT;i++)
		{
			OrderTaker t = new OrderTaker(ORDER_COUNT,queue);
			t.start();
		}
		
		for(int i =0;i<HANDLER_COUNT;i++)
		{
			OrderHandler h = new OrderHandler(queue);
			h.start();
		}

	}

}
