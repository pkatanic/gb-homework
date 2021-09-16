import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import product.ProductService;
import user.UserService;

@SpringBootApplication
public class ShoppingCartApp {
	public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext = SpringApplication.run(ShoppingCartApp.class, args);

	
	ProductService productService = applicationContext.getBean(ProductService.class);
	productService.deleteAll();
	productService.insertProductSampleData();

	
	UserService userService = applicationContext.getBean(UserService.class);
	userService.deleteAll();
	userService.insertUserSampleData();
	}
}
