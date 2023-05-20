package ASMJava5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/homeShop")
	public String home() {
		return "index";
	}
	@GetMapping("/shop")
	public String shop() {
		return "shop";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/detail")
	public String detail() {
		return "detail";
	}
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
}
