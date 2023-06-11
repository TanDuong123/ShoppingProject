package ASMJava5.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import ASMJava5.Model.User;
import ASMJava5.Service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthIterceptor implements HandlerInterceptor{
//	@Autowired
//	SessionService session;
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		String uri= request.getRequestURI();
//		User user= (User)session.getAttribute("user");
//		String error="";
//		if(user==null) {
//			error="Please login!";
//		}
//		else if(!user.getRole() && uri.startsWith("/admin")){
//			error="Access denied!";
//		}
//		if(error.length() >0) {
//			session.setAttribute("security-uri", uri);
//			response.sendRedirect("/account/login?error="+error);
//			return false;
//		}
//		return true;
//	}
}