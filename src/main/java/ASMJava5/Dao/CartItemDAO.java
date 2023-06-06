package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.CartItem;

public interface CartItemDAO extends JpaRepository<CartItem, Long>{

}
