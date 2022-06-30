package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;

import board_dao_dto.BoardDAO;
import board_dao_dto.BoardDTO;
import member_dao_dto.MemberDAO;
import member_dao_dto.MemberDTO;
import utils.Getpaging;

@WebServlet("/controler/boardlist.do")
public class BoardListViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Map paramMap = req.getParameterMap();
		Iterator it = paramMap.keySet().iterator();
		String params ="";
		String key = null;
		String[] value = null;
		int j = 0;
		while(it.hasNext()) {
			key = (String) it.next();
			value = (String[]) paramMap.get(key);			
			
			for(int i =0; i <value.length; i++) {
				System.out.println(key);
				if(j == 0 &&   ! key.equals("pageNum")&&! key.equals("ID")&&! key.equals("Pass")) {
					params += key+"="+value[i];
				}					
				else if(key.equals("pageNum")){
					params += "";
				}
				else if(j >= 1 && ! key.equals("pageNum")&&! key.equals("ID")&&! key.equals("Pass") ) {
					params += "&"+key+"="+value[i];	
					
				}
				
			}
			j++;		
		}
		
			
		
		
		
		
			
		HttpSession session = req.getSession();
		String user_type = (String)session.getAttribute("user_type");
		ServletContext application = getServletContext();
		
		Map<String, Object> map = new HashedMap<String, Object>();
		BoardDAO dao = new BoardDAO();
		Getpaging paging = new Getpaging();
		
		int posts_per_page	= Integer.parseInt(application.getInitParameter("BOARD_POSTS_PER_PAGE"));
		int pages_per_block =  Integer.parseInt(application.getInitParameter("BOARD_PAGES_PER_BLOCK")); 
		String searchWord = req.getParameter("searchWord");
		String searchKeyWord = req.getParameter("searchKeyWord");
		int totalCount = 0;
		
		map.put("searchWord",searchWord);
		map.put("searchKeyWord",searchKeyWord);
		
		if(user_type.equals("guest")) {
			totalCount = dao.guestboardCount(map);
		}
		else {
			totalCount = dao.boardCount(map);
		}
		
		
		
		//pageTemp = 현재페이지
		int pagenum = 1;
	
	
		  String pageTemp = req.getParameter("pageNum");
		  
		  if(pageTemp != null && ! pageTemp.equals("")) {
			 
			  pagenum = Integer.parseInt(pageTemp);
			  
		  }
		  
		  int start = ((pagenum-1) * posts_per_page);	
		  int end = pages_per_block;
		  
		  map.put("pagenum", pagenum);
		  map.put("start", start);
		  map.put("end", end);
		
		  List<BoardDTO> boardLists = new ArrayList<BoardDTO>();
		
		
		if(user_type.equals("guest")) {
			 boardLists = dao.guestviewBoardList(map);
		}
		else {
			
			 boardLists = dao.viewBoardList(map);
		}
		
		String pageingStr = paging.Getpage(totalCount, posts_per_page, pages_per_block, pagenum, "../controler/boardlist.do",params);
		
		dao.close();
		
		
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("pagingStr" , pageingStr);
		req.setAttribute("map", map);
		//view로 포워드를 걸어준다.
		if(user_type.equals("admin")) {
			req.getRequestDispatcher("/Admin/boardmaintain.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/Admin/noadmin/boardview.jsp").forward(req, resp);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	}

