package com.geekbrains.service;

import com.geekbrains.entities.Product;
import java.util.List;

import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Product product) {

    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
