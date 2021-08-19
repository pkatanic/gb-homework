package implementation;

import model.Cart;
import model.CartInterface;
import model.Product;
import model.ProductRepository;

import org.springframework.beans.factory.annotation.Lookup;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class CartImpl implements CartInterface {
	private ProductRepository productRepository;
	public CartImpl(ProductRepository productRepo) {
		this.productRepository=productRepo;
	}
	@Lookup
	@Override
	public Cart getNewCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Cart cart, Product product, Integer quantity) {
		cart.addProduct(product, quantity);
		
	}

	@Override
	public void addProduct(Cart cart, Long prodId, Integer quantity) {
		
		 Product product = productRepository.findById(prodId);
	        this.addProduct(cart, product, quantity);
	}

	@Override
	public void delProduct(Cart cart, Product product, Integer quantity) {
		 cart.delProduct(product, quantity);
		
	}

	@Override
	public BigDecimal getSum(Cart cart) {
		// TODO Auto-generated method stub
		return cart.getSum();
	}

	@Override
	public void printCart(Cart cart) {
		BigDecimal sum = BigDecimal.valueOf(0);
        
        for (Map.Entry<Product, Integer> entryMap : cart.getProducts().entrySet()) {
            Product product = entryMap.getKey();
            BigDecimal prodSum = product.getPrice().multiply(BigDecimal.valueOf(entryMap.getValue()));
            System.out.printf("Product id = %-2s | name = %-15s | price = %-8s | quantity = %-3s | sum = %-12s \n",
                    product.getID(), product.getName(), product.getPrice(), entryMap.getValue(), prodSum);
            sum = sum.add(prodSum);
        }
        System.out.println("К оплате: " + sum);
		
	}

	@Override
	public int getProductQuantity(Cart cart, Product product) {
		   if (cart.getProducts().containsKey(product)) {
	            return cart.getProducts().get(product);
	        }
	       
		return 0;
	}

	@Override
	public int getProductQuantity(Cart cart, Long prodId) {
		Product product = productRepository.findById(prodId);
        return this.getProductQuantity(cart, product);
	}

}
