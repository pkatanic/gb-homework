package repositories;

import java.util.List;

import entities.Product;

public interface IProductRepository {
    List<Product> findAll();

    List<Product> findAllSortedByName();

    Product findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(Product product);  
}
