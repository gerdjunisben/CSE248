package p4;

public class Demo {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			for(int i = 0;i<10;i++)
			{
				try {
					System.out.println("hi " + i + " : " + Thread.currentThread().getName());
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i = 0;i<10;i++)
			{
				try {
					System.out.println("hi " + i + " : " + Thread.currentThread().getName());
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			//prioritizes a thread
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}

}
