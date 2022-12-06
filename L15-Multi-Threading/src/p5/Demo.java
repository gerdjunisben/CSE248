package p5;

public class Demo {
	public static void main(String[] args)
	{
		Thread t1 = new Thread(()->{
			for(int i = 0;i<5;i++)
			{
				try {
					System.out.println((int)((Math.random()*10) + 1));
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(()->{
			for(int i = 0;i<5;i++)
			{
				try {
					System.out.println((char)(((int)(Math.random()*25)) +97) );
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
