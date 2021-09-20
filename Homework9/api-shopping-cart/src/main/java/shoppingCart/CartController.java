package shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/cart/{userId}", produces = APPLICATION_JSON_VALUE)
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getCart(@PathVariable(value = "userId", required = true) String userId) {
        return cartService.find(userId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCart(@PathVariable(value = "userId", required = true) String userId,
                        @Valid @RequestBody(required = true) CartDto cartDto) {
        cartService.insert(userId, cartDto);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateCart(@PathVariable(value = "userId", required = true) String userId,
                        @Valid @RequestBody(required = true) CartDto cartDto) {
        cartService.save(userId, cartDto);
    }

    @DeleteMapping(params = "cartId")
    public void deleteCart(@PathVariable(value = "userId", required = true) String userId,
                           @RequestParam(value = "cartId", required = true) String cartId) {
        cartService.delete(userId, cartId);
    }
}
