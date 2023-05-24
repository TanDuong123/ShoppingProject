package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ASMJava5.Model.Bill;

public interface BillDAOInterface extends JpaRepository<Bill, String> {

}
