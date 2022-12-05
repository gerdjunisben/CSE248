package p2;

public class Runner extends Thread {

	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for(int i = 0;i<5;i++)
		{
			System.out.println("hi " + i + " : " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
