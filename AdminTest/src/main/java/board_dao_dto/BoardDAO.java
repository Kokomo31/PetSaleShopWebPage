package board_dao_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.MysqlConnPull;

public class BoardDAO extends MysqlConnPull {
	
	public BoardDAO() {
		super();
	}
	
	public List<BoardDTO> viewBoardList(Map<String, Object> map){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
				String searchKeyWord = "";
				String searchWord = "";
		
				int start = (int) map.get("start");
				int end =(int) map.get("end");
				if(  map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
					 searchKeyWord = map.get("searchKeyWord").toString();
					 searchWord = map.get("searchWord").toString();					
				}
				String query = "select b.board_num,b.board_title,board_content,board_viewcount,board_like,c.cate_name, m.m_name, board_regdate from board as b "
				+ "join category as c "
				+ "on c.cate_num = b.board_category "
				+ "join members as m "
				+"on  b.board_author = m.m_num ";
		
		if(  map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
		   query+= "where "+searchKeyWord+" like '%"+searchWord+"%' ";
		}
		query += "order by b.board_num desc "
				+ "limit ? , ?";
		
				
		try {
			psmt = conn.prepareStatement(query);
				

				psmt.setInt(1, start);
				psmt.setInt(2, end);
			
				rs = psmt.executeQuery();
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setBoard_num(rs.getInt(1));
				dto.setBoard_title(rs.getString(2));
				dto.setBoard_content(rs.getString(3));
				dto.setBoard_viewcount(rs.getInt(4));
				dto.setBoard_like(rs.getInt(5));
				dto.setBoard_category(rs.getString(6));
				dto.setBoard_author(rs.getString(7));
				dto.setBoard_regdate(rs.getDate(8));
				
				list.add(dto);
				
				
				
			}
		}
		catch (Exception e) {
			System.out.println("리스트반환실패");
			e.printStackTrace();
		}
		
