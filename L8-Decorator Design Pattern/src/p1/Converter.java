package p1;

public class Converter implements ITemp{

	public double convertToCelsius(double temp) {
		return (temp-32)*0.5556;
	}

}
