package Model;

public class NumericQuery extends QueryDecorator {
	private Query query;
	private String symbol;
	public NumericQuery(Query query,String symbol)
	{
		this.query = query;
		this.symbol = symbol;
	}
	
	public String toString()
	{
		return query.toString() + " "+ symbol + " " + Double.parseDouble(query.getQuery());
	}

	@Override
	public String getQuery() {
		return query.getQuery();
	}

	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return query.getAttribute();
	}
}
