package DBAO;

public class DAOFactory {
	private static DAOFactory instance = new DAOFactory();
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public AccountDAO getAccountDAO(){
		return new AccountDAO();
	}
	public BookDAO getBookDAO(){
		return new BookDAO();
	}
	
	
}
