package p4;

import java.util.Scanner;

public class App {
	
	

	public static void main(String[] args) {
		Object lock = new Object();
		//you may also use "this" in place of lock if it isn't static
		//it works exactly the same other than the whole static thing
		
		Thread t1 = new Thread(()->{
			synchronized(lock) {
				System.out.println("Producer thread is runnin");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("resumed");
			}
		});
		
		Thread t2 = new Thread(()->{
			try {
				Thread.sleep(1000);
				synchronized(lock) {
					System.out.println("Waiting for return key");
					Scanner scan = new Scanner(System.in);
					String s = scan.nextLine();
					System.out.println(s);
					lock.notify();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
