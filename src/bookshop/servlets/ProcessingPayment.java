package bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.BookDAO;
import bookshop.dao.BoughtDAO;
import bookshop.dao.WishDAO;
import bookshop.model.Book;
import bookshop.model.User;

/**
 * Servlet implementation class ProcessingPayment
 */
public class ProcessingPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessingPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dodati knjigu u listu bought i oduzeti available in stock- count, plus uvecati number of sold copies za count
		PrintWriter out= response.getWriter();
		out.println("<html><body bgcolor='lightgrey'>");
		HttpSession session = request.getSession();
		Book b = (Book) session.getAttribute("bookToBuy");
		User u = (User) session.getAttribute("user");
		int count = Integer.parseInt(request.getParameter("countConfirm"));
		if (count>b.getAvailableInStock()) {
			out.println("<h2>Out of stock!</h2>");
			return;
		}
		BoughtDAO.add(u.getId(), b.getId());
		
		
		Book updated = new Book(b.getId(), b.getTitle(), b.getIsbn(),b.getPrice(), b.getCover(), b.getRating(), 
				b.getPublisher(), b.getWriter(), b.getAvailableInStock()-count,b.getNumberOfSoldCopies()+count);
		BookDAO.update(updated); 
		WishDAO.delete(u.getId(),b.getId());
		//WishDAo delete wish user i delete wish book- izbaci iz wishliste
		response.sendRedirect("MyOrders");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
