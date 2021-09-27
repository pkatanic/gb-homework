package service;

import java.util.List;

import model.Product;

public interface IProductService {
	List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);
}
