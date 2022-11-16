package p3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StudentListener implements PropertyChangeListener {
	private Record record;
	
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

}
