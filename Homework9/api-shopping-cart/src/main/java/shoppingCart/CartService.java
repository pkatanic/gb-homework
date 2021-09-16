package shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.exceptions.AlreadyExistException;
import common.exceptions.NotFoundException;
import product.Product;
import product.ProductService;
import user.User;
import user.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public CartService(CartRepository cartRepository,
                       UserService userService,
                       ProductService productService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public List<Cart> find(String userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public Optional<Cart> find(User user, Product product) {
        return cartRepository.findByUserAndProduct(user, product);
    }

    public Cart insert(String userId, CartDto cartDto) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        Product product = productService.find(cartDto.getProductId()).orElseThrow(() -> new NotFoundException(("Продукт не найден")));
        this.find(user, product).ifPresent(cart -> { throw new AlreadyExistException("Продукт уже в корзине"); });
        return cartRepository.insert(new Cart(user, product, cartDto.getQuantity(), cartDto.getQuantity() * product.getPrice()));
    }

    public Cart save(String userId, CartDto cartDto) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        Product product = productService.find(cartDto.getProductId()).orElseThrow(() -> new NotFoundException(("Продукт не найден")));

        int quantity = cartDto.getQuantity();
        if(quantity > product.getQuantity()) {
            throw new IllegalArgumentException("количество товара ошибочное");
        }

        return cartRepository.save(
                this.find(user, product)
                        .orElse(new Cart()
                                .setUser(user)
                                .setProduct(product))
                        .setQuantity(quantity)
                        .setAmount(quantity * product.getPrice()));
    }

    public void delete(String userId, String cartId) {
        User user = userService.find(userId).orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        cartRepository.deleteById(cartId);
    }
}
