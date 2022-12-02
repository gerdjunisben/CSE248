package Util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.College;

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
			
			
		
			
			statement.executeUpdate("DROP TABLE IF EXISTS colleges"); 
			statement.executeUpdate(
			"CREATE TABLE colleges (ID varchar(255) PRIMARY KEY, Name varchar(255), "+
			"City varchar(255), Zip varchar(255),Admission DOUBLE(5,2),Completion DOUBLE(5,2),"+
			"InState INT(10),OutState INT(10))");
			
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
						JsonNode admissionNode = jsonNameNode.get("latest.admissions.admission_rate.overall");
						JsonNode completionNode = jsonNameNode.get("latest.completion.completion_rate_4yr_150nt");
						JsonNode inStateNode = jsonNameNode.get("latest.cost.tuition.in_state");
						JsonNode outStateNode = jsonNameNode.get("latest.cost.tuition.out_of_state");
						statement.executeUpdate(
						"INSERT INTO colleges (ID,Name,City,Zip,Admission,Completion,InState,OutState) "+
						"VALUES ('"+idNode.asInt()+"','"+collegeName+"','"+cityName+"','"+zipNode.asText()+"','"+
						admissionNode.asDouble()+"','"+completionNode.asDouble()+"','"+inStateNode.asInt()+"','"+
						outStateNode.asInt()+"')");
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
	
	
	public static LinkedList<College> getCollegesAll()
	{
		Statement statement;
		LinkedList<College> list = new LinkedList<>();
		try {
			statement = db.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM colleges");
			
			while(rs.next())
			{

				list.add(new College(rs.getString("ID"),rs.getString("Name"),rs.getString("City"),rs.getString("Zip"),rs.getDouble("Admission"),rs.getDouble("Completion"),rs.getInt("InState"),rs.getInt("OutState")));
				
				
			}
			return list;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		
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
