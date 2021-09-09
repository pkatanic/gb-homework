package service;

import java.util.List;

import entities.Product;

public interface ProductService {
	   List<Product> getProductList();

	    void saveOrUpdate(Product product);

	    Product getProductById(Long id);

	    void deleteById(Long id);
}
