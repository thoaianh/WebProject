package DBAO;

import data.Account;

public interface AccountDAOInterFace {
	public boolean insert(Account acc, String role);

	public int accCount();

	public Account getAccByUserInfo(String name, String pass);

	public Account getAccByID(String inputId);

	public Account setAccByID(String inputId); // change info of acc

}
