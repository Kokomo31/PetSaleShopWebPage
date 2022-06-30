package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board_dao_dto.BoardDAO;
import board_dao_dto.BoardDTO;
import member_dao_dto.MemberDAO;
import utils.Cookies;
import utils.JSutils;

@WebServlet("/controler/moreview.do")
public class ViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = (String)session.getAttribute("user_type");
		String backURI = req.getHeader("Referer");
		boolean isContain = false;
		
		String testStr = "";
		if(backURI.contains("?")) {
			
			 testStr = backURI.substring(backURI.lastIndexOf("/")+1,backURI.indexOf("?"));
		}
		else {
			 testStr = backURI.substring(backURI.lastIndexOf("/")+1);
		}
		
		String viewNumS = req.getParameter("viewNum");
		
		int viewNum = Integer.parseInt( req.getParameter("viewNum"));
		
		String readCookieVal = utils.Cookies.readCookies(req, "visited");
		
		String[] readCookieVals = readCookieVal.split("/");
		System.out.println(readCookieVal);
		
		
		if(readCookieVal.equals(null) || readCookieVal.equals("")) {
			
			utils.Cookies.setCookies(resp, req, "visited", 24*(60*60),viewNumS+"/" );
			
		}
		else if(readCookieVal != null && readCookieVal != "") {
			
			System.out.println("notnull");
			
			
			for(String c : readCookieVals) {
				if(c.equals(viewNumS)) {
					isContain = true;
					break;
				}
			}
			
		}
		System.out.println(testStr);
		
		switch (testStr) { 
		  
			case"boardlist.do":
		  		BoardDAO Bdao = new BoardDAO();
		  		BoardDTO dto =	Bdao.boardviewMore(viewNum);
		  		if(dto.getBoard_content() != "" && dto.getBoard_content() != null ) {
		  			dto.setBoard_content(dto.getBoard_content().replaceAll("\r\n", "<br>"));
		  		}
		  		else {
		  			dto.setBoard_content("");
		  		}
		  		if(user.equals("guest") && isContain == false) {
		  			utils.Cookies.setCookies(resp, req, "visited", 24*(60*60),readCookieVal+"/"+viewNumS );
		  			Bdao.updateBoardViewNum(viewNum);
		  		}
		  		Bdao.close();
		  		req.setAttribute("dto", dto);
		  		if(user.equals("admin")) {
		  			req.getRequestDispatcher("/Admin/adminBoardviewMore.jsp").forward(req, resp);			
		  		}
		  		else {
		  			req.getRequestDispatcher("/Admin/noadmin/boardviewMore.jsp").forward(req, resp);	
		  		}
		  		break;
		  
		  	case"list.do":
		  		MemberDAO dao = new MemberDAO();
		  		//dao.deleteMember(); dao.close();
			  	dao.close();
			  	System.out.println("list");
			  	resp.sendRedirect(backURI); 
			  	break;
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	}


