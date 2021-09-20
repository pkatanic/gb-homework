package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.OrderMain;
import entity.ProductInOrder;
import entity.ShoppingCart;
import entity.User;
import repository.CartRepository;
import repository.OrderRepository;
import repository.ProductInOrderRepository;
import repository.UserRepository;
import service.CartService;
import service.ProductService;
import service.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {
	  @Autowired
	    ProductService productService;
	    @Autowired
	    OrderRepository orderRepository;
	    @Autowired
	    UserRepository userRepository;

	    @Autowired
	    ProductInOrderRepository productInOrderRepository;
	    @Autowired
	    CartRepository cartRepository;
	    @Autowired
	    UserService userService;
	    @Override
	    public ShoppingCart getCart(User user) {
	        return user.getCart();
	    }

	    @Override
	    @Transactional
	    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
	        ShoppingCart finalCart = user.getCart();
	        productInOrders.forEach(productInOrder -> {
	            Set<ProductInOrder> set = finalCart.getProducts();
	            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductId().equals(productInOrder.getProductId())).findFirst();
	            ProductInOrder prod;
	            if (old.isPresent()) {
	                prod = old.get();
	                prod.setCount(productInOrder.getCount() + prod.getCount());
	            } else {
	                prod = productInOrder;
	                prod.setCart(finalCart);
	                finalCart.getProducts().add(prod);
	            }
	            productInOrderRepository.save(prod);
	        });
	        cartRepository.save(finalCart);

	    }

	    @Override
	    @Transactional
	    public void delete(String itemId, User user) {
	        Optional<ProductInOrder> op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
	        op.ifPresent(productInOrder -> {
	            productInOrder.setCart(null);
	            productInOrderRepository.deleteById(productInOrder.getId());
	        });
	    }



	    @Override
	    @Transactional
	    public void checkout(User user) {
	       
	        OrderMain order = new OrderMain(user);
	        orderRepository.save(order);

	      
	        user.getCart().getProducts().forEach(productInOrder -> {
	            productInOrder.setCart(null);
	            productInOrder.setOrderMain(order);
	            productService.decreaseStock(productInOrder.getProductId(), productInOrder.getCount());
	            productInOrderRepository.save(productInOrder);
	        });

	    }

		
}
