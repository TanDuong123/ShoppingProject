package ASMJava5.Service;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse resp;
	
	public Cookie setCookie(String name, String value, int days) {
		Cookie cookie= new Cookie(name, value);
		cookie.setMaxAge(days*60*60);
		cookie.setPath("/");
		return cookie;
	}
	public Cookie get(String name) {
		Cookie[] cookies= req.getCookies();
		if(cookies !=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) return cookie;
			}
		}
		return null;
	}
}
