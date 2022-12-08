package Model;

import java.util.LinkedList;

public class User {
    private String username;
    private int id;
    private LinkedList<Integer> list;
    private int elems;

    

    public User(String username,int id)
    {
        this.username = username;
        elems=0;
        this.id = id;
        list = new LinkedList<>();
    }

    public String getUsername()
    {
        return username;
    }
    
    public int getID()
    {
    	return id;
    }
    
    public boolean addCollege(int collegeID)
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
        	return true;
    	}
    	
    	return false;
    }
    
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
