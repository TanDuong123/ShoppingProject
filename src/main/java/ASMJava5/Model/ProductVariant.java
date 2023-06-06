package ASMJava5.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
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
@Table(name="ProductVariants")
public class ProductVariant implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ProductVariantId;
	String size;
	@Column(columnDefinition = "nvarchar(50)")
	String color;
	Integer Quantity;
	@ManyToOne @JoinColumn(name="ProductId")
	Product ProductVariant;
}
