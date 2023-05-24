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
	String Name;
	String Image;
	Integer Quantity;
	@ManyToOne @JoinColumn(name="CategoryId")
	Category Category;
	String Color;
	Integer Size;
	Double Price;
	Boolean Available;
	String Decription;
	@OneToMany(mappedBy = "Product")
	List<BillDetail> BillDetails;
}