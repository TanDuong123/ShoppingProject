package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.User;

public interface UserDAO extends JpaRepository<User, String> {
	@Query("Select o from User o Where o.UserName = ?1")
	User findByUserName(String username);
	
	@Query("Select o From User o Where o.Email = ?1")
	User findBymail(String email);
}