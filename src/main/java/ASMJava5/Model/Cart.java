package ASMJava5.Model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="Carts")
public class Cart implements Serializable{
	@Id
	String CartId;
	@ManyToOne @JoinColumn(name="UserId")
	User Cart;
	@ManyToOne @JoinColumn(name="ProductId")
	Product Product;
	Integer Quantity;
	@Temporal(TemporalType.DATE)
	@Column(name="SaveDate")
	Date SaveDate= new Date();
}
