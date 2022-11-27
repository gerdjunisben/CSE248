package Kitchen;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Dishes.Dish;




public class Chef implements PropertyChangeListener  {
	private static Chef _chef;
	private Record record;
	private Dish current;
	private PropertyChangeSupport support;
	
	private Chef()
	{
		
		support = new PropertyChangeSupport(this);
	}
	
	public static Chef getChef()
	{
		if(_chef==null)
		{
			_chef = new Chef();
		}
		return _chef;
	}
	
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		this.setRecord((Record)evt.getNewValue());

	}

	public void setRecord(Record record) {
		this.record=record;
		
	}
	
	public Record getRecord()
	{
		return record;
	}
	
	public String newDish()
	{
		Dish old = current;
		current = Kitchen.takeOrder(record.getDish(), record.getCook(), record.getSpice());
		support.firePropertyChange("Dish changed", old, current);
		return current.recipe();
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl)
	{
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl)
	{
		support.removePropertyChangeListener(pcl);
	}
	
	

}
