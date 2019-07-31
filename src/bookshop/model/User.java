package bookshop.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String password;
	private String username;
	
	
	private List<Book> wishList = new ArrayList<Book>();
	private List<Book> itemsBought = new ArrayList<Book>();
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		
	}

	public User(String username, String password) {
		super();
		this.password = password;
		this.username = username;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Book> getWishList() {
		return wishList;
	}

	public void setWishList(List<Book> wishList) {
		this.wishList = wishList;
	}

	public List<Book> getItemsBought() {
		return itemsBought;
	}

	public void setItemsBought(List<Book> itemsBought) {
		this.itemsBought = itemsBought;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
	}

	
	
}
