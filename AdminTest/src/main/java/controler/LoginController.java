package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import member_dao_dto.MemberDAO;
import member_dao_dto.MemberDTO;
import utils.JSutils;

@WebServlet("/controler/login.do")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		  String backURI = req.getHeader("Referer").substring(req.getHeader("Referer").indexOf("/AdminTest/"));
		 
		   
			/*
			 * for(int i =0; i<backURI.length; i++) {
			 * 
			 * if(i>=4 && i != backURI.length-1) {
			 * 
			 * backStr += backURI[i]+"/"; } else if(i == backURI.length-1) { backStr +=
			 * backURI[i]; }
			 * 
			 * } System.out.println(backStr);
			 */
		 
		
		boolean sucessOrfail = false;
		
		MemberDAO dao = new MemberDAO();
		
	
		HttpSession session = req.getSession();	
		
		String user_id = req.getParameter("ID");
		
		String user_pass = req.getParameter("Pass");
		
		String[] user_info = dao.LoginMember(user_id, user_pass);
		
		dao.close();
		
		String user_name = "";
		
		String user_type = "";
		
		String user_num = "";
		
		
		if(user_info.length >= 2) {
			 user_name = user_info[0];
			
			 user_type = user_info[1];
			 
			 user_num = user_info[2];
		}
		
		
		//session.removeAttribute(user_name);
		//session.removeAttribute(user_type);
		
		String passURI = (String)req.getAttribute("passURI");
		
		String controllerPassURI = (String)req.getParameter("controllerPassURI");
		if(req.getParameter("controllerPassURI") == null) {
			controllerPassURI = "";
		}
		
		if(backURI.contains("/Admin/")) {			  
			backURI = "/Admin/";
		}
		else if(backURI.contains("/controler/")) {
			passURI = backURI.substring(backURI.lastIndexOf("/")+1,backURI.lastIndexOf("do")+2);
			if(!backURI.contains("login.do") && controllerPassURI.equals("") ){
				controllerPassURI = backURI.substring(backURI.lastIndexOf("/")+1,backURI.lastIndexOf("do")+2);
			}
			backURI ="/controler/";
		 }		
		if(user_name != null && ! user_name.equals("")) {
			session.setAttribute("user_name",user_name);
			session.setAttribute("user_type", user_type);
			session.setAttribute("user_id",user_id);
			session.setAttribute("user_num", user_num);
			sucessOrfail = true;
			
		}
		req.setAttribute("sucessOrfail", sucessOrfail);
		
		
		if (!sucessOrfail) {
			req.setAttribute("controllerPassURI", controllerPassURI);
			req.getRequestDispatcher("/Admin/login.jsp").forward(req, resp);
		}
		else if(sucessOrfail && user_type.equals("admin")) {
				
			if(passURI == null )  {
				req.getRequestDispatcher("/Admin/index.jsp").forward(req, resp); }
				 
			if(passURI != null && ! passURI.equals("/controler/login.do")) {
				req.getRequestDispatcher(backURI+controllerPassURI).forward(req, resp);
			}	
			else if(passURI != null &&  passURI.equals("/controler/login.do")) {
				resp.sendRedirect("../Admin/login.jsp?") ;
			}
		}
		else {
			resp.sendRedirect("/AdminTest/Admin/noadmin/shopview-index.jsp");
		}
	}
		
		
}

	
	

