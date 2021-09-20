package model;

import java.util.List;

public interface IProductService {
	 List<Product> getProductList();

	    void saveOrUpdate(Product product);

	    Product getProductById(Long id);
	    int getProductQuantity(Cart cart, Long prodId);
	    void deleteById(Long id);
	    
}
