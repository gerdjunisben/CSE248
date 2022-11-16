package p1;

public class Wrapper implements ITemp {
	private ITemp iTemp;
	

	public Wrapper(ITemp iTemp)
	{
		this.iTemp = iTemp;
	}
	
	@Override
	public double convertToCelsius(double temp) {
		return iTemp.convertToCelsius(temp);
	}
	
	public double convertToFahrenheit(double temp)
	{
		return (temp*30)+32;
	}

	
}
