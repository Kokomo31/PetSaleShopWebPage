package pet_dao_dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxCrud.Limit;

import board_dao_dto.BoardDTO;
import db.MysqlConnPull;

public class PetDAO extends MysqlConnPull {
	
	public PetDAO() {
		super();
	}
	
	public List<BoardDTO> PetListView(Map<String, Object> map) {
	
		List<BoardDTO> petBoardList= new ArrayList<BoardDTO>(); 
		try {
			
			String query ="select board_title,board_like,board_viewcount,board_img,a_name,"
						+ "a_gender,a_price,a_type,a_species "
						+ "from board as b inner join animals as a "
						+ "on a.a_num = b.board_num ";
			if(map.get("SearchKeyWord")!=null && map.get("SearchWord")!=null ) {
				
				query +=  "where ? like concat ('%', ?, '%') ";			
			}	
			if(map.get("start")!=null && map.get("end")!=null) {
				
				query +=  "limit ? , ?";
			}	
			psmt = conn.prepareStatement(query);
			
			if(map.get("SearchKeyWord")!=null && map.get("SearchWord")!=null 
					&& (map.get("start")!=null && map.get("end")!=null )) {
				
				psmt.setString(1,(String)map.get("SearchKeyWord"));
				psmt.setString(2,(String)map.get("SearchWord"));
				psmt.setInt(3, (int) map.get("start"));
				psmt.setInt(4, (int) map.get("end"));
				
			}
			
			else if(map.get("SearchKeyWord")==null && map.get("SearchWord")==null){
				
				psmt.setInt(1, (int) map.get("start"));
				psmt.setInt(2, (int) map.get("end"));
			}
			rs = psmt.executeQuery();
			while(rs.next()) {
				PetDTO dto = new PetDTO();
				BoardDTO bdto = new BoardDTO();
				bdto.setBoard_title(rs.getString(1));
				bdto.setBoard_like(rs.getInt(2));				
				bdto.setBoard_viewcount(rs.getInt(3));
				bdto.setBoard_img(rs.getString(4));
				dto.setA_name(rs.getString(5));
				dto.setA_gender(rs.getString(6));
				dto.setA_price(rs.getInt(7));
				dto.setA_type(rs.getString(8));
				dto.setA_species(rs.getString(9));
				bdto.setPetInfo(dto);
				petBoardList.add(bdto);
			}
			
		}
		catch (Exception e) {
			System.out.println("펫목록불러오기 실패!");
			e.printStackTrace();
		}
		
		return petBoardList;
	
	}
	
	public int updatePet(Map<String, Object> map) {
		int a_result = 0;
		String query = "update animals set a_name = ? , a_health = ? , a_gender = ?, a_price = ? , a_type = ?, a_species = ? "
				+ "where a_name = 'new' ";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, (String)map.get("a_name"));
			psmt.setString(2, (String)map.get("a_gender"));
			psmt.setString(3, (String)map.get("a_health"));
			psmt.setInt(4, Integer.parseInt(String.valueOf(map.get("a_price"))));
			psmt.setString(5, (String)map.get("a_type"));
			psmt.setString(6, (String)map.get("a_species"));
			a_result = psmt.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println("업데이트중 문제발생");
			e.printStackTrace();
		}
		return a_result;
	}
	
	
}
