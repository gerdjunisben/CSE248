package p1;

public class Demo {

	public static void main(String[] args) {
		// there can only be one captain
		Captain captain = Captain.getCaptain("William");
		Captain captain2 = Captain.getCaptain("Andrew");
		System.out.println(captain.equals(captain2));
		System.out.println(captain==captain2);
	}

}
