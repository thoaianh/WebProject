package bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import DBAO.BookDAO;
import data.Bill;
import data.BookDetails;
import data.BookInCart;

public class ShoppingCart {
	HashMap<String, BookInCart> books = null;
	int numberOfBooks = 0;
	BookDAO bookDAO;

	public ShoppingCart() {
		books = new HashMap<String, BookInCart>();
		bookDAO = new BookDAO();
	}
	
	public HashMap<String, BookInCart> add(String bookId, BookDetails book) {
		if (books.containsKey(bookId)) {
			BookInCart scitem = (BookInCart) books.get(bookId);
			scitem.incrementQuantity();

		} else {
			BookInCart newItem = new BookInCart(book);
			books.put(bookId, newItem);

		}
		return books;

	}

	public void remove(String bookId) {
		if (books.containsKey(bookId)) {
			BookInCart scitem = (BookInCart) books.get(bookId);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0) {
				books.remove(bookId);
			}

			numberOfBooks--;
		}
	}

	public HashMap<String, BookInCart> getBooksInCart() {
		return books;
	}

	public List<BookInCart> getBooks() {
		List<BookInCart> results = new ArrayList<BookInCart>();
		results.addAll(this.books.values());

		return results;
	}

	protected void finalize() throws Throwable {
		books.clear();
	}

	public int getNumberOfItems() {
		numberOfBooks = 0;

		for (Iterator i = getBooks().iterator(); i.hasNext();) {
			BookInCart item = (BookInCart) i.next();
			numberOfBooks += item.getQuantity();

		}

		return numberOfBooks;
	}

	public double getTotal() {
		double amount = 0;

		for (Iterator i = getBooks().iterator(); i.hasNext();) {
			BookInCart item = (BookInCart) i.next();
			BookDetails bookDetails = (BookDetails) item.getBook();

			amount += (item.getQuantity() * bookDetails.getPrice());
		}

		return amount;
	}

	public void clearCart() {
		books.clear();
		numberOfBooks = 0;
	}

	public BookInCart getBookICById(String id) {
		BookInCart book = null;
		for (BookInCart b : getBooks()) {
			if (b.getBook().getId().equals(id)) {
				book = b;
			}

		}
		return book;

	}

	public void buy(ShoppingCart cart, String accId) {

		bookDAO.buy(cart, accId);
		;

	}

	public List<Bill> getBill(ShoppingCart cart, String accId) {
		return bookDAO.bill(cart, accId);
	}

	public int currentAmount(String id) {
		return bookDAO.currentAmount(id);
	}

	public String dayReceive(LocalDate dayBuy) {

		int day = dayBuy.getDayOfMonth();
		int month = dayBuy.getMonthValue();

		if ((month == 8 || month % 2 != 0) && month != 12) {
			if (day == 31) {
				day = 1;
				month++;
			} else {
				day = day + 3;
			}
		}
		if (month == 2) {
			if (day == 28) {
				day = 2;
				month++;
			} else {
				day = day + 3;
			}
		}
		if (month != 2 && month % 2 == 0) {
			if (day == 30) {
				day = 2;
				month++;
			} else {
				day = day + 3;
			}
		}

		if (month == 12) {
			if (day == 31) {
				day = 2;
				month = 1;
			} else {
				day = day + 3;
			}
		}
		return day + "/" + month;
	}
}
