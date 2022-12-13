package Model;

public class StringQuery extends QueryDecorator {
	private Query query;
	public StringQuery(Query query)
	{
		this.query = query;
	}
	
	public String toString()
	{
		return query.toString() + " = '" + query.getQuery() + "'";
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
