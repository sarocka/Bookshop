package bookshop.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.model.Book;
import bookshop.utils.ConnectionManager;

public class BookDAO {

	
	public static List<Book> getAll(){
		List<Book> books = new ArrayList<>();
		Book book = null;
		
		Statement st=null;
		ResultSet rs=null;
		try {
			String query = "SELECT * FROM books";
			st = ConnectionManager.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	
				int id = rs.getInt("id");
				int isbn = rs.getInt("isbn");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				String cover = rs.getString("cover");
				double rating = rs.getDouble("rating");
				String publisher = rs.getString("publisher");
				String writer = rs.getString("writer");
				int availableInStock = rs.getInt("available_in_stock");
				int sold = rs.getInt("sold");
				
				book = new Book(id, title, isbn, price, cover, rating, publisher, writer, availableInStock,sold);
				books.add(book);
			}
			
		
		} catch (Exception e) {
			System.out.println("Invalid query");
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				
			} catch (Exception e2) {
				
			}
			try {
				rs.close();
			} catch (Exception e2) {
				
			}
		}
		
		return books;
	}

	public static Book getById(int id) {
		Book b = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String query="SELECT * FROM books WHERE id ="+id;
			st=ConnectionManager.getConnection().createStatement();
			rs= st.executeQuery(query);
			
			while (rs.next()) {
				
				
				int isbn = rs.getInt("isbn");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				String cover = rs.getString("cover");
				double rating = rs.getDouble("rating");
				String publisher = rs.getString("publisher");
				String writer = rs.getString("writer");
				int availableInStock = rs.getInt("available_in_stock");
				
				b = new Book(id, title, isbn, price, cover, rating, publisher, writer, availableInStock);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				
			} catch (Exception e2) {
				
			}
			try {
				rs.close();
			} catch (Exception e2) {
			
			}
		}
		
		return b;
	}
	public static boolean update(Book book) {
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE books SET title = ?, isbn= ?, price = ?, cover = ?, rating=?, publisher=?, writer=?, available_in_stock=?, sold=? WHERE id = " + book.getId();

			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, book.getTitle());
			pstmt.setInt(index++, book.getIsbn());
			pstmt.setDouble(index++, book.getPrice());
			pstmt.setString(index++, book.getCover());
			pstmt.setDouble(index++, book.getRating());
			pstmt.setString(index++, book.getPublisher());
			pstmt.setString(index++, book.getWriter());
			pstmt.setInt(index++, book.getAvailableInStock());
			pstmt.setInt(index++, book.getNumberOfSoldCopies());
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static List<Book> getBookByTitle(String title) {
		Book b = null;
		List<Book> books = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM bookshop.books WHERE title = ?";

			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, title);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int isbn = rs.getInt("isbn");
				
				double price = rs.getDouble("price");
				String cover = rs.getString("cover");
				double rating = rs.getDouble("rating");
				String publisher = rs.getString("publisher");
				String writer = rs.getString("writer");
				int availableInStock = rs.getInt("available_in_stock");
				
				b = new Book(id, title, isbn, price, cover, rating, publisher, writer, availableInStock);
				books.add(b);
			}
		} catch (SQLException ex) {
			System.out.println("Invalid query");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rs.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return books;
	}
	
	
	public static List<Book> getBookForAdvancedSearch(String title, String writer, double min, double max) {
		Book b = null;
		List<Book> books = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM bookshop.books WHERE (title IS NULL OR title = ?) OR (writer IS NULL OR writer=?) OR price BETWEEN "+min+" AND "+max;

			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, title);
			pstmt.setString(index++, writer);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int isbn = rs.getInt("isbn");
				title =rs.getString("title");
				double price = rs.getDouble("price");
				String cover = rs.getString("cover");
				double rating = rs.getDouble("rating");
				String publisher = rs.getString("publisher");
				writer = rs.getString("writer");
				int availableInStock = rs.getInt("available_in_stock");
				
				b = new Book(id, title, isbn, price, cover, rating, publisher, writer, availableInStock);
				books.add(b);
			}
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rs.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return books;
	}

	

}