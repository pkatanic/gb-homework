package com.geekbrains.service;

import com.geekbrains.entities.Product;
import com.geekbrains.entities.ShoppingCart;
import com.geekbrains.entities.ShoppingCartEntry;

import java.math.BigDecimal;
import java.util.List;

public interface IShoppingCartService {
    ShoppingCart getNewCart();
    void addProduct(ShoppingCart cart, Product product, Integer quantity);
    void addProduct(ShoppingCart cart, Long prodId, Integer quantity);

    BigDecimal getSum(ShoppingCart cart);

    Integer getItemsAmount(ShoppingCart cart);

    void printCart(ShoppingCart cart);

    int getProductQuantity(ShoppingCart cart, Product product);
    int getProductQuantity(ShoppingCart cart, Long prodId);

    List<Product> getCartListSorted(ShoppingCart cart);

    List<ShoppingCartEntry> findAllProductsById(Long orderId);
}
