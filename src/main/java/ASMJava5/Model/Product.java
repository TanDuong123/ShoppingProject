package ASMJava5.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="Products")
public class Product implements Serializable{
	@Id
	String ProductId;
	@Column(columnDefinition = "nvarchar(200)")
	String Name;
	String Image;
	@ManyToOne @JoinColumn(name="CategoryId")
	Category Category;
	Double Price;
	Boolean Available;
	@Column(columnDefinition = "nvarchar(500)")
	String Decription;
	@OneToMany(mappedBy = "Product")
	List<BillDetail> BillDetails;
	@OneToMany(mappedBy="ProductVariant")
	List<ProductVariant> ProductVariants;
	@OneToMany(mappedBy = "CartItem")
	List<CartItem> CartItems;
}
