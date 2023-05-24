package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.Product;

public interface ProductDAOInterface extends JpaRepository<Product, String> {

}
