package bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.UserDAO;
import bookshop.model.User;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='lightgrey'>");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		//User u = new User(username, password);
		
		if (session.getAttribute("user")==null) {
			
		//proveriti da li username i pass postoji u bazi
		List<User> users = UserDAO.getAll();
		
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				response.sendRedirect("AvailableBooks");
				return;
			}
			
		}
		out.println("<h2> Username does not exist. Please try again.</h2> ");
		return;
		} 
		out.println("<h2> Already logged in. </h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
