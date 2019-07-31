package bookshop.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.BookDAO;
import bookshop.model.Book;

/**
 * Servlet implementation class ConfirmPayment
 */
public class ConfirmPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int count = 0;
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		try {
			count = Integer.parseInt(request.getParameter("count"));
		} catch (Exception e) {
			response.sendRedirect("badInput.jsp");
			return;
		}
		
		
		Book b = BookDAO.getById(bookId);
		HttpSession session = request.getSession();
		session.setAttribute("bookToBuy", b);
		session.setAttribute("count", count);
		response.sendRedirect("confirm.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
