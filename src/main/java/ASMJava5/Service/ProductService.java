package ASMJava5.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ASMJava5.Dao.CategoryDAO;
import ASMJava5.Dao.ProductDAO;
import ASMJava5.Model.Category;
import ASMJava5.Model.Product;

@Service
public class ProductService {

	private final ProductDAO productRepository ;
    private final CategoryDAO categoryRepository;
    
    public ProductService(ProductDAO productRepository, CategoryDAO categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product createProduct(String productid,String name,String img, Double gia, String categoryId,String desc,Boolean available) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            // Handle error when category is not found
        }
        
        Product product = new Product();
        product.setProductId(productid);
        product.setPrice(gia);
        product.setAvailable(available);
        product.setImage(img);
        product.setDecription(desc);
        product.setName(name);
        product.setCategory(category);
        return productRepository.save(product);
    }
    public Product getEmployeeById(String id) {
        Optional<Product>  optional = productRepository.findById(id);
        Product prod = null;
        if (optional.isPresent()) {
            prod = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return prod;
    }
}
