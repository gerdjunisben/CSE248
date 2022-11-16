package p1;

import javax.swing.JOptionPane;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rnd;
		for(int x =0;x<100;x++)
		{
			rnd = (int) (Math.random()*4) +1;
			System.out.println(rnd);
		}
		
		
	}

}
