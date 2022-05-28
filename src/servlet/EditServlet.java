package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListBook;
import data.BookDetails;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListBook bean = (ListBook) session.getAttribute("bean");
		

	   String bookId= (String) session.getAttribute("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");

		String bookPrice = request.getParameter("price");
		double price = 0;
		try {
			price = Double.parseDouble(bookPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String decription = request.getParameter("decription");

		String bookAmount = request.getParameter("amount");
		int amount = 0;
		try {
			amount = Integer.parseInt(bookAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		bean.update(new BookDetails(bookId, title, author, price, decription, amount));

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ListBookServlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
