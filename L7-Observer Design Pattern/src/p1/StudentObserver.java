package p1;

public class StudentObserver implements Observer {
	private String name;
	
	
	public StudentObserver(String name, Student student) {
		student.register(this);
		System.out.println("Watching " + student.getName());
		this.name = name;
		
	}


	@Override
	public void update(String name, double gpa) {
		System.out.println("Student is :" + name + "," + gpa);
		
	}

}
