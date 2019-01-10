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

import main.java.com.GDA.bean.User;
import main.java.com.GDA.config.Role;

/**
 * Servlet Filter implementation class DispatchFilter
 */
@WebFilter("/dispatchfilter")
public class DispatchFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * Default constructor.
	 */
	public DispatchFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);

		User u2 = (User) session.getAttribute("user");

		System.out.println(u2.getFunction().getId());

		if (u2.getFunction().getId() == Role.ROLE_ADMIN.getValue()) {

			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/indexAdministrator"); // logged-in page Admin

		} else if (u2.getFunction().getId() == Role.ROLE_MANAGER.getValue()) {

			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/indexManager"); // logged-in page Manager
		
		} else if (u2.getFunction().getId() == Role.ROLE_EMPLOYEE.getValue()) {

			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/indexEmployee"); // logged-in page Employee

		}
	}
//
//	} else {
//	// pass the request along the filter chain
//	chain.doFilter(request,response);
//
//	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
