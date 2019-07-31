package bookshop.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import bookshop.model.Book;
import bookshop.utils.ConnectionManager;

public class WishDAO {

	
	public static boolean add(int userID, int bookId){
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO bookshop.wish (user_id, book_id) VALUES (?, ?)";

			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, userID);
			pstmt.setInt(index++, bookId);

			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static List<Book> getBooksByUserID(int userID) {
		List<Book> booksInWishList = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT book_id FROM bookshop.wish WHERE user_id = " + userID;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int bookID = rset.getInt(1); 

				Book book = BookDAO.getById(bookID);
				booksInWishList.add(book);
			}
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return booksInWishList;
	}
	public static boolean delete(int userID, int bookId) {
		Statement stmt = null;
		try {
			String query = "DELETE FROM bookshop.wish WHERE user_id = " + userID+" AND book_id = "+bookId;

			stmt = ConnectionManager.getConnection().createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
}
