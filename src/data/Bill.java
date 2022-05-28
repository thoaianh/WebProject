package data;

public class Bill {
	private String bookId;
	private String customerID;
	private String bookTitle;
	private int amount;
	private double price;

	public Bill(String bookId, String customerID, String bookTitle, int amount, double price) {
		super();
		this.bookId = bookId;
		this.customerID = customerID;
		this.bookTitle = bookTitle;
		this.amount = amount;
		this.price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
