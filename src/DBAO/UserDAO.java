package DBAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Users;


public class UserDAO {
	public Users checkUser(String userName, String pass) {
		Connection connection = null;
		Users u = null;
	
		try {
			connection = DatabaseConnection.getConnection();
		
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USER_ROLE where NAME=? AND USER_PASS=?");
			stmt.setString(1,userName);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				u= new Users(rs.getString(1), rs.getString(2), rs.getString(3));
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
		return u ;
	}
}
