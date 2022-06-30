package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member_dao_dto.MemberDAO;
import utils.JSutils;

@WebServlet("/controler/regist.do")
public class MemberRegisterController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int result = 0;
	MemberDAO dao = new MemberDAO();
	String name =	req.getParameter("user_name");
	String[] gender =	req.getParameterValues("user_gender");
	String user_gender = gender[0];
	String id =	req.getParameter("user_id");
	String pass =	req.getParameter("user_pass");
	
	String[] user_info = {name,user_gender,id,pass};
	
	result = dao.registMember(user_info);
	dao.close();
	if(result != 1 ) {
		
		resp.sendRedirect("/AdminTest/Admin/noadmin/shopview-index.jsp");
	}
	else {
		
		resp.sendRedirect("/AdminTest/Admin/noadmin/shopview-index.jsp");
	}
	
	
	
	
	
	}

}
