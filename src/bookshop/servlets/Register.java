package bookshop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.UserDAO;
import bookshop.model.User;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//proveriti da li username i pass postoji u bazi
		String username = request.getParameter("usernameRegister");
		String password = request.getParameter("passRegister");
		
		User u = new User(username, password);
		List<User> users = UserDAO.getAll();
		for (User user : users) {
		
			if (user.getUsername().equals(username)) {
				response.sendRedirect("failedRegistration.jsp");
				return;
			}
			
		}
				if (username.equals("")|| username.equals("") || username.equals(" ")|| username.equals(" ")) {
					response.sendRedirect("badInput.jsp");
					return;
				}
			// dodaj u bazu
				UserDAO.add(u);
				HttpSession session = request.getSession();
				session.setAttribute("newlyRegistered", u.getUsername());
				response.sendRedirect("welcomeMessage.jsp");
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
