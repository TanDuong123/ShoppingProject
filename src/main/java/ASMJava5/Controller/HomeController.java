package ASMJava5.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ASMJava5.Dao.BillDAO;
import ASMJava5.Dao.BillDetailDAO;
import ASMJava5.Dao.CartDAO;
import ASMJava5.Dao.CartItemDAO;
import ASMJava5.Dao.CategoryDAO;
import ASMJava5.Dao.ProductDAO;
import ASMJava5.Dao.ProductVariantDAO;
import ASMJava5.Dao.UserDAO;
import ASMJava5.Model.Bill;
import ASMJava5.Model.BillDetail;
import ASMJava5.Model.Cart;
import ASMJava5.Model.CartItem;
import ASMJava5.Model.Category;
import ASMJava5.Model.Product;
import ASMJava5.Model.ProductVariant;
import ASMJava5.Model.User;
import ASMJava5.Service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/SpaceShope/")
public class HomeController {
	@Autowired
	SessionService session;
	@Autowired
	ProductDAO ProductDao;
	@Autowired
	CategoryDAO categoryDao;
	@Autowired
	ProductVariantDAO ProductVariantDao;
	@Autowired
	CartDAO cartDao;
	@Autowired
	CartItemDAO cartItemDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	BillDAO billDao;
	@Autowired
	BillDetailDAO billDetailDao;
	
