package Cooks;

public class Boil implements CookBehavior {
	public String cook() {
		return "boiling";
	}
	
	public String toString()
	{
		return "boil";
	}
}
