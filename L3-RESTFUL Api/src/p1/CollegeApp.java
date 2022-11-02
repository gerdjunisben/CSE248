package p1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CollegeApp {
	public static void main(String[] args)
	{
		String inLine = "";
		
		try {
			URL url = new URL("https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3,4&_fields=id,school.name&_zip=11784&_distance=10mi&api_key=nSTCffEr2yiN7QOxzqiGTZ4W0SGs7YJTXz9WitvF");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			if(responseCode!=200)
			{
				throw new RuntimeException("Response failed");
			}
			else
			{
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNextLine())
				{
					inLine += scanner.nextLine();
				}
				//System.out.println("Raw");
				//System.out.println(inLine);
				System.out.println("Parsed");
				ObjectMapper objectMapper = new ObjectMapper();
				
				
				JsonNode node = objectMapper.readValue(inLine,JsonNode.class);
				JsonNode array = node.get("results");
				
				for(int x =0;x<array.size();x++)
				{
					JsonNode jsonNameNode = array.get(x);
					JsonNode nameNode = jsonNameNode.get("school.name");
					System.out.println("name:" + nameNode.asText());
					JsonNode idNode = jsonNameNode.get("id");
					System.out.println("id:" + idNode.asText());
				}
				
				JsonNode metaData = node.get("metadata");
				JsonNode totalField = metaData.get("total");
				System.out.println("total:" + totalField.asText());
				JsonNode pageField = metaData.get("page");
				System.out.println("page:" + pageField.asText());
				JsonNode perPageField = metaData.get("per_page");
				System.out.println("per page:" + perPageField.asText());
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
