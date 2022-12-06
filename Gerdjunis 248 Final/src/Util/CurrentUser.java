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
	
	public void addCollege(int collegeID)
	{
		user.addCollege(collegeID);
	}
	
	public void save()
	{
		Connect.saveUser(user);
	}
	
	public String toString()
	{
		return user.toString();
	}
	
	
}
