package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBAO.BookDAO;
import bean.ListBook;
import data.BookDetails;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/Add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListBook bean = (ListBook) session.getAttribute("bean");
		boolean ok = true;

		// doc cac tham so
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");

		String bookPrice = request.getParameter("price");

		double price = 0;
		if (bookPrice == "" || bookPrice == null) {
         bookPrice="0";
		}
		try {
			price = Double.parseDouble(bookPrice);
		} catch (NumberFormatException e) {

			ok = false;
			String error = "Input number, not text";
			session.setAttribute("errorPrice", error);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/form/AddBook.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}

		String decription = request.getParameter("decription");

		String bookAmount = request.getParameter("amount");
		if (bookAmount == "" || bookAmount == null) {
	         bookAmount="0";
			}
		int amount = 0;
		try {
			amount = Integer.parseInt(bookAmount);
		} catch (NumberFormatException e) {
			ok = false;
			String error = "Input number, not text";
			session.setAttribute("errorAmount", error);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/form/AddBook.jsp");
			dispatcher.forward(request, response);
		
		}
		if (ok) {
			bean.insert(new BookDetails(id, title, author, price, decription, amount));

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/fileupload/uploadfile.jsp");
			dispatcher.forward(request, response);
		}

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
