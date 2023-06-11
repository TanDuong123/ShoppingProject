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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Carts")
public class Cart implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long CartId;
	@ManyToOne @JoinColumn(name="UserName")
	User Cart;
	@OneToMany(mappedBy = "Cart")
	List<CartItem> CartItems;
}