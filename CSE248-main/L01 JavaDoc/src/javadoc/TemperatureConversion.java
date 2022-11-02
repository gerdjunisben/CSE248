package javadoc;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * The TemperatureConversion Java application prints a table converting Celsius 
 * to Fahrenheit degrees
 * @see <A href="./javadoc/TemperatureConversion.java"> Java Source Code (www.google.com)
 * </A>
 * 
 * @author Chen <A href="mailto:chenb@sunysuffolk.edu"> (chenb@sunysuffolk.edu)</A>
 * 
 * @version September 28, 2022
 *
 */

public class TemperatureConversion { 
	
	/**
	 * The main method prints a Celsius to Fahrenheit conversion table.
	 * The bounds of the table range from -50C to + 50C in 10 degree-increments.
	 * 
	 * @param args A string argument not used in this implementation.
	 */

	public static void main(String[] args) {
		
		final double TABLE_BEGIN = -50;
		final double TABLE_END = 50;
		final double TABLE_STEP = 10.0;
		
		double celsius;
		double fahrenheit;
		
		System.out.println("TEMPERATURE CONVERSION");
		System.out.println("-----------------------");
		System.out.println("Celsius       Fehrenheit");
		
		for(celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) {
			fahrenheit = celsiusToFahrenheit(celsius);
			System.out.printf("%6.2fC", celsius);
			System.out.printf("%14.2fF\n", fahrenheit);
		}
		System.out.println("-----------------------");
	}
	
	/**
	 * Convert a temperature from Celsius degrees to Fahrenheit degrees
	 * 
	 * @param celsius
	 * a temperature in Celsius degrees
	 * 
	 * @return
	 * 	the temperature celsius converted to Fahrenheit
	 * 
	 * @throws java.lang.IllegalArgumentException indicates that celsius is less than the 
	 *  smallest Celsius temperature (-273.16).
	 * 
	 */

	public static double celsiusToFahrenheit(double celsius) {
		final double MINIMUM_CELSIUS = -273.16;
		
		if(celsius < MINIMUM_CELSIUS) {
			throw new IllegalArgumentException("Argument " + celsius + " is too small.");
		}
		
		return (9.0/5.0) * celsius + 32;
	}
}
