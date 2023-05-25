package ASMJava5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ASMJava5.Service.ShoppingCartService;

@Controller
@RequestMapping("/ASMJava5/")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cart; // tiêm Spring Bean đã tạo

	@RequestMapping("view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		model.addAttribute("Count", cart.getCount());
		model.addAttribute("Amount", cart.getAmount());
		return "giohang";
	}

	@RequestMapping("add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/ASMJava5/view"; // hiển thị giỏ hàng
	}

	@RequestMapping("remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/ASMJava5/view";
	}

	@RequestMapping("update/{id}/{pre}")
	public String update(@PathVariable("id") Integer id,@PathVariable("pre") String pre) {
		cart.update(id, pre);
		return "redirect:/ASMJava5/view";
	}

	@RequestMapping("clear")
	public String clear() {
		cart.clear();
		return "redirect:/ASMJava5/view";
	}
}
