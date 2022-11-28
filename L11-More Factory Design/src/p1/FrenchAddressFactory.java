package p1;

public class FrenchAddressFactory implements AddressFactory {

	@Override
	public Address createAddress() {
		return new FrenchAddress();
	}

	@Override
	public PhoneNumber createPhoneNumber() {
		// TODO Auto-generated method stub
		return new FrenchPhoneNumber();
	}

}
