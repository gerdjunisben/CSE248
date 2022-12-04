package Util;

import Model.User;

public class CurrentUser {
	
	private static CurrentUser currentUser;
	private User user;
	
	private CurrentUser(User user)
	{
		this.user = user;
	}
	
	private static void makeUser(User user)
	{
		currentUser = new CurrentUser(user);
	}
	
	
}
