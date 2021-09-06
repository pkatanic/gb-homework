package repository;

import java.util.List;

import model.Product;

public interface IProductRepository {
	List<Product> findAll();

    List<Product> findAllSortedByName();

    Product findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(Product product);
}
