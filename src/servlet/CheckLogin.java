package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CheckUser;
import bean.ListAccount;
import bean.ShoppingCart;
import data.Account;
import data.Users;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Users u = null;

		CheckUser check = (CheckUser) session.getAttribute("check");
		ListAccount listAcc = (ListAccount) session.getAttribute("listAcc");
		if (check == null) {
			check = new CheckUser();
			session.setAttribute("check", check);
		}
       //Tao bean
		if (listAcc == null) {
			listAcc = new ListAccount();
			session.setAttribute("listAcc", listAcc);
		}

	
		u = check.checkUser(name, pass);
		

		if (session != null && u != null) {
			session.setAttribute("user", u);
			Account acc = listAcc.getAccByUSerInfo(name, pass);
			session.setAttribute("acc", acc);
	
			String userRole = u.getRole();
			session.setAttribute("userRole", userRole);

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ListBookServlet");
			dispatcher.forward(request, response);
		}

		if (u == null && name==null && pass==null) {
			
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/form/login.jsp");
			dispatcher.forward(request, response);
		}
		
		if (u == null && name!=null && pass!=null) {
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/form/login_error.jsp");
				dispatcher.forward(request, response);
			}
		
//		if (session!=null && user!=null) {
//			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ListBookServlet");
//			dispatcher.forward(request, response);
//			}
//		
//		
		
	
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
