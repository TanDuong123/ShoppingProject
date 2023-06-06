package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.Category;

public interface CategoryDAO extends JpaRepository<Category, String>{
	
}
