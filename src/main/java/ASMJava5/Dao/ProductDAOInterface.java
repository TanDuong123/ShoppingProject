package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.java5.slide5.entity.Report;

import ASMJava5.Model.Product;

public interface ProductDAOInterface extends JpaRepository<Product, String> {
//	List<Product> findByPriceBetween(double minPrice, double maxPrice);
//	Page<Product> findAllByNameLike(String keywords, Pageable pageable);
//
//	@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.category"
//			+ " ORDER BY sum(o.price) DESC")
//	List<Report> getInventoryByCategory();
}
