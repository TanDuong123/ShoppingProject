package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.User;

public interface UserDAOInterface extends JpaRepository<User, String> {

}
