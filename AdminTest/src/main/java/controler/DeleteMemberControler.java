package controler;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import board_dao_dto.BoardDAO;
import board_dao_dto.BoardDTO;
import member_dao_dto.MemberDAO;
import utils.JSutils;

@WebServlet("/controler/delete.do")
public class DeleteMemberControler extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSutils js = new JSutils();
		
		String backURI = req.getHeader("Referer");
		
		System.out.println(backURI);
		
		String testStr = backURI.substring(backURI.lastIndexOf("/")+1);
		
		String deleteNums[] = req.getParameterValues("checkedvalue");
		 	
		int deleteNumI[] = Arrays.stream(deleteNums).mapToInt(Integer::parseInt).toArray();
		
		
		
		switch (testStr) { 
		  
			case"boardlist.do":
		  		BoardDAO Bdao = new BoardDAO();
		  		int del = Bdao.deleteBoard(deleteNumI);
		  		Bdao.close();		  		
		  		JSutils.alertLocation(resp, del+"개 의 게시물이 삭제 되었습니다", backURI); 
		  		break;
		  
		  	case"list.do":
		  		MemberDAO dao = new MemberDAO();
		  		int Mdel = dao.deleteMember(deleteNumI); dao.close();
			  	dao.close();
			  	JSutils.alertLocation(resp, Mdel+"명의 회원이 삭제되었습니다 ", backURI);			  	
			  	break;
			  	
		  	case"moreview.do":
		  		BoardDAO MBdao = new BoardDAO();
		  		MBdao.deleteBoard(deleteNumI);
		  		MBdao.close();
		  	    JSutils.alertLocation(resp, "게시물이 삭제 되었습니다", "../controler/boardlist.do");
		  		break;
		}
		
			
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}


