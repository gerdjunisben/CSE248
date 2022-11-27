package p3;

public class Captain {
	private static String name;
	
	private Captain() {
	}
	
	private static class SingletonHelper{
		private static final Captain _captain = new Captain();
	}
	
	public static Captain getCaptain()
	{
		return SingletonHelper._captain;
	}
	
	public static void setName(String name)
	{
		Captain.name = name;
	}

	public static String getName() {
		return name;
	}
}
