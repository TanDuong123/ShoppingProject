package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{
	@Query("Select c.CategoryId, c.Name, count(p.ProductId), p.Image From Category c "
			+ "Join Product p On c.CategoryId = p.Category.CategoryId "
			+ "Group By c.CategoryId, c.Name, p.Image"
			+ " Order By Rand()"
			)
	List<Object[]> findAllCategory();
}
