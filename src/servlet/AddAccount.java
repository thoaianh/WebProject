package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListAccount;
import bean.ListBook;
import data.Account;
import data.BookDetails;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListAccount listAcc = (ListAccount) session.getAttribute("listAcc");
		if (listAcc == null) {
			listAcc = new ListAccount();
			session.setAttribute("listAcc", listAcc);
		}
		boolean ok = true;
		// doc cac tham so

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String role = request.getParameter("role");

		if ((name == null) || (name == "")) {
			ok = false;
		}
		if ((pass == null) || (pass == "")) {
			ok = false;
		}
		if ((phone == null) || (phone == "")) {
			ok = false;
		}
		if ((email == null) || (email == "")) {
			ok = false;
		}
		if ((address == null) || (address == "")) {
			ok = false;
		}
		if ((role == null) || (role == "")) {
			role = "custormer";
		}

		Pattern checkPhone = Pattern.compile("(\\d\\D*){10}");
		Matcher match = checkPhone.matcher(phone);
		if (!match.matches()) {
			ok = false;
			request.setAttribute("phoneErr", "Phone has 10 numbers");
			getServletContext().getRequestDispatcher("/form/signup.jsp").forward(request, response);

		}

		Pattern checkEmail = Pattern.compile("\\w+@\\w+(.\\w+)*");
		Matcher matchEmail = checkEmail.matcher(email);

		if (!matchEmail.matches()) {
			ok = false;
			session.setAttribute("emailErr", "Email error");
			getServletContext().getRequestDispatcher("/form/signup.jsp").forward(request, response);
		}

		if (ok && role.equals("custormer")) {
			listAcc.insert(new Account(String.valueOf(listAcc.getCount() + 1), name, pass, email, phone, address),
					role);

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/form/login.jsp");
			dispatcher.forward(request, response);
		}
		if (ok && role.equals("admin")) {
			listAcc.insert(new Account(String.valueOf(listAcc.getCount() + 1), name, pass, email, phone, address),
					role);

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ListBookServlet");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
