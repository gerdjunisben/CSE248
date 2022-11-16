package p2;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Criminal extends Observable {
	private String name;
	private String crime;
	public Criminal(String name, String crime) {
		super();
		this.name = name;
		this.crime = crime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers("Name changed");
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
		setChanged();
		notifyObservers("Crime changed");
	}
	@Override
	public String toString() {
		return "Criminal [name=" + name + ", crime=" + crime + "]";
	}
	
	
}
