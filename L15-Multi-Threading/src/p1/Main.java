package p1;

public class Main {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		System.out.println("hi");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread());
		System.out.println("bye");
		
		
		
		

	}

}
