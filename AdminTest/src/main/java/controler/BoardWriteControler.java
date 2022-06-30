package controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board_dao_dto.BoardDAO;
import utils.JSutils;

@WebServlet("/controler/boardwrite.do")
public class BoardWriteControler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		BoardDAO dao = new BoardDAO();
		HttpSession session = req.getSession();
		String content =req.getParameter("content");
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String user_num =(String)session.getAttribute("user_num");
		
		
		map.put("content", content);
		map.put("category", category);
		map.put("title", title);
		map.put("user_num", user_num);
		
		int result = dao.writeboard(map);
		
		if(result == 1 ) {
			JSutils.Justalert(resp, result+"개의 글이 작성완료 되었습니다!");
			resp.sendRedirect("/AdminTest/controler/boardlist.do?&pageNum=1") ;
		}
		
		
		
	}
}
