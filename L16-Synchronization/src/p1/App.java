package p1;

public class App {
	private static int count=0;
	
	public static void main(String args[]) {
		doIncrementation();
	}
	
	//this method is "thread safe", without synchronize it would be "not thread safe"
	public synchronized static void increment() //this makes it so only 1 thread at a time can access the method
	{
		count++;
	}
	
	public static void doIncrementation()
	{
		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				increment();
			}
			System.out.println("t1 is done");
		});
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				increment();
			}
			System.out.println("t2 is done");
		});
		Thread t3 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				increment();
			}
			System.out.println("t3 is done");
		});
		Thread t4 = new Thread(()->{
			for(int i=0;i<1000;i++)
			{
				increment();
			}
			System.out.println("t4 is done");
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			//joining them makes it wait for the threads to finish
			//they may try to access the same variable at the same time causing it to work improperly
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
