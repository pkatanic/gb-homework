package service;

import java.math.BigDecimal;
import java.util.List;

import entities.CartEntry;
import entities.Product;
import entities.ShoppingCart;

public interface ShoppingCartService {
	 ShoppingCart getNewCart();

	    void addProduct(ShoppingCart cart, Product product, Integer quantity);
	    void addProduct(ShoppingCart cart, Long prodId, Integer quantity);

	    BigDecimal getSum(ShoppingCart cart);

	    Integer getItemsAmount(ShoppingCart cart);

	    void printCart(ShoppingCart cart);

	    int getProductQuantity(ShoppingCart cart, Product product);
	    int getProductQuantity(ShoppingCart cart, Long prodId);

	    List<Product> getCartListSorted(ShoppingCart cart);

	    List<CartEntry> findAllProductsById(Long orderId); 
}
