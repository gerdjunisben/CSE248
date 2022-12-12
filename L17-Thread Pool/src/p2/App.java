package p2;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			produce();
		});
		Thread t2 = new Thread(()->{
			consume();
		});
		t1.start();
		t2.start();
		
		//duel of the fates
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void produce()
	{
		Random rnd = new Random();
		while(true)
		{
			try {
				int i = rnd.nextInt(100);
				queue.put(i);
				Thread.sleep(1);

				System.out.println(i + " added, size:" + queue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void consume()
	{
		while(true)
		{
			try {
				int i = queue.take();
				Thread.sleep(2);
				System.out.println(i + " removed, size:" + queue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
