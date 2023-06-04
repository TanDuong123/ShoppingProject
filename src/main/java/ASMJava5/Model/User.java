package ASMJava5.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class User implements Serializable{
	@Id
	String UserName;
	String Password;
	Boolean Role;
	Boolean Activated;
	String Image;
	String Name;
	String Email;
	String Address;
	String Phone;
	String ZipCode;
	String Intimately;
	@OneToMany(mappedBy = "Bill")
	List<Bill> Bills;
	@OneToMany(mappedBy="Cart")
	List<Cart> Carts;
}
