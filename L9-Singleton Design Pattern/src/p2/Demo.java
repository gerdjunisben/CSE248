package p2;

import p1.Captain;

public class Demo {

	public static void main(String[] args) {
		// there can only be one captain
		//this is called eager initialization
		Captain captain = Captain.getCaptain("Andrew");
		Captain captain2 = Captain.getCaptain("William");
		System.out.println(captain.equals(captain2));
		System.out.println(captain==captain2);
	}

}
