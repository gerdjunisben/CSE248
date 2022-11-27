package p2;

import java.lang.reflect.InvocationTargetException;

public class Demo {

	public static void main(String[] args) {
		try {
			//it's like if I removed your eye your body would actively look for a new one
			//instead of just chilling
			String meatType = "p2.Beef";
			Class clazz = Class.forName(meatType);
			Meat meat = (Meat) clazz.getDeclaredConstructor().newInstance();
			meat.doMeat();
			meatType = "p2.Pork";
			clazz = Class.forName(meatType);
			meat = (Meat) clazz.getDeclaredConstructor().newInstance();
			meat.doMeat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
