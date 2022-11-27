package Control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Kitchen.Record;

public class Waiter {
	Record record;
	private PropertyChangeSupport support;
	
	public Waiter(Record record) {
		super();
		this.record = record;
		support = new PropertyChangeSupport(this);
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener pcl)
	{
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl)
	{
		support.removePropertyChangeListener(pcl);
	}
	
	public Record getRecord()
	{
		return record;
	}
	
	
	public void setRecord(Record record)
	{
		Record old = this.record;
		this.record = record;
		support.firePropertyChange("Record changed", old, record);
	}
}
