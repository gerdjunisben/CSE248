package Register;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Dishes.Dish;




public class Cashier  implements PropertyChangeListener  {
	private Dish dish;
	private static Cashier _cashier;
	
	
	private Cashier()
	{
		
	}
	
	public static Cashier getCashier()
	{
		if(_cashier==null)
		{
			_cashier = new Cashier();
		}
		return _cashier;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		this.setDish((Dish)evt.getNewValue());

	}

	public void setDish(Dish dish) {
		this.dish=dish;
		
	}
	
	public Dish getDish()
	{
		return dish;
	}
	
	public double getBill()
	{
		return dish.cost();
	}

}
