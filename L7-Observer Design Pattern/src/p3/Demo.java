package p3;

public class Demo {

	public static void main(String[] args) {
		Record r1 = new Record("Kevin","Sequential Art",3.9);
		Student s1 = new Student(r1);
		
		StudentListener l1 = new StudentListener();
		
		s1.addPropertyChangeListener(l1);
		
		Record r2 = new Record("Kevin","Sequential Art",4.0);
		s1.setRecord(r2);
		
		System.out.println(l1.getRecord());
	}

}
