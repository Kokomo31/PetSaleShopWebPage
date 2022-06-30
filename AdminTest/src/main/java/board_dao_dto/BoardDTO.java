package board_dao_dto;

import pet_dao_dto.PetDTO;

public class BoardDTO {
	private int board_num; 
	private String	board_author; 
	private String	board_title;
	private	String board_content; 
	private	String board_img;
	private	int board_viewcount;
	private	int board_like; 
	private	String board_category;
	private	java.sql.Date board_regdate;
	private BoardCommentDTO commDTO;
	private PetDTO petInfo;
	
	
	public PetDTO getPetInfo() {
		return petInfo;
	}
	public void setPetInfo(PetDTO petInfo) {
		this.petInfo = petInfo;
	}
	public BoardCommentDTO getCommDTO() {
		return commDTO;
	}
	public void setCommDTO(BoardCommentDTO commDTO) {
		this.commDTO = commDTO;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_author() {
		return board_author;
	}
	public void setBoard_author(String board_author) {
		this.board_author = board_author;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_img() {
		return board_img;
	}
	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}
	public int getBoard_viewcount() {
		return board_viewcount;
	}
	public void setBoard_viewcount(int board_viewcount) {
		this.board_viewcount = board_viewcount;
	}
	public int getBoard_like() {
		return board_like;
	}
	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public java.sql.Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(java.sql.Date board_regdate) {
		this.board_regdate = board_regdate;
	}
}
