package ASMJava5.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ASMJava5.Dao.CategoryDAOInterface;
import ASMJava5.Dao.ProductDAOInterface;
import ASMJava5.Model.Category;
import ASMJava5.Model.Product;

@Controller
@RequestMapping("/SpaceShope/")
public class HomeController {
	@Autowired
	ProductDAOInterface ProductDao;
	@Autowired
	CategoryDAOInterface categoryDao;
	@GetMapping("Home")
	public String home(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 8);
		Page<Product> products= ProductDao.findAll(pageable);
		model.addAttribute("products",products);
		List<Category> categories= categoryDao.findAll();
		model.addAttribute("categories",categories);
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 6);
		Page<Product> products= ProductDao.findAll(pageable);
		model.addAttribute("products",products);
		return "shop";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") String id) {
		Product product= new Product();
		product= ProductDao.findById(id).get();
		model.addAttribute("product", product);
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
	public String adminProduct(Model model) {
		Product item = new Product();
		model.addAttribute("PRODUCT", item);
		List<Product> prod = ProductDao.findAll();
		model.addAttribute("PRODUCTS",prod);
		return "admin/products";
	}
	@GetMapping("/admin/carts")
	public String adminCarts() {
		return "admin/carts";
	}
}
