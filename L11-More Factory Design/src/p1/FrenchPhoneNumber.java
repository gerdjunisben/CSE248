package p1;

public class FrenchPhoneNumber extends PhoneNumber {

	private static final String COUNTRY_CODE = "33";
	private static final int NUMBER_LENGTH = 9;
	
	@Override
	public String getCountryCode() {
		return COUNTRY_CODE;
	}
	
	public void setPhoneNumber(String newPhoneNumber)
	{
		if(newPhoneNumber.length()==NUMBER_LENGTH)
		{
			super.setPhoneNumber(newPhoneNumber);
		}
	}

}
