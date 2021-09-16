package shoppingCart;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import product.Product;
import user.User;

import java.util.List;

public class Cart {
	 @Id
	    private String id;

	    @DBRef
	    private User user;

	    @DBRef
	    private Product product;

	    private Integer quantity;
	    private Double amount;

	    public Cart() {
	    }

	    public Cart(User user, Product product, Integer quantity, Double amount) {
	        this.user = user;
	        this.product = product;
	        this.quantity = quantity;
	        this.amount = amount;
	    }

	    public String getId() {
	        return id;
	    }

	    public Cart setId(String id) {
	        this.id = id;
	        return this;
	    }

	    public User getUser() {
	        return user;
	    }

	    public Cart setUser(User user) {
	        this.user = user;
	        return this;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public Cart setProduct(Product product) {
	        this.product = product;
	        return this;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public Cart setQuantity(Integer quantity) {
	        this.quantity = quantity;
	        return this;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public Cart setAmount(Double amount) {
	        this.amount = amount;
	        return this;
	    }

	    @Override
	    public String toString() {
	        return "Cart{" +
	                "id='" + id + '\'' +
	                ", user=" + user +
	                ", product=" + product +
	                ", quantity=" + quantity +
	                ", amount=" + amount +
	                '}';
	    }
}
