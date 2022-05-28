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

import bean.ShoppingCart;
import data.Account;
import data.Bill;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String page = "/bookstore/cart.jsp";
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		 Account acc= (Account) session.getAttribute("acc");
	
		String bookId = request.getParameter("id");
		String accId=request.getParameter("accId");
		String action = request.getParameter("action");
		
		

		if (action != null) {
			if (action.equals("Remove")) {
				cart.remove(bookId);
			}
			if (action.equals("Decrease")) {
				if(cart.getBookICById(bookId).getQuantity()>=1) {
				cart.getBookICById(bookId).decrementQuantity();
				}
				if(cart.getBookICById(bookId).getQuantity()==0) {
					cart.remove(bookId);
				}
				
			}
			if (action.equals("Increase")) {
				if((cart.getBookICById(bookId).getQuantity()< cart.currentAmount(bookId))){
				cart.getBookICById(bookId).incrementQuantity();
				}
			}
			if (action.equals("SeeBill")) {
			
				page = "/bookstore/checkout.jsp";
			}
			if (action.equals("Checkout")) {
				
			    cart.buy(cart, accId);
			
				ShoppingCart cartAfterBuy=(ShoppingCart) session.getAttribute("cart");
				session.setAttribute("cartAfterBuy", cartAfterBuy);
				
				String date= (String) cart.dayReceive(java.time.LocalDate.now());
				session.setAttribute("receiveDay", date);
				
				List<Bill> listBill=cart.getBill(cart, accId);
				
				session.setAttribute("listBill", listBill);
				
				cart.clearCart();
				page = "/responsepage/ResponseToCheckout.jsp";
			
			}
		}

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
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
