package p2;

public class Main {
	//doesn't work on all computers
	private static volatile boolean flag = false;

	public static void main(String[] args) {
		
		new Main().greetings(flag);
		flag = true;
		System.out.println(Thread.currentThread().getName());
	}
	
	public void greetings(final boolean isFinished)
	{
		Thread t1 = new Thread( new Runnable()
		{
			public void run()
			{
				while(true) {
					if(isFinished)
					{
						System.out.println("Done!");
					}
					else
					{
						System.out.println("GREETINGS!");

						System.out.println(Thread.currentThread().getName());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		t1.run();
	}
	

}
