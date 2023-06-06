package ASMJava5.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ASMJava5.Model.Cart;

public class CartService implements CartServiceInterface{
	Map<Long, Cart> map= new HashMap<>();
	@Override
	public Cart add(Long id) {
		Cart item= map.get(id);
		if(item==null) {
			item= map.get(id);
//			item.s
		}
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart update(Long id, String quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Cart> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
