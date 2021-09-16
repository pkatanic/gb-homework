package model;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService implements IShoppingCartService {
	 private final ProductRepository productRepository;
	 
	 public ShoppingCartService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	@Lookup
	@Override
	public Cart getNewCart() {
		return null;
	}

	@Lookup
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
	public BigDecimal getSum(Cart cart) {
		// TODO Auto-generated method stub
		 return cart.getSum();
	}

	@Override
	public void printCart(Cart cart) {
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
	public int getProductQuantity(Cart cart, Product product) {
		// TODO Auto-generated method stub
		if (cart.getCartMap().containsKey(product)) {
            return cart.getCartMap().get(product);
        }
       
		return 0;
	}

	@Override
	public int getProductQuantity(Cart cart, Long prodId) {
		Product product = productRepository.findById(prodId);
        return this.getProductQuantity(cart, product);
	}

	@Override
	public List<Product> getCartListSorted(Cart cart) {
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
