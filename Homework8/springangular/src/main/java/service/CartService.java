package service;
import entity.ShoppingCart;
import entity.ProductInOrder;
import entity.User;

import java.util.Collection;

public interface CartService {
   ShoppingCart getCart(User user);
   
   void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

   void delete(String itemId, User user);

   void checkout(User user);
}
