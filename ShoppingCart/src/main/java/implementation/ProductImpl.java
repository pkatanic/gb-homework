package implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Product;
import model.ProductInterface;
import model.ProductRepository;
public class ProductImpl implements ProductInterface {

	private ProductRepository productRepository;
	
	@Autowired
    public void setProductRepository(ProductRepository productRepository) {
	     this.productRepository = productRepository;
	 }
	@Override
	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public void saveOrUpdate(Product product) {
		productRepository.saveOrUpdate(product);
		
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 productRepository.deleteById(id);
		
	}

}
