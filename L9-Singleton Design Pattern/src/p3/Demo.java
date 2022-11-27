package p3;

public class Demo {

	public static void main(String[] args) {
		//Bill Pugh method for singleton
		Captain cap1 = Captain.getCaptain();
		cap1.setName("Andrew");
		Captain cap2 = Captain.getCaptain();
		cap2.setName("Luke");
		System.out.println(cap1==cap2);

		//the captain is also static so you can grab the same captain no matter where you are
	}

}
