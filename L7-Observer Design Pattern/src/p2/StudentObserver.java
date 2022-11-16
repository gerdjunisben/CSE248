package p2;

import java.util.Observable;
import java.util.Observer;

public class StudentObserver implements Observer{
	private String name;
	private double gpa;
	private Student student;
	
	
	
	public StudentObserver(String name, Student student) {
		this.name = name;
		student.addObserver(this);
		this.student = student;
		System.out.println(name + " added a new observable");
	}



	@Override
	public void update(Observable o, Object arg) {
		System.out.println(o.toString());
		System.out.println(arg);
	}

}
