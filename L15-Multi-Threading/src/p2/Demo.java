package p2;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Runner().start();
		new Runner().start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("Bye from main");
		
	}

}
