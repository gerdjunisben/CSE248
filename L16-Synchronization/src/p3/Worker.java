package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	private Random random = new Random();
	
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public void process()
	{
		for(int i=0;i<1000;i++)
		{
			stageOne();
			stageTwo();
		}
	}
	
	public void main()
	{
		Thread t1=new Thread(()->{
			process();
		});
		Thread t2=new Thread(()->{
			process();
		});
		long startTime = System.currentTimeMillis();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis()-startTime + " millis");
		System.out.println("List 1 size " + list1.size());
		System.out.println("List 2 size " + list2.size());
	}
	
	public  void stageOne()
	{
		synchronized (obj1)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
		
	}
	
	public void stageTwo()
	{
		synchronized (obj2)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
}
