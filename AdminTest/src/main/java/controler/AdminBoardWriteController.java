package controler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import board_dao_dto.BoardDAO;
import board_dao_dto.BoardDTO;
import pet_dao_dto.PetDAO;
import pet_dao_dto.PetDTO;
import utils.JSutils;
@WebServlet("/controler/adminboardwrite.do")
public class AdminBoardWriteController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		String saveDirectroy = application.getRealPath("/Uploads");
		int maxPostSize = 1024*1000;
		String encoding = "UTF-8";
		System.out.println(saveDirectroy);
		try {
			
			MultipartRequest mr = new MultipartRequest(req, saveDirectroy, maxPostSize,encoding);
			  
			String fileName = mr.getFilesystemName("attachedFile"); String ext = fileName.substring(fileName.lastIndexOf(".")); 
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String newFileName =now +ext;
			  
			File oldFile = new File(saveDirectroy+File.separator+fileName); 
			File newFile= new File(saveDirectroy+File.separator+newFileName);
			oldFile.renameTo(newFile);

			Map<String, Object> b_map = new HashMap<String, Object>();
			Map<String, Object> p_map = new HashMap<String, Object>();
			
			BoardDAO b_dao = new BoardDAO();
			PetDAO p_dao = new PetDAO();
			
			String a_name = mr.getParameter("a_name"); 
			String a_gender = mr.getParameter("a_gender"); 
			String a_health = mr.getParameter("a_health");
			String a_price = mr.getParameter("a_price"); 
			String a_type = mr.getParameter("a_type"); 
			String a_species = mr.getParameter("a_species");
			String b_title = mr.getParameter("b_title"); 
			String b_content =mr.getParameter("b_content"); 
			String b_author =(String)session.getAttribute("user_num");
			
			b_map.put("b_title", b_title);
			b_map.put("b_content",b_content);
			b_map.put("b_author",b_author);
			b_map.put("Filename", newFileName);
			
			b_dao.writeAdminBoard(b_map);
			b_dao.close();
			
			p_map.put("a_name",a_name);
			p_map.put("a_gender",a_gender);
			p_map.put("a_health",a_health);
			p_map.put("a_price",a_price);
			p_map.put("a_type",a_type);
			p_map.put("a_species",a_species);
			
			int a_result = p_dao.updatePet(p_map);
			p_dao.close();
			
			if(a_result != 1) {
				resp.sendRedirect(req.getHeader("Referer"));
				JSutils.Justalert(resp, "글작성안됨!");
			}
			else {
				resp.sendRedirect(req.getHeader("Referer"));
			}
			
			
		}
		catch (Exception e) {
			System.out.println("분양글작성서블릿에서 오류발생");
			e.printStackTrace();
		}
		
	}

}
