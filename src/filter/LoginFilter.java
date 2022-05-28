package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import data.Users;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	private FilterConfig fcon;

	public LoginFilter() {

	}

	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

//        
//            String role= fcon.getInitParameter("role");
//            session.setAttribute("role", role);
//            String userRole= (String) session.getAttribute("userRole"); 
		Users user = (Users) session.getAttribute("user");

		boolean isLoggedIn = (session != null && user != null);

		if (!isLoggedIn) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/CheckLogin");
			dispatcher.forward(request, response);
		} else if (isLoggedIn) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ListBookServlet");
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		fcon = fConfig;

	}

}
