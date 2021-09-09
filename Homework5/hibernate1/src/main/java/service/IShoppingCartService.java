package service;

import java.math.BigDecimal;
import java.util.List;

import model.Cart;
import model.Product;

public interface IShoppingCartService {
	 Cart getNewCart();

	    void addProduct(Cart cart, Product product, Integer quantity);
	    void addProduct(Cart cart, Long prodId, Integer quantity);

	    BigDecimal getSum(Cart cart);

	    Integer getItemsAmount(Cart cart);

	    void printCart(Cart cart);

	    int getProductQuantity(Cart cart, Product product);
	    int getProductQuantity(Cart cart, Long prodId);

	    List<Product> getCartListSorted(Cart cart);
}
