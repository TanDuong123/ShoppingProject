package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.Cart;

public interface CartDAOInterface extends JpaRepository<Cart, String>{

}
