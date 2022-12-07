package Model;

public class Query {
	private String attribute;
	private String query;
	private char type;
	public Query(String attribute, String query, char type) {
		super();
		this.attribute = attribute;
		this.query = query;
		this.type = type;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String toString()
	{
		if(type == 'd')
			return attribute + "=" + Double.parseDouble(query);
		else if(type == 'i')
			return attribute + "=" + Integer.parseInt(query);
		else
			return attribute + "='" + query + "'";
	}
}
