package product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductServiceTest {
	  @Autowired
	    private ProductRepository productRepository;

	    private ProductService productService;

	    @BeforeEach
	    public void setup() {
	        productService = new ProductService(productRepository);
	        productService.insertProductSampleData();
	    }

	    @AfterEach
	    public void tearDown() {
	        productRepository.deleteAll();
	    }

	    @Test
	    public void mongoTemplateShouldNotBeNull(@Autowired MongoTemplate mongoTemplate) {
	        Assert.notNull(mongoTemplate, "Шаблон Mongo не создан");
	    }

	    @Test
	    public void shouldReturnListOfProduct_whenSampleProductInserted() {
	        assertEquals("Должны быть продукты по умолчанию", 5, productRepository.findAll().size());
	    }
}
