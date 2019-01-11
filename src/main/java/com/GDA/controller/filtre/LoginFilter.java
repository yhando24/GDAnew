
package main.java.com.GDA.controller.filtre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/loginfilter")
public class LoginFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("LogFilter init!");

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here

		/* Cast request and response object */

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		/* Récupération de la session depuis la requête */

		HttpSession session = ((HttpServletRequest) request).getSession();

		/**
		 * 
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * 
		 * l'utilisateur n'est pas connecté.
		 * 
		 */

		if (session.getAttribute("user") == null) {

			// No logged-in user found, so redirect to login page.
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");

		} else {

			/* Logged-in user found, so just continue request to loginServlet */

			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
