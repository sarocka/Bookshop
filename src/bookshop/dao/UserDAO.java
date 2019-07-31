package bookshop.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bookshop.model.User;
import bookshop.utils.ConnectionManager;

public class UserDAO {
	public static List<User> getAll(){
		List<User> users = new ArrayList<>();
		User u = null;
		
		Statement st=null;
		ResultSet rs=null;
		try {
			String query = "SELECT * FROM users";
			st = ConnectionManager.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
	
				int id = rs.getInt("id");
				
				String username = rs.getString("username");
				
				String password = rs.getString("password");
				
				
				u = new User(id, username, password);
				users.add(u);
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
		
		return users;
	}
	
	public static boolean add(User user) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO users (username, password) VALUES (?, ?)";

			pstmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, user.getUsername());
			pstmt.setString(index++, user.getPassword());
			
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Invalid query!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
}
