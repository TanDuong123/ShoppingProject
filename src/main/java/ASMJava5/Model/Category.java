package ASMJava5.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Categories")
public class Category implements Serializable {
	@Id
	String Categoryid;
	String Name;
	@OneToMany(mappedBy = "Category")
	List<Product> Products;
}
