package ASMJava5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.Bill;

public interface BillDAO extends JpaRepository<Bill, String> {
	@Query("Select b From Bill b Where b.Bill.UserName = ?1")
	Bill findBillByUserName(String username);
}
