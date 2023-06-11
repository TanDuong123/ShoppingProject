package ASMJava5.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import ASMJava5.Dao.CartItemDAO;
import ASMJava5.Model.User;
import ASMJava5.Service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserInterceptor implements HandlerInterceptor{
	@Autowired
	SessionService session;
	@Autowired
	CartItemDAO cartItemDao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		User user= new User();
		user= (User) session.getAttribute("user");
		String error="";
		if(user==null) {
			error="Please Login!";
			response.sendRedirect("/account/index");
			return false;
		}else {
			int amount=cartItemDao.getAmount(user.getUserName());
			session.setAttribute("amount",amount);
		}
		
		return true;
	}
}