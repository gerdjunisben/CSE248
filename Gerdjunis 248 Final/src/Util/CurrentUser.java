package Util;

import Model.User;

public class CurrentUser {
	
	private static CurrentUser currentUser;
	private User user;
	
	private CurrentUser(User user)
	{
		this.user = user;
	}
	
	public static CurrentUser makeUser(User user)
	{
		if(currentUser==null)
			return new CurrentUser(user);
		else
			return currentUser;
	}
	
	public boolean addCollege(int collegeID)
	{
		return user.addCollege(collegeID);
	}
	
	public void removeCollege(int collegeID)
	{
		user.removeCollege(collegeID);
	}
	
	public void save()
	{
		Connect.saveUser(user);
	}
	
	public int getCollege(int index)
	{
		return user.getCollege(index);
	}
	
	public String toString()
	{
		return user.toString();
	}
	
	
	
	
}
