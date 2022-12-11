package Model;

import java.util.LinkedList;

/**
 * The data model for users
 * @see <A href="C:/Users/green/Documents/CSE248/cse248/GerdjunisFinal248/src/Model/User.java"> 
 * Java Source Code
 * </A/>
 * @author Benjamin Gerdjunis <A href="mailto:benjamingerdjunis@gmail.com"> (benjamingerdjunis@gmail.com)
 * </A/>
 * @version December 11th, 2022
 *
 */
public class User {
    private String username;
    private int id;
    private LinkedList<Integer> list;
    private int elems;

    
/**
 * Constructor that sets all vars
 * @param username
 * @param id
 */
    public User(String username,int id)
    {
        this.username = username;
        elems=0;
        this.id = id;
        list = new LinkedList<>();
    }

    /**
     * gets username
     * @return String
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * gets id
     * @return int
     */
    public int getID()
    {
    	return id;
    }
    
    /**
     * adds a college to the list if there is less than 10 ints in the list and it isn't already in the list
     * @param collegeID
     * @return 1 if success, 0 if it already exist, -1 if the list is at it's max (10)
     */
    public int addCollege(int collegeID)
    {
    	boolean exists = false;
    	for(int i = 0;i<elems-1;i++)
    	{
    		if(list.get(i)==collegeID)
    			exists = true;
    	}
    	if(!exists && elems<10)
    	{
    		list.add(collegeID);
        	elems++;
        	return 1;
    	}
    	
    	if(exists)
    	{
    		return 0;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    /**
     * removes a college by id
     * @param id
     */
    public void removeCollege(int id)
    {
    	for(int i =0;i<elems-1;i++)
    	{
    		if(list.get(i)==id)
    		{
    			list.remove(i);
    			i--;
    			elems--;
    		}
    	}
    	
    }
    
    /**
     * gets a college id at an index
     * @param index
     * @return int id
     */
    public int getCollege(int index)
    {
    	if(elems>index)
    		return list.get(index);
    	else
    		return 0;
    	
    }
    
    
    

    

    public String toString()
    {
        return username;
    }
}
