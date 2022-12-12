package p3;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	Object lock = new Object();
	
	public void produce()
	{
		int value = 0;
		while(true)
		{
			synchronized(lock) {
				while(list.size() == LIMIT) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume()
	{
		Random rnd = new Random();
		while(true)
		{
			synchronized(lock)
			{
				while(list.size()==0)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("List size is " + list.size());
				int value = list.removeFirst();
				System.out.println(value +" was removed");
				lock.notify();
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
