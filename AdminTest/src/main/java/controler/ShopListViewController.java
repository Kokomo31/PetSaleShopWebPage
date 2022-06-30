package controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import board_dao_dto.BoardDTO;
import pet_dao_dto.PetDAO;
import pet_dao_dto.PetDTO;

@WebServlet("/controler/petboardlist.do")
public class ShopListViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		String searchKeyWord = req.getParameter("searchKeyWord");
		String searchWord = req.getParameter("searchWord");
		
		ServletContext applicaiton = req.getServletContext();
		
		int posts_per_page	= Integer.parseInt(applicaiton.getInitParameter("SHOP_POSTS_PER_PAGE"));
		
		int start = (pageNum -1) * posts_per_page ;
		int end = 8;		
		map.put("animalPage", posts_per_page);
		map.put("start", start);
		map.put("end", end);
		map.put("pageNum", pageNum);
		map.put("searchKeyWord", searchKeyWord);
		map.put("searchWord", searchWord);
		
		JSONObject arr = JSONlistGET(map);
		
		JSONParser parse = new JSONParser();
		
		String ars = arr.toString();
		
		//req.setAttribute("boardLists", arr );
		
		resp.getWriter().write(ars);
		
	}
	protected JSONObject JSONlistGET(Map<String, Object> map) {	
		PetDAO dao = new PetDAO();
		List<BoardDTO> petlist = dao.PetListView(map);	
		dao.close();
		JSONObject topObject = new JSONObject();
		
		JSONArray jsonboardArray = new JSONArray();
		JSONArray jsonPetsArray = new JSONArray();
		System.out.println(petlist.size());
		for(int i =0; i<petlist.size(); i++) {
			JSONObject boardobject = new JSONObject();
			JSONObject animalobject = new JSONObject();
	
			boardobject.put("board_title",petlist.get(i).getBoard_title() );
			boardobject.put("board_like",petlist.get(i).getBoard_like());
			boardobject.put("board_viewcount",petlist.get(i).getBoard_viewcount());
			boardobject.put("board_img",petlist.get(i).getBoard_img());
			animalobject.put("pet_name", petlist.get(i).getPetInfo().getA_name());
			animalobject.put("pet_gender",petlist.get(i).getPetInfo().getA_gender());
			animalobject.put("pet_price",petlist.get(i).getPetInfo().getA_price());
			animalobject.put("pet_type", petlist.get(i).getPetInfo().getA_type());
			animalobject.put("pet_species",petlist.get(i).getPetInfo().getA_species());
			
				
			jsonPetsArray.add(animalobject);
			boardobject.put("petsobj", jsonPetsArray);
			jsonboardArray.add(boardobject);
		}
		
		
		topObject.put("boardLists", jsonboardArray);
		return topObject;
		
		
		
	}
}