			return list;
	}
	
	public int boardCount(Map<String, Object> map) {
		
		
		
		int totalCount =0;
		String query = "select count(*) from board as b "
				+ "join category as c "
				+ "on c.cate_num = b.board_category "
				+ "join members as m "
		 		+ "on  b.board_author = m.m_num ";
		if( map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
		  
			String searchKeyWord = map.get("searchKeyWord").toString();
			String searchWord = map.get("searchWord").toString();
			query +=" where "+searchKeyWord+" like "+"\"%\""+"'"+searchWord+"'"+"\"%\""+" ";
		}
	
		query += "order by b.board_num desc";
				
		try {
				
				
				psmt = conn.prepareStatement(query);			
				
				rs = psmt.executeQuery(query);			
				rs.next();
				totalCount = rs.getInt(1);
				
			
			
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return totalCount;
		}
	public int deleteBoard(int[] deleteNum) {
		int delNum = 0;
		int[] del = deleteNum;
		String query = "";
		if(del.length == 1 ) {
		 query = "delete from board where board_num = ?";
		}
		else {
		 query = "";
			for(int i =1; i < del.length; i++) {
			
				if(i == 1) {
					query = "delete from board where board_num = ?";
				}
				query += " or board_num = ? ";
			}
			
		}
		try {
			
			  psmt = conn.prepareStatement(query);
			  for(int i =0; i<del.length; i++) {
			  psmt.setInt(i+1 , del[i]); 
			  } 
			  delNum = psmt.executeUpdate();
			  System.out.println(delNum+"개의 게시물이 삭제되었습니다!");
			 
			
		}
		catch (Exception e) {
			System.out.println("회원삭제중 문제발생!");
			e.printStackTrace();
		}
		return delNum;
	}
	public BoardDTO boardviewMore (int viewNum) {
		
		BoardDTO dto = new BoardDTO();
		
		String query = "select m.m_name,"
				+ "board_title,"
				+ "board_content,"
				+ "board_viewcount,"
				+ "board_like,"
				+ "c.cate_name,"
				+ "board_num,"
				+ "board_regdate from board as b join category as c "
				+ "on c.cate_num = b.board_category "
				+ "join members as m "
				+ "on b.board_author = m.m_num "
				+ "where board_num = ? ";
				
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1 , viewNum);
			rs = psmt.executeQuery();
			rs.next();
			dto.setBoard_author(rs.getString(1));
			dto.setBoard_title(rs.getString(2));
			dto.setBoard_content(rs.getString(3));
			dto.setBoard_viewcount(rs.getInt(4));
			dto.setBoard_like(rs.getInt(5));
			dto.setBoard_category(rs.getString(6));
			dto.setBoard_num(rs.getInt(7));
			dto.setBoard_regdate(rs.getDate(8));
			
			
			
		}
		catch (Exception e) {
			System.out.println("게시물보기중오류");
			e.printStackTrace();
		}
		return dto;
	}
	public void updateBoardViewNum(int boardNum) {
		
		String query = "update board set board_viewcount = board_viewcount+1 where board_num = ?" ;
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, boardNum);
			psmt.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println("조회수 올리기중 오류발생");
			e.printStackTrace();
		}
	}
	public int writeboard(Map<String, Object> map) {
		int result = 0;
		String query = "insert into board values(null,?,?,?,null,0,0,?,current_timestamp)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(map.get("user_num").toString()));
			psmt.setString(2, (String)map.get("title"));
			psmt.setString(3, (String)map.get("content"));
			psmt.setString(4, (String)map.get("category"));
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시글 작성중 오류발생");
			e.printStackTrace();
		}
		return result;
		
	}
	public int writeAdminBoard(Map<String, Object> map) {
		int result = 0;
		String query = "insert into board values(null,?,?,?,?,0,0,2,current_timestamp)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1,  Integer.parseInt((String)map.get("b_author") )   );
			psmt.setString(2, (String)map.get("b_title"));
			psmt.setString(3, (String)map.get("b_content"));
			psmt.setString(4, (String)map.get("Filename"));
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("분양글 게시글 작성중 오류발생");
			e.printStackTrace();
		}
		return result;
	
	}
	public List<BoardDTO>  guestviewBoardList(Map<String, Object> map){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
				String searchKeyWord = "";
				String searchWord = "";
		
				int start = (int) map.get("start");
				int end =(int) map.get("end");
				if(  map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
					 searchKeyWord = map.get("searchKeyWord").toString();
					 searchWord = map.get("searchWord").toString();					
				}
				String query = "select b.board_num,b.board_title,board_content,board_viewcount,board_like,c.cate_name, m.m_name, board_regdate from board as b "
				+ "join category as c "
				+ "on c.cate_num = b.board_category "
				+ "join members as m "
				+"on  b.board_author = m.m_num "
				+ "where c.cate_name not in ('분양글') ";
		
		if(  map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
		   query+= " and "+searchKeyWord+" like '%"+searchWord+"%'";
		}
		query += "order by b.board_num desc "
				+ "limit "+start+","+end+"";
		
				
		try {
			psmt = conn.prepareStatement(query);
				

				
			
				rs = psmt.executeQuery();
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setBoard_num(rs.getInt(1));
				dto.setBoard_title(rs.getString(2));
				dto.setBoard_content(rs.getString(3));
				dto.setBoard_viewcount(rs.getInt(4));
				dto.setBoard_like(rs.getInt(5));
				dto.setBoard_category(rs.getString(6));
				dto.setBoard_author(rs.getString(7));
				dto.setBoard_regdate(rs.getDate(8));
				
				list.add(dto);
				
				
				
			}
		}
		catch (Exception e) {
			System.out.println("리스트반환실패");
			e.printStackTrace();
		}
		
			return list;
	}
public int guestboardCount(Map<String, Object> map) {
		
		
		
		int totalCount =0;
		String query = "select count(*) from board as b "
				+ "join category as c "
				+ "on c.cate_num = b.board_category "
				+ "join members as m "
		 		+ "on  b.board_author = m.m_num "
		 		+ "where c.cate_name not in ('분양글') ";
		
		if( map.get("searchKeyWord") != null && map.get("searchWord")!= null)	{
		  
			String searchKeyWord = map.get("searchKeyWord").toString();
			String searchWord = map.get("searchWord").toString();
			query +=" and "+searchKeyWord+" like "+"'%"+searchWord+"%'";
		}
	
		query += " order by b.board_num desc";
				
		try {
				
				
				psmt = conn.prepareStatement(query);			
				
				rs = psmt.executeQuery(query);			
				rs.next();
				totalCount = rs.getInt(1);
				
			
			
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return totalCount;
		}
}

