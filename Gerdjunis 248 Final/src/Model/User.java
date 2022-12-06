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
    
    public void addCollege(int collegeID)
    {
    	list.add(collegeID);
    	elems++;
    }
    
    public void removeCollege(int id)
    {
    	for(int i =0;i<elems;i++)
    	{
    		if(list.get(i)==id)
    		{
    			list.remove(i);
    			i--;
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
