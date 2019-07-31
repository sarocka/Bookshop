package bookshop.model;

import java.io.Serializable;

public class Book implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int isbn;
	private double price;
	private String cover;
	private double rating;
	private String publisher;
	private String writer;
	private int availableInStock;
	private int numberOfSoldCopies;
	
	public Book(int id, String title, int isbn, double price, String cover, double rating, String publisher,
			String writer) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.cover = cover;
		this.rating = rating;
		this.publisher = publisher;
		this.writer = writer;
	}

	
	public Book(int id, String title, int isbn, double price, String cover, double rating, String publisher,
			String writer, int availableInStock) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.cover = cover;
		this.rating = rating;
		this.publisher = publisher;
		this.writer = writer;
		this.availableInStock = availableInStock;
	}


	public Book(int id, String title, int isbn, double price, String cover, double rating, String publisher,
			String writer, int availableInStock, int numberOfSoldCopies) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.cover = cover;
		this.rating = rating;
		this.publisher = publisher;
		this.writer = writer;
		this.availableInStock = availableInStock;
		this.numberOfSoldCopies = numberOfSoldCopies;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	
	public int getAvailableInStock() {
		return availableInStock;
	}

	public void setAvailableInStock(int availableInStock) {
		this.availableInStock = availableInStock;
	}

	public int getNumberOfSoldCopies() {
		return numberOfSoldCopies;
	}


	public void setNumberOfSoldCopies(int numberOfSoldCopies) {
		this.numberOfSoldCopies = numberOfSoldCopies;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + isbn;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (isbn != other.isbn)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return ""+title +", ISBN: " + isbn + ", price:" + price + " , " + cover
				+ ", rating:" + rating + ", publisher:" + publisher + ", by: " + writer;
	}
	
	
}
