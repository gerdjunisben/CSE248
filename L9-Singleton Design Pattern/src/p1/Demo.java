package p1;

public class Demo {

	public static void main(String[] args) {
		// there can only be one captain
		//this is called lazy initialization
		Captain captain = Captain.getCaptain("William");
		Captain captain2 = Captain.getCaptain("Andrew");
		System.out.println(captain.equals(captain2));//both are the same captain so this is true but
		//if it just had the same fields this would be true
		System.out.println(captain==captain2);//this is true if and only if they are the same object in
		//memory which they are
	}

}
