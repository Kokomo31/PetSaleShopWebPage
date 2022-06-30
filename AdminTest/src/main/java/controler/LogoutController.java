package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controler/logout.do")
public class LogoutController extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			String user_type = (String)session.getAttribute("user_type");
			
			if(user_type == "admin")
			resp.sendRedirect("/AdminTest/Admin/login.jsp");
			else {
			resp.sendRedirect("/AdminTest/Admin/noadmin/shopview-index.jsp");
			}
			
			
			session.removeAttribute("user_id");
			session.removeAttribute("user_type");
			session.removeAttribute("user_name");
			session.removeAttribute("user_num");
		}
}
