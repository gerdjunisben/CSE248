package p2;

public class Demo {

	public static void main(String[] args) {
		Student student = new Student("Kevin",0);
		Criminal criminal = new Criminal("Draven","none");
		StudentObserver observer = new StudentObserver("Ben",student);
		criminal.addObserver(observer);
		
		student.setGpa(3.9);
		
		criminal.setCrime("Man slaughter");

	}

}
