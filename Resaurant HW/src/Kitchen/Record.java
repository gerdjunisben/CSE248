package Kitchen;

public class Record {
	private String dish;
	private String cook;
	private String spice;
	public Record(String dish, String cook, String spice) {
		super();
		this.dish = dish;
		this.cook = cook;
		this.spice = spice;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public String getCook() {
		return cook;
	}
	public void setCook(String cook) {
		this.cook = cook;
	}
	public String getSpice() {
		return spice;
	}
	public void setSpice(String spice) {
		this.spice = spice;
	}
	
	
}
