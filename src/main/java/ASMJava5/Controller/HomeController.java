package ASMJava5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ASMJava5.Dao.CategoryDAOInterface;
import ASMJava5.Dao.ProductDAOInterface;
import ASMJava5.Model.Category;
import ASMJava5.Model.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDAOInterface dao;
	@GetMapping("/homeShop")
	public String home(Model model) {
		List<Product> items= dao.findAll();
		model.addAttribute("items",items);
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
	//admin
	@GetMapping("/admin/index")
	public String adminIndex() {
		return "admin/index";
	}
	@GetMapping("/admin/account")
	public String adminaccount() {
		return "admin/account";
	}
	@GetMapping("/admin/products")
	public String adminProduct() {
		return "admin/products";
	}
	@GetMapping("/admin/carts")
	public String adminCarts() {
		return "admin/carts";
	}
}
