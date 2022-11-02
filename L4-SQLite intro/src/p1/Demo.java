package p1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args)
	{
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.getConnection("MyDB.sqlite");
			
			Statement statement = connection.createStatement();
			//Timeout after 30 seconds
			statement.setQueryTimeout(30);
			
			//destroys old table
			statement.executeUpdate("DROP TABLE IF EXISTS Users"); 
			//creates a table with the following variables
			statement.executeUpdate(
			"CREATE TABLE Users" +
			"(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
			"FirstName VARCAR(50)," +
			"LastName VARCAR(50)," +
			"UserName VARCAR(50) NOT NULL UNIQUE," +
			"Password VARCAR(50) NOT NULL" +
			")");
			
			//adds a user with the specified values in the specified order
			statement.executeUpdate(
			"INSERT INTO Users"+
			"(FirstName,LastName,UserName,Password)" +
			"VALUES ('Joey', 'Smith','jsmith','js123')"
			);
			
			statement.executeUpdate(
			"INSERT INTO Users"+
			"(FirstName,LastName,UserName,Password)" +
			"VALUES ('John', 'Doe','jdoe','jd456')"
			);
			
			ResultSet rs = statement.executeQuery("SELECT * FROM USERS");
			
			while(rs.next())
			{
				System.out.println(rs.getString("FirstName"));
				System.out.println(rs.getString("LastName"));
				System.out.println(rs.getString("UserName"));
				System.out.println(rs.getString("Password"));
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionUtil.closeConnection(connection);
		}
	}
}
