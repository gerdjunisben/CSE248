package p3;

public class Demo {

	public static void main(String[] args) {
		new Thread(new Runner()).start();;
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
		new Thread(new Runner()).start();
		

	}

}
