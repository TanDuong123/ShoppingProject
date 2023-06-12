package ASMJava5.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ASMJava5.Model.BillDetail;

public interface BillDetailDAO extends JpaRepository<BillDetail, Integer> {
	
	@Query("Select bi.BillId, bi.Bill.Name, sum(b.Price), bi.Bill.Phone, bi.Bill.Address,b.CreateDate, b.State From BillDetail b "
			+ "Join Bill bi On b.BillDetail.BillId = bi.BillId "
			+ "Where bi.Bill.UserName = ?1 "
			+ "Group By bi.BillId, bi.Bill.Name, bi.Bill.Phone, bi.Bill.Address,b.CreateDate, b.State")
	Page<Object[]> findBillByUserName(String username,Pageable pagebable);
}
