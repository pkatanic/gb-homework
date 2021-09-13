package model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private static final ProductRepository INSTANCE = new ProductRepository();
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    {

        productMap.put(1L, new Product(1L, "Apples", BigDecimal.valueOf(110.05)));
        productMap.put(2L, new Product(2L, "Bread", BigDecimal.valueOf(20.02)));
        productMap.put(3L, new Product(3L, "Milk", BigDecimal.valueOf(300.0)));
        productMap.put(4L, new Product(4L, "Meat", BigDecimal.valueOf(444.44)));
        productMap.put(5L, new Product(5L, "Coffe", BigDecimal.valueOf(55.5)));
    }



    
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }


    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            Long id = Collections.max(productMap.keySet()) + 1;
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    
    public Product findById(Long id) { return productMap.get(id); }

    
    public void deleteById(Long id) {
        productMap.remove(id);
    }
}
