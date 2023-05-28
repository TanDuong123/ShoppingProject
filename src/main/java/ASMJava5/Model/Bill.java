package ASMJava5.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Bills")
public class Bill implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long BillId;
	@ManyToOne @JoinColumn(name="UserName")
	User Bill;
	@OneToMany(mappedBy = "BillDetail")
	List<BillDetail> BillDetails;
	
}
