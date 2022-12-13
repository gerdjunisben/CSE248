package Model;

public abstract class Query {
	private String attribute;
	private String query;
	
	public abstract String getQuery();
	public abstract String getAttribute();
}
