package p1;

public class Demo {
	public static void main(String[] args)
	{
		Converter converter = new Converter();
		double temp = converter.convertToCelsius(32);
		System.out.println(temp);
		Wrapper wrap = new Wrapper(converter);
		temp = wrap.convertToFahrenheit(temp);
		System.out.println(temp);
	}
}
