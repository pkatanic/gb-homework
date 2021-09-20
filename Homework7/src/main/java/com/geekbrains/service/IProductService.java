package com.geekbrains.service;

import com.geekbrains.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);
}
