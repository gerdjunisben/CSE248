package p1;

public class Demo {

	public static void main(String[] args) {
		Student kevin = new Student("Kevin Lynch",3.9);
		StudentObserver ben = new StudentObserver("Ben",kevin);
		StudentObserver draven = new StudentObserver("Draven",kevin);
		
		kevin.setGpa(2.5);
		
		kevin.unregister(draven);
		
		kevin.setGpa(3.7);
		
		kevin.register(draven);
		
		kevin.setGpa(1.2);

	}

}
