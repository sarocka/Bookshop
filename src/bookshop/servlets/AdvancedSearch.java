package bookshop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.BookDAO;
import bookshop.model.Book;

/**
 * Servlet implementation class AdvancedSearch
 */
public class AdvancedSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title= request.getParameter("titleSearch");
		String writer = request.getParameter("writerSearch");
		double min=0;
		double max=0;
		try {
			 min = Double.parseDouble(request.getParameter("from"));
		} catch (Exception e) {
			min=0;
		}
		try {
			 max = Double.parseDouble(request.getParameter("to"));
		} catch (Exception e) {
			max=0;
		}
		
		List<Book> b= BookDAO.getBookForAdvancedSearch(title, writer, min, max);
		
		HttpSession session = request.getSession();
	
		
			session.setAttribute("advancedResult", b);
			response.sendRedirect("advancedSearchResult.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
