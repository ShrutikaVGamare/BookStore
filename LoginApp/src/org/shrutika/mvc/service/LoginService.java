package org.shrutika.mvc.service;

public class LoginService {

	public boolean authenticate(String userID, String passwd)
	{
		if(passwd==null || passwd.trim()== "")
		{
			return false;
		}
		return true;
			
	}
	
	public void checkUser(String userID,String password)
	{
		
	}
}
