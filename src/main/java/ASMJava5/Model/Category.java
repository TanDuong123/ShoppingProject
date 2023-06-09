package ASMJava5.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Categories")
public class Category implements Serializable {
	@Id
	String CategoryId;
	@Column(columnDefinition = "nvarchar(200)")
	String Name;
	@OneToMany(mappedBy = "Category")
	List<Product> Products;
}
