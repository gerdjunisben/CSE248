package p1;

//in line comment (the classic), used to document things the developer needs to know
/*
 * block comment
 * like a line comment but more than one line
 * below this is a Javadoc comment
 * it is used to document what you code does in the form of a web page
 * to teach users of your code how it works
 */
/**
 * The TemperatureConversion class prints a table converting Celsius to Fahrenheit
 * @see <A href="C:/Users/green/Documents/CSE248/cse248/L1-Javadoc/src/p1/TemperatureConversion.java"> 
 * Java Source Code
 * </A/>
 * @author Benjamin Gerdjunis <A href="mailto:benjamingerdjunis@gmail.com"> (benjamingerdjunis@gmail.com)
 * </A/>
 * @version September 28, 2022
 *
 */
public class TemperatureConversion 
{
	/**
	 * Prints celsius to fahrenheit conversion table.
	 * The bounds of the table range from -50C to 50C in 10 degree increments
	 * 
	 * @param args string argument not used in this implementation 
	 */
	public static void main(String[] args)
	{
		final double TABLE_BEGIN =50;
		final double TABLE_END = -50;
		final double TABLE_STEP = 10.0;
		
		double celsius, fahrenheit;
		
		System.out.println("TEMPERATURE CONVERSION");
		System.out.println("--------------------------");
		System.out.println("Celsius            Fahrenheit");
		
		for(celsius = TABLE_BEGIN;celsius >= TABLE_END;celsius -= TABLE_STEP)
		{
			fahrenheit = celsiusToFahrenheit(celsius);
			System.out.printf("%6.2fC",celsius);
			System.out.printf("%14.2fF\n", fahrenheit);
		}
	}

	/**
	 * Converts celsius to fahrenheit
	 * @param celsius the celsius (double) to be converted
	 * @return the celsius converted to fahrenheit (double)
	 * 
	 * @throws 
	 * java.lang.illegalArgumentException Indicates that celsius is less than the smallest celsius temperature (-273.16C)
	 */
	private static double celsiusToFahrenheit(double celsius) 
	{
		final double MIN_CELSIUS = -273.16;
		if(celsius < MIN_CELSIUS)
			throw new IllegalArgumentException("Argument: " + celsius + " is too small");
		return (celsius * (9.0/5.0)) + 32 ;
	}
}
