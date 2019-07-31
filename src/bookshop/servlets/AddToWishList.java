package bookshop.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.BookDAO;
import bookshop.dao.WishDAO;
import bookshop.model.Book;
import bookshop.model.User;

/**
 * Servlet implementation class AddToWishList
 */
public class AddToWishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToWishList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null) {
			response.sendRedirect("signIn.html");
			return;
		}
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book book = BookDAO.getById(bookId);
		User u = (User) session.getAttribute("user");
		List<Book> booksInWishList = WishDAO.getBooksByUserID(u.getId());
		
		for (Book wish : booksInWishList) {
			if (book.equals(wish)) {
				response.sendRedirect("badInput.jsp");
				return;
			}
		}
		
			WishDAO.add(u.getId(),bookId);
			session.setAttribute("wishList", booksInWishList);
			response.sendRedirect("WishListServlet");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
