package ASMJava5.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CartItems")
public class CartItem implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long CartItemId;
	Integer Quantity;
	@ManyToOne @JoinColumn(name="ProductVariantId")
	ProductVariant CartItem;
	@ManyToOne @JoinColumn(name="CartId")
	Cart Cart;
}
