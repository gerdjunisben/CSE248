package p1;

public class Demo {
	public static void main(String[] args)
	{
		//remember to comment this during presentation or you will be sad
		
		Connect.setQuery("https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3,4&_fields=id,school.name,school.city,school.zip,latest.academics.program.bachelors.computer&api_key=nSTCffEr2yiN7QOxzqiGTZ4W0SGs7YJTXz9WitvF&per_page=100");
		Connect.setConnection("DB.sqlite");
		Connect.fillDataBase();
		
		
		Connect.printTable();
		
		Connect.closeConnection();
	}
}
