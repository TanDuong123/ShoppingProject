package ASMJava5.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ASMJava5.Dao.CategoryDAO;
import ASMJava5.Dao.ProductDAO;
import ASMJava5.Dao.ProductVariantDAO;
import ASMJava5.Dao.UserDAO;
import ASMJava5.Model.Product;
import ASMJava5.Model.User;
import ASMJava5.Service.ProductService;
import ASMJava5.Service.SessionService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/SpaceShope/")
public class AdminController {
	private final ProductService productService;
	
	public AdminController(ProductService productService) {
        this.productService = productService;
    }@Autowired
	HttpServletRequest request;
	
	@Autowired
	SessionService session;
	@Autowired
	ProductDAO ProductDao;
	@Autowired
	UserDAO UserDao;
	@Autowired
	CategoryDAO categoryDao;
	@Autowired
	ProductVariantDAO ProductVariantDao;
	
	
	//admin
		@GetMapping("/admin/index")
		public String adminIndex() {
			return "admin/index";
		}
		
		
//		ACCOUNT----------------------------------------------------------------
		
		
		
		@GetMapping("/admin/account")
		public String adminaccount(Model model, @RequestParam("p") Optional<Integer> p) {
			User user = new User();
			model.addAttribute("user",user);
			
			Pageable pageable = PageRequest.of(p.orElse(0), 3);
			Page<User> page = UserDao.findAll(pageable);
			model.addAttribute("users",page);
			return "admin/account";
		}
		@PostMapping("/admin/account/add")
		public String createAccount(Model model,
				@RequestParam("UserName") String UserName,
				@RequestParam("Password") String Password,
				@RequestParam("Role") Boolean Role,
				@RequestParam("Activated") Boolean Activated,
				@RequestParam("Image") String Image,
				@RequestParam("Name") String Name,
				@RequestParam("email") String Email,
				@RequestParam("Address") String Address,
				@RequestParam("Phone") String Phone,
				@RequestParam("ZipCode") String ZipCode,
				@RequestParam("Intimately") String Intimately
				) {
			User user  = new User();
			user.setUserName(UserName);
			user.setPassword(Password);
			user.setRole(Role);
			user.setActivated(Activated);
			user.setImage(Image);
			user.setName(Name);
			user.setEmail(Email);
			user.setAddress(Address);
			user.setPhone(Phone);
			user.setZipCode(ZipCode);
			user.setIntimately(Intimately);
			UserDao.save(user);

			List<User> users = UserDao.findAll();
			model.addAttribute("users",users);
			return "admin/account";
		}
		@GetMapping("/admin/account/del/{id}")
		public String delAccount(Model model,@PathVariable("id") String id) {
			UserDao.deleteById(id);
			List<User> prod = UserDao.findAll();
			model.addAttribute("users",prod);
			return "admin/account";
		}
		
		@GetMapping("/admin/account/edit")
		public String editAccount(Model model) {
			String id = request.getParameter("id");
			Optional<User> userOptional=UserDao.findById(id);
			if(userOptional.isPresent()) {
				User user=userOptional.get();
				model.addAttribute("UserName",user.getUserName());
				model.addAttribute("Password",user.getPassword());
				model.addAttribute("Role",user.getRole());
				model.addAttribute("Activated",user.getActivated());
				model.addAttribute("Image",user.getImage());
				model.addAttribute("Name",user.getName());
				model.addAttribute("Address",user.getAddress());
				model.addAttribute("Phone",user.getPhone());
				model.addAttribute("email",user.getEmail());
				model.addAttribute("ZipCode",user.getZipCode());
				model.addAttribute("Intimately",user.getIntimately());
			}
//			session.setAttribute("productid", prod.getProductId());
//			model.addAttribute("product",prod);
//			System.out.println(id);
//			System.out.println(productOptional);
			return "admin/formAccount";
		}
		
