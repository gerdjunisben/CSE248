package p3;

public class Runner implements Runnable {

	@Override
	public void run() {
		for(int i = 0;i<10;i++)
		{
			try {
				System.out.println(i + " : " + Thread.currentThread().getName());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
