package service;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import entities.CartEntry;
import entities.Product;
import entities.ShoppingCart;
import repositories.ProductRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final EntityManager em;

    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(EntityManager em, ProductRepository productRepository) {
        this.em = em;
        this.productRepository = productRepository;
    }
    @Lookup
    @Override
    public ShoppingCart getNewCart() {
        return null;
    }

    public List<CartEntry> findAllProductsById(Long orderId) {
        List<CartEntry> cartEntryList = em.createQuery("FROM CartEntry c WHERE c.order_id = :orderId")
                .setParameter("order_id", orderId)
                .getResultList();
        return cartEntryList;
    }


    @Override
    public void addProduct(ShoppingCart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(ShoppingCart cart, Long prodId, Integer quantity) {
        Product product = productRepository.findById(prodId);
        this.addProduct(cart, product, quantity);
    }

    @Override
    public BigDecimal getSum(ShoppingCart cart) {
        return cart.getSum();
    }

    public void printCart(ShoppingCart cart) {
        BigDecimal sum = BigDecimal.valueOf(0);
        
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            Product product = entryMap.getKey();
            BigDecimal prodSum = product.getPrice().multiply(BigDecimal.valueOf(entryMap.getValue()));
            System.out.printf("Product id = %-2s | name = %-15s | price = %-8s | quantity = %-3s | sum = %-12s \n",
                    product.getId(), product.getName(), product.getPrice(), entryMap.getValue(), prodSum);
            sum = sum.add(prodSum);
        }
        System.out.println("Общая стоимость продуктов в корзине: " + sum);
    }

    @Override
    public int getProductQuantity(ShoppingCart cart, Product product) {
        if (cart.getCartMap().containsKey(product)) {
            return cart.getCartMap().get(product);
        }
        return 0;
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
    public int getProductQuantity(ShoppingCart cart, Long prodId) {
        Product product = productRepository.findById(prodId);
        return this.getProductQuantity(cart, product);
    }

    @Override
    public List<Product> getCartListSorted(ShoppingCart cart) {
        List<Product> cartList = new ArrayList<>(cart.getCartMap().keySet());
        Collections.sort(cartList, (p1, p2) -> {
            if (p1.getId() > p2.getId()) {
                return 1;
            } else if (p1.getId() < p2.getId()) {
                return -1;
            }
            return 0;
        });
        return cartList;
    }
}
