package ASMJava5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ASMJava5.Dao.CartItemDAO;
import ASMJava5.Dao.UserDAO;
import ASMJava5.Model.User;
import ASMJava5.Service.SessionService;

@Controller
@RequestMapping("/account/")
public class AccountController {
	
	@Autowired
	SessionService session;
	@Autowired
	UserDAO userDao;
	@Autowired
	CartItemDAO cartItemDao;
	@GetMapping("index")
	public String index() {
		return "account/login";
	}
	@PostMapping("login")
	public String login(Model model,
			@RequestParam("username") String Username,
			@RequestParam("password") String Password) {
		if(Username.isEmpty()|| Password.isEmpty()) {
			return "/account/login";
		}
		else {
			User user= userDao.findByUserName(Username);
			if(user == null || !user.getPassword().equals(Password)) {
				model.addAttribute("message", "Login invalid!");
			}else {
				session.setAttribute("user", user);
				int amount=cartItemDao.getAmount(user.getUserName());
				session.setAttribute("amount",amount);
				return "redirect:/SpaceShope/Home";
			}
		}
		return "account/login";
	}
	@RequestMapping("logout")
	public String logout() {
		
		session.removeAttribute("user");
		session.removeAttribute("amount");
		return "account/login";
	}
	
	@GetMapping("registerIndex")
	public String indexRegister() {
		return "account/register";
	}
	@PostMapping("register")
	public String register(Model model, 
			@RequestParam("registerUserName") String username,
			@RequestParam("registerEmail") String email,
			@RequestParam("registerPassword") String password) {
		User checkUser= userDao.findByUserName(username);
		User checkEmail=userDao.findBymail(email);
		if(checkUser == null && checkEmail == null) {
			User user=new User();
			user.setUserName(username);
			user.setEmail(email);
			user.setActivated(false);
			user.setAddress("");
			user.setPassword(password);
			user.setRole(false);
			user.setPhone("");
			user.setName("");
			user.setImage("");
			user.setZipCode("");
			user.setIntimately("");
			userDao.save(user);
			model.addAttribute("errorRegister", "Register success!");
			return "redirect:/account/index";
		}
		else {
			model.addAttribute("errorRegister", "Username or Email alrealy exists!");
		}
		return "account/register";
	}
}
