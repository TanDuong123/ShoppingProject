package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.CartItem;

public interface CartItemDAO extends JpaRepository<CartItem, Long>{
	@Query("Select p.Name, p.Image, p.Price, ci.Quantity, ci.CartItemId From CartItem ci "
			+ "Join Cart c On ci.Cart.CartId = c.CartId "
			+ "Join User u On c.Cart.UserName = u.UserName "
			+ "Join ProductVariant prv On ci.CartItem.ProductVariantId = prv.ProductVariantId "
			+ "Join Product p On p.ProductId= prv.ProductVariant.ProductId Where u.UserName = ?1"
			)
	List<Object[]> getAllInforWithUserName(String username);
	@Query("Select count(ci) From CartItem ci "
			+ "Join Cart c On ci.Cart.CartId=c.CartId Where c.Cart.UserName=?1")
	Integer getAmount(String username);
	
	@Query("Select Sum(p.Price * prv.Quantity) From CartItem ci "
			+ "Join ProductVariant prv On prv.ProductVariantId = ci.CartItem.ProductVariantId "
			+ "Join Product p On p.ProductId = prv.ProductVariant.ProductId "
			+ "Join Cart c On c.CartId = ci.Cart.CartId "
			+ "Where c.Cart.UserName = ?1")
	Double getToTal(String username);
}