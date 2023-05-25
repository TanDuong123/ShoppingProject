package ASMJava5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ASMJava5.Service.ShoppingCartService;
import ASMJava5.Service.ShoppingCartServiceImpl;
import ASMJava5.Util.SP;

@Controller
@RequestMapping("/ASMJava5/")
public class ItemController {
	@Autowired
	ShoppingCartServiceImpl cart;
	
	@RequestMapping("index")
	public String cart(Model model) {
		model.addAttribute("items", SP.item.values());
		model.addAttribute("Count", cart.getCount());
		return "spview";
	}
}