	@GetMapping("Home")
	public String home(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 8);
		Page<Product> products= ProductDao.findAll(pageable);
		model.addAttribute("products",products);
//		List<Category> categories= categoryDao.findAll();
		List<Object[]> categories= categoryDao.findAllCategory();
		model.addAttribute("categories",categories);
		return "index";
	}
	@GetMapping("shop")
	public String shop(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 6);
		Page<Product> products= ProductDao.findAll(pageable);
		model.addAttribute("products",products);
		return "shop";
	}
	@GetMapping("category/{id}")
	public String categoryId(Model model, 
			@PathVariable("id") String id,
			@RequestParam("page") Optional<Integer> page) {
		Pageable pageable=PageRequest.of(page.orElse(0), 6);
		Page<Product> products= ProductDao.findByCategoryId(id,pageable);
		model.addAttribute("products",products);
		return "shop";
	}
	@RequestMapping("search")
	public String search(Model model, 
			@RequestParam("nameProduct") Optional<String> name,
			@RequestParam("page") Optional<Integer> page) {
		String nameProduct=name.orElse(session.getAttribute("keyword"));
		session.setAttribute("keyword", nameProduct);
		Pageable pageable= PageRequest.of(page.orElse(0), 6);
		Page<Product> products= ProductDao.findAllByName(nameProduct, pageable);
		model.addAttribute("products",products);
		return "shop";
	}
	@GetMapping("contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id") String id) {
		Optional<Product> productOptional=ProductDao.findById(id);
		if(productOptional.isPresent()) {
			Product products=productOptional.get();
			List<ProductVariant> variants= products.getProductVariants();
			model.addAttribute("products",products);
			model.addAttribute("variants", variants);
			session.setAttribute("id", id);
			System.out.println("id"+ session.getAttribute("id"));
		}
		return "detail";
	}
	@GetMapping("findBySizeAndColor")
	@ResponseBody
	public Map<String, Object> findBySizeAndColor(Model model,
			HttpServletRequest req,
			@RequestParam("size") String size, 
			@RequestParam("color") String color) {
	    // Xử lý logic để tìm số lượng dựa trên size và color
		ProductVariant variant=ProductVariantDao.findBySizeAndColorAndProductid(size, color,session.getAttribute("id"));
		Integer quantity=0;
		Long productVariantId = null;
		if(variant !=null) {
			productVariantId=variant.getProductVariantId();
	    	quantity = variant.getQuantity();
	    }
		Map<String,Object> response= new HashMap<>();
		response.put("productVariantId", productVariantId);
		response.put("quantity", quantity);
	    return response;
	}
	 
	@PostMapping("addToCart")
	public String addToCat(Model model, 
			@RequestParam("productVariantId") Long productVariantId,
			@RequestParam("quantity") Integer quantity) {
		User user=(User) session.getAttribute("user");
		String username= user.getUserName();
		Cart checkUserInCart= cartDao.findByUserName(username);
		CartItem cartItem= new CartItem();
		if(checkUserInCart==null) {
			checkUserInCart.setCart(user);
			cartDao.save(checkUserInCart);
		}
		else {
			cartItem.setCart(checkUserInCart);
			cartItem.setQuantity(quantity);
			cartItem.setCartItem(ProductVariantDao.findOneById(productVariantId));
			int amount= cartItemDao.getAmount(username);
			session.setAttribute("amount", amount);
			cartItemDao.save(cartItem);
			List<Object[]> listCart= cartItemDao.getAllInforWithUserName(username);
			double total=cartItemDao.getToTal(username); 
			model.addAttribute("listCart", listCart);
			model.addAttribute("total", total);
		}
		return "redirect:/SpaceShope/cart";
	}
	
	@GetMapping("cart")
	public String cart(Model model) {
		User user=(User) session.getAttribute("user");
		String username= user.getUserName();
		List<Object[]> listCart= cartItemDao.getAllInforWithUserName(username);
		double total=cartItemDao.getToTal(username); 
		model.addAttribute("listCart", listCart);
		model.addAttribute("total", total);
		return "cart";
	}
	@RequestMapping("removeCartItem/{cartId}")
	public String removeCartItem(Model mode, @PathVariable("cartId") Long id) {
		cartItemDao.deleteById(id);
		User user=(User) session.getAttribute("user");
		int amount=cartItemDao.getAmount(user.getUserName());
		session.setAttribute("amount",amount);
		return "redirect:/SpaceShope/cart";
	}
	@GetMapping("checkout")
	public String checkout(Model model) {
		User user=(User) session.getAttribute("user");
		String username= user.getUserName();
		List<Object[]> listCart= cartItemDao.getAllInforWithUserName(username);
		User inforUser= userDao.findByUserName(username);
		double total=cartItemDao.getToTal(username); 
		model.addAttribute("listCart", listCart);
		model.addAttribute("total", total);
		model.addAttribute("inforUser", inforUser);
		return "checkout";
	}
	
	@GetMapping("order")
	public String order(Model model, @RequestParam("page") Optional<Integer> page){
		Pageable pageable= PageRequest.of(page.orElse(0),5);
		User user=(User) session.getAttribute("user");
		String username= user.getUserName();
		Page<Object[]> listBill= billDetailDao.findBillByUserName(username,pageable);
		model.addAttribute("list", listBill);
		Object[] item= {"","","","","","","",""} ;
		model.addAttribute("item", item);
		return "order";
	}
	@GetMapping("order/create")
	public String createOrder(
			Model model,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address ) {
		
		System.out.println("infor"+name+phone+address);
		//Save bill
//		User user= (User) session.getAttribute("user");
//		Bill bill=billDao.findBillByUserName(user.getUserName());
//		if(bill==null) {
//			bill= new Bill();
//			bill.setBill(user);
//			billDao.save(bill);
//		}else {
//			//Save bill detail
//			BillDetail billdetail= new BillDetail();
//			billdetail.setAddress(address);
//			billdetail.setBillDetail(bill);
//			billdetail.setNumberPhoneBill(phone);
//			billdetail.setPrice(total);
//			billdetail.setState(false);
//			billDetailDao.save(billdetail);
//			//delete product in cart
//			List<Object[]> listCart= cartItemDao.getAllInforWithUserName(user.getUserName());
//			for(Object[] cartitem:listCart) {
//				cartItemDao.deleteById((Long) cartitem[4]);
//			}
//			session.setAttribute("amount", 0);
//		}
		return "checkout";
	}
	@GetMapping("/changelanguage")
	  public String changeLanguage(@RequestParam("lang") String lang, HttpServletRequest request, HttpServletResponse response) {
		// Đặt ngôn ngữ mới vào session
        request.getSession().setAttribute("lang", lang);
        
        // Đặt ngôn ngữ mới vào cookie
        Cookie cookie = new Cookie("lang", lang);
        response.addCookie(cookie);
        
        // Chuyển hướng ngược lại trang trước đó
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
	
}
