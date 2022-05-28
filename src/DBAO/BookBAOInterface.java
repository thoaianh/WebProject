package DBAO;

import java.util.List;

import data.BookDetails;

public interface BookBAOInterface {
	public boolean insert(BookDetails book);
	public boolean update(BookDetails book);
	public boolean delete(String inputID);
	public List<BookDetails> getBooks();
	public int bookCount();
	public BookDetails getBookByID(String inputId);
	public List<BookDetails> getBookType(String string);//chua viet
	
}
