package ru.gb.SpringProject;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepoBean implements ProductRepo {
	 private List<Product> products;

	    @PostConstruct
	    public void init(){
	        products = new ArrayList<>();
	        products.add(new Product(123123L, "apple", 123));
	        products.add(new Product(1223L, "bread", 110));
	        products.add(new Product(121313123L, "milk", 200));
	        
	    }

	    @Override
	    public List<Product> get() {
	        return products;
	    }
}
