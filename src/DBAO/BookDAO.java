package DBAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import bean.ShoppingCart;
import data.Account;
import data.Bill;
import data.BookDetails;
import data.BookInCart;

public class BookDAO implements BookBAOInterface {
	private ArrayList<BookDetails> book;
	/*
	 * private String id; private String title; private String author; private
	 * double price; private String decription;
	 * 
	 * 
	 * ID CHAR(8) PRIMARY KEY, TITLE NCHAR(50) NOT NULL, AUTHOR CHAR(50) NULL, PRICE
	 * FLOAT NOT NULL, DECRIPITION NTEXT NULL)
	 */

	public List<BookDetails> getBooks() {
		book = new ArrayList<BookDetails>();
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BOOKDETAIL");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookDetails b = new BookDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
						rs.getString(5), rs.getInt(6));
				if (rs.getInt(6) > 0) {
					book.add(b);
				}

			}

			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return book;
	}

	public boolean delete(String id) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM BOOKDETAIL WHERE ID = ?");
			stmt.setString(1, id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public boolean update(BookDetails book) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement stmt = connection.prepareStatement("DELETE FROM BOOKDETAIL WHERE ID = ?");
			stmt.setString(1, book.getId());
			stmt.executeUpdate();

			stmt = connection.prepareStatement("INSERT INTO BOOKDETAIL VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, book.getId());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setDouble(4, book.getPrice());
			stmt.setString(5, book.getDecription());
			stmt.setInt(6, book.getAmount());

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

	public List<BookDetails> findByUserName(String uName) {
		Connection connection = null;
		List<BookDetails> resultList = new ArrayList<BookDetails>();
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BOOKDETAIL WHERE TITLE like ? ");
			stmt.setString(1, uName + "%");

			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				BookDetails book = new BookDetails(result.getString(1), result.getString(2), result.getString(3),
						result.getFloat(4), result.getString(5), result.getInt(6));
				resultList.add(book);
			}
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

	@Override
	public int bookCount() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM BOOKDETAIL");
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
	public boolean insert(BookDetails book) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO BOOKDETAIL VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, book.getId());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setDouble(4, book.getPrice());
			stmt.setString(5, book.getDecription());
			stmt.setInt(6, book.getAmount());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;

	}

	@Override
	public BookDetails getBookByID(String inputId) {
		Connection connection = null;
		BookDetails book = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BOOKDETAIL WHERE ID = ?");
			stmt.setString(1, inputId);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				book = new BookDetails(result.getString(1), result.getString(2), result.getString(3),
						result.getFloat(4), result.getString(5), result.getInt(6));
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
		return book;
	}

	@Override
	public List<BookDetails> getBookType(String string) {
		Connection connection = null;
		BookDetails book = null;
		List<BookDetails> listBook = new ArrayList<>();
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM BOOKDETAIL WHERE TITLE LIKE ? OR DECRIPITION LIKE ?");
			stmt.setString(1, "%" + string + "%");
			stmt.setString(2, "%" + string + "%");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				book = new BookDetails(result.getString(1), result.getString(2), result.getString(3),
						result.getFloat(4), result.getString(5), result.getInt(6));
				listBook.add(book);
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
		return listBook;
	}

	public void buyBook(String bookId, int quantity, String accId) {
		Connection connection = null;

		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("select * " + "from BOOKDETAIL where ID = ? ");
			prepStmt.setString(1, bookId);

			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				int amount = rs.getInt(6);
				prepStmt.close();

				if ((amount - quantity) >= 0) {
					PreparedStatement updateStatement = connection
							.prepareStatement("update BOOKDETAIL set AMOUNT = AMOUNT - ? where ID = ?");

					updateStatement.setInt(1, quantity);
					updateStatement.setString(2, bookId);
					updateStatement.executeUpdate();
					
					BookDetails book = getBookByID(bookId);
					updateStatement = connection.prepareStatement("insert into bill values(?,?,?,?,?)");
					updateStatement.setString(1, bookId);
					updateStatement.setString(2, accId);
					updateStatement.setString(3, book.getTitle());
					updateStatement.setInt(4, quantity);

					updateStatement.setDouble(5, book.getPrice());

					updateStatement.executeUpdate();

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void buy(ShoppingCart cart, String accId) {
		Connection connection = null;
		Collection books = cart.getBooks();
		Iterator i = books.iterator();

		try {
			connection = DatabaseConnection.getConnection();
			connection.setAutoCommit(false);

			while (i.hasNext()) {
				BookInCart bic = (BookInCart) i.next();
				BookDetails bd = (BookDetails) bic.getBook();
				String id = bd.getId();
				int quantity = bic.getQuantity();
				buyBook(id, quantity, accId);
			}

			connection.commit();
			connection.setAutoCommit(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int currentAmount(String bookId) {
		Connection connection = null;
		int currentAmount = 0;

		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("select AMOUNT from BOOKDETAIL where ID = ? ");
			prepStmt.setString(1, bookId);

			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				currentAmount = rs.getInt("AMOUNT");
			}

			prepStmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return currentAmount;

	}

//	public List<Bill> bill(ShoppingCart cart, String accId) {
//		Connection connection = null;
//		Bill bill = null;
//		List<Bill> list= new ArrayList<>();
//
//		try {
//			connection = DatabaseConnection.getConnection();
//		   PreparedStatement stm= connection.prepareStatement("select * from bill where accId=?");
//		   stm.setString(1, accId);
//		   ResultSet rs= stm.executeQuery();
//		    
//			while(rs.next()) {
//				 bill= new Bill(rs.getString(1), rs.getString(2));
//				 list.add(bill);
//			}
//
//				
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return list;
//
//	}
	public List<Bill> bill(ShoppingCart cart, String accId) {
		Connection connection = null;
		Bill bill = null;
		List<Bill> list = new ArrayList<>();

		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stm = connection.prepareStatement("select * from bill where accId=?");
			stm.setString(1, accId);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				bill = new Bill(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
				list.add(bill);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;

	}

}
