package ASMJava5.Util;

import java.util.HashMap;
import java.util.Map;
import ASMJava5.Model.Item;

public class SP {
	public static Map<Integer, Item> item = new HashMap<>(); 
	static {
		item.put(1, new Item(1,"Iphone" , 23.0, 0,"carousel-1.jpg"));
		item.put(2, new Item(2,"samsung" , 12.0, 0,"carousel-2.jpg"));
		item.put(3, new Item(3,"TV" , 33.0, 0,"carousel-3.jpg"));
		item.put(4, new Item(4,"Laptop" , 42.0, 0,"payments.png"));
	}
	
}
