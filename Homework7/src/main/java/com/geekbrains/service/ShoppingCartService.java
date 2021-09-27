package com.geekbrains.service;

import com.geekbrains.entities.Product;
import com.geekbrains.entities.ShoppingCart;
import com.geekbrains.entities.ShoppingCartEntry;

import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService implements IShoppingCartService{

    private final EntityManager em;

    private final ProductRepository productRepository;

    public ShoppingCartService(EntityManager em, ProductRepository productRepository) {
        this.em = em;
        this.productRepository = productRepository;
    }

    @Lookup
    @Override
    public ShoppingCart getNewCart() {
        return null;
    }

    @Override
    public void addProduct(ShoppingCart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(ShoppingCart cart, Long prodId, Integer quantity) {
        Product product = productRepository.findById(prodId).get();
        this.addProduct(cart, product, quantity);
    }

    @Override
    public BigDecimal getSum(ShoppingCart cart) {
        return cart.getSum();
    }

    @Override
    public Integer getItemsAmount(ShoppingCart cart) {
        Integer amount = 0;
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            amount += entryMap.getValue();
        }
        return amount;
    }

    @Override
    public void printCart(ShoppingCart cart) {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            Product product = entryMap.getKey();
            BigDecimal prodSum = product.getPrice().multiply(BigDecimal.valueOf(entryMap.getValue()));
            System.out.printf("Product id = %-2s | name = %-15s | price = %-8s | quantity = %-3s | sum = %-12s \n",
                    product.getId(), product.getName(), product.getPrice(), entryMap.getValue(), prodSum);
            sum = sum.add(prodSum);
        }
        System.out.println("К оплате: " + sum);
    }

    @Override
    public int getProductQuantity(ShoppingCart cart, Product product) {
        if (cart.getCartMap().containsKey(product)) {
            return cart.getCartMap().get(product);
        }
        return 0;
    }

    @Override
    public int getProductQuantity(ShoppingCart cart, Long prodId) {
        Product product = productRepository.findById(prodId).get();
        return this.getProductQuantity(cart, product);
    }


    @Override
    public List<Product> getCartListSorted(ShoppingCart cart) {
        return null;
    }

    @Override
    public List<ShoppingCartEntry> findAllProductsById(Long orderId) {
        @SuppressWarnings("JpaQlInspection") List<ShoppingCartEntry> cartEntryList = em.createQuery("Select c FROM ShoppingCartEntry c WHERE c.order_id = :orderId")
                .setParameter("order_id", orderId)
                .getResultList();
        return cartEntryList;
    }
}
