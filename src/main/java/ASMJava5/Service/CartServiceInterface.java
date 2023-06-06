package ASMJava5.Service;

import ASMJava5.Model.Cart;
import java.util.Collection;

public interface CartServiceInterface {
	Cart add(Long id);
	
	void remove(Long id);
	
	Cart update(Long id, String quantity);
	
	void clear();
	
	Collection<Cart> getItems();
	
	int getCount();
	
	double getAmount();
	
}
