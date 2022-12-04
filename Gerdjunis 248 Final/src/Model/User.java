package Model;

import java.util.LinkedList;

public class User {
    private String username;
    private LinkedList<Integer> list;
    private int elems;

    

    public User(String username)
    {
        this.username = username;
        elems=0;
    }

    public String getUsername()
    {
        return username;
    }
    
    public void addCollege(int id)
    {
    	list.add(id);
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

    

    public String toString()
    {
        return username;
    }
}
