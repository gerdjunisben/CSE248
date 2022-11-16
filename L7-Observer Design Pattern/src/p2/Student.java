package p2;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Student extends Observable {
	private String name;
	private double gpa;
	
	

	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers("Name changed");
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		setChanged();
		notifyObservers("Gpa changed");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + "]";
	}
	
	
}
