package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListAccount;
import bean.ListBook;
import bean.ShoppingCart;
import data.Account;
import data.BookDetails;
import data.Users;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = null;
		BookDetails book = null;
		String accId = null;

		HttpSession session = request.getSession();
		String nextPage = "/bookstore/homepage.jsp";

		// Tao attribute cho ListBook
		ListBook listBook = (ListBook) session.getAttribute("bean");
		if (listBook == null) {
			listBook = new ListBook();
			session.setAttribute("bean", listBook);
		}

		List<BookDetails> listBooks;
		String searchContent = request.getParameter("searchBook");
		if (searchContent != null) {
			listBooks = listBook.getBookType(searchContent);
			session.setAttribute("list", listBooks);
		}
		if (searchContent == null) {
			listBooks = listBook.getBooks();
			session.setAttribute("list", listBooks);
		}

		// Tao attribute cho cart
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}

		String action = request.getParameter("action");
		Account acc = (Account) session.getAttribute("acc");
		session.setAttribute("acc", acc);

		if (action != null) {

			if (action.equals("Detail")) {
				bookId = request.getParameter("id");
				book = listBook.getBook(bookId);
				session.setAttribute("current", book);
				nextPage = "/bookstore/product.jsp";
				session.setAttribute("acc", acc);
			}
			if (action.equals("AddToCart")) {
				bookId = request.getParameter("id");
				accId = request.getParameter("accId");

				book = listBook.getBook(bookId);
				if (book.getAmount() == 0) {
					nextPage = "/responsepage/OutOfStock.jsp";
				}

				if (book.getAmount() != 0) {
					cart.add(bookId, book);
					int currentAmount = cart.currentAmount(bookId);
					session.setAttribute("currentAmount", currentAmount);
					session.setAttribute("acc", acc);
				}
			}
			if (action.equals("Add")) {
				nextPage = "/form/AddBook.jsp";
			}
			if (action.equals("EditBook")) {
				bookId = request.getParameter("id");
				session.setAttribute("bookId", bookId);
				book = listBook.getBook(bookId);
				session.setAttribute("current", book);
				nextPage = "/form/EditBook.jsp";
			}
			if (action.equals("Delete")) {
				bookId = request.getParameter("id");
				listBook.deleteBook(bookId);

			}

			if (action.equals("UploadImage")) {
				nextPage = "/fileupload/uploadfile.jsp";

			}
			if (action.equals("UploadImage")) {
				nextPage = "/fileupload/uploadfile.jsp";

			}
			if (action.equals("AddAccount")) {
				nextPage = "/form/signup.jsp";

			}

		}

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
