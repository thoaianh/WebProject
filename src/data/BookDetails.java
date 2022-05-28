package data;

import java.io.Serializable;

public class BookDetails implements Serializable {
	private String id;
	private String title;
	private String author;
	private double price;
	private String decription;
	private int amount;

	public BookDetails(String id, String title, String author, double price, String decription, int amount) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.decription = decription;
		this.amount = amount;
	}

	public BookDetails() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
