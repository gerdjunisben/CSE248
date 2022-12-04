package Model;

import java.util.LinkedList;

public class User {
    private String username;
    private LinkedList<Integer> list;
    

    

    public User(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    
    public void addCollege(int id)
    {
    	list.add(id);
    }

    

    public String toString()
    {
        return username;
    }
}
