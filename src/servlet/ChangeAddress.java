package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListAccount;

/**
 * Servlet implementation class ChangeAddress
 */
@WebServlet("/ChangeAddress")
public class ChangeAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accId=request.getParameter("accId");
	    String address= request.getParameter("accAddress");
	    System.out.println(address);
	    ListAccount listAcc=new ListAccount();
	    listAcc.updateAddress(address, accId);    
	    System.out.println( listAcc.updateAddress(address, accId));
	    
		
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/bookstore/address.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
