package model;

import java.util.List;

public interface ProductInterface {
	List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);
}
