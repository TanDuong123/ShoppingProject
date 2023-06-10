package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.Cart;

public interface CartDAO extends JpaRepository<Cart, Long>{
	
	@Query("Select o From Cart o Where o.Cart.UserName = ?1")
	Cart findByUserName(String username);
	
}
