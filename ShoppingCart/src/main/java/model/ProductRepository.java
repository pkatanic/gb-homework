package model;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    {
        for (long i = 1; i < 6; i++) {
            BigDecimal rndPrice = BigDecimal.valueOf(new Random().nextInt(100000)).divide(BigDecimal.valueOf(100));
            productMap.put(i, new Product(i, "Product " + i, rndPrice));
        }
   
        productMap.put(1L, new Product(1L, "Apple", BigDecimal.valueOf(110.05)));
        productMap.put(2L, new Product(2L, "Bannana", BigDecimal.valueOf(20.02)));
        productMap.put(3L, new Product(3L, "Pear", BigDecimal.valueOf(300.0)));
        productMap.put(4L, new Product(4L, "Cherry", BigDecimal.valueOf(444.44)));
        productMap.put(5L, new Product(5L, "Blueberry", BigDecimal.valueOf(55.5)));
    }

    
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

  
    public void saveOrUpdate(Product product) {
        if (product.getID() == null) {
            Long id = (long) (productMap.size() + 1);
            product.setID(id);
        }
        productMap.put(product.getID(), product);
    }

   
    public Product findById(Long id) { return productMap.get(id); }

    
    public void deleteById(Long id) {
        productMap.remove(id);
    }
}