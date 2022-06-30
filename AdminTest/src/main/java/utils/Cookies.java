package utils;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	
	public static void setCookies(HttpServletResponse resp , HttpServletRequest req , 
						   String cname,  int ctime, String cvalue ) {
		
		Cookie cookie = new Cookie(cname,cvalue);
		cookie.setPath(req.getContextPath());
		cookie.setMaxAge(ctime);
		resp.addCookie(cookie);
		
	}
	public static String readCookies(HttpServletRequest req , String cname) {
		String cookieVal = "";
		
		Cookie[] cookies = req.getCookies();
		
		for(Cookie c : cookies) {
			String cookiename = c.getName();
			if(cookiename.equals(cname)) {
				 cookieVal = c.getValue();
			}
		}
		return cookieVal;
	}

}
