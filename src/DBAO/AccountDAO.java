package DBAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import data.Account;
import data.Users;

/*ID CHAR(8) PRIMARY KEY,
NAME CHAR(100) NOT NULL,
ACCPASSWORD CHAR(10) NOT NULL,
EMAIL CHAR(50) NOT NULL,
PHONE CHAR(11) NOT NULL,
ADDR NTEXT NOT NULL
*/

public class AccountDAO implements AccountDAOInterFace {

	private List<Account> populateList(ResultSet result) throws SQLException {
		List<Account> accList = new ArrayList<Account>();
		while (result.next()) {
			String id = result.getString("ID");
			String name = result.getString("NAME");
			String password = result.getString("ACCPASSWORD");
			String email = result.getString("EMAIL");
			String phone = result.getString("PHONE");
			String address = result.getString("ADDR");
			Account acc = new Account(id, name, password, email, phone, address);
			accList.add(acc);
		}
		return accList;
	}

//	public boolean delete(String id) {
//		Connection connection = null;
//		try {
//			connection = DatabaseConnection.getConnection();
//			PreparedStatement stmt = connection.prepareStatement(
//			      "DELETE FROM ACCOUNT WHERE ID = ?");
//			stmt.setString(1, id);
//			stmt.executeUpdate();
//			stmt.close();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//			return false;
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException sqleClose) {
//				sqleClose.printStackTrace();
//			}
//		}
//		return true;
//	}
//
//
	public boolean insert(Account acc, String role) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO ACCOUNT VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, acc.getId());
			stmt.setString(2, acc.getName());
			stmt.setString(3, acc.getPassword());

			stmt.setString(4, acc.getEmail());
			stmt.setString(5, acc.getPhone());
			stmt.setString(6, acc.getAddress());

			stmt.executeUpdate();

			stmt = connection.prepareStatement("INSERT INTO USER_ROLE VALUES (?, ?, ?)");
			stmt.setString(1, acc.getEmail());
			stmt.setString(2, acc.getPassword());
			stmt.setString(3, role);

			stmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				connection.rollback();
				return false;
			} catch (SQLException sqleRollback) {
				sqleRollback.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public List<Account> findByUserName(String uName) {
		Connection connection = null;
		List<Account> resultList = new ArrayList<Account>();
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE NAME like ? ");
			stmt.setString(1, uName + "%");

			ResultSet result = stmt.executeQuery();
			resultList = populateList(result);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return resultList;
	}

	public int accCount() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM ACCOUNT");
			if (result.next())
				count = result.getInt(1);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public Account getAccByID(String inputId) {
		Connection connection = null;
		Account acc = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?");
			stmt.setString(1, inputId);
			ResultSet result = stmt.executeQuery();
			List<Account> accList = populateList(result);
			if (accList.size() > 0) {
				acc = accList.get(0);
			}
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return acc;
	}

//	public Users checkUser(String userName, String pass) {
//		Connection connection = null;
//		Users u = null;
//
//		try {
//			connection = DatabaseConnection.getConnection();
//
//			PreparedStatement stmt = connection
//					.prepareStatement("SELECT * FROM USER_ROLE where NAME=? AND USER_PASS=?");
//			stmt.setString(1, userName);
//			stmt.setString(2, pass);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				u = new Users(rs.getString(1), rs.getString(2), rs.getString(3));
//			}
//
//			stmt.close();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException sqleClose) {
//				sqleClose.printStackTrace();
//			}
//		}
//		return u;
//	}

	@Override
	public Account setAccByID(String inputId) {
		return null;
	}

	// check account by email
	@Override
	public Account getAccByUserInfo(String name, String pass) {
		Connection connection = null;
		Account acc = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM ACCOUNT WHERE EMAIL = ? AND ACCPASSWORD=?");
			stmt.setString(1, name);
			stmt.setString(2, pass);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				acc = new Account(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getString(6));
			}
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return acc;

	}

	public boolean updateAddress(String addr, String id) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE ACCOUNT SET PHONE=? WHERE ID=?");
			stmt.setString(1, addr);
			stmt.setString(2, id);

			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;

		}
		return true;
	}

}
