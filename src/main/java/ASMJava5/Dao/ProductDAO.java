package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.java5.slide5.entity.Report;

import ASMJava5.Model.Product;

public interface ProductDAO extends JpaRepository<Product, String> {
//	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	@Query("SELECT o FROM Product o WHERE o.Name LIKE %?1%")
	Page<Product> findAllByName(String keywords, Pageable pageable);
																	
//	Page<Product> findByNameLike(String keywords, Pageable pageable);
//
//	@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.category"
//			+ " ORDER BY sum(o.price) DESC")
//	List<Report> getInventoryByCategory();
}
