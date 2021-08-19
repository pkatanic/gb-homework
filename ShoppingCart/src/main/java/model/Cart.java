package model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Component
@Scope("prototype")
public class Cart {
	 private Map<Product, Integer> products = new HashMap<>();
	 
	 public Map<Product,Integer> getProducts(){
		 return products;
	 }
	 
	 public void addProduct(Product product, Integer quantity) {
	        if (product != null)
	            products.merge(product, quantity, Integer::sum);
	    }

	    public void delProduct(Product product, Integer quantity) {
	        if (products.containsKey(product)) {
	           if (quantity != null && products.get(product).compareTo(quantity) > 0) {
	        	   products.put(product, products.get(product) - quantity);
	           } else {
	        	   products.remove(product);
	           }
	        }
	    }
	    public BigDecimal getSum() {
	        BigDecimal sum = BigDecimal.valueOf(0);
	        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
	            sum = sum.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
	        }
	        return sum;
	    }
}
