package filter;

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

import utils.JSutils;



@WebFilter(urlPatterns={"/controler/list.do","/controler/boardlist.do",
						"/controler/moreview.do","/controler/delete.do"})
public class CheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			HttpSession session = req.getSession(false);
			String passURI = req.getContextPath();
			System.out.println(passURI);
			req.setAttribute("passURI", passURI);
			
			
			boolean logOrNOt = false;
			
			
			if(session != null ) {
				
				if(session.getAttribute("user_name") != null  ) {
				logOrNOt = true;
				}
			
			}
			if(logOrNOt) {
				chain.doFilter(request, response);
			}
			else {
				JSutils.Justalert(resp, "로그인이 필요한 기능입니다!");
				req.getRequestDispatcher("/Admin/login.jsp").forward(req, resp);
			}
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
