//package main.java.com.GDA.controller.filtre;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import main.java.com.GDA.bean.User;
//
///**
// * Servlet Filter implementation class LoginFilter
// */
//@WebFilter("/LoginFilter")
//public class LoginFilter implements Filter {
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("LogFilter init!");
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// place your code here
//		
//		HttpServletRequest req = (HttpServletRequest) request;
//		User user = (User) req.getSession().getAttribute("user");
//
//		if (user != null && user.isLogedIn()) {
//			chain.doFilter(request, response);
//		}
//		else {
//			 HttpServletResponse res = (HttpServletResponse) response;
//			 res.sendRedirect(req.getContextPath() + "/login");
//		}
//		
//		
//		
//		// Check if session already exists
//
////no existing session => redirect to login doPost
//		
//		
//		
//		
//		
//		
//
//		boolean sessionExist = false;
//
//		if (request instanceof HttpServletRequest) {
//			
//			HttpSession session = ((HttpServletRequest) request).getSession(false);
//
//			if (session != null) {
//
//				User user = (User) session.getAttribute("user");
//
//				if (user != null) {
//					sessionExist = true;
//				}
//			}
//
//			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request)) request).getContextPath() + "/WEB-INF/view/Login.java");
//
//		} else {
//			chain.doFilter(request, response);
//		}
//
//// session already exists => redirect to dispatchFilter depended on the function
//
//		if (sessionExist = true) {
//			
//		
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/view/home.java");
//
//		}
//
//		// pass the request along the filter chain
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//	}
//
//}
