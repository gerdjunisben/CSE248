package p1;



public class Demo {

	public static void main(String[] args) {
		String s = "";
		for(int i=167;i!=0;i/=16)
		{
			if(i%16<=9)
			{
				s = (i%16)+ s ;
			}
			else
			{
				s= (char)('A' + i -10) + s;
			}
		}
		System.out.println(s);
		

		
		
	}

}
