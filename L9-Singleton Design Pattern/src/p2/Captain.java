package p2;

public class Captain {
	private String name;
	private static Captain _captain = new Captain();
	
	private Captain()
	{
		
	}
	
	public static Captain getCaptain(String name)
	{
		_captain.setName(name);
		return _captain;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
