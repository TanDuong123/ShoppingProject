package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.ProductVariant;

public interface ProductVariantDAO extends JpaRepository<ProductVariant, Long>{
	
	@Query("Select p From ProductVariant p Where p.size = ?1 And p.color = ?2 And p.ProductVariant.ProductId = ?3")
	ProductVariant findBySizeAndColorAndProductid(String size, String color, String id);
	
	@Query("Select p From ProductVariant p Where p.ProductVariantId = ?1")
	ProductVariant findOneById(Long productVariantId);
	
	@Query("select p from ProductVariant p where p.ProductVariant.ProductId =?1")
	ProductVariant findbyProductId(String productId); 
}
