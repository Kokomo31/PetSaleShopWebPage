package member_dao_dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.MysqlConnPull;

public class MemberDAO extends MysqlConnPull {
	
	public MemberDAO() {
		super();
	}
	public int totalCount (Map<String, Object> map) {
		int totalCount = 0 ;
		if(map.get("searchWord") != null &&  ! map.get("searchWord").equals("") ) {
			String query = "select count(*) from members where m_id like ? ";
			try {
				psmt=conn.prepareStatement(query);
				psmt.setString(1 , "%"+map.get("searchWord")+"%");
				rs = psmt.executeQuery();
				rs.next();
				totalCount = rs.getInt(1);
				System.out.println("검색어 반영숫자"+totalCount);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return totalCount;
			
		}
		else {
			String query = "select count(*) from members";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
		}
		
	}
	public List<MemberDTO> showMemberList(Map<String, Object> map) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		if(map.get("searchWord") == null) {
			String query = "select * from members orders limit ? , ?";
			try {
				psmt = conn.prepareStatement(query);
				psmt.setInt(1 , (int)map.get("start"));
				psmt.setInt(2 , (int)map.get("end"));
				
				rs = psmt.executeQuery();
				while(rs.next()) {
					MemberDTO dto = new MemberDTO();
					dto.setM_num(rs.getInt(1));
					dto.setM_name(rs.getNString(2));
					dto.setM_gender(rs.getString(3));
					dto.setM_id(rs.getString(4));
					dto.setM_pass(rs.getString(5));
					dto.setM_type(rs.getString(6));
					
					list.add(dto);
					
				}
			}
			catch (Exception e) {
				System.out.println("게시물조회중 오류");
				e.printStackTrace();
			}
			return list;
			}
		else {
			String query = "select * from members orders where m_id like ? limit ? , ?";
			try {
				psmt = conn.prepareStatement(query);
				psmt.setString(1 , "%"+map.get("searchWord")+"%");
				psmt.setInt(2 , (int)map.get("start"));
				psmt.setInt(3 , (int)map.get("end"));
			
				rs = psmt.executeQuery();
				while(rs.next()) {
					MemberDTO dto = new MemberDTO();
					dto.setM_num(rs.getInt(1));
					dto.setM_name(rs.getNString(2));
					dto.setM_gender(rs.getString(3));
					dto.setM_id(rs.getString(4));
					dto.setM_pass(rs.getString(5));
					dto.setM_type(rs.getString(6));
				
					list.add(dto);
				
			}
		}
		catch (Exception e) {
			System.out.println("게시물조회중 오류");
			e.printStackTrace();
		}
		return list;
		}
	
		
		
		
	}
	public int deleteMember(int[] deleteNum) {
		int delNum = 0;
		int[] del = deleteNum;
		String query = "";
		if(del.length == 1 ) {
		 query = "delete from members where m_num = ?";
		}
		else {
		 query = "";
			for(int i =1; i < del.length; i++) {
			
				if(i == 1) {
					query = "delete from members where m_num = ?";
				}
				query += " or m_num = ? ";
			}
			
		}
		try {
			
			  psmt = conn.prepareStatement(query);
			  for(int i =0; i<del.length; i++) {
			  psmt.setInt(i+1 , del[i]); 
			  } 
			  delNum = psmt.executeUpdate();
			 
			 
			
		}
		catch (Exception e) {
			System.out.println("회원삭제중 문제발생!");
			e.printStackTrace();
		}
		return delNum;
	}
	public String[] LoginMember(String id, String pass) {
		String[] user_info = new String[3];
		String query = "select m_name,m_type,m_num from members where m_id = ? and m_pass = ? ";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				String user_name = rs.getString(1);
				String user_type = rs.getString(2);
				int user_num = rs.getInt(3);
				user_info[0] = user_name;
				user_info[1] = user_type;
				user_info[2] = String.valueOf(user_num);
			}
			
			
			}
		catch (Exception e) {
			System.out.println("로그인정보 찾기 실패");
			e.printStackTrace();
		}
		return user_info;
	}
	public int registMember(String[] mem) {	
		int result = 0;
		String query = "insert into members values(null,?,?,?,?,'guest')";
		try {
			
			psmt = conn.prepareStatement(query);
			psmt.setString(1, mem[0]);
			psmt.setString(2,mem[1]);
			psmt.setString(3, mem[2]);
			psmt.setString(4, mem[3]);
			result = psmt.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println("유저가입중 오류발생");
			e.printStackTrace();
			
		}
		return result;
	}
	
}
