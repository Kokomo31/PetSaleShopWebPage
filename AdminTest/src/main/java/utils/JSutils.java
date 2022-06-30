package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSutils {

	
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			//컨텐츠 타입을 설정
			resp.setContentType("text/html;charset=UTF-8");
			//PrintWrite객체를 통해 스크립트를 서블릿에서 직접 출력한다.
			PrintWriter writer = resp.getWriter();
			String script = "" + "<script>" + "    alert('" + msg + "');" + "   location.href='" + url + "';"
					+ "</script>";
			writer.println(script);
		} catch (Exception e) {
		}
	}
	public static void Justalert(HttpServletResponse resp, String msg) {
		try {
			//컨텐츠 타입을 설정
			resp.setContentType("text/html;charset=UTF-8");
			//PrintWrite객체를 통해 스크립트를 서블릿에서 직접 출력한다.
			PrintWriter writer = resp.getWriter();
			String script = "" + "<script>" + "    alert('" + msg + "');" 
					+ "</script>";
			writer.println(script);
		} catch (Exception e) {
		}
	}
}