		@PostMapping("/admin/account/edit")
		public String updateAccount(Model model,
				@RequestParam("UserName") String UserName,
				@RequestParam("Password") String Password,
				@RequestParam("Role") Boolean Role,
				@RequestParam("Activated") Boolean Activated,
				@RequestParam("Image") String Image,
				@RequestParam("Name") String Name,
				@RequestParam("email") String Email,
				@RequestParam("Address") String Address,
				@RequestParam("Phone") String Phone,
				@RequestParam("ZipCode") String ZipCode,
				@RequestParam("Intimately") String Intimately) {
			User user  = new User();
			user.setUserName(UserName);
			user.setPassword(Password);
			user.setRole(Role);
			user.setActivated(Activated);
			user.setImage(Image);
			user.setName(Name);
			user.setEmail(Email);
			user.setAddress(Address);
			user.setPhone(Phone);
			user.setZipCode(ZipCode);
			user.setIntimately(Intimately);
			UserDao.save(user);

			List<User> users = UserDao.findAll();
			model.addAttribute("users",users);
			return "redirect:/SpaceShope/admin/account";
		}
		
		
//		PRODUCT----------------------------------------------------------------------------
		
		
		@GetMapping("/admin/products")
		public String adminProduct(Model model, @RequestParam("p") Optional<Integer> p) {
			Product product = new Product();
			model.addAttribute("product",product);
			
			Pageable pageable = PageRequest.of(p.orElse(0), 3);
			Page<Product> page = ProductDao.findAll(pageable);
			model.addAttribute("PRODUCTS",page);
//			System.out.println(prod);
			return "admin/products";
		}
		@PostMapping("/admin/products/add")
		public String create(Model model,
				@RequestParam("productid") String productid,
				@RequestParam("name") String name,
				@RequestParam("image") String image,
				@RequestParam("Category") String category,
				@RequestParam("price") Double price,
				@RequestParam("available") Boolean available,
				@RequestParam("decription") String decription
				) {
			Product product = new Product();
			model.addAttribute("product",product);
			productService.createProduct(productid, name, image, price, category, decription, available);
			System.out.println(productid);
			List<Product> prod = ProductDao.findAll();
			model.addAttribute("PRODUCTS",prod);
			return "admin/products";
		}
		@GetMapping("/admin/products/del/{id}")
		public String delProduct(Model model,@PathVariable("id") String id) {
			ProductDao.deleteById(id);
			List<Product> prod = ProductDao.findAll();
			model.addAttribute("PRODUCTS",prod);
			return "admin/products";
		}
		@GetMapping("/admin/products/edit")
		public String edit(Model model) {
			String id = request.getParameter("id");
			Optional<Product> productOptional=ProductDao.findById(id);
			if(productOptional.isPresent()) {
				Product product=productOptional.get();
				model.addAttribute("productName",product.getName());
				model.addAttribute("productImg",product.getImage());
				model.addAttribute("productPrice",product.getPrice());
				model.addAttribute("productID",product.getProductId());
				model.addAttribute("productDesc",product.getDecription());
				model.addAttribute("productAvai",product.getAvailable());
				model.addAttribute("productCategory",product.getCategory().getCategoryId());
				System.out.println(product.getName());
			}
//			session.setAttribute("productid", prod.getProductId());
//			model.addAttribute("product",prod);
//			System.out.println(id);
//			System.out.println(productOptional);
			return "admin/formProduct";
		}
		@PostMapping("/admin/products/edit")
		public String update(Model model,
				@RequestParam("productid") String productid,
				@RequestParam("name") String name,
				@RequestParam("image") String image,
				@RequestParam("Category") String category,
				@RequestParam("price") Double price,
				@RequestParam("available") Boolean available,
				@RequestParam("decription") String decription) {
			try {
				Product product = new Product();
				productService.createProduct(productid, name, image, price, category, decription, available);
				ProductDao.save(product);
				System.out.println("update");
				List<Product> prod = ProductDao.findAll();
				model.addAttribute("PRODUCTS",prod);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "redirect:/SpaceShope/admin/products";
		}

//		PRODUCT DETAIL
		@RequestMapping("/admin/product/detail")
		public String detail() {
			
			return "/admin/Productdetail";
		}
		
		@GetMapping("/admin/carts")
		public String adminCarts() {
			return "admin/carts";
		}
}
