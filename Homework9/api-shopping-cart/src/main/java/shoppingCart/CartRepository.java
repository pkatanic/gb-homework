package shoppingCart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import product.Product;
import user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    public List<Cart> findAllByUserId(String userId);
    public Optional<Cart> findByUserAndProduct(User user, Product product);
}
