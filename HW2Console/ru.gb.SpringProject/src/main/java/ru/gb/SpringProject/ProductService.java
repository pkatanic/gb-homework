package ru.gb.SpringProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	 @Autowired
	    ProductRepoBean repo = new ProductRepoBean();

	    public void add(Product product){
	        repo.get().add(product);
	    }

	    public void delete(Product product){
	        repo.get().remove(product);
	    }

	    public void delete(int index){
	        repo.get().remove(index);
	    }
	    public String read(){
	    	  List<Product> productList = repo.get();
	          StringBuilder str = new StringBuilder();
	          for (int i = 0; i < productList.size(); i++) {
	              str.append(productList.get(i).toString()).append("\n");
	          }
	          return str.toString();
	    }
	    public double avgCost() {
	        int sum = 0;
	        for (Product p: repo.get()) {
	            sum += p.getPrice();
	        }
	        return (double) sum/repo.get().size();
	    }

	    public void update(int index, Product product){
	        repo.get().set(index, product);
	    }
	    public int getProductsNumber() {
	        return repo.get().size();
	    }
}