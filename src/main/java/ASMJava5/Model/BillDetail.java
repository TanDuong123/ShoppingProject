package ASMJava5.Model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="BillDetails", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"BillId","ProductId"})
})
public class BillDetail implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long BillDetailId;
	@ManyToOne @JoinColumn(name="BillId")
	Bill BillDetail;
	@ManyToOne @JoinColumn(name="ProductId")
	Product Product;
	Integer Quantity;
	String Address;
	@Temporal(TemporalType.DATE)
	@Column(name="CreateDate")
	Date CreateDate= new Date();
	Boolean State;
}
