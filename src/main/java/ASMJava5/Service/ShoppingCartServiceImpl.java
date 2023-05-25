package ASMJava5.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import ASMJava5.Model.Item;
import ASMJava5.Util.SP;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	Map<Integer, Item> map = new HashMap<>();
	@Override
	public Item add(Integer id) {
		Item item =map.get(id);
		if(item == null) { // Chưa có trong giỏ hàng
			item = SP.item.get(id);
			item.setQty(1);
			map.put(id, item);
		}else {
			item.setQty(item.getQty()+1);
		}
		return item;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Item update(Integer id, String qty) {
		Item item = map.get(id);
		if(qty.equals("dis") && item.getQty()>0) {
			item.setQty(item.getQty()-1);
		}else if(qty.equals("plus") &&item.getQty()<100) {
			item.setQty(item.getQty()+1);
		}
		
		return item;
	}

	@Override
	public void clear() {
		// xoa het gio hang
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		
		return map.values().stream().mapToInt(item -> item.getQty()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getPrice()*item.getQty()).sum();
	}

}