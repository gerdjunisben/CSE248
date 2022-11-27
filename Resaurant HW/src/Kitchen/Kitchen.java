package Kitchen;

import Cooks.CookBehavior;
import Dishes.Dish;
import Spices.Cinnamon;
import Spices.Garlic;
import Spices.SpiceDecorator;

public class Kitchen {
	public static Dish takeOrder(String dish, String cook,String spice)
	{
		Dish d = getMeat(dish);
		cookMeat(d,cook);
		d= spiceMeat(d, spice);
		return d;
	}
	public static Dish getMeat(String s)
	{
		try {
			String dishType = "Dishes." +s;
			Class clazz = Class.forName(dishType);
			Dish dish = (Dish) clazz.getDeclaredConstructor().newInstance();
			return dish;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void cookMeat(Dish d, String s)
	{
		try {
			String cookType = "Cooks." +s;
			Class clazz = Class.forName(cookType);
			CookBehavior cook = (CookBehavior) clazz.getDeclaredConstructor().newInstance();
			d.setCookBehavior(cook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Dish spiceMeat(Dish d, String s)
	{
		try {
			if(s.equalsIgnoreCase("garlic"))
				return new Garlic(d);
			else if(s.equalsIgnoreCase("cinnamon"))
				return new Cinnamon(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
