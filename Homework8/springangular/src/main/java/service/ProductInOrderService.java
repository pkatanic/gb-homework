package service;

import entity.ProductInOrder;
import entity.User;

public interface ProductInOrderService {
	    void update(String itemId, Integer quantity, User user);
	    ProductInOrder findOne(String itemId, User user);
}
