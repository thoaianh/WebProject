package bean;

import java.util.List;

import DBAO.BookDAO;
import DBAO.DAOFactory;
import data.BookDetails;

public class ListBook {
	private BookDAO bookDAO;

	public ListBook() {
		bookDAO = DAOFactory.getInstance().getBookDAO();
	}

	public List<BookDetails> getBooks() {
		return bookDAO.getBooks();
	}

	public BookDetails getBook(String id) {
		return bookDAO.getBookByID(id);
	}

	public void deleteBook(String id) {
		bookDAO.delete(id);
	}

	public boolean update(BookDetails book) {
		return bookDAO.update(book);

	}

	public boolean insert(BookDetails book) {
		return bookDAO.insert(book);

	}

	public List<BookDetails> getBookType(String string) {
		return bookDAO.getBookType(string);
	}

}
