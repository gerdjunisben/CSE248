package p1;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {
	private String name;
	private double gpa;
	private List<Observer> observerList;
	
	public Student(String name, double gpa)
	{
		observerList = new ArrayList<>();
		this.name = name;
		this.gpa = gpa;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
		notifyObservers();
	}

	@Override
	public void register(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void unregister(Observer observer) {
		int index = observerList.indexOf(observer);
		observerList.remove(observer);
		
		System.out.println((index +1)+ " was removed");
	}

	@Override
	public void notifyObservers() {
		observerList.forEach((e)->{
			e.update(name, gpa);
		});
		
	}

}
