package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Product;
import repository.ProductRepository;

public class ProductService implements IProductService {
   
	 private ProductRepository productRepository;
     
	 @Autowired
	 public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
    }
	 
	@Override
	public List<Product> getProductList() {
		return productRepository.findAllSortedByName();
		
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
