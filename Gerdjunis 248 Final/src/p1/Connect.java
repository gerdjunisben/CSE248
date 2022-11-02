package p1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Connect {
	public static URL url;
	public static Connection db;
	public static String cQuery;
	public static void fillDataBase() 
	{
		try
		{
			setURL(cQuery);
			Statement statement = db.createStatement();
			statement.setQueryTimeout(30);
			String inLine = "";
			
			
		
			
			statement.executeUpdate("DROP TABLE IF EXISTS Colleges"); 
			statement.executeUpdate(
			"CREATE TABLE Colleges" +
			"(ID VARCAR(50) PRIMARY KEY," +
			"Name VARCAR(50)," +
			"City VARCAR(50)," +
			"Zip VARCAR(50)" +
			")");
			
			Scanner scanner = new Scanner(url.openStream());
			while(scanner.hasNextLine())
			{
				inLine += scanner.nextLine();
			}
			ObjectMapper objectMapper = new ObjectMapper();
			
			
			JsonNode node = objectMapper.readValue(inLine,JsonNode.class);
			JsonNode array = node.get("results");
			JsonNode totalNode = node.get("metadata").get("total");
			int total = Integer.parseInt(totalNode.asText());
			
			
			for(int y = 0;y<= (total/100);y++)
			{
				System.out.println(y + "/" + (total/100));
				
				for(int x =0;x<array.size();x++)
				{
					JsonNode jsonNameNode = array.get(x);
					JsonNode compsciNode = jsonNameNode.get("latest.academics.program.bachelors.computer");
					if(compsciNode != null && compsciNode.asInt()==1)
					{
						
						JsonNode idNode = jsonNameNode.get("id");
						JsonNode nameNode = jsonNameNode.get("school.name");
						JsonNode cityNode = jsonNameNode.get("school.city");
						String cityName = cityNode.asText().replace("'", "");
						JsonNode zipNode = jsonNameNode.get("school.zip");
						String collegeName = nameNode.asText().replace("'", "");
						//System.out.println(collegeName);
						statement.executeUpdate(
								"INSERT INTO Colleges"+
								"(ID,Name,City,Zip)" +
								"VALUES('"+idNode.asInt()+"','"+collegeName+"','"+cityName+"','"+zipNode.asText()+"')"
								);
					}
					
				}
				if(y==34)
					break;
				setURL(cQuery+ "&page=" +(y+1));
				statement.setQueryTimeout(30);
				inLine = "";
				scanner = new Scanner(url.openStream());
				while(scanner.hasNextLine())
				{
					inLine += scanner.nextLine();
				}
				objectMapper = new ObjectMapper();
				
				
				node = objectMapper.readValue(inLine,JsonNode.class);
				array = node.get("results");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void printTable()
	{
		Statement statement;
		try {
			statement = db.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM Colleges");
			
			while(rs.next())
			{

				System.out.print(rs.getString("ID") + " ");
				System.out.print(rs.getString("Name")+ " ");
				System.out.print(rs.getString("City")+ " ");
				System.out.print(rs.getString("Zip"));
				System.out.println();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void setQuery(String query)
	{
		cQuery = query;
	}
	
	
	public static void setURL(String query)
	{
		
		try {
			URL urlT = new URL(query);
			HttpURLConnection conn = (HttpURLConnection)urlT.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			
			if(responseCode!=200)
			{
				throw new RuntimeException("Response failed");
			}
			else
			{
				url = urlT;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setConnection(String databaseName)
	{
		try {
			Class.forName("org.sqlite.JDBC");
			db= DriverManager.getConnection("jdbc:sqlite:" + databaseName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static boolean closeConnection()
	{
		try {
			if(db != null)
			{
				db.close();
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
