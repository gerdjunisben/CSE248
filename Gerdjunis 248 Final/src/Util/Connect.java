package Util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.College;
import Model.User;

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
			"CREATE TABLE colleges (ID INT(20) PRIMARY KEY, Name varchar(255), "+
			"City varchar(255), Zip varchar(255),Admission DOUBLE(5,2),Completion DOUBLE(5,2),"+
			"InState INT(10),OutState INT(10))");
			
			/*
			statement.executeUpdate("DROP TABLE IF EXISTS users"); 
			statement.executeUpdate(
			"CREATE TABLE users ("
			+ "username	VARCHAR(255),"
			+ "password VARCHAR(255),"
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT"
			+ ")");
			
			statement.executeUpdate("DROP TABLE IF EXISTS savedList"); 
			statement.executeUpdate(
			"CREATE TABLE savedList("
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "save1 INT(20),"
			+ "save2 INT(20),"
			+ "save3 INT(20),"
			+ "save4 INT(20),"
			+ "save5 INT(20),"
			+ "save6 INT(20),"
			+ "save7 INT(20),"
			+ "save8 INT(20),"
			+ "save9 INT(20),"
			+ "save10 INT(20)"
			+ ")");
			*/
			
			
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
	
	public static void saveUser(User user)
	{
		try {
			Statement statement = db.createStatement();
			statement.setQueryTimeout(30);
			String s = "UPDATE savedList SET ";
			int index =0;
			int college = user.getCollege(index);
			
			while(college!=0)
			{
				if(index>0)
					s+= ",";
				s += "save" + (index+1) + "='" + user.getCollege(index) + "'";
				
				index++;
				college = user.getCollege(index);
				
			}
			s += " WHERE id=" +user.getID();
			System.out.println(s);
			statement.executeUpdate(s);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int signIn(String username,String password)
	{
		
		try {
			Statement statement = db.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username+"'");
			if(rs.next())
			{
				if(rs.getString("password").equals(password))
				{
					return rs.getInt("id");
				}
			}
			else
			{
				System.out.println("User doesn't exist");
				return 0;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static User getUser(String username,String password)
	{
		int id = signIn(username,password);
		User user;
		if(id!=-1)
		{
			user = new User(username,id);
			
			try {
				Statement statement = db.createStatement();
				statement.setQueryTimeout(30);
				ResultSet rs = statement.executeQuery("SELECT * FROM savedList WHERE id='" + id+"'");
				for(int i =1;i<=10;i++)
				{
					int save = rs.getInt("save" + i);
					if(save!=0)
						user.addCollege(save);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			user=null;
		}
		return user;
	}
	
	public static int addUser(String username,String password)
	{
		
		try {
			Statement statement = db.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username+"'");
			
			if(!rs.next())
			{
				statement.executeUpdate(
						"INSERT INTO users (username,password) "+
						"VALUES ('"+username+"','"+password+"')");
				statement.executeUpdate(
						"INSERT INTO savedList (save1,save2,save3,save4,save5,save6,save7,save8,save9,save10) "+
						"VALUES ('"+0+"','"+0+"','"+0+"','"+0+
						"','"+0+"','"+0+"','"+0+"','"+0+
						"','"+0+"','"+0+"')");
				return 1;
			}
			else
			{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static LinkedList<College> getSomeColleges(String[] queries)
	{
		Statement statement;
		LinkedList<College> list = new LinkedList<>();
		try {
			statement = db.createStatement();
			statement.setQueryTimeout(30);
			String query = "SELECT * FROM colleges WHERE";
			for(int i =0;i<queries.length;i++)
			{
				query += " " + queries[0] + " AND ";
			}

			ResultSet rs = statement.executeQuery(query);
			
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
