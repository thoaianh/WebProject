package data;

public class BookInCart {
	BookDetails book;
	int quantity;

	public BookInCart(BookDetails anItem) {
		book = anItem;
		quantity = 1;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public BookDetails getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
