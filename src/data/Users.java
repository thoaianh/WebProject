package data;

public class Users {
	private String userName;
	private String pass;
	private String role;

	public Users(String userName, String pass, String role) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
