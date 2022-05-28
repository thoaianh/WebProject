package bean;

import DBAO.AccountDAO;
import data.Account;

public class ListAccount {
	private AccountDAO accDAO;

	public ListAccount() {
		accDAO = new AccountDAO();
	}

	public Account getAccByID(String id) {
		return accDAO.getAccByID(id);
	}

	public Account getAccByUSerInfo(String name, String pass) {
		return accDAO.getAccByUserInfo(name, pass);
	}

	public boolean insert(Account acc, String role) {
		return accDAO.insert(acc, role);
	}

	public int getCount() {
		return accDAO.accCount();
	}

	public boolean updateAddress(String string, String id) {
		return accDAO.updateAddress(string, id);
	}

}
