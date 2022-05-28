package bean;

import DBAO.UserDAO;
import data.Users;

public class CheckUser {
	UserDAO userDAO;
	
	public CheckUser() {
		userDAO=new UserDAO();
	}
	public Users checkUser(String name, String pass) {
		return userDAO.checkUser(name, pass);
	}

}
